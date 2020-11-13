package com.chiques.shared;
 
import java.util.HashMap;
import java.util.Map;
 
public abstract class AbstractRequest {
   private HashMap<String, String> errorList = new HashMap<>();
 
   public boolean isValid(){
       return (this.errorList == null || this.errorList.isEmpty());
   }
 
   public void cleanErrorList() {
       this.errorList = new HashMap<>();
   }
 
   public Map<String, String> getErrorList(){
       return this.errorList;
   }
 
   public void addError(String field, String error){
       this.errorList.put(field, error);
   }
 
   public abstract String toString();
   
}
