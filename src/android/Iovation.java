package org.apache.cordova.iovation;

import static com.iovation.mobile.android.DevicePrint.start;
import static com.iovation.mobile.android.DevicePrint.getBlackbox;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Iovation extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("start")) {
            this.startIovation(callbackContext);
            return true;
        }

        if (action.equals("blackbox")) {
            this.blackbox(callbackContext);
            return true;
        }

        return false;
      }

    private void startIovation(final CallbackContext callbackContext) {
        this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                start(cordova.getActivity().getApplicationContext());
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, true));
            }
        });
    }

    private void blackbox(final CallbackContext callbackContext) {
        this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                String blackbox = getBlackbox(cordova.getActivity().getApplicationContext());
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, blackbox));
            }
        });
    }
}
