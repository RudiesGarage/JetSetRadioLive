package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ae;
import android.support.v7.p027b.C0670a.C0659a;
import android.support.v7.p027b.C0670a.C0664f;
import android.support.v7.p027b.C0670a.C0666h;
import android.support.v7.p027b.C0670a.C0669k;
import android.support.v7.view.menu.C0709n.C0706a;
import android.support.v7.widget.as;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements C0706a {
    private C0726h f1380a;
    private ImageView f1381b;
    private RadioButton f1382c;
    private TextView f1383d;
    private CheckBox f1384e;
    private TextView f1385f;
    private ImageView f1386g;
    private Drawable f1387h;
    private int f1388i;
    private Context f1389j;
    private boolean f1390k;
    private Drawable f1391l;
    private int f1392m;
    private LayoutInflater f1393n;
    private boolean f1394o;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0659a.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        as a = as.m4294a(getContext(), attributeSet, C0669k.MenuView, i, 0);
        this.f1387h = a.m4297a(C0669k.MenuView_android_itemBackground);
        this.f1388i = a.m4310g(C0669k.MenuView_android_itemTextAppearance, -1);
        this.f1390k = a.m4299a(C0669k.MenuView_preserveIconSpacing, false);
        this.f1389j = context;
        this.f1391l = a.m4297a(C0669k.MenuView_subMenuArrow);
        a.m4298a();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        ae.m2209a((View) this, this.f1387h);
        this.f1383d = (TextView) findViewById(C0664f.title);
        if (this.f1388i != -1) {
            this.f1383d.setTextAppearance(this.f1389j, this.f1388i);
        }
        this.f1385f = (TextView) findViewById(C0664f.shortcut);
        this.f1386g = (ImageView) findViewById(C0664f.submenuarrow);
        if (this.f1386g != null) {
            this.f1386g.setImageDrawable(this.f1391l);
        }
    }

    public void mo491a(C0726h c0726h, int i) {
        this.f1380a = c0726h;
        this.f1392m = i;
        setVisibility(c0726h.isVisible() ? 0 : 8);
        setTitle(c0726h.m3053a((C0706a) this));
        setCheckable(c0726h.isCheckable());
        m2907a(c0726h.m3066f(), c0726h.m3062d());
        setIcon(c0726h.getIcon());
        setEnabled(c0726h.isEnabled());
        setSubMenuArrowVisible(c0726h.hasSubMenu());
    }

    public void setForceShowIcon(boolean z) {
        this.f1394o = z;
        this.f1390k = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f1383d.setText(charSequence);
            if (this.f1383d.getVisibility() != 0) {
                this.f1383d.setVisibility(0);
            }
        } else if (this.f1383d.getVisibility() != 8) {
            this.f1383d.setVisibility(8);
        }
    }

    public C0726h getItemData() {
        return this.f1380a;
    }

    public void setCheckable(boolean z) {
        if (z || this.f1382c != null || this.f1384e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f1380a.m3067g()) {
                if (this.f1382c == null) {
                    m2904c();
                }
                compoundButton = this.f1382c;
                compoundButton2 = this.f1384e;
            } else {
                if (this.f1384e == null) {
                    m2905d();
                }
                compoundButton = this.f1384e;
                compoundButton2 = this.f1382c;
            }
            if (z) {
                int i;
                compoundButton.setChecked(this.f1380a.isChecked());
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f1384e != null) {
                this.f1384e.setVisibility(8);
            }
            if (this.f1382c != null) {
                this.f1382c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f1380a.m3067g()) {
            if (this.f1382c == null) {
                m2904c();
            }
            compoundButton = this.f1382c;
        } else {
            if (this.f1384e == null) {
                m2905d();
            }
            compoundButton = this.f1384e;
        }
        compoundButton.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.f1386g != null) {
            this.f1386g.setVisibility(z ? 0 : 8);
        }
    }

    public void m2907a(boolean z, char c) {
        int i = (z && this.f1380a.m3066f()) ? 0 : 8;
        if (i == 0) {
            this.f1385f.setText(this.f1380a.m3064e());
        }
        if (this.f1385f.getVisibility() != i) {
            this.f1385f.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        int i = (this.f1380a.m3069i() || this.f1394o) ? 1 : 0;
        if (i == 0 && !this.f1390k) {
            return;
        }
        if (this.f1381b != null || drawable != null || this.f1390k) {
            if (this.f1381b == null) {
                m2903b();
            }
            if (drawable != null || this.f1390k) {
                ImageView imageView = this.f1381b;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f1381b.getVisibility() != 0) {
                    this.f1381b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f1381b.setVisibility(8);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f1381b != null && this.f1390k) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1381b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    private void m2903b() {
        this.f1381b = (ImageView) getInflater().inflate(C0666h.abc_list_menu_item_icon, this, false);
        addView(this.f1381b, 0);
    }

    private void m2904c() {
        this.f1382c = (RadioButton) getInflater().inflate(C0666h.abc_list_menu_item_radio, this, false);
        addView(this.f1382c);
    }

    private void m2905d() {
        this.f1384e = (CheckBox) getInflater().inflate(C0666h.abc_list_menu_item_checkbox, this, false);
        addView(this.f1384e);
    }

    public boolean mo492a() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.f1393n == null) {
            this.f1393n = LayoutInflater.from(getContext());
        }
        return this.f1393n;
    }
}
