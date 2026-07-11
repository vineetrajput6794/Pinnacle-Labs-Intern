package com.weather;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService {

    private final String API_KEY = "ca9bf06005613b23eaca7512ea0e5bd9";

    public String getWeather(String city){

        try{

            String urlString=
                    "https://api.openweathermap.org/data/2.5/weather?q="
                            +city+
                            "&appid="+API_KEY+
                            "&units=metric";

            URL url=new URL(urlString);

            HttpURLConnection connection=
                    (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader br=
                    new BufferedReader(
                            new InputStreamReader(
                                    connection.getInputStream()));

            StringBuilder response=
                    new StringBuilder();

            String line;

            while((line=br.readLine())!=null){

                response.append(line);

            }

            br.close();

            JSONObject json=
                    new JSONObject(response.toString());

            String weather=
                    json.getJSONArray("weather")
                            .getJSONObject(0)
                            .getString("main");

            double temp=
                    json.getJSONObject("main")
                            .getDouble("temp");

            int humidity=
                    json.getJSONObject("main")
                            .getInt("humidity");

            return "City : "+city+
                    "<br>Weather : "+weather+
                    "<br>Temperature : "+temp+" °C"+
                    "<br>Humidity : "+humidity+" %";

        }

        catch(Exception e){

            return "City not found.";

        }

    }

}