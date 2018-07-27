package com.live.jetsetradio.JetSetRadioLive;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

class DownloadAsync extends AsyncTask<URL, Long, String> {


    protected String doInBackground(URL[] urlArr) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //System.out.println("HELLO?" + urlArr[0].toString());
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlArr[0].openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setReadTimeout(5000);
            //System.out.println(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while (true) {

                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    readLine = readLine.replaceAll(".*=", "");
                    readLine = readLine.substring(2);
                    //readLine = readLine.substring(0, readLine.length() - 2);
                   // System.out.println(readLine);
                    stringBuilder.append(readLine);
                } else {
                    bufferedReader.close();
                    return stringBuilder.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
