package dev.villahermosa.com.droid3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PokiDes extends AppCompatActivity {

    private ImageLoader mImageLoader;
    List<PokeDescription> list_items = new ArrayList<>();
    private String pokemon_api;
    private PokeDescription pokemon= new PokeDescription();

    private String passedArg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poki_des);

        passedArg = getIntent().getExtras().getString("arg");
        Toast.makeText(this, "arg:"+passedArg, Toast.LENGTH_SHORT).show();
        pokemon_api = passedArg;

        mImageLoader = new ImageLoader(VolleyApplication.getInstance().getRequestQueue(), new BitmapLruCache());

        get();

////        NetworkImageView imageView = (NetworkImageView) findViewById(R.id.img_pokiimage);
//        EditText poki_name = (EditText) findViewById(R.id.tv_poke_name);
//        TextView poki_type = (TextView) findViewById(R.id.tv_type);
//        TextView poki_weight = (TextView) findViewById(R.id.tv_weight);
//        TextView poki_height = (TextView) findViewById(R.id.tv_height);
//        TextView poki_baseexp = (TextView) findViewById(R.id.tv_base_experience);
//
////        imageView.setImageUrl(pokemon.getImg(), mImageLoader);
//        poki_name.setText(pokemon.getName());
//        ArrayList temp = pokemon.getType();
//        String type = "";
//        for(int x=0; x < temp.size(); x++){
//                    String tmp = type;
//                    String tmp2 = temp.get(x).toString();
//                    type = tmp + ";" + tmp2;
//        }
//        poki_type.setText(type);
//
//        poki_weight.setText(pokemon.getWeight());
//        poki_height.setText(pokemon.getHeight());
//        poki_baseexp.setText(pokemon.getBase_experience());

    }

    private void get() {
        Toast.makeText(this, "annyeong get!", Toast.LENGTH_SHORT).show();
        JsonObjectRequest request = new JsonObjectRequest(
                passedArg,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            pokemon.setHeight(jsonObject.getInt("height")+"");
                            pokemon.setBase_experience(jsonObject.getInt("base_experience")+"");
                            pokemon.setWeight(jsonObject.getInt("weight")+"");
                            pokemon.setName(jsonObject.getString("name").toString());

//                            pokemon.setHeight(jsonObject.getJSONObject("height")+"");
//                            pokemon.setBase_experience(jsonObject.getJSONObject("base_experience")+"");
//                            pokemon.setWeight(jsonObject.getJSONObject("weight")+"");
//                            pokemon.setName(jsonObject.getJSONObject("name").toString());

                            EditText poki_name = (EditText) findViewById(R.id.tv_poke_name);
                            TextView poki_type = (TextView) findViewById(R.id.tv_type);
                            TextView poki_weight = (TextView) findViewById(R.id.tv_weight);
                            TextView poki_height = (TextView) findViewById(R.id.tv_height);
                            TextView poki_baseexp = (TextView) findViewById(R.id.tv_base_experience);

//                          imageView.setImageUrl(pokemon.getImg(), mImageLoader);
                            poki_name.setText(pokemon.getName());
                            ArrayList temp = pokemon.getType();
                            String type = "";
                            for(int x=0; x < temp.size(); x++){
                                String tmp = type;
                                String tmp2 = temp.get(x).toString();
                                type = tmp + ";" + tmp2;
                            }
                            poki_type.setText(type);

                            poki_weight.setText(pokemon.getWeight());
                            poki_height.setText(pokemon.getHeight());
                            poki_baseexp.setText(pokemon.getBase_experience());

//                            List<PokeDescription> pokii = parse(jsonObject);

                        } catch (JSONException e) {
                            Toast.makeText(PokiDes.this, "Unable to parse data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(PokiDes.this, "Unable to fetch data: " + volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        VolleyApplication.getInstance().getRequestQueue().add(request);
    }

    private List<PokeDescription> parse(JSONObject json) throws JSONException {
        ArrayList<PokeDescription> records = new ArrayList<PokeDescription>();

        pokemon.setHeight(json.getJSONObject("height").toString());
        pokemon.setBase_experience(json.getJSONObject("base_experience").toString());
        pokemon.setWeight(json.getJSONObject("weight").toString());
//        pokemon.setImg(json.getJSONObject("sprites/front_default").toString());

        EditText poki_name = (EditText) findViewById(R.id.tv_poke_name);
        TextView poki_type = (TextView) findViewById(R.id.tv_type);
        TextView poki_weight = (TextView) findViewById(R.id.tv_weight);
        TextView poki_height = (TextView) findViewById(R.id.tv_height);
        TextView poki_baseexp = (TextView) findViewById(R.id.tv_base_experience);

//        imageView.setImageUrl(pokemon.getImg(), mImageLoader);
        poki_name.setText(pokemon.getName());
        ArrayList temp = pokemon.getType();
        String type = "";
        for(int x=0; x < temp.size(); x++){
            String tmp = type;
            String tmp2 = temp.get(x).toString();
            type = tmp + ";" + tmp2;
        }
        poki_type.setText(type);

        poki_weight.setText(pokemon.getWeight());
        poki_height.setText(pokemon.getHeight());
        poki_baseexp.setText(pokemon.getBase_experience());

        return records;
    }

}
