package live.jetsetradio.jetsetradiolive;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* compiled from: ChatFragment */
public class C1296a extends Fragment {
    private ArrayList<String> f3385a = new ArrayList();
    private ArrayAdapter<String> f3386b;
    private boolean f3387c = true;
    private ListView f3388d;
    private EditText f3389e;
    private String f3390f;
    private int f3391g;
    private Timer f3392h;

    /* compiled from: ChatFragment */
    class C12911 extends TimerTask {
        final /* synthetic */ C1296a f3379a;

        C12911(C1296a c1296a) {
            this.f3379a = c1296a;
        }

        public void run() {
            if (this.f3379a.getActivity() != null) {
                this.f3379a.m5871a();
            }
        }
    }

    /* compiled from: ChatFragment */
    class C12922 implements OnClickListener {
        final /* synthetic */ C1296a f3380a;

        C12922(C1296a c1296a) {
            this.f3380a = c1296a;
        }

        public void onClick(View view) {
            this.f3380a.m5874b();
        }
    }

    /* compiled from: ChatFragment */
    class C12955 implements Runnable {
        final /* synthetic */ C1296a f3384a;

        C12955(C1296a c1296a) {
            this.f3384a = c1296a;
        }

        public void run() {
            if (this.f3384a.getActivity() != null) {
                Toast makeText = Toast.makeText(this.f3384a.getActivity(), "No Internet detected\nThe Noise Tanks must be behind this!", 0);
                TextView textView = (TextView) makeText.getView().findViewById(16908299);
                if (textView != null) {
                    textView.setGravity(17);
                }
                makeText.show();
            }
        }
    }

    public void onStart() {
        super.onStart();
        Log.e("DEBUG", "ChatFragment ONstart");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        this.f3390f = defaultSharedPreferences.getString("username", "fail");
        this.f3391g = Integer.valueOf(defaultSharedPreferences.getString("chatsize", "17")).intValue();
        getActivity().findViewById(R.id.listView);
        this.f3392h = new Timer();
        this.f3392h.scheduleAtFixedRate(new C12911(this), 0, 5000);
    }

