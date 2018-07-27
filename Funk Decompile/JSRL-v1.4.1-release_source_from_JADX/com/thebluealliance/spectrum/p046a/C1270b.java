package com.thebluealliance.spectrum.p046a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.thebluealliance.spectrum.C1273a.C1264b;
import com.thebluealliance.spectrum.C1273a.C1265c;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/* compiled from: ColorItem */
public class C1270b extends FrameLayout implements OnClickListener {
    private EventBus f3303a;
    private ImageView f3304b;
    private int f3305c;
    private boolean f3306d = false;
    private int f3307e = 0;

    /* compiled from: ColorItem */
    class C12681 extends AnimatorListenerAdapter {
        final /* synthetic */ C1270b f3301a;

        C12681(C1270b c1270b) {
            this.f3301a = c1270b;
        }

        public void onAnimationEnd(Animator animator) {
            this.f3301a.setItemCheckmarkAttributes(1.0f);
        }
    }

    /* compiled from: ColorItem */
    class C12692 extends AnimatorListenerAdapter {
        final /* synthetic */ C1270b f3302a;

        C12692(C1270b c1270b) {
            this.f3302a = c1270b;
        }

        public void onAnimationEnd(Animator animator) {
            this.f3302a.f3304b.setVisibility(4);
            this.f3302a.setItemCheckmarkAttributes(0.0f);
        }
    }

    public C1270b(Context context, int i, boolean z, EventBus eventBus) {
        super(context);
        this.f3305c = i;
        this.f3306d = z;
        this.f3303a = eventBus;
        m5820b();
        setChecked(this.f3306d);
    }

    private void m5818a() {
        setForeground(m5823e());
        if (VERSION.SDK_INT < 16) {
            setBackgroundDrawable(m5822d());
        } else {
            setBackground(m5822d());
        }
    }

    private void m5820b() {
        m5818a();
        this.f3303a.register(this);
        setOnClickListener(this);
        LayoutInflater.from(getContext()).inflate(C1265c.color_item, this, true);
        this.f3304b = (ImageView) findViewById(C1264b.selected_checkmark);
        this.f3304b.setColorFilter(C1271c.m5824a(this.f3305c) ? -1 : -16777216);
    }

    public void setOutlineWidth(int i) {
        this.f3307e = i;
        m5818a();
    }

    public void setChecked(boolean z) {
        boolean z2 = this.f3306d;
        this.f3306d = z;
        if (!z2 && this.f3306d) {
            setItemCheckmarkAttributes(0.0f);
            this.f3304b.setVisibility(0);
            this.f3304b.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(250).setListener(new C12681(this)).start();
        } else if (!z2 || this.f3306d) {
            m5821c();
        } else {
            this.f3304b.setVisibility(0);
            setItemCheckmarkAttributes(1.0f);
            this.f3304b.animate().alpha(0.0f).scaleX(0.0f).scaleY(0.0f).setDuration(250).setListener(new C12692(this)).start();
        }
    }

    private void m5821c() {
        this.f3304b.setVisibility(this.f3306d ? 0 : 4);
        setItemCheckmarkAttributes(1.0f);
    }

    private void setItemCheckmarkAttributes(float f) {
        this.f3304b.setAlpha(f);
        this.f3304b.setScaleX(f);
        this.f3304b.setScaleY(f);
    }

    @Subscribe
    public void onSelectedColorChanged(C1272d c1272d) {
        setChecked(c1272d.m5826a() == this.f3305c);
    }

    public void onClick(View view) {
        this.f3303a.post(new C1272d(this.f3305c));
    }

    private Drawable m5822d() {
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        if (this.f3307e != 0) {
            gradientDrawable.setStroke(this.f3307e, C1271c.m5824a(this.f3305c) ? -1 : -16777216);
        }
        gradientDrawable.setColor(this.f3305c);
        return gradientDrawable;
    }

    private Drawable m5823e() {
        if (VERSION.SDK_INT >= 21) {
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(-16777216);
            return new RippleDrawable(ColorStateList.valueOf(C1271c.m5825b(this.f3305c)), null, gradientDrawable);
        }
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.setAlpha(80);
        stateListDrawable.setEnterFadeDuration(250);
        stateListDrawable.setExitFadeDuration(250);
        gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(C1271c.m5825b(this.f3305c));
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable);
        stateListDrawable.addState(new int[0], new ColorDrawable(0));
        return stateListDrawable;
    }
}
