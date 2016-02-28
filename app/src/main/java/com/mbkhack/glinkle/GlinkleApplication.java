package com.mbkhack.glinkle;

import android.app.Application;

/**
 * Created by johnsonma on 2/27/16.
 */
public class GlinkleApplication extends Application {

    CharityManager charityManager = null;

    public CharityManager getCharityManager() {
        if(charityManager == null) {
            charityManager = new CharityManager();
        }

        return charityManager;
    }
}
