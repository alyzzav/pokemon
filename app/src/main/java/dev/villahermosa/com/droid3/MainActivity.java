package dev.villahermosa.com.droid3;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String JsonURLPokemon = "http://pokeapi.co/api/v2/pokemon/";
    private PokeAdapter mAdapter;
    List<Pokemon> listpoki = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listpoki = new ArrayList<>();
        mAdapter = new PokeAdapter(this, listpoki);

        ListView listView = (ListView) this.findViewById(R.id.list_pokemons);
        listView.setAdapter(mAdapter);

        get();

        listView.setOnItemClickListener(this);

    }


    private void get() {
        Toast.makeText(MainActivity.this, "annyeong fetch!", Toast.LENGTH_SHORT).show();

        JsonObjectRequest request = new JsonObjectRequest(
                "http://pokeapi.co/api/v2/pokemon/",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            List<Pokemon> pokii = parse(jsonObject);

                            mAdapter.swapImageRecords(pokii);
                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this, "Unable to parse data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(MainActivity.this, "Unable to fetch data: " + volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        VolleyApplication.getInstance().getRequestQueue().add(request);
    }

    private List<Pokemon> parse(JSONObject json) throws JSONException {
        ArrayList<Pokemon> records = new ArrayList<Pokemon>();

        JSONArray pokijson = json.getJSONArray("results");

        for (int i = 0; i < pokijson.length(); i++) {
            JSONObject pokis = pokijson.getJSONObject(i);
            String name = pokis.getString("name");
            String url = pokis.getString("url");

            Pokemon record = new Pokemon(name, url);
            records.add(record);
        }

        listpoki = records;
        return records;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String url = listpoki.get(position).toString();
            Toast.makeText(MainActivity.this, url+"was selected", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, PokiDes.class);
            intent.putExtra("arg", "http://pokeapi.co/api/v2/pokemon/"+(position+1)+"/");
            startActivity(intent);
   }

}
