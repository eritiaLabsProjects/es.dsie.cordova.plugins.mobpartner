package es.dsie.cordova.plugins.mobpartner;

import java.util.Iterator;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LinearLayoutSoftKeyboardDetect;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.dsie.labs.bacoAndroidTesting.R;
import com.mobpartner.android.publisher.views.MobPartnerAdBanner;
import com.mobpartner.android.publisher.views.MobPartnerAdInterstitial;

import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.WebBackForwardList;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MobPartnerPlugin extends CordovaPlugin {
	private static final String LOGTAG = "MobPartnerPlugin";
	
    private static final String ACTION_INIT = "init";
    private static final String ACTION_SHOW_BANNER = "showBanner";
    private static final String ACTION_SHOW_INTERSTITIAL = "showInterstitial";
    private static final String ACTION_HIDE_BANNER = "hideBanner";
    
    private String poolId = "";

    @Override
    public boolean execute(String action, JSONArray inputs, CallbackContext callbackContext) throws JSONException {
        if (ACTION_INIT.equals(action)) {
            //executeCreateBannerView(inputs, callbackContext);
            //executeInit(inputs,callbackContext);
            return true;
        } else if (ACTION_SHOW_BANNER.equals(action)) {
            //executeCreateInterstitialView(inputs, callbackContext);
            executeShowBanner(inputs,callbackContext);
            return true;
        } else if (ACTION_SHOW_INTERSTITIAL.equals(action)) {
        	executeShowInterstitial(inputs, callbackContext);
            //executeRequestAd(inputs, callbackContext);
            return true;
        } else if (ACTION_HIDE_BANNER.equals(action)) {
            //executeKillAd(callbackContext);
            return true;
        } else {
            Log.d(LOGTAG, String.format("Invalid action passed: %s", action));
            callbackContext.error("Invalid Action");
        }
        return false;
    }

    private void executeShowBanner(JSONArray inputs, CallbackContext callbackContext) {
        // Get the input data.
        try {
            this.poolId = inputs.getString(0);
            final CordovaInterface cordova = this.cordova;

    		// Create the AdView on the UI thread.
    		Log.w(LOGTAG, "createBannerView");
    		Runnable runnable = new Runnable() {
    			public void run() {
    				Log.w(LOGTAG, "ShowBanner:" + poolId);
    				Log.w(LOGTAG, String.valueOf(webView));
    					
    				LinearLayoutSoftKeyboardDetect parentView = (LinearLayoutSoftKeyboardDetect) webView.getParent();
    				MobPartnerAdBanner banner = new MobPartnerAdBanner(webView.getContext(),poolId);
					parentView.addView(banner);
    			    banner.show();
    			}
    		};
    		this.cordova.getActivity().runOnUiThread(runnable);
        } catch (JSONException exception) {
            Log.w(LOGTAG,String.format("Got JSON Exception: %s",exception.getMessage()));
            callbackContext.error(exception.getMessage());
        }
    }
    
    private void executeShowInterstitial(JSONArray inputs, CallbackContext callbackContext) {
        // Get the input data.
        try {
            this.poolId = inputs.getString(0);
            final CordovaInterface cordova = this.cordova;

    		// Create the AdView on the UI thread.
    		Log.w(LOGTAG, "createInterstitialView");
    		Runnable runnable = new Runnable() {
    			public void run() {
    				Log.w(LOGTAG, "ShowInterstitial:" + poolId);
    				Log.w(LOGTAG, String.valueOf(webView));
    					
    				MobPartnerAdInterstitial interstitial = new MobPartnerAdInterstitial(webView.getContext(),poolId);
    				interstitial.show();
    			}
    		};
    		this.cordova.getActivity().runOnUiThread(runnable);
        } catch (JSONException exception) {
            Log.w(LOGTAG,String.format("Got JSON Exception: %s",exception.getMessage()));
            callbackContext.error(exception.getMessage());
        }
        
    }


}