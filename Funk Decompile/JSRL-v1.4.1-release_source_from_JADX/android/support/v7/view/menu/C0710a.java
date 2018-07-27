package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p018b.C0185a;
import android.support.v4.p020d.p021a.C0319b;
import android.support.v4.view.C0563d;
import android.support.v4.view.C0594p.C0593e;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionMenuItem */
public class C0710a implements C0319b {
    private final int f1395a;
    private final int f1396b;
    private final int f1397c;
    private final int f1398d;
    private CharSequence f1399e;
    private CharSequence f1400f;
    private Intent f1401g;
    private char f1402h;
    private char f1403i;
    private Drawable f1404j;
    private int f1405k = 0;
    private Context f1406l;
    private OnMenuItemClickListener f1407m;
    private int f1408n = 16;

    public /* synthetic */ MenuItem setActionView(int i) {
        return m2909a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m2912a(view);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m2914b(i);
    }

    public C0710a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f1406l = context;
        this.f1395a = i2;
        this.f1396b = i;
        this.f1397c = i3;
        this.f1398d = i4;
        this.f1399e = charSequence;
    }

    public char getAlphabeticShortcut() {
        return this.f1403i;
    }

    public int getGroupId() {
        return this.f1396b;
    }

    public Drawable getIcon() {
        return this.f1404j;
    }

    public Intent getIntent() {
        return this.f1401g;
    }

    public int getItemId() {
        return this.f1395a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f1402h;
    }

    public int getOrder() {
        return this.f1398d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f1399e;
    }

    public CharSequence getTitleCondensed() {
        return this.f1400f != null ? this.f1400f : this.f1399e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f1408n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f1408n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f1408n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f1408n & 8) == 0;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f1403i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f1408n = (z ? 1 : 0) | (this.f1408n & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f1408n = (z ? 2 : 0) | (this.f1408n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f1408n = (z ? 16 : 0) | (this.f1408n & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1404j = drawable;
        this.f1405k = 0;
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1405k = i;
        this.f1404j = C0185a.m612a(this.f1406l, i);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1401g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f1402h = c;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1407m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1402h = c;
        this.f1403i = c2;
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1399e = charSequence;
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f1399e = this.f1406l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1400f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f1408n = (z ? 0 : 8) | (this.f1408n & 8);
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public C0319b m2912a(View view) {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public C0319b m2909a(int i) {
        throw new UnsupportedOperationException();
    }

    public C0563d mo499a() {
        return null;
    }

    public C0319b mo497a(C0563d c0563d) {
        throw new UnsupportedOperationException();
    }

    public C0319b m2914b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public C0319b mo498a(C0593e c0593e) {
        return this;
    }
}
