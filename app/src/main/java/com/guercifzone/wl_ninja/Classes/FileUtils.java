package com.guercifzone.wl_ninja.Classes;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {
    public static  void saveToFile(String htmlcontent, Context context) {
        FileOutputStream outputStream;
        try {
            File file = new File(context.getFilesDir(),"index.html");
            outputStream = new FileOutputStream(file);
            outputStream.write(htmlcontent.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
