package io.github.pankeny;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Request {

    private URL url;

    public Request(String stringUrl){

        try{
            this.url = new URL(stringUrl);

        }
        catch(MalformedURLException e) {
            this.url = null;
        }
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

    public String getContentFromUrl(){

        StringBuilder stringBuilder = new StringBuilder();

        HttpURLConnection connection = openConnection();

        try {
            InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(streamReader);
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
