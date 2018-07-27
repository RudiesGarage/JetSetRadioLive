package android.support.v4.p020d.p021a;

import android.support.v4.view.C0563d;
import android.support.v4.view.C0594p.C0593e;
import android.view.MenuItem;
import android.view.View;

/* compiled from: SupportMenuItem */
public interface C0319b extends MenuItem {
    C0319b mo497a(C0563d c0563d);

    C0319b mo498a(C0593e c0593e);

    C0563d mo499a();

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);
}
