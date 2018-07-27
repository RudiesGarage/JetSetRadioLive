package live.jetsetradio.jetsetradiolive;

import android.os.AsyncTask;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/* compiled from: POSTAsync */
public class C1299d extends AsyncTask<Object, Long, Integer> {
    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m5886a(objArr);
    }

    protected Integer m5886a(Object... objArr) {
        Integer num = null;
        String[] strArr = (String[]) objArr[1];
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URL) objArr[0]).openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            Object obj = num;
        }
        if (httpURLConnection != null) {
            OutputStream outputStream;
            String str;
            try {
                httpURLConnection.setRequestMethod("POST");
            } catch (ProtocolException e2) {
                e2.printStackTrace();
            }
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            try {
                outputStream = httpURLConnection.getOutputStream();
            } catch (IOException e3) {
                e3.printStackTrace();
                Object obj2 = num;
            }
            try {
                str = "chatmessage=" + URLEncoder.encode(strArr[0], "UTF-8") + "&username=" + URLEncoder.encode(strArr[1], "UTF-8") + "&chatpassword=" + URLEncoder.encode(strArr[2], "UTF-8");
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
                Object obj3 = num;
            }
            if (!(outputStream == null || str == null)) {
                try {
                    outputStream.write(str.getBytes("UTF-8"));
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            try {
                num = Integer.valueOf(httpURLConnection.getResponseCode());
            } catch (IOException e52) {
                e52.printStackTrace();
            }
            if (num == null) {
                Log.e("DEBUG", "ResponseCode is Null");
            } else if (num.intValue() == 200) {
                httpURLConnection.disconnect();
                return Integer.valueOf(1);
            } else {
                httpURLConnection.disconnect();
                return Integer.valueOf(0);
            }
        }
        return Integer.valueOf(0);
    }
}
