package live.jetsetradio.jetsetradiolive;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: DownloadAsync */
public class C1297b extends AsyncTask<URL, Long, String> {
    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m5881a((URL[]) objArr);
    }

    protected String m5881a(URL... urlArr) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlArr[0].openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setReadTimeout(5000);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
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
