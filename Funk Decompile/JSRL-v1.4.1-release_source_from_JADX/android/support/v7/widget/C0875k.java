package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v7.p028c.p029a.C0673b;
import android.widget.ImageView;

/* compiled from: AppCompatImageHelper */
public class C0875k {
    private final ImageView f2360a;

    public void m4490a(android.util.AttributeSet r7, int r8) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x003b in list [B:12:0x0038]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = this;
        r5 = -1;
        r1 = 0;
        r0 = r6.f2360a;	 Catch:{ all -> 0x003c }
        r0 = r0.getDrawable();	 Catch:{ all -> 0x003c }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003c }
    L_0x000a:
        r2 = r6.f2360a;	 Catch:{ all -> 0x003c }
        r2 = r2.getContext();	 Catch:{ all -> 0x003c }
        r3 = android.support.v7.p027b.C0670a.C0669k.AppCompatImageView;	 Catch:{ all -> 0x003c }
        r4 = 0;	 Catch:{ all -> 0x003c }
        r1 = android.support.v7.widget.as.m4294a(r2, r7, r3, r8, r4);	 Catch:{ all -> 0x003c }
        r2 = android.support.v7.p027b.C0670a.C0669k.AppCompatImageView_srcCompat;	 Catch:{ all -> 0x003c }
        r3 = -1;	 Catch:{ all -> 0x003c }
        r2 = r1.m4310g(r2, r3);	 Catch:{ all -> 0x003c }
        if (r2 == r5) goto L_0x0031;	 Catch:{ all -> 0x003c }
    L_0x0020:
        r0 = r6.f2360a;	 Catch:{ all -> 0x003c }
        r0 = r0.getContext();	 Catch:{ all -> 0x003c }
        r0 = android.support.v7.p028c.p029a.C0673b.m2768b(r0, r2);	 Catch:{ all -> 0x003c }
        if (r0 == 0) goto L_0x0031;	 Catch:{ all -> 0x003c }
    L_0x002c:
        r2 = r6.f2360a;	 Catch:{ all -> 0x003c }
        r2.setImageDrawable(r0);	 Catch:{ all -> 0x003c }
    L_0x0031:
        if (r0 == 0) goto L_0x0036;	 Catch:{ all -> 0x003c }
    L_0x0033:
        android.support.v7.widget.C0901u.m4589b(r0);	 Catch:{ all -> 0x003c }
    L_0x0036:
        if (r1 == 0) goto L_0x003b;
    L_0x0038:
        r1.m4298a();
    L_0x003b:
        return;
    L_0x003c:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0042;
    L_0x003f:
        r1.m4298a();
    L_0x0042:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.k.a(android.util.AttributeSet, int):void");
    }

    public C0875k(ImageView imageView) {
        this.f2360a = imageView;
    }

    public void m4489a(int i) {
        if (i != 0) {
            Drawable b = C0673b.m2768b(this.f2360a.getContext(), i);
            if (b != null) {
                C0901u.m4589b(b);
            }
            this.f2360a.setImageDrawable(b);
            return;
        }
        this.f2360a.setImageDrawable(null);
    }

    boolean m4491a() {
        Drawable background = this.f2360a.getBackground();
        if (VERSION.SDK_INT < 21 || !(background instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }
}
