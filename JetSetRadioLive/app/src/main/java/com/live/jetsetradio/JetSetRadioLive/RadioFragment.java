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

//Radio Portion of the APP
public class RadioFragment extends Fragment {
    Intent intent;
    private BroadcastReceiver My_BroadcastReceiver; //broadcast reciever
    private LocalBroadcastManager BroadcastManager; //broadcast manager
    private MediaPlayer mp; //media player
    private boolean bgmsound = true; //on click sound
    private boolean randombg = true; //background
    private Integer bgcolor = Integer.valueOf(0); //background color
    //BG color check
    private Integer f3418g = Integer.valueOf(Color.parseColor("#680b93"));
    private Integer f3419h = Integer.valueOf(Color.parseColor("#a00b82"));
    private Integer f3420i = Integer.valueOf(Color.parseColor("#4c89ab"));
    private Integer f3421j = Integer.valueOf(Color.parseColor("#f1a0f7"));
    private Integer f3422k = Integer.valueOf(Color.parseColor("#867a66"));
    private Integer f3423l = Integer.valueOf(Color.parseColor("#000000"));
    private Integer f3424m = Integer.valueOf(Color.parseColor("#67242e"));
    private boolean status = false;
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

        //action on tap on radio fragment
        public void onClick(View view) {
            if (this.rf.bgmsound) {
                if (new Random().nextInt(7) == 0) {
                    this.rf.mp = MediaPlayer.create(this.rf.getContext(), R.raw.killsound); //special sound (1/7 chance)
                } else {
                    this.rf.mp = MediaPlayer.create(this.rf.getContext(), R.raw.hitsound); //normal hit sound
                }
                this.rf.mp.start(); //play the song
            }

            //make media player
            Intent intent = new Intent(this.rf.getContext(), MediaPlayerS.class);
            intent.setAction("action_next"); //set the action_next
            this.rf.getActivity().startService(intent); //start intent
        }
    }



    /* compiled from: RadioFragment */
    //On click class to check the preferences (Not implimented)
    class C13066 implements View.OnClickListener {
        final /* synthetic */ RadioFragment f3411a;

        C13066(RadioFragment c1307e) {
            this.f3411a = c1307e;
        }

        public void onClick(View view) {
            this.f3411a.startActivity(new Intent(this.f3411a.getContext(), Preferences.class));
        }
    }

    //On start of radio fragment...
    public void onStart() {
        intent = new Intent(getActivity().getBaseContext(), MediaPlayerS.class); //start on the intent
        super.onStart(); //start
       // SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
       // this.bgmsound = defaultSharedPreferences.getBoolean("bgmsound", true);
       // this.randombg = defaultSharedPreferences.getBoolean("randombg", true);
    }

    //when view is created...
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {

        Wallpaper = getResources().obtainTypedArray(R.array.wallpapers); //array of wallpapers

        final ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_radio, viewGroup, false);
        //set layout to radio fragment

        this.BroadcastManager = LocalBroadcastManager.getInstance(getContext()); //make a broadcast manager

        //broadcast receiver
          this.My_BroadcastReceiver = new BroadcastReceiver() {
            final RadioFragment f3397b = new RadioFragment(); //radio fragment

              //on receive (not implemented)
            public void onReceive(Context context, Intent intent) {
                if (intent.hasExtra("listeners")) {
                    this.f3397b.listenerCount((intent.getIntExtra("listeners", 0)));
                } else if (intent.hasExtra("Song")) {
                    ((TextView) viewGroup2.findViewById(R.id.songtitle)).setText(intent.getStringArrayExtra("Song")[0]);
                    ((TextView) viewGroup2.findViewById(R.id.songartist)).setText(intent.getStringArrayExtra("Song")[1]);
                    if (this.f3397b.randombg && !intent.getStringArrayExtra("Song")[0].equals("") && this.f3397b.bgcolor == 0) {
                        this.f3397b.RandomBGColor();
                    }
                } else if (intent.hasExtra("Text")) {
                  //  final String stringExtra = intent.getStringExtra("Text");
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


        //Declare buttons
        final SegmentedGroup segmentedGroup = viewGroup2.findViewById(R.id.segmented1); //row 1
        final SegmentedGroup segmentedGroup2 =  viewGroup2.findViewById(R.id.segmented2);//row 2
        final SegmentedGroup segmentedGroup3 = viewGroup2.findViewById(R.id.segmented3); //row 3
        final SegmentedGroup segmentedGroup4 = viewGroup2.findViewById(R.id.segmented4); //row 4
        segmentedGroup4.check(R.id.Shuffle); //make shuffle checked by default
        final   RadioFragment publicradio = new RadioFragment(); //make a public radio for all rows


        //Button Handlers for row 1
        segmentedGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            final RadioFragment JSRadio = publicradio; //copy publicradio

            //if any button on row 1 are checked...
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == -1) {
                    return;
                }
                if (this.JSRadio.status) {
                    this.JSRadio.status = false;
                    return;
                }//check if anything else is checked
                if (!(segmentedGroup2.getCheckedRadioButtonId() == -1 && segmentedGroup3.getCheckedRadioButtonId() == -1 && segmentedGroup4.getCheckedRadioButtonId() == -1)) {
                    this.JSRadio.status = true;
                }

                intent.setAction("action_next");//get nextsong
                ImageView imageView =  viewGroup2.findViewById(R.id.StationLogo); //get image view
                //change image based on the button pressed
                switch (i) {
                    //Summer Station
                    case R.id.Summer:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index=11)); //change background
                        imageView.setImageResource(R.drawable.summer); //change the station icon
                        intent.putExtra("Station", 11); //change station array
                        break;

                     //Classic Station
                    case R.id.Classic:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index = 1));//change background
                        imageView.setImageResource(R.drawable.classic);//change the station icon
                        intent.putExtra("Station", 1);//change station array
                        break;

                    //Future Station
                    case R.id.Future:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index = 2));//change background
                        imageView.setImageResource(R.drawable.future);//change the station icon
                       intent.putExtra("Station", 2);//change station array
                        break;

                    //GGs Station
                    case R.id.GGs:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index = 3));//change background
                        imageView.setImageResource(R.drawable.ggs);//change the station icon
                        intent.putExtra("Station", 3);//change station array
                        break;

                }
                //uncheck other rows
                segmentedGroup2.check(-1);
                segmentedGroup3.check(-1);
                segmentedGroup4.check(-1);

                getActivity().startService(intent); //start intent
            }
        });

        //Button Handlers for row 2
        segmentedGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            RadioFragment JSRadio = publicradio;//copy publicradio

            //if any button on row 1 are checked...
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == -1) {
                    return;
                }
                if (this.JSRadio.status) {
                    this.JSRadio.status = false;
                    return;
                }
                if (!(segmentedGroup.getCheckedRadioButtonId() == -1 && segmentedGroup3.getCheckedRadioButtonId() == -1 && segmentedGroup4.getCheckedRadioButtonId() == -1)) {
                    this.JSRadio.status = true;
                }

                    intent.setAction("action_next");
                ImageView imageView = viewGroup2.findViewById(R.id.StationLogo); //get station logo
                switch (i) {

                    case R.id.PoisonJam:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index=4));//change background
                        imageView.setImageResource(R.drawable.poisonjam);//change the station icon
                        intent.putExtra("Station", 4);//change station array
                        break;

                    case R.id.NoiseTanks:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index = 5));//change background
                        imageView.setImageResource(R.drawable.noisetanks);//change the station icon
                         intent.putExtra("Station", 5);//change station array
                        break;

                    case R.id.LoveShockers:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index = 6));//change background
                        imageView.setImageResource(R.drawable.loveshockers);//change the station icon
                          intent.putExtra("Station", 6);//change station array
                        break;


                }

                //uncheck other rows
                segmentedGroup.check(-1);
                segmentedGroup3.check(-1);
                segmentedGroup4.check(-1);

                getActivity().startService(intent); //restart intent
            }
        });

        //Button Handlers for row 3
        segmentedGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            RadioFragment JSRadio = publicradio;

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == -1) {
                    return;
                }
                if (this.JSRadio.status) {
                    this.JSRadio.status = false;
                    return;
                }
                if (!(segmentedGroup2.getCheckedRadioButtonId() == -1 && segmentedGroup.getCheckedRadioButtonId() == -1 && segmentedGroup4.getCheckedRadioButtonId() == -1)) {
                    this.JSRadio.status = true;
                }

                    intent.setAction("action_next");
                ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.StationLogo);//get station
                switch (i) {
                    //Rapid 99 Station
                    case R.id.Rapid99:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index=7));//change bg
                        imageView.setImageResource(R.drawable.rapid99);//change station logo
                        intent.putExtra("Station", 7);//update song array
                        break;
                    //Immortals Station
                    case R.id.Immortals:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index = 8));//change bg
                        imageView.setImageResource(R.drawable.immortals);//change station logo
                        intent.putExtra("Station", 8);//update song array
                        break;

                    //DoomRiders Station
                    case R.id.DoomRiders:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index = 9));//change bg
                        imageView.setImageResource(R.drawable.doomriders);//change station logo
                        intent.putExtra("Station", 9);//update song array
                        break;

                    //GoldenRhinos Station
                    case R.id.GoldenRhinos:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index = 10));//change bg
                        imageView.setImageResource(R.drawable.goldenrhinos);//change station logo
                         intent.putExtra("Station", 10);//update song array
                        break;

                }
                //uncheck other rows
                segmentedGroup2.check(-1);
                segmentedGroup.check(-1);
                segmentedGroup4.check(-1);
                getActivity().startService(intent);//restart music player
            }
        });

        //Button Handlers for row 4
        segmentedGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            RadioFragment JSRadio = publicradio;

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == -1) {
                    return;
                }
                if (this.JSRadio.status) {
                    this.JSRadio.status = false;
                    return;
                }
                if (!(segmentedGroup2.getCheckedRadioButtonId() == -1 && segmentedGroup.getCheckedRadioButtonId() == -1 && segmentedGroup3.getCheckedRadioButtonId() == -1)) {
                    this.JSRadio.status = true;
                }

                intent.setAction("action_next");
                ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.StationLogo);
                switch (i) {

                    case R.id.Shuffle:
                        viewGroup2.findViewById(R.id.background).setBackground(Wallpaper.getDrawable(index=0));
                        imageView.setImageResource(R.drawable.shuffle);
                        intent.putExtra("Station", 0);
                        break;

                }
                //uncheck other rows
                segmentedGroup2.check(-1);
                segmentedGroup3.check(-1);
                segmentedGroup.check(-1);
                getActivity().startService(intent);//start intent
            }
        });

         viewGroup2.findViewById(R.id.StationLogo).setOnClickListener(new C13055(this));
       //viewGroup2.findViewById(R.id.settingsbutton).setOnClickListener(new C13066(this)); (SETTING TBD)
        viewGroup2.findViewById(R.id.songtitle).setSelected(true);

        return viewGroup2;
    }

    //when activity is created
    public void onActivityCreated(Bundle bundle) {
        Log.e("FRAGMENT", "Activity Created");
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.My_BroadcastReceiver, new IntentFilter("JSRL.UPDATEUI"));
        super.onActivityCreated(bundle);
    }

    //on create
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    //randomize the bg color
    public void RandomBGColor() {
        int rgb = Color.rgb((int) (Math.random() * 256.0d), (int) (Math.random() * 256.0d), (int) (Math.random() * 256.0d));
        Intent intent = new Intent();
        intent.setAction("JSRL.UPDATEBG");
        intent.putExtra("Color", rgb);
        this.BroadcastManager.sendBroadcastSync(intent);
    }

    //change the bg
    public void changeBG(int num) {
       // viewGroup2.findViewById(R.id.StationLogo).setOnClickListener(new C13055(this));
        //Intent intent = new Intent();
       // intent.setAction("JSRL.UPDATEBG");
        //intent.putExtra("Color", num);
        //this.BroadcastManager.sendBroadcast(intent);
    }



    //check num rudies tuned in (not used)
    public void listenerCount(Integer num) {
        if (this.f3426o == null) {
            return;
        }
        if (num != 0) {
            this.f3426o.setText(num + " rudies tuned in!");
        } else {
            this.f3426o.setText(" ");
        }
    }

    //on destroy
    public void onDestroy() {
        Log.e("DEBUG", "OnDestroy!");
        Intent intent = new Intent(getContext(), MediaPlayerS.class);
        intent.setAction("action_stop");
        getActivity().stopService(intent);
        super.onDestroy();
    }
}
