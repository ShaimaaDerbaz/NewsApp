package com.example.shaimaaderbaz.newsapp.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.shaimaaderbaz.newsapp.R;
import com.example.shaimaaderbaz.newsapp.models.News;


import java.util.ArrayList;

/**
 * Created by Shaimaa Derbaz on 2/3/2018.
 */

public class NewsListAdapter extends ArrayAdapter<News> {
    private ArrayList<News> items = new ArrayList<News>();

    public NewsListAdapter(Activity context, ArrayList<News> items) {
        super(context, 0, items);
        this.items=items;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(
                    getContext()).inflate(R.layout.list_item, null, false);

        }
        News currentItem = getItem(position);
        TextView titleItemTextView=(TextView)listItemView.findViewById(R.id.item_title_text_view);
        titleItemTextView.setText(currentItem.getType());
        TextView autherItemTextView = (TextView) listItemView.findViewById(R.id.item_auther_text_view);
        autherItemTextView.setText(currentItem.getSectionName());
        TextView itemPublisherTextView = (TextView) listItemView.findViewById(R.id.item_publisher_text_view);
        itemPublisherTextView.setText(currentItem.getPublicationDate());
        TextView itemAuthorTextView = (TextView) listItemView.findViewById(R.id.item_author_text_view);
        itemAuthorTextView.setText(currentItem.getAuthor());
        TextView itemDescriptionTextView = (TextView) listItemView.findViewById(R.id.item_description_text_view);
        itemDescriptionTextView.setText(currentItem.getTitle());
        TextView itemUrlTextView = (TextView) listItemView.findViewById(R.id.item_url_text_view);
        itemUrlTextView.setText(currentItem.getWebUrl());

        return listItemView;
    }

    public void setNews(ArrayList<News> data) {
        items.addAll(data);
        notifyDataSetChanged();
    }

}
