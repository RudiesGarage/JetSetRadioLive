package com.live.jetsetradio.JetSetRadioLive;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class Constants {
    public interface ACTION {
        public static String MAIN_ACTION = "com.marothiatechs.customnotification.action.main";
        public static String INIT_ACTION = "com.marothiatechs.customnotification.action.init";
        public static String PREV_ACTION = "com.marothiatechs.customnotification.action.prev";
        public static String PLAY_ACTION = "com.marothiatechs.customnotification.action.play";
        public static String NEXT_ACTION = "com.marothiatechs.customnotification.action.next";
        public static String STARTFOREGROUND_ACTION = "com.marothiatechs.customnotification.action.startforeground";
        public static String STOPFOREGROUND_ACTION = "com.marothiatechs.customnotification.action.stopforeground";

    }

    public interface NOTIFICATION_ID {
        public static int FOREGROUND_SERVICE = 101;
    }

    public static Bitmap getDefaultAlbumArt(Context context) {
        Bitmap bm = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            bm = BitmapFactory.decodeResource(context.getResources(),
                    R.mipmap.ic_launcher, options);
        } catch (Error | Exception ee) {

        }
        return bm;
    }

    public static Bitmap getAlbumArt(Context context,int station){
        Bitmap bm = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {

            switch(station){
                case 0:
                    bm = BitmapFactory.decodeResource(context.getResources(),
                            R.mipmap.ic_launcher, options);
                    break;
                case 1:
                    bm = BitmapFactory.decodeResource(context.getResources(),
                            R.drawable.classic, options);
                    break;
                case 2:
                    bm = BitmapFactory.decodeResource(context.getResources(),
                            R.drawable.future, options);
                    break;
                case 3:
                    bm = BitmapFactory.decodeResource(context.getResources(),
                            R.drawable.ggs, options);
                    break;
                case 4:
                    bm = BitmapFactory.decodeResource(context.getResources(),
                            R.drawable.poisonjam, options);
                    break;
                case 5:
                    bm = BitmapFactory.decodeResource(context.getResources(),
                            R.drawable.noisetanks, options);
                    break;
                case 6:
                    bm = BitmapFactory.decodeResource(context.getResources(),
                            R.drawable.loveshockers, options);
                    break;
                case 7:
                    bm = BitmapFactory.decodeResource(context.getResources(),
                            R.drawable.rapid99, options);
                    break;
                case 8:
                    bm = BitmapFactory.decodeResource(context.getResources(),
                            R.drawable.immortals, options);
                    break;
                case 9:
                    bm = BitmapFactory.decodeResource(context.getResources(),
                            R.drawable.doomriders, options);
                    break;
                case 10:
                    bm = BitmapFactory.decodeResource(context.getResources(),
                            R.drawable.goldenrhinos, options);
                    break;
                case 11:
                    bm = BitmapFactory.decodeResource(context.getResources(),
                            R.drawable.summer, options);
                    break;
                default:
                    bm = BitmapFactory.decodeResource(context.getResources(),
                            R.mipmap.ic_launcher, options);
                    break;

            }
        } catch (Error | Exception ee) {

        }
        return bm;
    }

}