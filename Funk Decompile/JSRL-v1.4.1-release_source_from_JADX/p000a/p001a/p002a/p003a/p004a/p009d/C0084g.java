package p000a.p001a.p002a.p003a.p004a.p009d;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: GZIPQueueFileEventStorage */
public class C0084g extends C0083h {
    public C0084g(Context context, File file, String str, String str2) {
        super(context, file, str, str2);
    }

    public OutputStream mo27a(File file) {
        return new GZIPOutputStream(new FileOutputStream(file));
    }
}
