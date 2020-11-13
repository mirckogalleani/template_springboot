package com.chiques.shared;
 
public abstract class AbstractResponse {
 
   enum Type {
       SYSTEM_ERROR,
       ARGUMENTS_ERROR,
       RESPONSE_SUCCESS
   }
 
   private String message;
   private Type type;
 
   public AbstractResponse(String message, Type type){
       this.message = message;
       this.type = type;
   }
 
   public String getType() {
       return this.type.toString();
   }
 
   public String value() {
       return this.message;
   }
 
   public abstract boolean isValid();
 
}
