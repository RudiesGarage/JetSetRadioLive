package com.p035a.p036a.p039c;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

/* compiled from: ClsFileOutputStream */
class C0968d extends FileOutputStream {
    public static final FilenameFilter f2647a = new C09671();
    private final String f2648b;
    private File f2649c;
    private File f2650d;
    private boolean f2651e = false;

    /* compiled from: ClsFileOutputStream */
    static class C09671 implements FilenameFilter {
        C09671() {
        }

        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    }

    public C0968d(File file, String str) {
        super(new File(file, str + ".cls_temp"));
        this.f2648b = file + File.separator + str;
        this.f2649c = new File(this.f2648b + ".cls_temp");
    }

    public synchronized void close() {
        if (!this.f2651e) {
            this.f2651e = true;
            super.flush();
            super.close();
            File file = new File(this.f2648b + ".cls");
            if (this.f2649c.renameTo(file)) {
                this.f2649c = null;
                this.f2650d = file;
            } else {
                String str = "";
                if (file.exists()) {
                    str = " (target already exists)";
                } else if (!this.f2649c.exists()) {
                    str = " (source does not exist)";
                }
                throw new IOException("Could not rename temp file: " + this.f2649c + " -> " + file + str);
            }
        }
    }

    public void m4789a() {
        if (!this.f2651e) {
            this.f2651e = true;
            super.flush();
            super.close();
        }
    }
}
