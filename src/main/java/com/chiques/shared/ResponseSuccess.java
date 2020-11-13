package com.chiques.shared;

public class ResponseSuccess extends AbstractResponse {

    public ResponseSuccess(String message, Type type) {
        super(message, type);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    public static ResponseSuccess buildResponseSuccess(String message) {
        Type type = Type.RESPONSE_SUCCESS;
        ResponseSuccess response = new ResponseSuccess(message, type);
        return response;
   }

}
