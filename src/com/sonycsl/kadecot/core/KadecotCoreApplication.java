/*
 * Copyright (C) 2013-2014 Sony Computer Science Laboratories, Inc. All Rights Reserved.
 * Copyright (C) 2014 Sony Corporation. All Rights Reserved.
 */

package com.sonycsl.kadecot.core;

import android.app.Application;

public class KadecotCoreApplication extends Application {

    protected AppModifiableCoreObject mModifiableCoreObject;

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        mModifiableCoreObject = new AppModifiableCoreObject(this);
    }

    public AppModifiableCoreObject getModifiableObject() {
        return mModifiableCoreObject;
    }

}