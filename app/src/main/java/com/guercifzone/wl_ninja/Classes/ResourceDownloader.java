package com.guercifzone.wl_ninja.Classes;

import android.content.Context;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ResourceDownloader {
    public static void sownloadImage(String htmlContent, Context context){
        Document document = Jsoup.parse(htmlContent);
        Elements images = document.select("img");
        
        for (Element img : images){
            String imageUrl = img.attr("src");
            downloadResource(imageUrl, context);
        }
    }

    private static void downloadResource(String imageUrl, Context context) {
    }
}
