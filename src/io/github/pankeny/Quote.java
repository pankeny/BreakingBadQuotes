package io.github.pankeny;

public class Quote {

    String quote;
    String author;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Your random quote is \n" + quote + " - " + author;
    }

}
