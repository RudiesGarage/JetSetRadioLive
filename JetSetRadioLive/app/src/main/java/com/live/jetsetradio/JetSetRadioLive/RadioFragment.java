package com.live.jetsetradio.JetSetRadioLive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.StyleableRes;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import info.hoang8f.android.segmented.SegmentedGroup;

import java.io.IOException;
import java.util.Random;
import java.util.prefs.Preferences;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link //RadioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the //{@link RadioFragment#//newInstance} factory method to
 * create an instance of this fragment.
 */
public class RadioFragment extends Fragment {

    private BroadcastReceiver My_BroadcastReciever;
    private LocalBroadcastManager BroadcastManager;
    private MediaPlayer mp;
    private boolean bgmsound = true;
    private boolean randombg = true;
    private Integer bgcolor = Integer.valueOf(0);
    private Integer f3418g = Integer.valueOf(Color.parseColor("#680b93"));
    private Integer f3419h = Integer.valueOf(Color.parseColor("#a00b82"));
    private Integer f3420i = Integer.valueOf(Color.parseColor("#4c89ab"));
    private Integer f3421j = Integer.valueOf(Color.parseColor("#f1a0f7"));
    private Integer f3422k = Integer.valueOf(Color.parseColor("#867a66"));
    private Integer f3423l = Integer.valueOf(Color.parseColor("#000000"));
    private Integer f3424m = Integer.valueOf(Color.parseColor("#67242e"));
    private boolean f3425n = false;
    Bundle bundle = new Bundle();

    private TextView f3426o;
    private TypedArray Wallpaper;
    @StyleableRes int index;
    /* compiled from: RadioFragment */
    class C13055 implements View.OnClickListener {
        final /* synthetic */ RadioFragment rf;

        C13055(RadioFragment rf) {
            this.rf = rf;
        }

        public void onClick(View view) {

            if (this.rf.bgmsound) {
                if (new Random().nextInt(7) == 0) {
                    this.rf.mp = MediaPlayer.create(this.rf.getContext(), R.raw.killsound);
                } else {
                    this.rf.mp = MediaPlayer.create(this.rf.getContext(), R.raw.hitsound);
                }

                this.rf.mp.start();
            }
            Intent intent = new Intent(this.rf.getContext(), MediaPlayerS.class);
            intent.setAction("action_next");
            this.rf.getActivity().startService(intent);
        }
    }



    /* compiled from: RadioFragment */
    class C13066 implements View.OnClickListener {
        final /* synthetic */ RadioFragment f3411a;

        C13066(RadioFragment c1307e) {
            this.f3411a = c1307e;
        }

        public void onClick(View view) {
            this.f3411a.startActivity(new Intent(this.f3411a.getContext(), Preferences.class));
        }
    }

