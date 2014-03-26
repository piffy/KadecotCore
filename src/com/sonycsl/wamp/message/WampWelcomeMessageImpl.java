
package com.sonycsl.wamp.message;

import com.sonycsl.wamp.WampAbstractMessage;
import com.sonycsl.wamp.WampMessage;
import com.sonycsl.wamp.WampMessageType;
import com.sonycsl.wamp.WampWelcomeMessage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WampWelcomeMessageImpl extends WampAbstractMessage implements WampWelcomeMessage {

    private static final int SESSION_INDEX = 1;
    private static final int DETAILS_INDEX = 2;

    public static WampMessage create(int session, JSONObject details) {
        return new WampWelcomeMessageImpl(new JSONArray().put(WampMessageType.WELCOME).put(session)
                .put(details));
    }

    public WampWelcomeMessageImpl(JSONArray msg) {
        super(msg);
    }

    @Override
    public boolean isWelcomeMessage() {
        return true;
    }

    @Override
    public WampWelcomeMessage asWelcomeMessage() {
        return this;
    }

    @Override
    public int getSession() {
        try {
            return toJSON().getInt(SESSION_INDEX);
        } catch (JSONException e) {
            throw new IllegalArgumentException("there is no session");
        }
    }

    @Override
    public JSONObject getDetails() {
        try {
            return toJSON().getJSONObject(DETAILS_INDEX);
        } catch (JSONException e) {
            throw new IllegalArgumentException("there is no details");
        }
    }

}