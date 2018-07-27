package live.jetsetradio.jetsetradiolive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.p018b.C0291f;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import info.hoang8f.android.segmented.SegmentedGroup;
import java.util.Random;

/* compiled from: RadioFragment */
public class C1307e extends Fragment {
    private BroadcastReceiver f3412a;
    private C0291f f3413b;
    private MediaPlayer f3414c;
    private boolean f3415d = true;
    private boolean f3416e = true;
    private Integer f3417f = Integer.valueOf(0);
    private Integer f3418g = Integer.valueOf(Color.parseColor("#680b93"));
    private Integer f3419h = Integer.valueOf(Color.parseColor("#a00b82"));
    private Integer f3420i = Integer.valueOf(Color.parseColor("#4c89ab"));
    private Integer f3421j = Integer.valueOf(Color.parseColor("#f1a0f7"));
    private Integer f3422k = Integer.valueOf(Color.parseColor("#867a66"));
    private Integer f3423l = Integer.valueOf(Color.parseColor("#000000"));
    private Integer f3424m = Integer.valueOf(Color.parseColor("#67242e"));
    private boolean f3425n = false;
    private TextView f3426o;

    /* compiled from: RadioFragment */
    class C13055 implements OnClickListener {
        final /* synthetic */ C1307e f3410a;

        C13055(C1307e c1307e) {
            this.f3410a = c1307e;
        }

        public void onClick(View view) {
            if (this.f3410a.f3415d) {
                if (new Random().nextInt(7) == 0) {
                    this.f3410a.f3414c = MediaPlayer.create(this.f3410a.getContext(), R.raw.killsound);
                } else {
                    this.f3410a.f3414c = MediaPlayer.create(this.f3410a.getContext(), R.raw.hitsound);
                }
                this.f3410a.f3414c.start();
            }
            Intent intent = new Intent(this.f3410a.getContext(), MediaPlayerService.class);
            intent.setAction("action_next");
            this.f3410a.getActivity().startService(intent);
        }
    }

    /* compiled from: RadioFragment */
    class C13066 implements OnClickListener {
        final /* synthetic */ C1307e f3411a;

        C13066(C1307e c1307e) {
            this.f3411a = c1307e;
        }

        public void onClick(View view) {
            this.f3411a.startActivity(new Intent(this.f3411a.getContext(), Preferences.class));
        }
    }

