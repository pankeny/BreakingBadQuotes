package io.github.pankeny;

import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        Quote quote = new Quote();
        quote.setAuthor("Konrad M.");
        quote.setQuote("If u want to be master of sth, better it's to do it 5 minutes daily than do nothing with that.");
        System.out.println(quote.toString());
    }
}
