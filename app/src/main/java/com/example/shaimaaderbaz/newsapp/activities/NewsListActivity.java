package com.example.shaimaaderbaz.newsapp.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.Loader;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shaimaaderbaz.newsapp.R;
import com.example.shaimaaderbaz.newsapp.adapters.NewsListAdapter;
import com.example.shaimaaderbaz.newsapp.loaders.NewsAsyncLoader;
import com.example.shaimaaderbaz.newsapp.models.News;
import com.example.shaimaaderbaz.newsapp.utils.NetworkConnect;

import java.io.IOException;
import java.util.ArrayList;

;


public class NewsListActivity extends FragmentActivity implements android.support.v4.app.LoaderManager.LoaderCallbacks<ArrayList<News>>{

    public static String URL_USGS  ;
    ListView newsListView;
    NewsListAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        URL_USGS = "http://content.guardianapis.com/search?q=debates&api-key=test";

        Context context = getApplicationContext();
        CharSequence text = "No Internet ,Please connect";
        int duration = Toast.LENGTH_SHORT;
        try
        {
            if (NetworkConnect.isConnected()==true)
            {
                mAdapter=new NewsListAdapter(this,new ArrayList<News>());
                newsListView = (ListView) findViewById(R.id.activity_news_list);
                newsListView.setAdapter(mAdapter);
                getSupportLoaderManager().initLoader(1, null, this).forceLoad();


            }
            else
            {

                Toast toast =Toast.makeText(context,text,duration);
                toast.show();
            }
        }catch (InterruptedException e )
        {

            Toast toast =Toast.makeText(context,text,duration);
            toast.show();
        }
        catch( IOException ee)
        {

            Toast toast =Toast.makeText(context,text,duration);

        }


    }
    @Override
    public Loader<ArrayList<News>> onCreateLoader(int id, Bundle args) {
        return new NewsAsyncLoader(NewsListActivity.this,URL_USGS);
    }
    @Override
    public void onLoadFinished(Loader<ArrayList<News>> loader, ArrayList<News> data) {
        mAdapter.setNews(data);
    }
    @Override
    public void onLoaderReset(Loader<ArrayList<News>> loader) {
        mAdapter.setNews(new ArrayList<News>());
    }


}
