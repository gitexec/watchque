package com.apps.appcerca.watchque.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.appcerca.watchque.R;
import com.apps.appcerca.watchque.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by wington on 1/10/17.
 */

public class MovieArrayAdapters extends ArrayAdapter<Movie>{

    public MovieArrayAdapters(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.movies_layout, parent, false);
        }

        ImageView tvImage =  (ImageView) convertView.findViewById(R.id.ivMovieImage);
        //Clear image
        tvImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());

        Picasso.with(getContext()).load(movie.getPoster()).into(tvImage);

        return tvOverview;
    }
}
