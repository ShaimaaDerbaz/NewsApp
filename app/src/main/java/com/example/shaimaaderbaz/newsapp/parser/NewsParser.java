package com.example.shaimaaderbaz.newsapp.parser;

import android.text.TextUtils;
import android.util.Log;

import com.example.shaimaaderbaz.newsapp.models.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Shaimaa Derbaz on 2/4/2018.
 */

public class NewsParser {
    public static ArrayList<News> extractFeatureFromJson(String newsJSON) {

        if (TextUtils.isEmpty(newsJSON)) {
            return null;
        }

        ArrayList<News> newsList = new ArrayList<>();
        try {
            JSONObject baseJsonResponse = new JSONObject(newsJSON);
            JSONObject response =baseJsonResponse.getJSONObject("response");
            JSONArray newsArray = response.getJSONArray("results");
            for (int i = 0; i < newsArray.length(); i++) {
                JSONObject currentArticleNews = newsArray.getJSONObject(i);
                String type = currentArticleNews.getString("type");
                String sectionName = currentArticleNews.getString("sectionName");
                String publicationDate = currentArticleNews.getString("webPublicationDate");
                String title =currentArticleNews.getString("webTitle");
                String webUrl =currentArticleNews.getString("webUrl");
                String author=" ";
                if(currentArticleNews.has("tags"))
                {
                    JSONArray tagsArr=currentArticleNews.getJSONArray("tags");
                    int l=tagsArr.length();
                    JSONObject authorObj=tagsArr.getJSONObject(0);
                    if(authorObj.has("firsName")||authorObj.has("lastName"))
                    {
                        String fName = authorObj.getString("firstName");
                        String lName = authorObj.getString("lastName");
                        author = fName + " " + lName;

                    }

                }
                else
                {
                    author = " ";
                }
                News news = new News(type, sectionName, publicationDate,author, title,webUrl);
                newsList.add(news);

            }
        } catch (JSONException e) {
            Log.e("", "Problem parsing the Book JSON results", e);
        }
        return newsList;
    }
}