    public void onStop() {
        super.onStop();
        this.f3392h.cancel();
        Log.e("DEBUG", "Onstop Chatfragment");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_chat, viewGroup, false);
        ((Button) viewGroup2.findViewById(R.id.send)).setOnClickListener(new C12922(this));
        this.f3388d = (ListView) viewGroup2.findViewById(R.id.listView);
        this.f3388d.setTranscriptMode(1);
        this.f3389e = (EditText) viewGroup2.findViewById(R.id.editText);
        List asList = Arrays.asList(new String[]{"Coin", "Captain Onishima", "Combo", "Corn", "Cube", "Garam", "Goji Rokkaku", "Gum", "Love Shocker", "Mew", "Piranha", "Poison Jam", "Pots", "Slate", "YoYo"});
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        if (defaultSharedPreferences.getBoolean("firsttime", true)) {
            Editor edit = defaultSharedPreferences.edit();
            edit.putString("username", (String) asList.get(new Random().nextInt(asList.size())));
            edit.putBoolean("firsttime", false);
            edit.apply();
        }
        return viewGroup2;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Log.e("DEBUG", "ActivityCreated ChatFragment");
        this.f3386b = new ArrayAdapter<String>(this, getContext(), R.layout.chat_row_layout, this.f3385a) {
            final /* synthetic */ C1296a f3381a;

            public View getView(int i, View view, ViewGroup viewGroup) {
                if (view == null) {
                    view = ((LayoutInflater) this.f3381a.getActivity().getSystemService("layout_inflater")).inflate(R.layout.chat_row_layout, null);
                }
                TextView textView = (TextView) view.findViewById(R.id.row);
                textView.setTextSize(2, (float) this.f3381a.f3391g);
                if (i < getCount()) {
                    textView.setText(Html.fromHtml((String) getItem(i)));
                } else {
                    Log.e("DEBUG", "Something Bad happened with position and getCount.");
                }
                return view;
            }
        };
    }

    private void m5871a() {
        Document parse;
        Exception e;
        final NodeList elementsByTagName;
        C1297b c1297b = new C1297b();
        try {
            URL url = new URL("http://jetsetradio.live/chat/messages.xml?100000000" + new Random().nextInt(900000000));
            String str = (String) c1297b.execute(new URL[]{url}).get();
            if (str != null) {
                InputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes(Charset.forName("UTF-8")));
                DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
                newInstance.setIgnoringElementContentWhitespace(true);
                try {
                    parse = newInstance.newDocumentBuilder().parse(byteArrayInputStream);
                } catch (ParserConfigurationException e2) {
                    e = e2;
                    e.printStackTrace();
                    parse = null;
                    if (parse == null) {
                        parse.getDocumentElement().normalize();
                        elementsByTagName = parse.getElementsByTagName("message");
                        if (!isAdded()) {
                            getActivity().runOnUiThread(new Runnable(this) {
                                final /* synthetic */ C1296a f3383b;

                                public void run() {
                                    this.f3383b.f3386b.setNotifyOnChange(false);
                                    if (!this.f3383b.f3385a.isEmpty()) {
                                        this.f3383b.f3385a.clear();
                                    }
                                    for (int i = 0; i < elementsByTagName.getLength(); i++) {
                                        Element element = (Element) elementsByTagName.item(i);
                                        String textContent = element.getElementsByTagName("username").item(0).getTextContent();
                                        if (textContent != null) {
                                            if (textContent.contains("<font")) {
                                                textContent = textContent.replaceAll("<font style='color:#(.{6});'>", "<font color=\"#$1\">");
                                            } else if (Html.fromHtml(textContent).toString().equalsIgnoreCase("djprofessork")) {
                                                textContent = "<font color=\"#fff000\"><b>" + Html.fromHtml(textContent).toString() + "</b></font>";
                                            } else {
                                                textContent = "<font color=\"#336699\">" + Html.fromHtml(textContent).toString() + "</font>";
                                            }
                                            String textContent2 = element.getElementsByTagName("text").item(0).getTextContent();
                                            if (textContent2 != null) {
                                                textContent2 = Html.fromHtml(textContent2).toString();
                                            } else {
                                                textContent2 = "";
                                            }
                                            this.f3383b.f3385a.add(textContent + ": " + textContent2);
                                        }
                                    }
                                    this.f3383b.f3386b.setNotifyOnChange(true);
                                    if (this.f3383b.f3388d.getAdapter() == null) {
                                        this.f3383b.f3388d.setAdapter(this.f3383b.f3386b);
                                        this.f3383b.f3386b.notifyDataSetChanged();
                                    } else {
                                        this.f3383b.f3386b.notifyDataSetChanged();
                                    }
                                    if (this.f3383b.f3387c) {
                                        this.f3383b.f3388d.setSelection(this.f3383b.f3385a.size() - 1);
                                        this.f3383b.f3387c = false;
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
                } catch (SAXException e3) {
                    e = e3;
                    e.printStackTrace();
                    parse = null;
                    if (parse == null) {
                        parse.getDocumentElement().normalize();
                        elementsByTagName = parse.getElementsByTagName("message");
                        if (!isAdded()) {
                            getActivity().runOnUiThread(/* anonymous class already generated */);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    parse = null;
                    if (parse == null) {
                        parse.getDocumentElement().normalize();
                        elementsByTagName = parse.getElementsByTagName("message");
                        if (!isAdded()) {
                            getActivity().runOnUiThread(/* anonymous class already generated */);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (parse == null) {
                    parse.getDocumentElement().normalize();
                    elementsByTagName = parse.getElementsByTagName("message");
                    if (!isAdded()) {
                        getActivity().runOnUiThread(/* anonymous class already generated */);
                        return;
                    }
                    return;
                }
                return;
            }
            Log.e("DEBUG", "No Internet");
            if (getActivity() != null) {
                getActivity().runOnUiThread(new C12955(this));
            }
        } catch (MalformedURLException e5) {
            e = e5;
            e.printStackTrace();
        } catch (InterruptedException e6) {
            e = e6;
            e.printStackTrace();
        } catch (ExecutionException e7) {
            e = e7;
            e.printStackTrace();
        } catch (NullPointerException e8) {
            e = e8;
            e.printStackTrace();
        }
    }

    private void m5874b() {
        if (!this.f3389e.getText().toString().equals("")) {
            URL url;
            this.f3389e.setText("");
            try {
                url = new URL("http://jetsetradio.live/chat/save.php");
            } catch (MalformedURLException e) {
                e.printStackTrace();
                url = null;
            }
            String[] strArr = new String[]{r2, this.f3390f, "false"};
            new C1299d().execute(new Object[]{url, strArr});
            m5871a();
        }
    }
}
