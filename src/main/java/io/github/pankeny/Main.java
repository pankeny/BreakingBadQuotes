package io.github.pankeny;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Request getRandomQuote = new Request("https://breaking-bad-quotes.herokuapp.com/v1/quotes");
        Request getArrayOfQuotes = new Request("https://breaking-bad-quotes.herokuapp.com/v1/quotes/5");

        JSONObject jsonObject;

        Quote quote = new Quote();
        List<Quote> listOfQuotes = new ArrayList<Quote>();

        try{
            String singleQuoteAsString = getRandomQuote.getContentFromUrl();

            jsonObject = new JSONObject(singleQuoteAsString.substring(1, singleQuoteAsString.length() - 1));
            quote.setQuote(jsonObject.getString("quote"));
            quote.setAuthor(jsonObject.getString("author"));

            System.out.println("Your random quote is: " + quote.toString());

            String arrayOfQuotesAsString = getArrayOfQuotes.getContentFromUrl();
            Iterator<Object> jsonArrayIterator = new JSONArray(arrayOfQuotesAsString).iterator();

            System.out.println();

            while (jsonArrayIterator.hasNext()){

                JSONObject nextJsoonObject = (JSONObject) jsonArrayIterator.next();
                Quote quoteTemp = new Quote();

                quoteTemp.setQuote(nextJsoonObject.getString("quote"));
                quoteTemp.setAuthor(nextJsoonObject.getString("author"));

                listOfQuotes.add(quoteTemp);

            }

            for(Quote q: listOfQuotes){
                System.out.println("Quote: " + q.toString() + "\n");
            }


        }
        catch(NullPointerException e){
            System.out.println("Something is wrong with your Request obj.");
            System.out.println("Check if Request's constructor dont initialize null to URL");
        }
    }
}
