/*
 * Copyright (C) 2013-2014 Sony Computer Science Laboratories, Inc. All Rights Reserved.
 * Copyright (C) 2014 Sony Corporation. All Rights Reserved.
 */

package com.sonycsl.wamp.message.impl;

import com.sonycsl.wamp.message.WampMessage;
import com.sonycsl.wamp.message.WampMessageType;
import com.sonycsl.wamp.message.WampUnsubscribedMessage;

import org.json.JSONArray;
import org.json.JSONException;

public class WampUnsubscribedMessageImpl extends WampAbstractMessage implements
        WampUnsubscribedMessage {

    private static final int REQUEST_ID_INDEX = 1;

    public static WampMessage create(int requestId) {
        return new WampUnsubscribedMessageImpl(new JSONArray().put(WampMessageType.UNSUBSCRIBED)
                .put(requestId));
    }

    public WampUnsubscribedMessageImpl(JSONArray msg) {
        super(msg);
        try {
            if (msg.getInt(0) != WampMessageType.UNSUBSCRIBED) {
                throw new IllegalArgumentException("message type is mismatched");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean isUnsubscribedMessage() {
        return true;
    }

    @Override
    public WampUnsubscribedMessage asUnsubscribedMessage() {
        return this;
    }

    @Override
    public int getRequestId() {
        try {
            return toJSON().getInt(REQUEST_ID_INDEX);
        } catch (JSONException e) {
            throw new IllegalArgumentException("there is no request id");
        }
    }
}
