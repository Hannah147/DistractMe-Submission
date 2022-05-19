package com.example.distractme;

import android.os.AsyncTask;

public class MyWeatherTask extends AsyncTask<String, Void, Weather>
{
    private MyWeatherTaskListener mListener;

    MyWeatherTask(MyWeatherTaskListener pListener)
    {
        this.mListener = pListener;
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        mListener.onWeatherTaskPreExecute();
    }

    @Override
    protected Weather doInBackground(String... strings)
    {
        Weather myWeather = null;

        //Fetch Weather
        String jsonStr = WeatherClient.fetchWeather(strings[0]);

        //Parsing Weather
        if (jsonStr != null)
        {
            myWeather = JSONParser.getWeather(jsonStr);
        }
        return myWeather;
    }

    @Override
    protected void onPostExecute(Weather myWeather)
    {
        super.onPostExecute(myWeather);
        mListener.onWeatherTaskPostExecute(myWeather);
    }
}

interface MyWeatherTaskListener
{
    void onWeatherTaskPreExecute();
    void onWeatherTaskPostExecute(Weather myWeather);
}

