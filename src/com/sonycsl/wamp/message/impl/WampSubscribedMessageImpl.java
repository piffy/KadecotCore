/*
 * Copyright (C) 2013-2014 Sony Computer Science Laboratories, Inc. All Rights Reserved.
 * Copyright (C) 2014 Sony Corporation. All Rights Reserved.
 */

package com.sonycsl.wamp.message.impl;

import com.sonycsl.wamp.message.WampMessage;
import com.sonycsl.wamp.message.WampMessageType;
import com.sonycsl.wamp.message.WampSubscribedMessage;

import org.json.JSONArray;
import org.json.JSONException;

public class WampSubscribedMessageImpl extends WampAbstractMessage implements WampSubscribedMessage {

    private static final int REQUEST_ID_INDEX = 1;
    private static final int SUBSCRIPTION_ID_INDEX = 2;

    public static WampMessage create(int requestId, int subscriptionId) {
        return new WampSubscribedMessageImpl(new JSONArray().put(WampMessageType.SUBSCRIBED)
                .put(requestId).put(subscriptionId));
    }

    public WampSubscribedMessageImpl(JSONArray msg) {
        super(msg);
        try {
            if (msg.getInt(0) != WampMessageType.SUBSCRIBED) {
                throw new IllegalArgumentException("message type is mismatched");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean isSubscribedMessage() {
        return true;
    }

    @Override
    public WampSubscribedMessage asSubscribedMessage() {
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

    @Override
    public int getSubscriptionId() {
        try {
            return toJSON().getInt(SUBSCRIPTION_ID_INDEX);
        } catch (JSONException e) {
            throw new IllegalArgumentException("there is no subscription id");
        }
    }
}
