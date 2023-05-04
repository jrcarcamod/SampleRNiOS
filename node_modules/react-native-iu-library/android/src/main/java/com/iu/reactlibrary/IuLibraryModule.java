package com.iu.reactlibrary;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import android.app.Application;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import amazonia.iu.com.amlibrary.client.IUApp;

public class IuLibraryModule extends ReactContextBaseJavaModule {

    private final String TAG = IuLibraryModule.class.getName();

    private final boolean IS_DEBUG = true;
    private static final String EVENT_NAME = "EVENT_NAME";
    // DO NOT CHANGE THE MODULE NAME
    private final String IU_LIBRARY_MODULE = "IuLibraryModule";

    private final ReactApplicationContext reactContext;

    public IuLibraryModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        launchSDK(reactContext);
    }

    public IuLibraryModule(Application application, ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        initSDK(application);
    }

    @Override
    public String getName() {
        return IU_LIBRARY_MODULE;
    }

    @ReactMethod
    public void initSDK(Application application) {

        if (application != null) {
            IUApp.init(application, HostComplianceActivity.class);
        }
    }

    @ReactMethod
    public void launchSDK(ReactApplicationContext context) {

        if (reactContext != null) {
            IUApp.launch(context);
        }
    }

    @ReactMethod
    public void invokeFCM(String message) {
        if (IS_DEBUG) {
            Log.e(TAG, "FCM Received in Module" + message);
        }
        try {
            JSONObject jsonObject = new JSONObject(message);
            if (IS_DEBUG) {
                Log.d(TAG, "JSon from : " + jsonObject.getString("from") + "   IU Sender : " + IUApp.getFCMSenderId());
            }
            if (jsonObject.getString("from").equals(IUApp.getFCMSenderId())) {
                if (IS_DEBUG) {
                    Log.e(TAG, "In if statFCM Received in Module" + message);
                }
                IUApp.handleFCMMessage(reactContext, jsonObject);
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    @ReactMethod
    public void refreshToken() {
        if (IS_DEBUG) {
            Log.e(TAG, "FCM Token refresh in Module");
        }
        try {
            IUApp.refreshFCMToken(reactContext);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // TIM - Opt In related
    @ReactMethod
    public void updateOptInStatus(boolean optInStatus) {
        try {
            if (IS_DEBUG) {
                Log.e(TAG, "Opt In Value - Update Value to IU SDK from RN :" + optInStatus);
            }
            IUApp.updateOptInStatus(reactContext, optInStatus);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @ReactMethod
    public void getOptInStatus(Callback booleanCallback) {
        try {
            if (IS_DEBUG) {
                Log.e(TAG, "Opt In Value - Value from IU SDK in RN :" + IUApp.getOptInStatus(reactContext));
            }
            boolean optInValue = IUApp.getOptInStatus(reactContext);
            booleanCallback.invoke(optInValue);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Set Client Attributes
    @ReactMethod
    public void setClientAttributes(String string) {
        try {
            JSONObject jsonObject = new JSONObject(string);
            if (IS_DEBUG) {
                Log.e(TAG, "Client Attributes : " + jsonObject.toString());
            }
            IUApp.setClientAttributes(reactContext, jsonObject);
        } catch (JSONException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @ReactMethod
    public void getFCMSenderId(Callback callback) {
        try {
            callback.invoke(IUApp.getFCMSenderId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @ReactMethod
    public void getSDKStatus(Callback callback) {
        try {
            callback.invoke(IUApp.getSDKStatus(reactContext));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // In App Events
    @ReactMethod
    public void sendEventWithName(String eventName) {
        try {
            if (IS_DEBUG) {
                Log.e(TAG, "In App Event RN - Event Name : " + eventName);
            }
            if (eventName != null) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put(EVENT_NAME, eventName);
                if (IS_DEBUG) {
                    Log.e(TAG, "In App Events : " + jsonObject.toString());
                }
                IUApp.trackInAppEvents(reactContext.getApplicationContext(), jsonObject);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Opt In - Opt Out Engagement
    @ReactMethod
    public void updateOptInStatusForEngagement(boolean optInStatus) {
        try {
            if (IS_DEBUG) {
                Log.e(TAG, "Opt In Value for Engagement - Update Value for Engagement to IU SDK from RN :" + optInStatus);
            }
            IUApp.updateOptInStatusForEngagement(reactContext, optInStatus);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @ReactMethod
    public void getOptInStatusForEngagement(Callback booleanCallback) {
        try {
            if (IS_DEBUG) {
                Log.e(TAG, "Opt In Value for Engagement -Value for Engagement from IU SDK in RN :" + IUApp.getOptInStatus(reactContext));
            }
            boolean optInValue = IUApp.getOptInStatusForEngagement(reactContext);
            booleanCallback.invoke(optInValue);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // New Methods

    @ReactMethod
    public void setAppPermissionStatus(boolean appPermissionsStatus) {
        try {
            if (IS_DEBUG) {
                Log.e(TAG, "App Permission Status Value - Update Value to IU SDK from RN App :" + appPermissionsStatus);
            }
            IUApp.setAppPermissionStatus(reactContext, appPermissionsStatus);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @ReactMethod
    public void getAppPermissionStatus(Callback callback) {
        try {

            if (IS_DEBUG) {
                Log.e(TAG, "App Permission Status Value - Value from IU SDK in RN App :" + IUApp.getAppPermissionStatus(reactContext));
            }
            boolean appPermissionStatus = IUApp.getAppPermissionStatus(reactContext);
            callback.invoke(appPermissionStatus);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @ReactMethod
    public void createOrganisationFromCountryCode(String countryCode) {
        try {
            if (IS_DEBUG) {
                Log.e(TAG, "create Organisation From CountryCode - Update Value to IU SDK from RN App :" + countryCode);
            }
            IUApp.createOrganisationFromCountryCode(reactContext, countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @ReactMethod
    public void getCurrentOrganizationName(Callback callback) {
        try {
            if (IS_DEBUG) {
                Log.e(TAG, "Get Current Organization Name Value - Value from IU SDK in RN App :" + IUApp.getCurrentOrganizationName(reactContext));
            }
            String organizationName = IUApp.getCurrentOrganizationName(reactContext);

            callback.invoke(organizationName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @ReactMethod
    public void setSensitiveDataSwitch(boolean sensitiveData) {
        try {
            if (IS_DEBUG) {
                Log.e(TAG, "App Permission Status Value - Update Value to IU SDK from RN App :" + sensitiveData);
            }
            IUApp.setSensitiveDataSwitch(reactContext, sensitiveData);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @ReactMethod
    public void saveFCMToken(String hostAppFCMToken) {
        try {
            if (IS_DEBUG) {
                Log.e(TAG, "Save Host App FCM Token - Update Value to IU SDK from RN App :" + hostAppFCMToken);
            }
            IUApp.saveFCMToken(reactContext, hostAppFCMToken);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Android 13 Notification permission request
     */
    @ReactMethod
    public void requestNotificationPermission() {
        IUApp.requestNotificationPermission(reactContext, granted -> {
            if (IS_DEBUG) {
                String text = granted ? "GRANTED" : "NO PERMISSION";
                Log.e(TAG, "RequestNotificationPermission - RN App :" + text);
            }
        });
    }

}
