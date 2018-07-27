package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

/* compiled from: TintableBackgroundView */
public interface ab {
    ColorStateList getSupportBackgroundTintList();

    Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(ColorStateList colorStateList);

    void setSupportBackgroundTintMode(Mode mode);
}
