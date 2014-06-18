
package com.sonycsl.test.wamp.message.impl;

import com.sonycsl.wamp.message.WampMessageType;
import com.sonycsl.wamp.message.impl.WampSubscribedMessageImpl;

import junit.framework.TestCase;

import org.json.JSONArray;

public class WampSubscribedMessageImplTestCase extends TestCase {
    public void testCtor() {
        JSONArray msg = new JSONArray();
        msg.put(WampMessageType.PUBLISHED);
        int requestId = 1;
        msg.put(requestId);
        int subscriptionId = 2;
        msg.put(subscriptionId);

        WampSubscribedMessageImpl subscribed = new WampSubscribedMessageImpl(msg);

        assertNotNull(subscribed);
        assertTrue(subscribed.isSubscribedMessage());
        assertTrue(subscribed.getRequestId() == requestId);
        assertTrue(subscribed.getSubscriptionId() == subscriptionId);
    }

    public void testAbnormal() {
        JSONArray msg = new JSONArray();
        WampSubscribedMessageImpl subscribed = new WampSubscribedMessageImpl(msg);

        // no requestId
        try {
            int requestId = subscribed.getRequestId();
            fail();
        } catch (IllegalArgumentException e) {
        }

        // no subscriptionId
        try {
            int subscriptionId = subscribed.getSubscriptionId();
            fail();
        } catch (IllegalArgumentException e) {
        }
    }
}
