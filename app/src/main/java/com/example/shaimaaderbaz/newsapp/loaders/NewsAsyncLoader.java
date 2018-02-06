package com.example.shaimaaderbaz.newsapp.loaders;

import android.app.Activity;

import com.example.shaimaaderbaz.newsapp.models.News;
import com.example.shaimaaderbaz.newsapp.utils.Utils;

import java.util.ArrayList;

/**
 * Created by Shaimaa Derbaz on 2/5/2018.
 */
public class NewsAsyncLoader extends android.support.v4.content.AsyncTaskLoader< ArrayList<News> >
{
    private String url;
    public NewsAsyncLoader(Activity activity,String url) {
        super(activity);
        this.url=url;
    }
    @Override
    public ArrayList<News> loadInBackground ()
    {
        ArrayList<News> result = Utils.fetchNewsData(url);
        return result;
    }
}
