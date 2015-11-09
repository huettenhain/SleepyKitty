package de.nullteilerfrei.sleepykitty;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class KittyLauncher extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ComponentName cn = new ComponentName(this, TheKitty.class);
        DevicePolicyManager mgr =
                (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);

        if (mgr.isAdminActive(cn)) {
            Toast.makeText(this, R.string.enabled, Toast.LENGTH_LONG).show();
        } else {
            Intent intent =
                    new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, cn);
            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                    getString(R.string.device_admin_explanation));
            startActivity(intent);
        }

        try {
            Process p = Runtime.getRuntime().exec("su");
        } catch (Exception ex) {
            Toast.makeText(this, R.string.error_superuser, Toast.LENGTH_LONG).show();
        }

        finish();
    }
}