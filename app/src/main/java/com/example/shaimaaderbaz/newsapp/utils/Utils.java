package com.example.shaimaaderbaz.newsapp.utils;

import android.util.Log;

import com.example.shaimaaderbaz.newsapp.models.News;
import com.example.shaimaaderbaz.newsapp.parser.NewsParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by Shaimaa Derbaz on 2/4/2018.
 */

public class Utils {
    public static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e("", "Problem building the URL ", e);
        }
        return url;
    }
    public static ArrayList<News> fetchNewsData(String requestUrl) {

        URL url = Utils.createUrl(requestUrl);
        String jsonResponse = null;
        try {
            jsonResponse = Utils.makeRequests(url);
        } catch (IOException e) {
            Log.e("", "Problem making the HTTP request.", e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<News> news = NewsParser.extractFeatureFromJson(jsonResponse);
        return news;
    }
    public static String readFromStream(InputStream input) throws Exception
    {
        StringBuilder output =new StringBuilder();
        if(input !=null)
        {
            InputStreamReader inputStreamReader =new InputStreamReader(input, Charset.forName("UTF-8"));
            BufferedReader reader=new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line !=null)
            {
                output.append(line);
                line=reader.readLine();
            }
        }
        return output.toString();
    }


    public static String makeRequests (URL url)  throws Exception
    {
        HttpURLConnection urlConnection=null;
        InputStream inputStream=null;
        String jsonResponse="";
        if (url==null)
        {
            return jsonResponse;
        }
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);

            }
        }catch (Exception e)
        {

        }
        return jsonResponse;
    }

}