    public void onStart() {
        super.onStart();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        this.bgmsound = defaultSharedPreferences.getBoolean("bgmsound", true);
        this.randombg = defaultSharedPreferences.getBoolean("randombg", true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Wallpaper = getResources().obtainTypedArray(R.array.wallpapers);

        final ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_radio, viewGroup, false);
        this.BroadcastManager = LocalBroadcastManager.getInstance(getContext());
       this.My_BroadcastReciever = new BroadcastReceiver() {
            final RadioFragment f3397b = new RadioFragment();

            public void onReceive(Context context, Intent intent) {
                if (intent.hasExtra("listeners")) {
                    this.f3397b.listenerCount(Integer.valueOf(intent.getIntExtra("listeners", 0)));
                } else if (intent.hasExtra("Song")) {
                    ((TextView) viewGroup2.findViewById(R.id.songtitle)).setText(intent.getStringArrayExtra("Song")[0]);
                    ((TextView) viewGroup2.findViewById(R.id.songartist)).setText(intent.getStringArrayExtra("Song")[1]);
                    if (this.f3397b.randombg && !intent.getStringArrayExtra("Song")[0].equals("") && this.f3397b.bgcolor.intValue() == 0) {
                        this.f3397b.RandomBGColor();
                    }
                } else if (intent.hasExtra("Text")) {
                    final String stringExtra = intent.getStringExtra("Text");
                    if (this.f3397b.getActivity() != null) {
                        this.f3397b.getActivity().runOnUiThread(new Runnable() {
                           // final /* synthetic */ C13011 f3395b;

                           public void run() {
                               // Toast makeText = Toast.makeText(this.f3395b.f3397b.getActivity(), stringExtra, 1);
                               // TextView textView = (TextView) makeText.getView().findViewById(16908299);
                               // if (textView != null) {
                            //        textView.setGravity(17);
                            //    }
                            //    makeText.show();
                            }
                        });
                    }
                }
            }
        };



        final SegmentedGroup segmentedGroup = viewGroup2.findViewById(R.id.segmented1);
        final SegmentedGroup segmentedGroup2 =  viewGroup2.findViewById(R.id.segmented2);
        final SegmentedGroup segmentedGroup3 = viewGroup2.findViewById(R.id.segmented3);
        final SegmentedGroup segmentedGroup4 = viewGroup2.findViewById(R.id.segmented4);
        segmentedGroup4.check(R.id.Shuffle);
        final   RadioFragment publicradio = new RadioFragment();
        final Intent intent = new Intent(getActivity().getBaseContext(), MediaPlayerS.class);
        //Button Handlers for row 1
        segmentedGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
         //   final /* synthetic */ RadioFragment rf;

            final RadioFragment JSRadio = publicradio;

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == -1) {
                    return;
                }
                if (this.JSRadio.f3425n) {
                    this.JSRadio.f3425n = false;
                    return;
                }
                if (!(segmentedGroup2.getCheckedRadioButtonId() == -1 && segmentedGroup3.getCheckedRadioButtonId() == -1 && segmentedGroup4.getCheckedRadioButtonId() == -1)) {
                    this.JSRadio.f3425n = true;
                }
             // Intent intent = new Intent(getActivity().getBaseContext(), MediaPlayerS.class);
               intent.setAction("action_next");
                ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.StationLogo);
                switch (i) {

                    case R.id.Summer:
                        //Log.e("DEBUG", "OnDestroy!");
                       // this.JSRadio.bgcolor = Integer.valueOf(0);
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index=11));
                        imageView.setImageResource(R.drawable.summer);
                        intent.putExtra("Station", 11);
                        //imageView.setImageResource(R.drawable.Summer);
                        break;
                    case R.id.Classic:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index = 1));
                        imageView.setImageResource(R.drawable.classic);
                       // this.JSRadio.changeBG(this.JSRadio.f3419h);
                       // this.JSRadio.bgcolor = Integer.valueOf(1);
                      //  publicradio.bundle.putInt("Station", 1);
                       // publicradio.setArguments(publicradio.bundle);
                        intent.putExtra("Station", 1);
                        //imageView.setImageResource(R.drawable.Classic);
                        break;
                    case R.id.Future:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index = 2));
                        imageView.setImageResource(R.drawable.future);
                        //this.JSRadio.bgcolor = Integer.valueOf(2);
                       // this.JSRadio.changeBG(this.JSRadio.f3420i);
                       intent.putExtra("Station", 2);

                       // imageView.setImageResource(R.drawable.Future);
                        break;
                    case R.id.GGs:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index = 3));
                        imageView.setImageResource(R.drawable.ggs);
                      //  this.JSRadio.bgcolor = Integer.valueOf(3);
                       // this.JSRadio.changeBG(this.JSRadio.f3418g);
                        intent.putExtra("Station", 3);
                       // imageView.setImageResource(R.drawable.GGs);
                        break;

                }
                segmentedGroup2.check(-1);
                segmentedGroup3.check(-1);
                segmentedGroup4.check(-1);
                getActivity().startService(intent);
            }
        });

        //Button Handlers for row 2
        segmentedGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            RadioFragment JSRadio = publicradio;

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == -1) {
                    return;
                }
                if (this.JSRadio.f3425n) {
                    this.JSRadio.f3425n = false;
                    return;
                }
                if (!(segmentedGroup.getCheckedRadioButtonId() == -1 && segmentedGroup3.getCheckedRadioButtonId() == -1 && segmentedGroup4.getCheckedRadioButtonId() == -1)) {
                    this.JSRadio.f3425n = true;
                }
            //   Intent intent = new Intent(publicradio.getContext(), MediaPlayerS.class);
                    intent.setAction("action_next");
                ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.StationLogo);
                switch (i) {

                    case R.id.PoisonJam:
                        //Log.e("DEBUG", "OnDestroy!");
                        //this.JSRadio.bgcolor = Integer.valueOf(0);
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index=4));
                        imageView.setImageResource(R.drawable.poisonjam);
                        intent.putExtra("Station", 4);
                        System.out.println(intent.getExtras().getInt("Station"));
                        //imageView.setImageResource(R.drawable.Summer);
                        break;
                    case R.id.NoiseTanks:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index = 5));
                        imageView.setImageResource(R.drawable.noisetanks);
                        //this.JSRadio.changeBG(this.JSRadio.f3419h);1
                        //this.JSRadio.bgcolor = Integer.valueOf(1);
                         intent.putExtra("Station", 5);
                        //imageView.setImageResource(R.drawable.Classic);
                        break;
                    case R.id.LoveShockers:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index = 6));
                        imageView.setImageResource(R.drawable.loveshockers);
                        //this.JSRadio.bgcolor = Integer.valueOf(2);
                        // this.JSRadio.changeBG(this.JSRadio.f3420i);
                          intent.putExtra("Station", 6);
                        // imageView.setImageResource(R.drawable.Future);
                        break;


                }
                segmentedGroup.check(-1);
                segmentedGroup3.check(-1);
                segmentedGroup4.check(-1);
                getActivity().startService(intent);
            }
        });

        //Button Handlers for row 3
        segmentedGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            RadioFragment JSRadio = publicradio;

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == -1) {
                    return;
                }
                if (this.JSRadio.f3425n) {
                    this.JSRadio.f3425n = false;
                    return;
                }
                if (!(segmentedGroup2.getCheckedRadioButtonId() == -1 && segmentedGroup.getCheckedRadioButtonId() == -1 && segmentedGroup4.getCheckedRadioButtonId() == -1)) {
                    this.JSRadio.f3425n = true;
                }

                    intent.setAction("action_next");
                ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.StationLogo);
                switch (i) {

                    case R.id.Rapid99:
                        //Log.e("DEBUG", "OnDestroy!");
                        //this.JSRadio.bgcolor = Integer.valueOf(0);
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index=7));
                        imageView.setImageResource(R.drawable.rapid99);
                        intent.putExtra("Station", 7);
                        //imageView.setImageResource(R.drawable.Summer);
                        break;
                    case R.id.Immortals:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index = 8));
                        imageView.setImageResource(R.drawable.immortals);
                        //this.JSRadio.changeBG(this.JSRadio.f3419h);
                        //this.JSRadio.bgcolor = Integer.valueOf(1);
                         intent.putExtra("Station", 8);
                        //imageView.setImageResource(R.drawable.Classic);
                        break;
                    case R.id.DoomRiders:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index = 9));
                        imageView.setImageResource(R.drawable.doomriders);
                        //this.JSRadio.bgcolor = Integer.valueOf(2);
                        // this.JSRadio.changeBG(this.JSRadio.f3420i);
                          intent.putExtra("Station", 9);
                        // imageView.setImageResource(R.drawable.Future);
                        break;
                    case R.id.GoldenRhinos:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index = 10));
                        imageView.setImageResource(R.drawable.goldenrhinos);
                        // this.JSRadio.bgcolor = Integer.valueOf(3);
                        // this.JSRadio.changeBG(this.JSRadio.f3418g);
                         intent.putExtra("Station", 10);
                        // imageView.setImageResource(R.drawable.GGs);
                        break;

                }
                segmentedGroup2.check(-1);
                segmentedGroup.check(-1);
                segmentedGroup4.check(-1);
                getActivity().startService(intent);
            }
        });

        //Button Handlers for row 4
        segmentedGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            RadioFragment JSRadio = publicradio;

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == -1) {
                    return;
                }
                if (this.JSRadio.f3425n) {
                    this.JSRadio.f3425n = false;
                    return;
                }
                if (!(segmentedGroup2.getCheckedRadioButtonId() == -1 && segmentedGroup.getCheckedRadioButtonId() == -1 && segmentedGroup3.getCheckedRadioButtonId() == -1)) {
                    this.JSRadio.f3425n = true;
                }
               // Intent intent = new Intent(publicradio.getContext(), MediaPlayerS.class);
                   intent.setAction("action_next");
                ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.StationLogo);
                switch (i) {

                    case R.id.Shuffle:
                        //Log.e("DEBUG", "OnDestroy!");
                        //this.JSRadio.bgcolor = Integer.valueOf(0);
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index=0));
                        imageView.setImageResource(R.drawable.shuffle);
                        intent.putExtra("Station", 0);
                        //imageView.setImageResource(R.drawable.Summer);
                        break;

                }
                segmentedGroup2.check(-1);
                segmentedGroup3.check(-1);
                segmentedGroup.check(-1);
                getActivity().startService(intent);
            }
        });

         viewGroup2.findViewById(R.id.StationLogo).setOnClickListener(new C13055(this));
       // viewGroup2.findViewById(R.id.settingsbutton).setOnClickListener(new C13066(this));
        viewGroup2.findViewById(R.id.songtitle).setSelected(true);
       // this.f3426o = (TextView) viewGroup2.findViewById(R.id.listeners);
        return viewGroup2;
    }

    public void onActivityCreated(Bundle bundle) {
        Log.e("FRAGMENT", "Activity Created");
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.My_BroadcastReciever, new IntentFilter("JSRL.UPDATEUI"));
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void RandomBGColor() {
        int rgb = Color.rgb((int) (Math.random() * 256.0d), (int) (Math.random() * 256.0d), (int) (Math.random() * 256.0d));
        Intent intent = new Intent();
        intent.setAction("JSRL.UPDATECOLOR");
        intent.putExtra("Color", rgb);
        this.BroadcastManager.sendBroadcastSync(intent);
    }

    public void changeBG(int num) {
       // viewGroup2.findViewById(R.id.StationLogo).setOnClickListener(new C13055(this));
        //Intent intent = new Intent();
       // intent.setAction("JSRL.UPDATECOLOR");
        //intent.putExtra("Color", num);
        //this.BroadcastManager.sendBroadcast(intent);
    }




    public void listenerCount(Integer num) {
        if (this.f3426o == null) {
            return;
        }
        if (num != 0) {
            this.f3426o.setText(String.valueOf(num) + " rudies tuned in!");
        } else {
            this.f3426o.setText(" ");
        }
    }

    public void onDestroy() {
        Log.e("DEBUG", "OnDestroy!");
        Intent intent = new Intent(getContext(), MediaPlayerS.class);
        intent.setAction("action_stop");
        getActivity().stopService(intent);
        super.onDestroy();
    }
}
