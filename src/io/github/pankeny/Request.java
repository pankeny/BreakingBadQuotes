package io.github.pankeny;

import netscape.javascript.JSObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {

    URL url;

    public Request(URL url){
        this.url = url;
    }

    public HttpURLConnection openConnection(){
        try{
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            return connection;
        }
        catch(IOException e) {
            System.out.println("!!! Can not open connection, maybe valid your URL");
            return null;
        }
    }

    public String getJsonObjectFromUrl(){

        StringBuilder stringBuilder = new StringBuilder();

        HttpURLConnection connection = openConnection();

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }

            bufferedReader.close();

            return stringBuilder.toString();
        }
        catch(IOException e){
            System.out.println();
            return null;
        }

    }


}