{"filter":false,"title":"MobPartnerPlugin.java","tooltip":"/src/android/es/dsie/cordova/plugins/mobpartner/MobPartnerPlugin.java","undoManager":{"mark":3,"position":3,"stack":[[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":61,"column":13},"end":{"row":61,"column":14}},"text":" "}]}],[{"group":"doc","deltas":[{"action":"removeText","range":{"start":{"row":61,"column":13},"end":{"row":61,"column":14}},"text":" "}]}],[{"group":"doc","deltas":[{"action":"removeText","range":{"start":{"row":111,"column":0},"end":{"row":111,"column":1}},"text":"}"},{"action":"removeLines","range":{"start":{"row":0,"column":0},"end":{"row":111,"column":0}},"nl":"\n","lines":["package es.dsie.cordova.plugins.mobpartner;","","import java.util.Iterator;","","import org.apache.cordova.CallbackContext;","import org.apache.cordova.CordovaInterface;","import org.apache.cordova.CordovaPlugin;","import org.apache.cordova.LinearLayoutSoftKeyboardDetect;","import org.json.JSONArray;","import org.json.JSONException;","import org.json.JSONObject;","","import com.dsie.labs.bacoAndroidTesting.R;","import com.mobpartner.android.publisher.views.MobPartnerAdBanner;","import com.mobpartner.android.publisher.views.MobPartnerAdInterstitial;","","import android.util.Log;","import android.view.Gravity;","import android.view.ViewGroup;","import android.view.ViewGroup.MarginLayoutParams;","import android.webkit.WebBackForwardList;","import android.widget.FrameLayout;","import android.widget.LinearLayout;","import android.widget.RelativeLayout;","","public class MobPartnerPlugin extends CordovaPlugin {","\tprivate static final String LOGTAG = \"MobPartnerPlugin\";","\t","    private static final String ACTION_INIT = \"init\";","    private static final String ACTION_SHOW_BANNER = \"showBanner\";","    private static final String ACTION_SHOW_INTERSTITIAL = \"showInterstitial\";","    private static final String ACTION_HIDE_BANNER = \"hideBanner\";","    ","    private String poolId = \"\";","","    @Override","    public boolean execute(String action, JSONArray inputs, CallbackContext callbackContext) throws JSONException {","        if (ACTION_INIT.equals(action)) {","            //executeCreateBannerView(inputs, callbackContext);","            //executeInit(inputs,callbackContext);","            return true;","        } else if (ACTION_SHOW_BANNER.equals(action)) {","            //executeCreateInterstitialView(inputs, callbackContext);","            executeShowBanner(inputs,callbackContext);","            return true;","        } else if (ACTION_SHOW_INTERSTITIAL.equals(action)) {","        \texecuteShowInterstitial(inputs, callbackContext);","            //executeRequestAd(inputs, callbackContext);","            return true;","        } else if (ACTION_HIDE_BANNER.equals(action)) {","            //executeKillAd(callbackContext);","            return true;","        } else {","            Log.d(LOGTAG, String.format(\"Invalid action passed: %s\", action));","            callbackContext.error(\"Invalid Action\");","        }","        return false;","    }","","    private void executeShowBanner(JSONArray inputs, CallbackContext callbackContext) {","        // Get the input data.","        try {","            this.poolId = inputs.getString(0);","            final CordovaInterface cordova = this.cordova;","","    \t\t// Create the AdView on the UI thread.","    \t\tLog.w(LOGTAG, \"createBannerView\");","    \t\tRunnable runnable = new Runnable() {","    \t\t\tpublic void run() {","    \t\t\t\tLog.w(LOGTAG, \"ShowBanner:\" + poolId);","    \t\t\t\tLog.w(LOGTAG, String.valueOf(webView));","    \t\t\t\t\t","    \t\t\t\tLinearLayoutSoftKeyboardDetect parentView = (LinearLayoutSoftKeyboardDetect) webView.getParent();","    \t\t\t\tMobPartnerAdBanner banner = new MobPartnerAdBanner(webView.getContext(),poolId);","\t\t\t\t\tparentView.addView(banner);","    \t\t\t    banner.show();","    \t\t\t}","    \t\t};","    \t\tthis.cordova.getActivity().runOnUiThread(runnable);","        } catch (JSONException exception) {","            Log.w(LOGTAG,String.format(\"Got JSON Exception: %s\",exception.getMessage()));","            callbackContext.error(exception.getMessage());","        }","    }","    ","    private void executeShowInterstitial(JSONArray inputs, CallbackContext callbackContext) {","        // Get the input data.","        try {","            this.poolId = inputs.getString(0);","            final CordovaInterface cordova = this.cordova;","","    \t\t// Create the AdView on the UI thread.","    \t\tLog.w(LOGTAG, \"createInterstitialView\");","    \t\tRunnable runnable = new Runnable() {","    \t\t\tpublic void run() {","    \t\t\t\tLog.w(LOGTAG, \"ShowInterstitial:\" + poolId);","    \t\t\t\tLog.w(LOGTAG, String.valueOf(webView));","    \t\t\t\t\t","    \t\t\t\tMobPartnerAdInterstitial interstitial = new MobPartnerAdInterstitial(webView.getContext(),poolId);","    \t\t\t\tinterstitial.show();","    \t\t\t}","    \t\t};","    \t\tthis.cordova.getActivity().runOnUiThread(runnable);","        } catch (JSONException exception) {","            Log.w(LOGTAG,String.format(\"Got JSON Exception: %s\",exception.getMessage()));","            callbackContext.error(exception.getMessage());","        }","        ","    }","",""]},{"action":"insertText","range":{"start":{"row":0,"column":0},"end":{"row":0,"column":43}},"text":"package es.dsie.cordova.plugins.mobpartner;"},{"action":"insertText","range":{"start":{"row":0,"column":43},"end":{"row":1,"column":0}},"text":"\n"},{"action":"insertLines","range":{"start":{"row":1,"column":0},"end":{"row":124,"column":0}},"lines":["","import java.util.Iterator;","","import org.apache.cordova.CallbackContext;","import org.apache.cordova.CordovaInterface;","import org.apache.cordova.CordovaPlugin;","import org.apache.cordova.LinearLayoutSoftKeyboardDetect;","import org.json.JSONArray;","import org.json.JSONException;","import org.json.JSONObject;","","import com.dsie.labs.bacoAndroidTesting.R;","import com.mobpartner.android.publisher.views.MobPartnerAdBanner;","import com.mobpartner.android.publisher.views.MobPartnerAdInterstitial;","import com.mobpartner.android.publisher.views.MobPartnerMobStream;","import com.mobpartner.android.publisher.views.MobPartnerMobWall;","import com.mobpartner.android.publisher.views.MobPartnerMobWidget;","","import android.util.Log;","import android.view.Gravity;","import android.view.ViewGroup;","import android.view.ViewGroup.MarginLayoutParams;","import android.webkit.WebBackForwardList;","import android.widget.FrameLayout;","import android.widget.LinearLayout;","import android.widget.RelativeLayout;","","public class MobPartnerPlugin extends CordovaPlugin {","\tprivate static final String LOGTAG = \"MobPartnerPlugin\";","\t","    private static final String ACTION_INIT = \"init\";","    private static final String ACTION_SHOW_BANNER = \"showBanner\";","    private static final String ACTION_SHOW_INTERSTITIAL = \"showInterstitial\";","    private static final String ACTION_HIDE_BANNER = \"hideBanner\";","    ","    private String poolId = \"\";","","    @Override","    public boolean execute(String action, JSONArray inputs, CallbackContext callbackContext) throws JSONException {","        if (ACTION_INIT.equals(action)) {","            //executeCreateBannerView(inputs, callbackContext);","            //executeInit(inputs,callbackContext);","            return true;","        } else if (ACTION_SHOW_BANNER.equals(action)) {","            //executeCreateInterstitialView(inputs, callbackContext);","            executeShowBanner(inputs,callbackContext);","            return true;","        } else if (ACTION_SHOW_INTERSTITIAL.equals(action)) {","        \texecuteShowInterstitial(inputs, callbackContext);","            //executeRequestAd(inputs, callbackContext);","            return true;","        } else if (ACTION_HIDE_BANNER.equals(action)) {","            //executeKillAd(callbackContext);","            return true;","        } else {","            Log.d(LOGTAG, String.format(\"Invalid action passed: %s\", action));","            callbackContext.error(\"Invalid Action\");","        }","        return false;","    }","","    private void executeShowBanner(JSONArray inputs, CallbackContext callbackContext) {","        // Get the input data.","        try {","            this.poolId = inputs.getString(0);","            final CordovaInterface cordova = this.cordova;","","    \t\t// Create the AdView on the UI thread.","    \t\tLog.w(LOGTAG, \"createBannerView\");","    \t\tRunnable runnable = new Runnable() {","    \t\t\tpublic void run() {","    \t\t\t\tLog.w(LOGTAG, \"ShowBanner:\" + poolId);","    \t\t\t\tLog.w(LOGTAG, String.valueOf(webView));","    \t\t\t\t\t","    \t\t\t\tLinearLayoutSoftKeyboardDetect parentView = (LinearLayoutSoftKeyboardDetect) webView.getParent();","    \t\t\t\tMobPartnerAdBanner banner = new MobPartnerAdBanner(webView.getContext(),poolId);","\t\t\t\t\tparentView.addView(banner);","    \t\t\t    banner.show();","    \t\t\t}","    \t\t};","    \t\tthis.cordova.getActivity().runOnUiThread(runnable);","        } catch (JSONException exception) {","            Log.w(LOGTAG,String.format(\"Got JSON Exception: %s\",exception.getMessage()));","            callbackContext.error(exception.getMessage());","        }","    }","    ","    private void executeShowInterstitial(JSONArray inputs, CallbackContext callbackContext) {","        // Get the input data.","        try {","            this.poolId = inputs.getString(0);","            final CordovaInterface cordova = this.cordova;","","    \t\t// Create the AdView on the UI thread.","    \t\tLog.w(LOGTAG, \"createInterstitialView\");","    \t\tRunnable runnable = new Runnable() {","    \t\t\tpublic void run() {","    \t\t\t\tLog.w(LOGTAG, \"ShowInterstitial:\" + poolId);","    \t\t\t\tLog.w(LOGTAG, String.valueOf(webView));","    \t\t\t\t\t","    \t\t\t\tMobPartnerAdInterstitial interstitial = new MobPartnerAdInterstitial(webView.getContext(),poolId);","    \t\t\t\tinterstitial.show();","    \t\t\t\t","    \t\t\t\t//MobPartnerMobStream  mobstream = new MobPartnerMobStream(webView.getContext(),poolId);","    \t\t\t\t//mobstream.show();","    \t\t\t\t","    \t\t\t\t//MobPartnerMobWall mobwall = new MobPartnerMobWall(webView.getContext(),poolId);","    \t\t\t\t//mobwall.show();","","    \t\t\t\t//MobPartnerMobWidget mobwidget = new MobPartnerMobWidget(webView.getContext(),poolId);","    \t\t\t\t//mobwidget.showAd();","    \t\t\t\t","    \t\t\t}","    \t\t};","    \t\tthis.cordova.getActivity().runOnUiThread(runnable);","        } catch (JSONException exception) {","            Log.w(LOGTAG,String.format(\"Got JSON Exception: %s\",exception.getMessage()));","            callbackContext.error(exception.getMessage());","        }","        ","    }","",""]},{"action":"insertText","range":{"start":{"row":124,"column":0},"end":{"row":124,"column":1}},"text":"}"}]}],[{"group":"doc","deltas":[{"action":"removeText","range":{"start":{"row":124,"column":0},"end":{"row":124,"column":1}},"text":"}"},{"action":"removeLines","range":{"start":{"row":0,"column":0},"end":{"row":124,"column":0}},"nl":"\n","lines":["package es.dsie.cordova.plugins.mobpartner;","","import java.util.Iterator;","","import org.apache.cordova.CallbackContext;","import org.apache.cordova.CordovaInterface;","import org.apache.cordova.CordovaPlugin;","import org.apache.cordova.LinearLayoutSoftKeyboardDetect;","import org.json.JSONArray;","import org.json.JSONException;","import org.json.JSONObject;","","import com.dsie.labs.bacoAndroidTesting.R;","import com.mobpartner.android.publisher.views.MobPartnerAdBanner;","import com.mobpartner.android.publisher.views.MobPartnerAdInterstitial;","import com.mobpartner.android.publisher.views.MobPartnerMobStream;","import com.mobpartner.android.publisher.views.MobPartnerMobWall;","import com.mobpartner.android.publisher.views.MobPartnerMobWidget;","","import android.util.Log;","import android.view.Gravity;","import android.view.ViewGroup;","import android.view.ViewGroup.MarginLayoutParams;","import android.webkit.WebBackForwardList;","import android.widget.FrameLayout;","import android.widget.LinearLayout;","import android.widget.RelativeLayout;","","public class MobPartnerPlugin extends CordovaPlugin {","\tprivate static final String LOGTAG = \"MobPartnerPlugin\";","\t","    private static final String ACTION_INIT = \"init\";","    private static final String ACTION_SHOW_BANNER = \"showBanner\";","    private static final String ACTION_SHOW_INTERSTITIAL = \"showInterstitial\";","    private static final String ACTION_HIDE_BANNER = \"hideBanner\";","    ","    private String poolId = \"\";","","    @Override","    public boolean execute(String action, JSONArray inputs, CallbackContext callbackContext) throws JSONException {","        if (ACTION_INIT.equals(action)) {","            //executeCreateBannerView(inputs, callbackContext);","            //executeInit(inputs,callbackContext);","            return true;","        } else if (ACTION_SHOW_BANNER.equals(action)) {","            //executeCreateInterstitialView(inputs, callbackContext);","            executeShowBanner(inputs,callbackContext);","            return true;","        } else if (ACTION_SHOW_INTERSTITIAL.equals(action)) {","        \texecuteShowInterstitial(inputs, callbackContext);","            //executeRequestAd(inputs, callbackContext);","            return true;","        } else if (ACTION_HIDE_BANNER.equals(action)) {","            //executeKillAd(callbackContext);","            return true;","        } else {","            Log.d(LOGTAG, String.format(\"Invalid action passed: %s\", action));","            callbackContext.error(\"Invalid Action\");","        }","        return false;","    }","","    private void executeShowBanner(JSONArray inputs, CallbackContext callbackContext) {","        // Get the input data.","        try {","            this.poolId = inputs.getString(0);","            final CordovaInterface cordova = this.cordova;","","    \t\t// Create the AdView on the UI thread.","    \t\tLog.w(LOGTAG, \"createBannerView\");","    \t\tRunnable runnable = new Runnable() {","    \t\t\tpublic void run() {","    \t\t\t\tLog.w(LOGTAG, \"ShowBanner:\" + poolId);","    \t\t\t\tLog.w(LOGTAG, String.valueOf(webView));","    \t\t\t\t\t","    \t\t\t\tLinearLayoutSoftKeyboardDetect parentView = (LinearLayoutSoftKeyboardDetect) webView.getParent();","    \t\t\t\tMobPartnerAdBanner banner = new MobPartnerAdBanner(webView.getContext(),poolId);","\t\t\t\t\tparentView.addView(banner);","    \t\t\t    banner.show();","    \t\t\t}","    \t\t};","    \t\tthis.cordova.getActivity().runOnUiThread(runnable);","        } catch (JSONException exception) {","            Log.w(LOGTAG,String.format(\"Got JSON Exception: %s\",exception.getMessage()));","            callbackContext.error(exception.getMessage());","        }","    }","    ","    private void executeShowInterstitial(JSONArray inputs, CallbackContext callbackContext) {","        // Get the input data.","        try {","            this.poolId = inputs.getString(0);","            final CordovaInterface cordova = this.cordova;","","    \t\t// Create the AdView on the UI thread.","    \t\tLog.w(LOGTAG, \"createInterstitialView\");","    \t\tRunnable runnable = new Runnable() {","    \t\t\tpublic void run() {","    \t\t\t\tLog.w(LOGTAG, \"ShowInterstitial:\" + poolId);","    \t\t\t\tLog.w(LOGTAG, String.valueOf(webView));","    \t\t\t\t\t","    \t\t\t\tMobPartnerAdInterstitial interstitial = new MobPartnerAdInterstitial(webView.getContext(),poolId);","    \t\t\t\tinterstitial.show();","    \t\t\t\t","    \t\t\t\t//MobPartnerMobStream  mobstream = new MobPartnerMobStream(webView.getContext(),poolId);","    \t\t\t\t//mobstream.show();","    \t\t\t\t","    \t\t\t\t//MobPartnerMobWall mobwall = new MobPartnerMobWall(webView.getContext(),poolId);","    \t\t\t\t//mobwall.show();","","    \t\t\t\t//MobPartnerMobWidget mobwidget = new MobPartnerMobWidget(webView.getContext(),poolId);","    \t\t\t\t//mobwidget.showAd();","    \t\t\t\t","    \t\t\t}","    \t\t};","    \t\tthis.cordova.getActivity().runOnUiThread(runnable);","        } catch (JSONException exception) {","            Log.w(LOGTAG,String.format(\"Got JSON Exception: %s\",exception.getMessage()));","            callbackContext.error(exception.getMessage());","        }","        ","    }","",""]},{"action":"insertText","range":{"start":{"row":0,"column":0},"end":{"row":0,"column":43}},"text":"package es.dsie.cordova.plugins.mobpartner;"},{"action":"insertText","range":{"start":{"row":0,"column":43},"end":{"row":1,"column":0}},"text":"\n"},{"action":"insertLines","range":{"start":{"row":1,"column":0},"end":{"row":110,"column":0}},"lines":["","import org.apache.cordova.CallbackContext;","import org.apache.cordova.CordovaInterface;","import org.apache.cordova.CordovaPlugin;","import org.apache.cordova.LinearLayoutSoftKeyboardDetect;","import org.json.JSONArray;","import org.json.JSONException;","","import android.util.Log;","","import com.mobpartner.android.publisher.views.MobPartnerAdBanner;","import com.mobpartner.android.publisher.views.MobPartnerAdInterstitial;","","public class MobPartnerPlugin extends CordovaPlugin {","\tprivate static final String LOGTAG = \"MobPartnerPlugin\";","\t","    private static final String ACTION_INIT = \"init\";","    private static final String ACTION_SHOW_BANNER = \"showBanner\";","    private static final String ACTION_SHOW_INTERSTITIAL = \"showInterstitial\";","    private static final String ACTION_HIDE_BANNER = \"hideBanner\";","    ","    private String poolId = \"\";","","    @Override","    public boolean execute(String action, JSONArray inputs, CallbackContext callbackContext) throws JSONException {","        if (ACTION_INIT.equals(action)) {","            //executeCreateBannerView(inputs, callbackContext);","            //executeInit(inputs,callbackContext);","            return true;","        } else if (ACTION_SHOW_BANNER.equals(action)) {","            //executeCreateInterstitialView(inputs, callbackContext);","            executeShowBanner(inputs,callbackContext);","            return true;","        } else if (ACTION_SHOW_INTERSTITIAL.equals(action)) {","        \texecuteShowInterstitial(inputs, callbackContext);","            //executeRequestAd(inputs, callbackContext);","            return true;","        } else if (ACTION_HIDE_BANNER.equals(action)) {","            //executeKillAd(callbackContext);","            return true;","        } else {","            Log.d(LOGTAG, String.format(\"Invalid action passed: %s\", action));","            callbackContext.error(\"Invalid Action\");","        }","        return false;","    }","","    private void executeShowBanner(JSONArray inputs, CallbackContext callbackContext) {","        // Get the input data.","        try {","            this.poolId = inputs.getString(0);","            final CordovaInterface cordova = this.cordova;","","    \t\t// Create the AdView on the UI thread.","    \t\tLog.w(LOGTAG, \"createBannerView\");","    \t\tRunnable runnable = new Runnable() {","    \t\t\tpublic void run() {","    \t\t\t\tLog.w(LOGTAG, \"ShowBanner:\" + poolId);","    \t\t\t\tLog.w(LOGTAG, String.valueOf(webView));","    \t\t\t\t\t","    \t\t\t\tLinearLayoutSoftKeyboardDetect parentView = (LinearLayoutSoftKeyboardDetect) webView.getParent();","    \t\t\t\tMobPartnerAdBanner banner = new MobPartnerAdBanner(webView.getContext(),poolId);","\t\t\t\t\tparentView.addView(banner);","    \t\t\t    banner.show();","    \t\t\t}","    \t\t};","    \t\tthis.cordova.getActivity().runOnUiThread(runnable);","        } catch (JSONException exception) {","            Log.w(LOGTAG,String.format(\"Got JSON Exception: %s\",exception.getMessage()));","            callbackContext.error(exception.getMessage());","        }","    }","    ","    private void executeShowInterstitial(JSONArray inputs, CallbackContext callbackContext) {","        // Get the input data.","        try {","            this.poolId = inputs.getString(0);","            final CordovaInterface cordova = this.cordova;","","    \t\t// Create the AdView on the UI thread.","    \t\tLog.w(LOGTAG, \"createInterstitialView\");","    \t\tRunnable runnable = new Runnable() {","    \t\t\tpublic void run() {","    \t\t\t\tLog.w(LOGTAG, \"ShowInterstitial:\" + poolId);","    \t\t\t\tLog.w(LOGTAG, String.valueOf(webView));","    \t\t\t\t\t","    \t\t\t\tMobPartnerAdInterstitial interstitial = new MobPartnerAdInterstitial(webView.getContext(),poolId);","    \t\t\t\tinterstitial.show();","    \t\t\t\t","    \t\t\t\t//MobPartnerMobStream  mobstream = new MobPartnerMobStream(webView.getContext(),poolId);","    \t\t\t\t//mobstream.show();","    \t\t\t\t","    \t\t\t\t//MobPartnerMobWall mobwall = new MobPartnerMobWall(webView.getContext(),poolId);","    \t\t\t\t//mobwall.show();","","    \t\t\t\t//MobPartnerMobWidget mobwidget = new MobPartnerMobWidget(webView.getContext(),poolId);","    \t\t\t\t//mobwidget.showAd();","    \t\t\t\t","    \t\t\t}","    \t\t};","    \t\tthis.cordova.getActivity().runOnUiThread(runnable);","        } catch (JSONException exception) {","            Log.w(LOGTAG,String.format(\"Got JSON Exception: %s\",exception.getMessage()));","            callbackContext.error(exception.getMessage());","        }","        ","    }","",""]},{"action":"insertText","range":{"start":{"row":110,"column":0},"end":{"row":110,"column":1}},"text":"}"}]}]]},"ace":{"folds":[],"scrolltop":540,"scrollleft":0,"selection":{"start":{"row":0,"column":0},"end":{"row":110,"column":1},"isBackwards":false},"options":{"guessTabSize":true,"useWrapMode":false,"wrapToView":true},"firstLineState":{"row":37,"state":"start","mode":"ace/mode/java"}},"timestamp":1405421778000,"hash":"ac6fa56c8ad68424569dc078f95819b27a7ef819"}