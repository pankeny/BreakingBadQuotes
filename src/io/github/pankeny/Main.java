package io.github.pankeny;

import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        Request getRandomQuote = new Request("https://breaking-bad-quotes.herokuapp.com/v1/quotes");

        try{
            String stringFromUrl = getRandomQuote.getContentFromUrl();
            System.out.println(stringFromUrl);
        }
        catch(NullPointerException e){
            System.out.println("Something is wrong with your Request obj.");
            System.out.println("Check if Request's constructor dont initialize null to URL");
        }
    }
}

// TODO: PROJECT STRUCTURE REORGANIZE?
