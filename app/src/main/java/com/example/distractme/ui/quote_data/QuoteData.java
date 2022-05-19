package com.example.distractme.ui.quote_data;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.distractme.ui.controller.AppController;
import com.example.distractme.ui.model.Quote;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QuoteData {
    ArrayList<Quote> quoteArrayList = new ArrayList<>();

    public void getQuotes(final QuoteListAsync callBack){
        String url = "https://type.fit/api/quotes";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, (JSONArray) null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i < response.length(); i++){
                    try {
                        JSONObject quoteObject = response.getJSONObject(i);
                        Quote quote = new Quote();
                        quote.setText(quoteObject.getString("text"));
                        quote.setAuthor(quoteObject.getString("author"));

                        quoteArrayList.add(quote);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                //if callback is not null (There's something in our callback)
                if(callBack != null) callBack.processFinished(quoteArrayList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }
}

