package com.guercifzone.wl_ninja.Classes;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebPageDownloader {
    public static String downloadWebPage(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            return document.toString();
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
