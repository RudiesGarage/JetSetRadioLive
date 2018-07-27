package live.jetsetradio.jetsetradiolive;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.view.MenuItem;

public class Preferences extends PreferenceActivity {
    static String f3378a;

    public static class C1290a extends PreferenceFragment {
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.preferences);
            if (Preferences.f3378a != null) {
                findPreference("version").setSummary(Preferences.f3378a);
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void onCreate(Bundle bundle) {
        PackageInfo packageInfo;
        super.onCreate(bundle);
        getFragmentManager().beginTransaction().replace(16908290, new C1290a()).commit();
        try {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (NameNotFoundException e2) {
            e2.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            f3378a = packageInfo.versionName;
            Log.e("DEBUG", f3378a);
        }
    }
}
