package com.example.distractme;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser
{
    public static Weather getWeather(String jsonStr)
    {
        Weather Weather = new Weather();

        try
        {
            JSONObject rootJsonObject = new JSONObject(jsonStr);

            //Get Weather condition
            JSONArray weatherJsonArray = rootJsonObject.getJSONArray("weather");
            JSONObject jsonObject1 = weatherJsonArray.getJSONObject(0);
            Weather.setWeatherCondition(jsonObject1.getString("main"));
            Weather.setWeatherDescription(jsonObject1.getString("description"));
            Weather.setWeatherIconStr(jsonObject1.getString("icon"));

            //Get temperature
            JSONObject jsonObject2 = rootJsonObject.getJSONObject("main");
            Weather.setTemperature((float) jsonObject2.getDouble("temp"));

        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        return Weather;
    }
}
