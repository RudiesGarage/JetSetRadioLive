package android.support.v4.widget;

import android.widget.ListView;

/* compiled from: ListViewAutoScrollHelper */
public class C0625g extends C0612a {
    private final ListView f1226f;

    public C0625g(ListView listView) {
        super(listView);
        this.f1226f = listView;
    }

    public void mo466a(int i, int i2) {
        C0626h.m2661a(this.f1226f, i2);
    }

    public boolean mo467e(int i) {
        return false;
    }

    public boolean mo468f(int i) {
        ListView listView = this.f1226f;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
