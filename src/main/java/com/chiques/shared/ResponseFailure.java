package com.chiques.shared;

public class ResponseFailure extends AbstractResponse {

    public ResponseFailure(){
        super(null, null);
    };

    public ResponseFailure(String errorMessage, Type type) {
        super(errorMessage, type);
    }
    
    public static ResponseFailure buildSystemError(String errorMessage) {
        Type type = Type.SYSTEM_ERROR;
        return new ResponseFailure(errorMessage, type);
    }

    public static ResponseFailure buildArgumentsError(String errorMessage) {
        Type type = Type.ARGUMENTS_ERROR;
        return new ResponseFailure(errorMessage, type);
   }

    @Override
    public boolean isValid() {
        return false;
    }
}

