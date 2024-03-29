/*
 * Copyright (C) 2013-2014 Sony Computer Science Laboratories, Inc. All Rights Reserved.
 * Copyright (C) 2014 Sony Corporation. All Rights Reserved.
 */

package com.sonycsl.wamp.util;

import java.util.concurrent.atomic.AtomicInteger;

public final class WampRequestIdGenerator {

    private static final AtomicInteger ID = new AtomicInteger(1);

    synchronized public static int getId() {
        int reqId = ID.getAndIncrement();
        if (reqId == Integer.MAX_VALUE) {
            ID.set(1);
        }
        return reqId;
    }
}
