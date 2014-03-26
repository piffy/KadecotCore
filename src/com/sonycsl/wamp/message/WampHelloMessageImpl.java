
package com.sonycsl.wamp.message;

import com.sonycsl.wamp.WampAbstractMessage;
import com.sonycsl.wamp.WampHelloMessage;
import com.sonycsl.wamp.WampMessage;
import com.sonycsl.wamp.WampMessageType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WampHelloMessageImpl extends WampAbstractMessage implements WampHelloMessage {

    private static final int REALM_INDEX = 1;
    private static final int DETAILS_TYPE_INDEX = 2;

    public static WampMessage create(String realm, JSONObject details) {
        return new WampHelloMessageImpl(new JSONArray().put(WampMessageType.HELLO).put(realm)
                .put(details));
    }

    public WampHelloMessageImpl(JSONArray msg) {
        super(msg);
    }

    @Override
    public boolean isHelloMessage() {
        return true;
    }

    @Override
    public WampHelloMessage asHelloMessage() {
        return this;
    }

    @Override
    public String getRealm() {
        try {
            return toJSON().getString(REALM_INDEX);
        } catch (JSONException e) {
            throw new IllegalArgumentException("there is no realm");
        }
    }

    @Override
    public JSONObject getDetails() {
        try {
            return toJSON().getJSONObject(DETAILS_TYPE_INDEX);
        } catch (JSONException e) {
            throw new IllegalArgumentException("there is no details.");
        }
    }

}