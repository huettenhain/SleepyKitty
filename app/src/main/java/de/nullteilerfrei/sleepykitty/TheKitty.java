package de.nullteilerfrei.sleepykitty;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TheKitty  extends DeviceAdminReceiver {
    @Override
    public void onEnabled(Context ctxt, Intent intent) {
        Toast.makeText(ctxt, R.string.enabled, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPasswordFailed(Context ctxt, Intent intent) {
        DevicePolicyManager policyManager = (DevicePolicyManager) ctxt.getSystemService(Context.DEVICE_POLICY_SERVICE);
        int attempts = 10;
        if (policyManager != null) {
            attempts = policyManager.getCurrentFailedPasswordAttempts();
        }
        if (attempts > 2) {
            Toast.makeText(ctxt, R.string.shutdown, Toast.LENGTH_LONG).show();
            try {
                Process proc = Runtime
                        .getRuntime()
                        .exec(new String[]{
                                "su",
                                "-c",
                                "am start -a android.intent.action.ACTION_REQUEST_SHUTDOWN"
                        });
                proc.waitFor();
            } catch (Exception ex) {
                ex.printStackTrace();
                Toast.makeText(ctxt, R.string.error_superuser, Toast.LENGTH_LONG).show();
            }
        }
    }
}
