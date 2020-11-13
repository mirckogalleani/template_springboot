package com.chiques.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EncryptionService {

    private static Logger mylog = LoggerFactory.getLogger(EncryptionService.class);
    


    public EncryptionService() {

    }
    
    public void invoke(String request) throws Exception{
        try {

            
        } catch (Exception e) {
            mylog.error(e.getMessage());
            throw new Exception(e.getMessage());
        } finally {
            mylog.info("end invoke");
        }
    }
    
}