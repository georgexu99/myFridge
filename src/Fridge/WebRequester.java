package Fridge;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class WebRequester {
    String API_KEY;
    String LOCATION;
    String urlString;
    BufferedReader br;
    StringBuilder sb;
    Map<String, Object>mainMap;
    Map<String, Object>respMap;
    URLConnection conn;
    URL url;

    public WebRequester() throws IOException {

        sb = new StringBuilder();
        API_KEY = "98d304a02c461969fe284c0f41911af7";
        LOCATION= "Vancouver,CA";
        urlString = "http://api.openweathermap.org/data/2.5/weather?q=" +LOCATION + "&appid=" + API_KEY +"&units=imperial";
        try {
            url = new URL(urlString);
            conn = url.openConnection();
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while((line=br.readLine()) != null){
                sb.append(line);
            }
            respMap = jsontoMap(sb.toString());
            mainMap = jsontoMap(respMap.get("main").toString());

        } finally {
            if (br != null){
                br.close();
            }
        }
    }
    public void setLOCATION(String city){
        this.LOCATION = city;
    }
    public void currentTemperature(){
        System.out.println(mainMap.get("temp"));
    }
    public static Map<String, Object> jsontoMap(String str){
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>() {}.getType()
        );
        return map;
    }
}
