package io.github.pankeny;

import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {

        Request getRandomQuote = new Request("https://breaking-bad-quotes.herokuapp.com/v1/quotes");
        JSONObject jsonObject;
        Quote quote = new Quote();

        try{
            String stringFromUrl = getRandomQuote.getContentFromUrl();

            jsonObject = new JSONObject(stringFromUrl.substring(1, stringFromUrl.length() - 1));
            quote.setQuote(jsonObject.getString("quote"));
            quote.setAuthor(jsonObject.getString("author"));

            System.out.println(quote.toString());

        }
        catch(NullPointerException e){
            System.out.println("Something is wrong with your Request obj.");
            System.out.println("Check if Request's constructor dont initialize null to URL");
        }
    }
}

// TODO: PROJECT STRUCTURE REORGANIZE?
