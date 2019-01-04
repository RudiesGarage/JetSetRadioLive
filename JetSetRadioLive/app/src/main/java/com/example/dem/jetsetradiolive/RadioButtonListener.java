package com.example.dem.jetsetradiolive;


import android.annotation.SuppressLint;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import com.bumptech.glide.Glide;
import info.hoang8f.android.segmented.SegmentedGroup;


//This class handles Radio Button changes and UI events
public class RadioButtonListener implements RadioGroup.OnCheckedChangeListener{

    private final RadioFragment rf;
    private int rownum;
    private ViewGroup viewGroup2;
    private SegmentedGroup segmentedGroup;
    private SegmentedGroup segmentedGroup2;
    private SegmentedGroup segmentedGroup3;
    private SegmentedGroup segmentedGroup4;


    RadioButtonListener(RadioFragment rf, SegmentedGroup segmentedGroup,SegmentedGroup segmentedGroup2,SegmentedGroup segmentedGroup3,SegmentedGroup segmentedGroup4, int row, ViewGroup view) {
        this.rf = rf;
        this.rownum = row;
        this.viewGroup2 = view;
        this.segmentedGroup = segmentedGroup;
        this.segmentedGroup2 = segmentedGroup2;
        this.segmentedGroup3 = segmentedGroup3;
        this.segmentedGroup4 = segmentedGroup4;
    }

    //check if anything button changed
    @SuppressLint("NewApi")
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if(checkedId != -1) {

            switch(this.rownum){
                case 1:
                    if( this.rf.status){
                        this.rf.status = false;
                        return;
                    }
                    checkrow1();
                    break;

                case 2:
                    if( this.rf.status){
                        this.rf.status = false;
                        return;
                    }
                    checkrow2();
                    break;

                case 3:
                    if( this.rf.status){
                        this.rf.status = false;
                        return;
                    }
                    checkrow3();
                    break;

                default:
                    if( this.rf.status){
                        this.rf.status = false;
                        return;
                    }
                    checkrow4();
            }
            changeImages(checkedId,viewGroup2);
        }
    }

    //these function uncheck all but the # in the title
    private void checkrow1(){
        //check if anything else is checked
        if (!(segmentedGroup2.getCheckedRadioButtonId() == -1 && segmentedGroup3.getCheckedRadioButtonId() == -1 && segmentedGroup4.getCheckedRadioButtonId() == -1)) {
            this.rf.status = true;
        }
        segmentedGroup2.check(-1);
        segmentedGroup3.check(-1);
        segmentedGroup4.check(-1);
    }
    private void checkrow2(){
        //check if anything else is checked
        if (!(segmentedGroup.getCheckedRadioButtonId() == -1 && segmentedGroup3.getCheckedRadioButtonId() == -1 && segmentedGroup4.getCheckedRadioButtonId() == -1)) {
            this.rf.status = true;
        }
        segmentedGroup.check(-1);
        segmentedGroup3.check(-1);
        segmentedGroup4.check(-1);
    }
    private void checkrow3(){
        //check if anything else is checked
        if (!(segmentedGroup2.getCheckedRadioButtonId() == -1 && segmentedGroup.getCheckedRadioButtonId() == -1 && segmentedGroup4.getCheckedRadioButtonId() == -1)) {
            this.rf.status = true;
        }
        segmentedGroup2.check(-1);
        segmentedGroup.check(-1);
        segmentedGroup4.check(-1);
    }
    private void checkrow4(){
        //check if anything else is checked
        if (!(segmentedGroup2.getCheckedRadioButtonId() == -1 && segmentedGroup3.getCheckedRadioButtonId() == -1 && segmentedGroup.getCheckedRadioButtonId() == -1)) {
            this.rf.status = true;
        }
        segmentedGroup2.check(-1);
        segmentedGroup3.check(-1);
        segmentedGroup.check(-1);
    }

    //this function changes the background image and station logo on a given button pressed ID (uses glide in )
    private void changeImages(int station,ViewGroup viewGroup2){
        ImageView imageView = viewGroup2.findViewById(R.id.StationLogo);
        ImageView background = viewGroup2.findViewById(R.id.background);
        switch(station){
            case R.id.Classic:
                Glide.with(rf).load(R.drawable.classicwallpaper).into(background);
                Glide.with(rf).load(R.drawable.classic).into(imageView);

                break;
            case R.id.Future:
                Glide.with(rf).load(R.drawable.futurewallpaper).into(background);
                Glide.with(rf).load(R.drawable.future).into(imageView);


                break;
            case R.id.GGs:
                Glide.with(rf).load(R.drawable.ggswallpaper).into(background);
                Glide.with(rf).load(R.drawable.ggs).into(imageView);

                break;
            case R.id.PoisonJam:

                Glide.with(rf).load(R.drawable.poisonjamwallpaper).into(background);
                Glide.with(rf).load(R.drawable.poisonjam).into(imageView);


                break;
            case R.id.NoiseTanks:

                Glide.with(rf).load(R.drawable.noisetankswallpaper).into(background);
                Glide.with(rf).load(R.drawable.noisetanks).into(imageView);


                break;
            case R.id.LoveShockers:

                Glide.with(rf).load(R.drawable.loveshockerswallpaper).into(background);
                Glide.with(rf).load(R.drawable.loveshockers).into(imageView);


                break;
            case R.id.Rapid99:


                Glide.with(rf).load(R.drawable.rapid99wallpaper).into(background);
                Glide.with(rf).load(R.drawable.rapid99).into(imageView);


                break;
            case R.id.Immortals:


                Glide.with(rf).load(R.drawable.immortalswallpaper).into(background);
                Glide.with(rf).load(R.drawable.immortals).into(imageView);


                break;
            case R.id.DoomRiders:


                Glide.with(rf).load(R.drawable.doomriderswallpaper).into(background);
                Glide.with(rf).load(R.drawable.doomriders).into(imageView);


                break;
            case R.id.GoldenRhinos:


                Glide.with(rf).load(R.drawable.goldenrhinoswallpaper).into(background);
                Glide.with(rf).load(R.drawable.goldenrhinos).into(imageView);

                break;
            case R.id.Summer:

                Glide.with(rf).load(R.drawable.summerwallpaper).into(background);
                Glide.with(rf).load(R.drawable.summer).into(imageView);
                break;

            default:

                Glide.with(rf).load(R.drawable.shufflewallpaper).into(background);
                Glide.with(rf).load(R.drawable.shuffle).into(imageView);
                break;
        }
        Log.d("RADIOBUTTONISTENER",""+station);
        rf.setStation(station);
    }




}