    public void onStart() {
        super.onStart();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        this.f3415d = defaultSharedPreferences.getBoolean("bgmsound", true);
        this.f3416e = defaultSharedPreferences.getBoolean("randombg", true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_radio, viewGroup, false);
        this.f3413b = C0291f.m1084a(getContext());
        this.f3412a = new BroadcastReceiver(this) {
            final /* synthetic */ C1307e f3397b;

            public void onReceive(Context context, Intent intent) {
                if (intent.hasExtra("listeners")) {
                    this.f3397b.m5904b(Integer.valueOf(intent.getIntExtra("listeners", 0)));
                } else if (intent.hasExtra("Song")) {
                    ((TextView) viewGroup2.findViewById(R.id.songtitle)).setText(intent.getStringArrayExtra("Song")[0]);
                    ((TextView) viewGroup2.findViewById(R.id.songartist)).setText(intent.getStringArrayExtra("Song")[1]);
                    if (this.f3397b.f3416e && !intent.getStringArrayExtra("Song")[0].equals("") && this.f3397b.f3417f.intValue() == 0) {
                        this.f3397b.m5902a();
                    }
                } else if (intent.hasExtra("Text")) {
                    final String stringExtra = intent.getStringExtra("Text");
                    if (this.f3397b.getActivity() != null) {
                        this.f3397b.getActivity().runOnUiThread(new Runnable(this) {
                            final /* synthetic */ C13011 f3395b;

                            public void run() {
                                Toast makeText = Toast.makeText(this.f3395b.f3397b.getActivity(), stringExtra, 1);
                                TextView textView = (TextView) makeText.getView().findViewById(16908299);
                                if (textView != null) {
                                    textView.setGravity(17);
                                }
                                makeText.show();
                            }
                        });
                    }
                }
            }
        };
        final SegmentedGroup segmentedGroup = (SegmentedGroup) viewGroup2.findViewById(R.id.segmented);
        final SegmentedGroup segmentedGroup2 = (SegmentedGroup) viewGroup2.findViewById(R.id.segmented2);
        final SegmentedGroup segmentedGroup3 = (SegmentedGroup) viewGroup2.findViewById(R.id.segmented3);
        segmentedGroup.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ C1307e f3401d;

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == -1) {
                    return;
                }
                if (this.f3401d.f3425n) {
                    this.f3401d.f3425n = false;
                    return;
                }
                if (!(segmentedGroup2.getCheckedRadioButtonId() == -1 && segmentedGroup3.getCheckedRadioButtonId() == -1)) {
                    this.f3401d.f3425n = true;
                }
                Intent intent = new Intent(this.f3401d.getContext(), MediaPlayerService.class);
                intent.setAction("action_next");
                ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.imageView1);
                switch (i) {
                    case R.id.radioButton:
                        this.f3401d.f3417f = Integer.valueOf(0);
                        intent.putExtra("Station", 0);
                        imageView.setImageResource(R.drawable.classic);
                        break;
                    case R.id.radioButton2:
                        this.f3401d.m5903a(this.f3401d.f3419h);
                        this.f3401d.f3417f = Integer.valueOf(1);
                        intent.putExtra("Station", 1);
                        imageView.setImageResource(R.drawable.loveshockers);
                        break;
                    case R.id.radioButton3:
                        this.f3401d.f3417f = Integer.valueOf(2);
                        this.f3401d.m5903a(this.f3401d.f3420i);
                        intent.putExtra("Station", 2);
                        imageView.setImageResource(R.drawable.noisetanks);
                        break;
                    case R.id.radioButton4:
                        this.f3401d.f3417f = Integer.valueOf(3);
                        this.f3401d.m5903a(this.f3401d.f3418g);
                        intent.putExtra("Station", 3);
                        imageView.setImageResource(R.drawable.poisonjam);
                        break;
                }
                segmentedGroup2.check(-1);
                segmentedGroup3.check(-1);
                this.f3401d.getActivity().startService(intent);
            }
        });
        segmentedGroup2.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ C1307e f3405d;

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == -1) {
                    return;
                }
                if (this.f3405d.f3425n) {
                    this.f3405d.f3425n = false;
                    return;
                }
                if (!(segmentedGroup.getCheckedRadioButtonId() == -1 && segmentedGroup3.getCheckedRadioButtonId() == -1)) {
                    this.f3405d.f3425n = true;
                }
                Intent intent = new Intent(this.f3405d.getContext(), MediaPlayerService.class);
                intent.setAction("action_next");
                ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.imageView1);
                switch (i) {
                    case R.id.radioButton5:
                        this.f3405d.m5903a(this.f3405d.f3421j);
                        this.f3405d.f3417f = Integer.valueOf(4);
                        intent.putExtra("Station", 4);
                        imageView.setImageResource(R.drawable.rapid99);
                        break;
                    case R.id.radioButton6:
                        this.f3405d.m5903a(this.f3405d.f3422k);
                        this.f3405d.f3417f = Integer.valueOf(5);
                        intent.putExtra("Station", 5);
                        imageView.setImageResource(R.drawable.immortals);
                        break;
                    case R.id.radioButton7:
                        this.f3405d.f3417f = Integer.valueOf(6);
                        this.f3405d.m5903a(this.f3405d.f3423l);
                        intent.putExtra("Station", 6);
                        imageView.setImageResource(R.drawable.goldenrhinos);
                        break;
                    case R.id.radioButton8:
                        this.f3405d.f3417f = Integer.valueOf(7);
                        this.f3405d.m5903a(this.f3405d.f3424m);
                        intent.putExtra("Station", 8);
                        imageView.setImageResource(R.drawable.doomriders);
                        break;
                }
                segmentedGroup.check(-1);
                segmentedGroup3.check(-1);
                this.f3405d.getActivity().startService(intent);
            }
        });
        segmentedGroup3.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ C1307e f3409d;

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == -1) {
                    return;
                }
                if (this.f3409d.f3425n) {
                    this.f3409d.f3425n = false;
                    return;
                }
                if (!(segmentedGroup.getCheckedRadioButtonId() == -1 && segmentedGroup2.getCheckedRadioButtonId() == -1)) {
                    this.f3409d.f3425n = true;
                }
                Intent intent = new Intent(this.f3409d.getContext(), MediaPlayerService.class);
                intent.setAction("action_next");
                ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.imageView1);
                switch (i) {
                    case R.id.radioButton9:
                        this.f3409d.f3417f = Integer.valueOf(0);
                        intent.putExtra("Station", 7);
                        imageView.setImageResource(R.drawable.shuffle);
                        break;
                }
                segmentedGroup.check(-1);
                segmentedGroup2.check(-1);
                this.f3409d.getActivity().startService(intent);
            }
        });
        viewGroup2.findViewById(R.id.imageView1).setOnClickListener(new C13055(this));
        viewGroup2.findViewById(R.id.settingsbutton).setOnClickListener(new C13066(this));
        viewGroup2.findViewById(R.id.songtitle).setSelected(true);
        this.f3426o = (TextView) viewGroup2.findViewById(R.id.listeners);
        return viewGroup2;
    }

    public void onActivityCreated(Bundle bundle) {
        Log.e("FRAGMENT", "Activity Created");
        C0291f.m1084a(getContext()).m1087a(this.f3412a, new IntentFilter("JSRL.UPDATEUI"));
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void m5902a() {
        int rgb = Color.rgb((int) (Math.random() * 256.0d), (int) (Math.random() * 256.0d), (int) (Math.random() * 256.0d));
        Intent intent = new Intent();
        intent.setAction("JSRL.UPDATECOLOR");
        intent.putExtra("Color", rgb);
        this.f3413b.m1088a(intent);
    }

    public void m5903a(Integer num) {
        Intent intent = new Intent();
        intent.setAction("JSRL.UPDATECOLOR");
        intent.putExtra("Color", num);
        this.f3413b.m1088a(intent);
    }

    public void m5904b(Integer num) {
        if (this.f3426o == null) {
            return;
        }
        if (num.intValue() != 0) {
            this.f3426o.setText(String.valueOf(num) + " rudies tuned in!");
        } else {
            this.f3426o.setText(" ");
        }
    }

    public void onDestroy() {
        Log.e("DEBUG", "OnDestroy!");
        Intent intent = new Intent(getContext(), MediaPlayerService.class);
        intent.setAction("action_stop");
        getActivity().stopService(intent);
        super.onDestroy();
    }
}
