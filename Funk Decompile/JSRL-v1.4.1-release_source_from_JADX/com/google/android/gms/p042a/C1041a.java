package com.google.android.gms.p042a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface C1041a extends IInterface {

    public static abstract class C1043a extends Binder implements C1041a {

        private static class C1042a implements C1041a {
            private IBinder f2808a;

            C1042a(IBinder iBinder) {
                this.f2808a = iBinder;
            }

            public IBinder asBinder() {
                return this.f2808a;
            }
        }

        public C1043a() {
            attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static C1041a m5056a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1041a)) ? new C1042a(iBinder) : (C1041a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }
}
