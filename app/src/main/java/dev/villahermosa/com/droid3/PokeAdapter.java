package dev.villahermosa.com.droid3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Villahermosa on 7/6/2017.
 */

public class PokeAdapter extends ArrayAdapter<Pokemon> {

    private ImageLoader mImageLoader;
    List<Pokemon> list_items = new ArrayList<>();
    public Context mContext;
    private LayoutInflater inflater;


    public PokeAdapter(Context context, List<Pokemon> pokilist) {
        super(context, R.layout.list_item, pokilist);
        mImageLoader = new ImageLoader(VolleyApplication.getInstance().getRequestQueue(), new BitmapLruCache());
        mContext = context;
        list_items = pokilist;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        EditText textView = (EditText) convertView.findViewById(R.id.tv_poke_name);
        textView.setText(list_items.get(position).getPokemonName());
        ImageView imgvw = (ImageView) convertView.findViewById(R.id.img_poki);

        return convertView;

    }


    public void swapImageRecords(List<Pokemon> objects) {
        clear();

        for(Pokemon object : objects) {
            add(object);
        }

        notifyDataSetChanged();
    }

}
