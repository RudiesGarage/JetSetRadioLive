package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.v4.p024g.C0356i;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentController */
public class C0224l {
    private final C0220m<?> f596a;

    public static final C0224l m781a(C0220m<?> c0220m) {
        return new C0224l(c0220m);
    }

    private C0224l(C0220m<?> c0220m) {
        this.f596a = c0220m;
    }

    public C0226n m783a() {
        return this.f596a.m744k();
    }

    public Fragment m782a(String str) {
        return this.f596a.f574d.m862b(str);
    }

    public void m787a(Fragment fragment) {
        this.f596a.f574d.m852a(this.f596a, this.f596a, fragment);
    }

    public View m784a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f596a.f574d.mo143a(view, str, context, attributeSet);
    }

    public void m794b() {
        this.f596a.f574d.m887j();
    }

    public Parcelable m798c() {
        return this.f596a.f574d.m886i();
    }

    public void m786a(Parcelable parcelable, C0235p c0235p) {
        this.f596a.f574d.m848a(parcelable, c0235p);
    }

    public C0235p m800d() {
        return this.f596a.f574d.m885h();
    }

    public void m801e() {
        this.f596a.f574d.m888k();
    }

    public void m802f() {
        this.f596a.f574d.m889l();
    }

    public void m803g() {
        this.f596a.f574d.m890m();
    }

    public void m804h() {
        this.f596a.f574d.m891n();
    }

    public void m805i() {
        this.f596a.f574d.m892o();
    }

    public void m806j() {
        this.f596a.f574d.m893p();
    }

    public void m807k() {
        this.f596a.f574d.m894q();
    }

    public void m808l() {
        this.f596a.f574d.m896s();
    }

    public void m790a(boolean z) {
        this.f596a.f574d.m855a(z);
    }

    public void m796b(boolean z) {
        this.f596a.f574d.m868b(z);
    }

    public void m785a(Configuration configuration) {
        this.f596a.f574d.m846a(configuration);
    }

    public void m809m() {
        this.f596a.f574d.m897t();
    }

    public boolean m792a(Menu menu, MenuInflater menuInflater) {
        return this.f596a.f574d.m859a(menu, menuInflater);
    }

    public boolean m791a(Menu menu) {
        return this.f596a.f574d.m858a(menu);
    }

    public boolean m793a(MenuItem menuItem) {
        return this.f596a.f574d.m860a(menuItem);
    }

    public boolean m797b(MenuItem menuItem) {
        return this.f596a.f574d.m870b(menuItem);
    }

    public void m795b(Menu menu) {
        this.f596a.f574d.m866b(menu);
    }

    public boolean m810n() {
        return this.f596a.f574d.m880e();
    }

    public void m811o() {
        this.f596a.m746m();
    }

    public void m799c(boolean z) {
        this.f596a.m729a(z);
    }

    public void m812p() {
        this.f596a.m747n();
    }

    public void m813q() {
        this.f596a.m748o();
    }

    public C0356i<String, C0245t> m814r() {
        return this.f596a.m749p();
    }

    public void m788a(C0356i<String, C0245t> c0356i) {
        this.f596a.m727a((C0356i) c0356i);
    }

    public void m789a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f596a.m736b(str, fileDescriptor, printWriter, strArr);
    }
}
