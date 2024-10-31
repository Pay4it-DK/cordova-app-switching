package dk.pay4it;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;

import android.net.Uri;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;

import java.lang.*;
import java.util.*;

import android.os.Message;

public class AppSwitching extends CordovaPlugin {
    public CallbackContext callbackContext;
    @Override
    public boolean execute(String action, final JSONArray data, final CallbackContext callbackContext) throws JSONException {
        this.callbackContext = callbackContext;
        try {
            if (action.equals("openApp")) {
                String url = data.getString(0);
                cordova.getThreadPool().execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Action: " + action);                  
                        Intent payIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        payIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        payIntent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);            
                        cordova.getActivity().startActivity(payIntent);
                    }
                
                });
            }
            return true;
        } catch (JSONException ex) {
            callbackContext.error(ex.getMessage());
            return false;
        } catch (Exception ex) {
            callbackContext.error(ex.getMessage());
            return false;
        }
    }
}