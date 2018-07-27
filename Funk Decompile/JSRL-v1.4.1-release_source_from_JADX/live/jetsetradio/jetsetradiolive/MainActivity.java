package live.jetsetradio.jetsetradiolive;

import android.animation.ArgbEvaluator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.C0223j;
import android.support.v4.app.C0226n;
import android.support.v4.app.C0237q;
import android.support.v4.app.Fragment;
import android.support.v4.p018b.C0291f;
import android.support.v4.view.C0236z;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0457f;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import com.p035a.p036a.C0942a;
import p000a.p001a.p002a.p003a.C0142c;

public class MainActivity extends C0223j {
    ArgbEvaluator f3332n = new ArgbEvaluator();
    Integer[] f3333o;
    private ViewPager f3334p;
    private C0236z f3335q;
    private int f3336r;

    class C12801 extends BroadcastReceiver {
        final /* synthetic */ MainActivity f3329a;

        C12801(MainActivity mainActivity) {
            this.f3329a = mainActivity;
        }

        public void onReceive(Context context, Intent intent) {
            this.f3329a.f3333o[0] = Integer.valueOf(intent.getExtras().getInt("Color"));
            if (this.f3329a.f3336r == 0) {
                this.f3329a.f3334p.setBackgroundColor(this.f3329a.f3333o[0].intValue());
            }
        }
    }

    private class C1281a implements C0457f {
        final /* synthetic */ MainActivity f3330a;

        private C1281a(MainActivity mainActivity) {
            this.f3330a = mainActivity;
        }

        public void mo870a(int i, float f, int i2) {
            this.f3330a.f3336r = i;
            if (i >= this.f3330a.f3335q.mo873b() - 1 || i >= this.f3330a.f3333o.length - 1) {
                this.f3330a.f3334p.setBackgroundColor(this.f3330a.f3333o[this.f3330a.f3333o.length - 1].intValue());
            } else {
                this.f3330a.f3334p.setBackgroundColor(((Integer) this.f3330a.f3332n.evaluate(f, this.f3330a.f3333o[i], this.f3330a.f3333o[i + 1])).intValue());
            }
        }

        public void mo869a(int i) {
        }

        public void mo871b(int i) {
            if (i == 1) {
                this.f3330a.m5846f();
            }
        }
    }

    private class C1282b extends C0237q {
        final /* synthetic */ MainActivity f3331a;

        public C1282b(MainActivity mainActivity, C0226n c0226n) {
            this.f3331a = mainActivity;
            super(c0226n);
        }

        public Fragment mo872a(int i) {
            if (i == 0) {
                return new C1307e();
            }
            return new C1296a();
        }

        public int mo873b() {
            return 2;
        }
    }

    protected void onCreate(Bundle bundle) {
        setVolumeControlStream(3);
        super.onCreate(bundle);
        C0142c.m459a((Context) this, new C0942a());
        setContentView(R.layout.screen_slide);
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        this.f3333o = new Integer[]{Integer.valueOf(Color.parseColor("#" + Integer.toHexString(getResources().getColor(R.color.md_orange_500)).toUpperCase())), Integer.valueOf(Color.parseColor("#" + Integer.toHexString(getResources().getColor(R.color.md_orange_500)).toUpperCase()))};
        this.f3335q = new C1282b(this, m780e());
        this.f3334p = (ViewPager) findViewById(R.id.pager);
        this.f3334p.setAdapter(this.f3335q);
        this.f3334p.m1775a(new C1281a());
        C0291f.m1084a(getApplicationContext()).m1087a(new C12801(this), new IntentFilter("JSRL.UPDATECOLOR"));
        getWindow().setSoftInputMode(3);
        Intent intent = new Intent(getApplicationContext(), MediaPlayerService.class);
        intent.setAction("action_preload");
        startService(intent);
    }

    protected void onStart() {
        Log.e("DEBUG", "MainActivity ONSTART");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        this.f3333o[1] = Integer.valueOf(Color.parseColor("#" + Integer.toHexString(defaultSharedPreferences.getInt("chatbg", getResources().getColor(R.color.md_orange_500))).toUpperCase()));
        if (!defaultSharedPreferences.getBoolean("randombg", true) && this.f3336r == 0) {
            this.f3333o[0] = Integer.valueOf(Color.parseColor("#" + Integer.toHexString(defaultSharedPreferences.getInt("radiobg", getResources().getColor(R.color.md_orange_500))).toUpperCase()));
            this.f3334p.setBackgroundColor(this.f3333o[0].intValue());
        }
        super.onStart();
        m5846f();
    }

    protected void onStop() {
        Log.e("DEBUG", "MainActivity ONSTOP");
        super.onStop();
    }

    private void m5846f() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f3334p.getWindowToken(), 0);
    }

    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
