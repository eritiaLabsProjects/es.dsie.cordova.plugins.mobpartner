{"filter":false,"title":"MobPartnerPlugin.java","tooltip":"/src/android/es/dsie/cordova/plugins/mobpartner/MobPartnerPlugin.java","undoManager":{"mark":26,"position":26,"stack":[[{"group":"doc","deltas":[{"action":"removeText","range":{"start":{"row":0,"column":8},"end":{"row":0,"column":33}},"text":"com.google.cordova.plugin"}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":8},"end":{"row":0,"column":9}},"text":"e"}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":9},"end":{"row":0,"column":10}},"text":"s"}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":10},"end":{"row":0,"column":11}},"text":"."}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":11},"end":{"row":0,"column":12}},"text":"d"}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":12},"end":{"row":0,"column":13}},"text":"s"}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":13},"end":{"row":0,"column":14}},"text":"i"}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":14},"end":{"row":0,"column":15}},"text":"e"}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":15},"end":{"row":0,"column":16}},"text":"."}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":16},"end":{"row":0,"column":17}},"text":"c"}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":17},"end":{"row":0,"column":18}},"text":"o"}]}],[{"group":"doc","deltas":[{"action":"removeText","range":{"start":{"row":0,"column":16},"end":{"row":0,"column":18}},"text":"co"},{"action":"insertText","range":{"start":{"row":0,"column":16},"end":{"row":0,"column":23}},"text":"cordova"}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":23},"end":{"row":0,"column":24}},"text":"."}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":24},"end":{"row":0,"column":25}},"text":"p"}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":25},"end":{"row":0,"column":26}},"text":"l"}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":26},"end":{"row":0,"column":27}},"text":"u"}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":27},"end":{"row":0,"column":28}},"text":"g"}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":28},"end":{"row":0,"column":29}},"text":"i"}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":29},"end":{"row":0,"column":30}},"text":"n"}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":30},"end":{"row":0,"column":31}},"text":"s"}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":31},"end":{"row":0,"column":32}},"text":"."}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":32},"end":{"row":0,"column":33}},"text":"m"}]}],[{"group":"doc","deltas":[{"action":"insertText","range":{"start":{"row":0,"column":33},"end":{"row":0,"column":34}},"text":"o"}]}],[{"group":"doc","deltas":[{"action":"removeText","range":{"start":{"row":0,"column":32},"end":{"row":0,"column":34}},"text":"mo"},{"action":"insertText","range":{"start":{"row":0,"column":32},"end":{"row":0,"column":42}},"text":"mobpartner"}]}],[{"group":"doc","deltas":[{"action":"removeText","range":{"start":{"row":64,"column":0},"end":{"row":64,"column":1}},"text":"}"},{"action":"removeLines","range":{"start":{"row":0,"column":0},"end":{"row":64,"column":0}},"nl":"\n","lines":["package es.dsie.cordova.plugins.mobpartner;","","import java.util.Iterator;","","import org.apache.cordova.CallbackContext;","import org.apache.cordova.CordovaInterface;","import org.apache.cordova.CordovaPlugin;","import org.apache.cordova.LinearLayoutSoftKeyboardDetect;","import org.json.JSONArray;","import org.json.JSONException;","import org.json.JSONObject;","","import com.mobpartner.android.publisher.views.MobPartnerAdBanner;","","import android.util.Log;","","public class MobPartnerPlugin extends CordovaPlugin {","    private static final String ACTION_INIT = \"init\";","    private static final String ACTION_SHOW_BANNER = \"showBanner\";","    private static final String ACTION_SHOW_INTERSTITIAL = \"showInterstitial\";","    private static final String ACTION_HIDE_BANNER = \"hideBanner\";","","    @Override","    public boolean execute(String action, JSONArray inputs, CallbackContext callbackContext) throws JSONException {","        if (ACTION_INIT.equals(action)) {","            //executeCreateBannerView(inputs, callbackContext);","            executeInit(inputs,callbackContext);","            return true;","        } else if (ACTION_SHOW_BANNER.equals(action)) {","            //executeCreateInterstitialView(inputs, callbackContext);","            executeShowBanner(inputs,callbackContext);","            return true;","        } else if (ACTION_SHOW_INTERSTITIAL.equals(action)) {","            //executeRequestAd(inputs, callbackContext);","            return true;","        } else if (ACTION_HIDE_BANNER.equals(action)) {","            //executeKillAd(callbackContext);","            return true;","        } else {","            Log.d(LOGTAG, String.format(\"Invalid action passed: %s\", action));","            callbackContext.error(\"Invalid Action\");","        }","        return false;","    }","","    private void executeShowBanner(JSONArray inputs, CallbackContext callbackContext) {","        String poolId = \"\";","        String size = \"\";","","        // Get the input data.","        try {","            poolId = inputs.getString(0);","            ","            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);","            banner = new MobPartnerAdBanner(this, poolId);","            banner.setLayoutParams(layoutParams); ","            banner.show();","","        } catch (JSONException exception) {","            Log.w(LOGTAG,String.format(\"Got JSON Exception: %s\",exception.getMessage()));","            callbackContext.error(exception.getMessage());","        }","    }",""]},{"action":"insertText","range":{"start":{"row":0,"column":0},"end":{"row":0,"column":43}},"text":"package es.dsie.cordova.plugins.mobpartner;"},{"action":"insertText","range":{"start":{"row":0,"column":43},"end":{"row":1,"column":0}},"text":"\n"},{"action":"insertLines","range":{"start":{"row":1,"column":0},"end":{"row":69,"column":0}},"lines":["","import java.util.Iterator;","","import org.apache.cordova.CallbackContext;","import org.apache.cordova.CordovaInterface;","import org.apache.cordova.CordovaPlugin;","import org.apache.cordova.LinearLayoutSoftKeyboardDetect;","import org.json.JSONArray;","import org.json.JSONException;","import org.json.JSONObject;","","import com.mobpartner.android.publisher.views.MobPartnerAdBanner;","","import android.util.Log;","import android.widget.FrameLayout;","import android.widget.LinearLayout;","","public class MobPartnerPlugin extends CordovaPlugin {","\tprivate static final String LOGTAG = \"MobPartnerPlugin\";","\t","    private static final String ACTION_INIT = \"init\";","    private static final String ACTION_SHOW_BANNER = \"showBanner\";","    private static final String ACTION_SHOW_INTERSTITIAL = \"showInterstitial\";","    private static final String ACTION_HIDE_BANNER = \"hideBanner\";","","    @Override","    public boolean execute(String action, JSONArray inputs, CallbackContext callbackContext) throws JSONException {","        if (ACTION_INIT.equals(action)) {","            //executeCreateBannerView(inputs, callbackContext);","            //executeInit(inputs,callbackContext);","            return true;","        } else if (ACTION_SHOW_BANNER.equals(action)) {","            //executeCreateInterstitialView(inputs, callbackContext);","            executeShowBanner(inputs,callbackContext);","            return true;","        } else if (ACTION_SHOW_INTERSTITIAL.equals(action)) {","            //executeRequestAd(inputs, callbackContext);","            return true;","        } else if (ACTION_HIDE_BANNER.equals(action)) {","            //executeKillAd(callbackContext);","            return true;","        } else {","            Log.d(LOGTAG, String.format(\"Invalid action passed: %s\", action));","            callbackContext.error(\"Invalid Action\");","        }","        return false;","    }","","    private void executeShowBanner(JSONArray inputs, CallbackContext callbackContext) {","        String poolId = \"\";","        String size = \"\";","","        // Get the input data.","        try {","            poolId = inputs.getString(0);","            ","            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);","            //banner = new MobPartnerAdBanner(this, poolId);","            MobPartnerAdBanner banner = new MobPartnerAdBanner(this.webView.getContext(),poolId);","            banner.setLayoutParams(layoutParams); ","            banner.show();","","        } catch (JSONException exception) {","            Log.w(LOGTAG,String.format(\"Got JSON Exception: %s\",exception.getMessage()));","            callbackContext.error(exception.getMessage());","        }","    }",""]},{"action":"insertText","range":{"start":{"row":69,"column":0},"end":{"row":69,"column":1}},"text":"}"}]}],[{"group":"doc","deltas":[{"action":"removeText","range":{"start":{"row":59,"column":0},"end":{"row":59,"column":1}},"text":" "},{"action":"removeText","range":{"start":{"row":58,"column":1},"end":{"row":58,"column":60}},"text":"           //banner = new MobPartnerAdBanner(this, poolId);"},{"action":"removeText","range":{"start":{"row":58,"column":1},"end":{"row":59,"column":0}},"text":"\n"}]}],[{"group":"doc","deltas":[{"action":"removeText","range":{"start":{"row":68,"column":0},"end":{"row":68,"column":1}},"text":"}"},{"action":"removeLines","range":{"start":{"row":0,"column":0},"end":{"row":68,"column":0}},"nl":"\n","lines":["package es.dsie.cordova.plugins.mobpartner;","","import java.util.Iterator;","","import org.apache.cordova.CallbackContext;","import org.apache.cordova.CordovaInterface;","import org.apache.cordova.CordovaPlugin;","import org.apache.cordova.LinearLayoutSoftKeyboardDetect;","import org.json.JSONArray;","import org.json.JSONException;","import org.json.JSONObject;","","import com.mobpartner.android.publisher.views.MobPartnerAdBanner;","","import android.util.Log;","import android.widget.FrameLayout;","import android.widget.LinearLayout;","","public class MobPartnerPlugin extends CordovaPlugin {","\tprivate static final String LOGTAG = \"MobPartnerPlugin\";","\t","    private static final String ACTION_INIT = \"init\";","    private static final String ACTION_SHOW_BANNER = \"showBanner\";","    private static final String ACTION_SHOW_INTERSTITIAL = \"showInterstitial\";","    private static final String ACTION_HIDE_BANNER = \"hideBanner\";","","    @Override","    public boolean execute(String action, JSONArray inputs, CallbackContext callbackContext) throws JSONException {","        if (ACTION_INIT.equals(action)) {","            //executeCreateBannerView(inputs, callbackContext);","            //executeInit(inputs,callbackContext);","            return true;","        } else if (ACTION_SHOW_BANNER.equals(action)) {","            //executeCreateInterstitialView(inputs, callbackContext);","            executeShowBanner(inputs,callbackContext);","            return true;","        } else if (ACTION_SHOW_INTERSTITIAL.equals(action)) {","            //executeRequestAd(inputs, callbackContext);","            return true;","        } else if (ACTION_HIDE_BANNER.equals(action)) {","            //executeKillAd(callbackContext);","            return true;","        } else {","            Log.d(LOGTAG, String.format(\"Invalid action passed: %s\", action));","            callbackContext.error(\"Invalid Action\");","        }","        return false;","    }","","    private void executeShowBanner(JSONArray inputs, CallbackContext callbackContext) {","        String poolId = \"\";","        String size = \"\";","","        // Get the input data.","        try {","            poolId = inputs.getString(0);","            ","            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);","            MobPartnerAdBanner banner = new MobPartnerAdBanner(this.webView.getContext(),poolId);","            banner.setLayoutParams(layoutParams); ","            banner.show();","","        } catch (JSONException exception) {","            Log.w(LOGTAG,String.format(\"Got JSON Exception: %s\",exception.getMessage()));","            callbackContext.error(exception.getMessage());","        }","    }",""]},{"action":"insertText","range":{"start":{"row":0,"column":0},"end":{"row":0,"column":43}},"text":"package es.dsie.cordova.plugins.mobpartner;"},{"action":"insertText","range":{"start":{"row":0,"column":43},"end":{"row":1,"column":0}},"text":"\n"},{"action":"insertLines","range":{"start":{"row":1,"column":0},"end":{"row":118,"column":0}},"lines":["","import java.util.Iterator;","","import org.apache.cordova.CallbackContext;","import org.apache.cordova.CordovaInterface;","import org.apache.cordova.CordovaPlugin;","import org.apache.cordova.LinearLayoutSoftKeyboardDetect;","import org.json.JSONArray;","import org.json.JSONException;","import org.json.JSONObject;","","import com.dsie.labs.bacoAndroidTesting.R;","import com.mobpartner.android.publisher.views.MobPartnerAdBanner;","import com.mobpartner.android.publisher.views.MobPartnerAdInterstitial;","","import android.util.Log;","import android.view.Gravity;","import android.view.ViewGroup;","import android.view.ViewGroup.MarginLayoutParams;","import android.webkit.WebBackForwardList;","import android.widget.FrameLayout;","import android.widget.LinearLayout;","import android.widget.RelativeLayout;","","public class MobPartnerPlugin extends CordovaPlugin {","\tprivate static final String LOGTAG = \"MobPartnerPlugin\";","\t","    private static final String ACTION_INIT = \"init\";","    private static final String ACTION_SHOW_BANNER = \"showBanner\";","    private static final String ACTION_SHOW_INTERSTITIAL = \"showInterstitial\";","    private static final String ACTION_HIDE_BANNER = \"hideBanner\";","    ","    private String poolId = \"\";","","    @Override","    public boolean execute(String action, JSONArray inputs, CallbackContext callbackContext) throws JSONException {","        if (ACTION_INIT.equals(action)) {","            //executeCreateBannerView(inputs, callbackContext);","            //executeInit(inputs,callbackContext);","            return true;","        } else if (ACTION_SHOW_BANNER.equals(action)) {","            //executeCreateInterstitialView(inputs, callbackContext);","            executeShowBanner(inputs,callbackContext);","            return true;","        } else if (ACTION_SHOW_INTERSTITIAL.equals(action)) {","        \texecuteShowInterstitial(inputs, callbackContext);","            //executeRequestAd(inputs, callbackContext);","            return true;","        } else if (ACTION_HIDE_BANNER.equals(action)) {","            //executeKillAd(callbackContext);","            return true;","        } else {","            Log.d(LOGTAG, String.format(\"Invalid action passed: %s\", action));","            callbackContext.error(\"Invalid Action\");","        }","        return false;","    }","","    private void executeShowBanner(JSONArray inputs, CallbackContext callbackContext) {","        // Get the input data.","        try {","            this.poolId = inputs.getString(0);","            final CordovaInterface cordova = this.cordova;","","    \t\t// Create the AdView on the UI thread.","    \t\tLog.w(LOGTAG, \"createBannerView\");","    \t\tRunnable runnable = new Runnable() {","    \t\t\tpublic void run() {","    \t\t\t\tLog.w(LOGTAG, \"ShowBanner:\" + poolId);","    \t\t\t\tLog.w(LOGTAG, String.valueOf(webView));","    \t\t\t\t\t","    \t\t\t\t//LinearLayoutSoftKeyboardDetect parentView = (LinearLayoutSoftKeyboardDetect) webView.getParent();","    \t\t\t\t//LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);","    \t\t\t\t//layoutParams.gravity = Gravity.BOTTOM;","","    \t\t\t\tRelativeLayout.LayoutParams layoutParams= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);","    \t\t\t\tlayoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, webView.getId());","    \t\t\t\t","    \t\t\t\tMobPartnerAdBanner banner = new MobPartnerAdBanner(webView.getContext(),poolId);","    \t\t\t    //banner.setLayoutParams(layoutParams);","    \t\t\t    cordova.getActivity().addContentView(banner, layoutParams);","    \t\t\t    banner.show();","    \t\t\t}","    \t\t};","    \t\tthis.cordova.getActivity().runOnUiThread(runnable);","        } catch (JSONException exception) {","            Log.w(LOGTAG,String.format(\"Got JSON Exception: %s\",exception.getMessage()));","            callbackContext.error(exception.getMessage());","        }","    }","    ","    private void executeShowInterstitial(JSONArray inputs, CallbackContext callbackContext) {","        // Get the input data.","        try {","            this.poolId = inputs.getString(0);","            final CordovaInterface cordova = this.cordova;","","    \t\t// Create the AdView on the UI thread.","    \t\tLog.w(LOGTAG, \"createInterstitialView\");","    \t\tRunnable runnable = new Runnable() {","    \t\t\tpublic void run() {","    \t\t\t\tLog.w(LOGTAG, \"ShowInterstitial:\" + poolId);","    \t\t\t\tLog.w(LOGTAG, String.valueOf(webView));","    \t\t\t\t\t","    \t\t\t\tMobPartnerAdInterstitial interstitial = new MobPartnerAdInterstitial(webView.getContext(),poolId);","    \t\t\t\tinterstitial.show();","    \t\t\t}","    \t\t};","    \t\tthis.cordova.getActivity().runOnUiThread(runnable);","        } catch (JSONException exception) {","            Log.w(LOGTAG,String.format(\"Got JSON Exception: %s\",exception.getMessage()));","            callbackContext.error(exception.getMessage());","        }","        ","    }","",""]},{"action":"insertText","range":{"start":{"row":118,"column":0},"end":{"row":118,"column":1}},"text":"}"}]}]]},"ace":{"folds":[],"scrolltop":1370,"scrollleft":0,"selection":{"start":{"row":118,"column":1},"end":{"row":118,"column":1},"isBackwards":false},"options":{"guessTabSize":true,"useWrapMode":false,"wrapToView":true},"firstLineState":{"row":96,"state":"start","mode":"ace/mode/java"}},"timestamp":1405074700454,"hash":"eaea2a6842089ddc6a59358b332ca6b118554d0a"}