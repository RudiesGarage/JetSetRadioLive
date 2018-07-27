package live.jetsetradio.jetsetradiolive;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.IBinder;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.support.v4.app.C0271y.C0253a;
import android.support.v4.app.C0271y.C0253a.C0252a;
import android.support.v4.app.C0271y.C0254q;
import android.support.v4.media.session.C0426d;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.C0395a;
import android.support.v4.media.session.PlaybackStateCompat.C0410a;
import android.support.v4.p018b.C0291f;
import android.support.v7.p026a.C0654c.C0647b;
import android.support.v7.p026a.C0654c.C0649h;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.p035a.p036a.C0942a;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MediaPlayerService extends Service {
    private URL f3344A;
    private URL f3345B;
    private URL f3346C;
    private String f3347D = "";
    private String f3348E = "";
    private Timer f3349F;
    private Timer f3350G;
    private C1308f f3351H;
    TelephonyManager f3352a;
    PhoneStateListener f3353b;
    private MediaSessionCompat f3354c;
    private C0426d f3355d;
    private MediaPlayer f3356e;
    private ArrayList<C1308f> f3357f;
    private ArrayList<C1308f> f3358g;
    private ArrayList<C1308f> f3359h;
    private ArrayList<C1308f> f3360i;
    private ArrayList<C1308f> f3361j;
    private ArrayList<C1308f> f3362k;
    private ArrayList<C1308f> f3363l;
    private ArrayList<C1308f> f3364m;
    private ArrayList<C1308f> f3365n;
    private C1308f f3366o;
    private int f3367p = 0;
    private boolean f3368q = false;
    private boolean f3369r = false;
    private C0291f f3370s;
    private IntentFilter f3371t = new IntentFilter("android.media.AUDIO_BECOMING_NOISY");
    private C1289a f3372u;
    private URL f3373v;
    private URL f3374w;
    private URL f3375x;
    private URL f3376y;
    private URL f3377z;

    class C12831 implements OnCompletionListener {
        final /* synthetic */ MediaPlayerService f3337a;

        C12831(MediaPlayerService mediaPlayerService) {
            this.f3337a = mediaPlayerService;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            this.f3337a.f3355d.m1670a().mo279d();
        }
    }

    class C12842 implements OnPreparedListener {
        final /* synthetic */ MediaPlayerService f3338a;

        C12842(MediaPlayerService mediaPlayerService) {
            this.f3338a = mediaPlayerService;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.start();
            this.f3338a.f3368q = false;
            Intent intent = new Intent();
            intent.setAction("JSRL.UPDATEUI");
            intent.putExtra("Song", new String[]{this.f3338a.f3366o.m5906b(), this.f3338a.f3366o.m5905a()});
            this.f3338a.f3370s.m1088a(intent);
            this.f3338a.f3354c.m1579a(new C0410a().m1591a(547).m1589a(3, -1, 1.0f).m1592a());
            this.f3338a.m5857a(this.f3338a.m5852a(17301539, "Pause", "action_pause"));
            this.f3338a.f3369r = false;
        }
    }

    class C12853 extends PhoneStateListener {
        final /* synthetic */ MediaPlayerService f3339a;

        C12853(MediaPlayerService mediaPlayerService) {
            this.f3339a = mediaPlayerService;
        }

        public void onCallStateChanged(int i, String str) {
            if (i == 1 || i == 2) {
                this.f3339a.f3355d.m1670a().mo277b();
            }
            super.onCallStateChanged(i, str);
        }
    }

    class C12864 extends TimerTask {
        final /* synthetic */ MediaPlayerService f3340a;

        C12864(MediaPlayerService mediaPlayerService) {
            this.f3340a = mediaPlayerService;
        }

        public void run() {
            if (PreferenceManager.getDefaultSharedPreferences(this.f3340a.getApplicationContext()).getBoolean("songrequests", true)) {
                this.f3340a.m5865c();
            }
        }
    }

    class C12875 extends TimerTask {
        final /* synthetic */ MediaPlayerService f3341a;

        C12875(MediaPlayerService mediaPlayerService) {
            this.f3341a = mediaPlayerService;
        }

        public void run() {
            new C1298c().execute(new Context[]{this.f3341a.getApplicationContext()});
        }
    }

    class C12886 extends C0395a {
        final /* synthetic */ MediaPlayerService f3342b;

        C12886(MediaPlayerService mediaPlayerService) {
            this.f3342b = mediaPlayerService;
        }

        public void mo878b() {
            super.mo878b();
            if (!this.f3342b.f3368q) {
                this.f3342b.m5870a();
            } else if (!this.f3342b.f3356e.isPlaying()) {
                this.f3342b.f3356e.start();
                this.f3342b.f3368q = false;
                this.f3342b.f3354c.m1579a(new C0410a().m1591a(547).m1589a(3, -1, 1.0f).m1592a());
                this.f3342b.m5857a(this.f3342b.m5852a(17301539, "Pause", "action_pause"));
            }
        }

        public void mo879c() {
            super.mo879c();
            if (this.f3342b.f3356e.isPlaying()) {
                this.f3342b.f3356e.pause();
                this.f3342b.f3368q = true;
                this.f3342b.m5857a(this.f3342b.m5852a(17301540, "Play", "action_play"));
                this.f3342b.f3354c.m1579a(new C0410a().m1591a(549).m1589a(2, -1, 0.0f).m1592a());
            }
        }

        public void mo880d() {
            super.mo880d();
            this.f3342b.m5870a();
        }

        public boolean mo877a(Intent intent) {
            return super.mo877a(intent);
        }

        public void mo881h() {
            super.mo881h();
            Log.e("MediaPlayerService", "onStop");
            if (this.f3342b.f3356e.isPlaying() || this.f3342b.f3368q) {
                this.f3342b.f3356e.stop();
                this.f3342b.f3354c.m1579a(new C0410a().m1591a(551).m1589a(1, -1, 0.0f).m1592a());
                Intent intent = new Intent();
                intent.setAction("JSRL.UPDATEUI");
                intent.putExtra("Song", new String[]{"", ""});
                this.f3342b.f3370s.m1088a(intent);
                ((NotificationManager) this.f3342b.getApplicationContext().getSystemService("notification")).cancel(1);
            }
        }
    }

    private class C1289a extends BroadcastReceiver {
        final /* synthetic */ MediaPlayerService f3343a;

        private C1289a(MediaPlayerService mediaPlayerService) {
            this.f3343a = mediaPlayerService;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f3343a.f3355d.m1670a().mo277b();
            }
        }
    }

    public void onCreate() {
        try {
            this.f3373v = new URL("http://jetsetradio.live/audioplayer/audio/~list.js");
            this.f3374w = new URL("http://jetsetradio.live/audioplayer/audio/poisonjam/~list.js");
            this.f3375x = new URL("http://jetsetradio.live/audioplayer/audio/noisetanks/~list.js");
            this.f3376y = new URL("http://jetsetradio.live/audioplayer/audio/loveshockers/~list.js");
            this.f3377z = new URL("http://jetsetradio.live/audioplayer/audio/rapid99/~list.js");
            this.f3344A = new URL("http://jetsetradio.live/audioplayer/audio/immortals/~list.js");
            this.f3345B = new URL("http://jetsetradio.live/audioplayer/audio/goldenrhinos/~list.js");
            this.f3346C = new URL("http://jetsetradio.live/audioplayer/audio/doomriders/~list.js");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.f3370s = C0291f.m1084a(getApplicationContext());
        this.f3356e = new MediaPlayer();
        this.f3357f = m5855a(this.f3373v);
        this.f3358g = m5855a(this.f3374w);
        this.f3359h = m5855a(this.f3375x);
        this.f3360i = m5855a(this.f3376y);
        this.f3361j = m5855a(this.f3377z);
        this.f3362k = m5855a(this.f3344A);
        this.f3363l = m5855a(this.f3345B);
        this.f3364m = m5855a(this.f3346C);
        this.f3356e.setAudioStreamType(3);
        this.f3356e.setWakeMode(getApplicationContext(), 1);
        this.f3356e.setOnCompletionListener(new C12831(this));
        this.f3356e.setOnPreparedListener(new C12842(this));
        this.f3372u = new C1289a();
        registerReceiver(this.f3372u, this.f3371t);
        this.f3353b = new C12853(this);
        this.f3352a = (TelephonyManager) getSystemService("phone");
        this.f3352a.listen(this.f3353b, 32);
    }

    private void m5856a(Intent intent) {
        if (intent != null && intent.getAction() != null) {
            if (intent.hasExtra("Station")) {
                this.f3367p = intent.getIntExtra("Station", 0);
            }
            String action = intent.getAction();
            if (action.equalsIgnoreCase("action_play")) {
                this.f3355d.m1670a().mo276a();
            } else if (action.equalsIgnoreCase("action_pause")) {
                this.f3355d.m1670a().mo277b();
            } else if (action.equalsIgnoreCase("action_next")) {
                this.f3355d.m1670a().mo279d();
            } else if (action.equalsIgnoreCase("action_stop")) {
                this.f3355d.m1670a().mo278c();
            }
        }
    }

    private C0253a m5852a(int i, String str, String str2) {
        Intent intent = new Intent(getApplicationContext(), MediaPlayerService.class);
        intent.setAction(str2);
        return new C0252a(i, str, PendingIntent.getService(getApplicationContext(), 1, intent, 0)).m976a();
    }

    private void m5857a(C0253a c0253a) {
        C0254q c0649h = new C0649h();
        C0647b c0647b = (C0647b) new C0647b(this).m990a((int) R.drawable.ic_stat_graffitisoul).m993a(BitmapFactory.decodeResource(getResources(), R.drawable.profk)).m996a(this.f3366o.m5906b()).m999b(this.f3366o.m5905a()).m997a(false).m998b(1).m992a(PendingIntent.getActivity(getApplicationContext(), 0, new Intent(this, MainActivity.class), 134217728)).m995a(c0649h);
        c0647b.m994a(m5852a(R.drawable.ic_media_stop, "Stop", "action_stop"));
        c0647b.m994a(c0253a);
        c0647b.m994a(m5852a(17301538, "Next", "action_next"));
        c0649h.m2709a(0, 1, 2);
        Notification a = c0647b.m989a();
        a.flags |= 32;
        ((NotificationManager) getSystemService("notification")).notify(1, a);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Exception e;
        if (intent != null) {
            if (this.f3354c == null) {
                try {
                    m5862b();
                    this.f3349F = new Timer();
                    this.f3349F.scheduleAtFixedRate(new C12864(this), 1000, 5000);
                    this.f3350G = new Timer();
                    this.f3350G.scheduleAtFixedRate(new C12875(this), 0, 60000);
                } catch (InterruptedException e2) {
                    e = e2;
                    e.printStackTrace();
                    m5856a(intent);
                    return 1;
                } catch (MalformedURLException e3) {
                    e = e3;
                    e.printStackTrace();
                    m5856a(intent);
                    return 1;
                } catch (URISyntaxException e4) {
                    e = e4;
                    e.printStackTrace();
                    m5856a(intent);
                    return 1;
                } catch (ExecutionException e5) {
                    e = e5;
                    e.printStackTrace();
                    m5856a(intent);
                    return 1;
                } catch (RemoteException e6) {
                    e = e6;
                    e.printStackTrace();
                    m5856a(intent);
                    return 1;
                }
            }
            m5856a(intent);
        }
        return 1;
    }

    private void m5862b() {
        this.f3354c = new MediaSessionCompat(getApplicationContext(), "Jet Set Radio Live!", new ComponentName(getPackageName(), MediaPlayerService.class.getName()), PendingIntent.getBroadcast(this, 99, new Intent("action_play"), 134217728));
        this.f3355d = new C0426d(getApplicationContext(), this.f3354c.m1581b());
        this.f3354c.m1576a(3);
        this.f3354c.m1580a(true);
        this.f3354c.m1577a(new C12886(this));
    }

    private ArrayList<C1308f> m5855a(URL url) {
        String str;
        Exception e;
        String[] split;
        int i;
        String[] split2;
        C1297b c1297b = new C1297b();
        ArrayList<C1308f> arrayList = new ArrayList();
        String str2 = "";
        if (url == this.f3374w) {
            str = "poisonjam";
        } else if (url == this.f3376y) {
            str = "loveshockers";
        } else if (url == this.f3375x) {
            str = "noisetanks";
        } else if (url == this.f3377z) {
            str = "rapid99";
        } else if (url == this.f3344A) {
            str = "immortals";
        } else if (url == this.f3345B) {
            str = "goldenrhinos";
        } else if (url == this.f3346C) {
            str = "doomriders";
        } else {
            str = str2;
        }
        try {
            str2 = (String) c1297b.execute(new URL[]{url}).get();
        } catch (InterruptedException e2) {
            e = e2;
            e.printStackTrace();
            str2 = null;
            if (str2 != null) {
                return null;
            }
            split = str2.split(";");
            for (i = 0; i < split.length; i++) {
                split2 = split[i].split("\"");
                if (split2.length > 1) {
                    split[i] = split2[1];
                }
                try {
                    arrayList.add(new C1308f(split[i], new URI("http", "//jetsetradio.live/audioplayer/audio/" + str + "/" + split[i] + ".mp3", null).toURL()));
                } catch (MalformedURLException e3) {
                    Exception e4 = e3;
                } catch (URISyntaxException e5) {
                    e4 = e5;
                }
            }
            return arrayList;
        } catch (ExecutionException e6) {
            e = e6;
            e.printStackTrace();
            str2 = null;
            if (str2 != null) {
                return null;
            }
            split = str2.split(";");
            for (i = 0; i < split.length; i++) {
                split2 = split[i].split("\"");
                if (split2.length > 1) {
                    split[i] = split2[1];
                }
                arrayList.add(new C1308f(split[i], new URI("http", "//jetsetradio.live/audioplayer/audio/" + str + "/" + split[i] + ".mp3", null).toURL()));
            }
            return arrayList;
        }
        if (str2 != null) {
            return null;
        }
        split = str2.split(";");
        for (i = 0; i < split.length; i++) {
            split2 = split[i].split("\"");
            if (split2.length > 1) {
                split[i] = split2[1];
            }
            arrayList.add(new C1308f(split[i], new URI("http", "//jetsetradio.live/audioplayer/audio/" + str + "/" + split[i] + ".mp3", null).toURL()));
        }
        return arrayList;
        e4.printStackTrace();
    }

    public void m5870a() {
        if (this.f3357f == null) {
            this.f3357f = m5855a(this.f3373v);
        }
        if (this.f3360i == null) {
            this.f3360i = m5855a(this.f3376y);
        }
        if (this.f3359h == null) {
            this.f3359h = m5855a(this.f3375x);
        }
        if (this.f3358g == null) {
            this.f3358g = m5855a(this.f3374w);
        }
        if (this.f3361j == null) {
            this.f3361j = m5855a(this.f3377z);
        }
        if (this.f3362k == null) {
            this.f3362k = m5855a(this.f3344A);
        }
        if (this.f3363l == null) {
            this.f3363l = m5855a(this.f3345B);
        }
        if (this.f3364m == null) {
            this.f3364m = m5855a(this.f3346C);
        }
        if (!this.f3369r) {
            if (this.f3357f == null || this.f3360i == null || this.f3359h == null || this.f3358g == null || this.f3361j == null || this.f3362k == null || this.f3363l == null || this.f3364m == null) {
                Log.e("DEBUG", "No Internet");
                Toast makeText = Toast.makeText(getApplicationContext(), "Unable to start playback\nNo internet detected.", 0);
                TextView textView = (TextView) makeText.getView().findViewById(16908299);
                if (textView != null) {
                    textView.setGravity(17);
                }
                makeText.show();
                return;
            }
            this.f3365n = new ArrayList();
            this.f3365n.addAll(this.f3357f);
            this.f3365n.addAll(this.f3359h);
            this.f3365n.addAll(this.f3358g);
            this.f3365n.addAll(this.f3361j);
            this.f3365n.addAll(this.f3362k);
            this.f3365n.addAll(this.f3363l);
            this.f3365n.addAll(this.f3364m);
            if (this.f3351H == null) {
                switch (this.f3367p) {
                    case 0:
                        this.f3366o = (C1308f) this.f3357f.get(new Random().nextInt(this.f3357f.size()));
                        break;
                    case 1:
                        this.f3366o = (C1308f) this.f3360i.get(new Random().nextInt(this.f3360i.size()));
                        break;
                    case 2:
                        this.f3366o = (C1308f) this.f3359h.get(new Random().nextInt(this.f3359h.size()));
                        break;
                    case 3:
                        this.f3366o = (C1308f) this.f3358g.get(new Random().nextInt(this.f3358g.size()));
                        break;
                    case 4:
                        this.f3366o = (C1308f) this.f3361j.get(new Random().nextInt(this.f3361j.size()));
                        break;
                    case 5:
                        this.f3366o = (C1308f) this.f3362k.get(new Random().nextInt(this.f3362k.size()));
                        break;
                    case 6:
                        this.f3366o = (C1308f) this.f3363l.get(new Random().nextInt(this.f3363l.size()));
                        break;
                    case 7:
                        this.f3366o = (C1308f) this.f3365n.get(new Random().nextInt(this.f3365n.size()));
                        break;
                    case 8:
                        this.f3366o = (C1308f) this.f3364m.get(new Random().nextInt(this.f3364m.size()));
                        break;
                    default:
                        break;
                }
            }
            this.f3366o = this.f3351H;
            this.f3351H = null;
            this.f3356e.reset();
            try {
                this.f3356e.setDataSource(this.f3366o.m5907c().toString());
                Log.e("DEBUG", this.f3366o.m5907c().toString());
            } catch (Throwable e) {
                C0942a.m4691a(e);
            }
            this.f3356e.prepareAsync();
            this.f3369r = true;
        }
    }

    private void m5858a(String str) {
        String str2;
        C1308f c1308f;
        Exception e;
        Log.e("DEBUG", str);
        Log.e("DEBUG", Html.fromHtml(str).toString());
        String[] split = str.split("/");
        if (split.length < 2) {
            str2 = str;
        } else {
            str2 = split[1];
        }
        try {
            c1308f = new C1308f(str2, new URI("http", "//jetsetradio.live/audioplayer/audio/" + str + ".mp3", null).toURL());
        } catch (MalformedURLException e2) {
            e = e2;
            e.printStackTrace();
            c1308f = null;
            if (c1308f == null) {
                Log.e("DEBUG", c1308f.toString());
                this.f3351H = c1308f;
                this.f3351H.m5908d();
                if (!this.f3356e.isPlaying()) {
                    this.f3355d.m1670a().mo279d();
                }
            }
        } catch (URISyntaxException e3) {
            e = e3;
            e.printStackTrace();
            c1308f = null;
            if (c1308f == null) {
                Log.e("DEBUG", c1308f.toString());
                this.f3351H = c1308f;
                this.f3351H.m5908d();
                if (!this.f3356e.isPlaying()) {
                    this.f3355d.m1670a().mo279d();
                }
            }
        }
        if (c1308f == null) {
            Log.e("DEBUG", c1308f.toString());
            this.f3351H = c1308f;
            this.f3351H.m5908d();
            if (!this.f3356e.isPlaying()) {
                this.f3355d.m1670a().mo279d();
            }
        }
    }

    private void m5865c() {
        CharSequence charSequence;
        Exception e;
        Pattern compile;
        Matcher matcher;
        C1297b c1297b = new C1297b();
        try {
            URL url = new URL("http://jetsetradio.live/messages/messages.xml?100000000" + new Random().nextInt(900000000));
            charSequence = (String) c1297b.execute(new URL[]{url}).get();
        } catch (MalformedURLException e2) {
            e = e2;
            e.printStackTrace();
            charSequence = null;
            compile = Pattern.compile("<message>(.*?)</message>");
            if (charSequence != null) {
                matcher = compile.matcher(charSequence);
                if (!matcher.find()) {
                    if (matcher.group(1).contains("REQUEST")) {
                    }
                    if (!matcher.group(1).contains("SCREEN:")) {
                        return;
                    }
                    return;
                }
                return;
            }
        } catch (InterruptedException e3) {
            e = e3;
            e.printStackTrace();
            charSequence = null;
            compile = Pattern.compile("<message>(.*?)</message>");
            if (charSequence != null) {
                matcher = compile.matcher(charSequence);
                if (!matcher.find()) {
                    if (matcher.group(1).contains("REQUEST")) {
                    }
                    if (!matcher.group(1).contains("SCREEN:")) {
                        return;
                    }
                    return;
                }
                return;
            }
        } catch (ExecutionException e4) {
            e = e4;
            e.printStackTrace();
            charSequence = null;
            compile = Pattern.compile("<message>(.*?)</message>");
            if (charSequence != null) {
                matcher = compile.matcher(charSequence);
                if (!matcher.find()) {
                    if (matcher.group(1).contains("REQUEST")) {
                    }
                    if (!matcher.group(1).contains("SCREEN:")) {
                        return;
                    }
                    return;
                }
                return;
            }
        } catch (NullPointerException e5) {
            e = e5;
            e.printStackTrace();
            charSequence = null;
            compile = Pattern.compile("<message>(.*?)</message>");
            if (charSequence != null) {
                matcher = compile.matcher(charSequence);
                if (!matcher.find()) {
                    if (matcher.group(1).contains("REQUEST")) {
                    }
                    if (!matcher.group(1).contains("SCREEN:")) {
                        return;
                    }
                    return;
                }
                return;
            }
        }
        compile = Pattern.compile("<message>(.*?)</message>");
        if (charSequence != null) {
            matcher = compile.matcher(charSequence);
            if (!matcher.find()) {
                return;
            }
            if (matcher.group(1).contains("REQUEST") || matcher.group(1).equals(this.f3347D)) {
                if (!matcher.group(1).contains("SCREEN:") && !matcher.group(1).contains("SNAPSHOT:") && !matcher.group(1).contains("REQUEST:") && !this.f3348E.equalsIgnoreCase(matcher.group(1))) {
                    Intent intent = new Intent();
                    intent.setAction("JSRL.UPDATEUI");
                    intent.putExtra("Text", "DJ Professor K:\n" + matcher.group(1));
                    this.f3370s.m1088a(intent);
                    this.f3348E = matcher.group(1);
                }
            } else if (this.f3365n != null) {
                this.f3347D = matcher.group(1);
                m5858a(matcher.group(1).substring(9));
            }
        }
    }

    public void onTaskRemoved(Intent intent) {
        Log.e("DEBUG", "onTaskRemoved");
        super.onTaskRemoved(intent);
        stopSelf();
    }

    public void onDestroy() {
        Log.e("DEBUG", "onDestroy");
        unregisterReceiver(this.f3372u);
        this.f3352a.listen(this.f3353b, 0);
        ((NotificationManager) getApplicationContext().getSystemService("notification")).cancelAll();
        this.f3354c.m1575a();
        this.f3349F.cancel();
        this.f3356e.release();
        onTaskRemoved(new Intent());
    }

    public IBinder onBind(Intent intent) {
        Log.e("DEBUG", "onBind");
        return null;
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
