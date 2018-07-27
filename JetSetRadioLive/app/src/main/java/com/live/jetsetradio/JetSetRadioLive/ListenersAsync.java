package com.live.jetsetradio.JetSetRadioLive;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.content.LocalBroadcastManager;


import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

class ListenersAsync extends AsyncTask<Context, Long, Integer> {
    private Context f3393a;

    @Override
    protected Integer doInBackground(Context... contexts) {
        return null;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }


/*
    protected Integer m5884a(Context... contextArr) {
        this.f3393a = contextArr[0];
      //  m5882a();
        try {
            return m5883b();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void m5885a(Integer num) {
        Intent intent = new Intent();
        intent.setAction("JSRL.UPDATEUI");
        intent.putExtra("listeners", num);
        LocalBroadcastManager.getInstance(this.f3393a).sendBroadcastSync(intent);
        super.onPostExecute(num);
    }

    private void m5882a() {
        URL url;
        HttpURLConnection httpURLConnection = null;
        HttpURLConnection httpURLConnection2 = null;
        try {
            url = new URL("http://jetsetradio.live/counter/counter.php");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            url = null;
        }
        if (url != null) {
            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else {
            httpURLConnection = null;
        }
        httpURLConnection2 = httpURLConnection;
        if (httpURLConnection2 != null) {
            try {
                httpURLConnection2.setRequestMethod("POST");
            } catch (ProtocolException e3) {
                e3.printStackTrace();
            }
            httpURLConnection2.setDoOutput(true);
            httpURLConnection2.setConnectTimeout(5000);
            httpURLConnection2.setReadTimeout(5000);
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                dataOutputStream.writeBytes("Ping");
                dataOutputStream.flush();
                dataOutputStream.close();
            } catch (IOException e22) {
                e22.printStackTrace();
            }
        }
    }
*/
/*
    private Integer m5883b() throws IOException {
        String stringBuilder;
        Document parse;
        Exception e;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://jetsetradio.live/counter/listeners.xml").openConnection();
        if (httpURLConnection != null) {
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setReadTimeout(5000);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder stringBuilder2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder2.append(readLine);
            }
            bufferedReader.close();
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = null;
        }
        if (stringBuilder != null) {
            InputStream byteArrayInputStream = new ByteArrayInputStream(stringBuilder.getBytes(Charset.forName("UTF-8")));
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            newInstance.setIgnoringElementContentWhitespace(true);
            try {
                parse = newInstance.newDocumentBuilder().parse(byteArrayInputStream);
            } catch (ParserConfigurationException e2) {
                e = e2;
                e.printStackTrace();
                parse = null;
                if (parse != null) {
                    return Integer.valueOf(parse.getElementsByTagName("user").getLength());
                }
                return null;
            } catch (SAXException e3) {
                e = e3;
                e.printStackTrace();
                parse = null;
                if (parse != null) {
                    return Integer.valueOf(parse.getElementsByTagName("user").getLength());
                }
                return null;
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
                parse = null;
                if (parse != null) {
                    return Integer.valueOf(parse.getElementsByTagName("user").getLength());
                }
                return null;
            }
            if (parse != null) {
                return Integer.valueOf(parse.getElementsByTagName("user").getLength());
            }
        }
        return null;
    }
    */
}