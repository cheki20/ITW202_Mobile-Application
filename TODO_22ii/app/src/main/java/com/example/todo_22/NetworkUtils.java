package com.example.todo_22;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();

    //Base URL for Book API
    private static final String BOOK_BASE_URL = "https://www.googleapis.com/books/v1/volumes?";

    //parameters that limits search result
    private static final String MAX_RESULTS = "maxResults";

    //Parameter for the search string
    private static final String QUERY_PARAM = "q";

    //parameter to filter  by print type
    private static final String PRINT_TYPE = "printType";

    static String getBookInfo(String queryString){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String bookJSONString = null;


        Uri buildURI = Uri.parse(BOOK_BASE_URL).buildUpon()
                .appendQueryParameter(QUERY_PARAM, queryString)
                .appendQueryParameter(MAX_RESULTS, "10")
                .appendQueryParameter(PRINT_TYPE, "books")
                .build();


        try{
            //making connection
            URL requestURL = new URL(buildURI.toString());
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            //For getting data and setting it to buffer reader
            //get the input stream
            InputStream inputStream = urlConnection.getInputStream();
            //create buffered reader  from that input stream
            reader = new BufferedReader(new InputStreamReader(inputStream));
            //use a stringBuilder to hold the incoming response
            StringBuilder builder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null){
                builder.append(line);
                builder.append("\n");

            }

            if (builder.length() == 0){
                return null;
            }
            bookJSONString = builder.toString();

        } catch (IOException e) {
            //one of the method to print exception
            e.printStackTrace();
        } finally {
            //finally is used when we want to close connections and all
            if (urlConnection != null){
                try{
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Log.d(LOG_TAG, bookJSONString);
        return bookJSONString;
    }
}
