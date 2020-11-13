package com.chiques.controller;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EncryptControllerTest {

    private static Logger mylog = LoggerFactory.getLogger(EncryptControllerTest.class);
    
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void invokeControllerSuccefully() throws Exception {
        //Arrange
        String destinationURL = "http://localhost:" + port + "/encrypt";
        String bodyMessage = "eyJzZXBhcmF0b3IiOiJ8IiwidGFibGVOYW1lIjoiREJNQVJLLlRFU1RfRlRfQk9MX1ZFTlRBIiwiZW5jcnlwdENvbHMiOiJJRF9CT0xFVEEsSURfRUFOLFBSRUNJT19JTlRFUk5FVCIsImVuY3J5cHRDYXJkSWQiOiItLSIsImNvbHVtbnMiOiJJRF9CT0xFVEEsSURfTE9DQUwsSURfUE9TLElEX0RJQSxJRF9IT1JBLElEX1RSQU5TQUMsSURfRUFOLElEX05PVklPUyxJRF9FVkVOVE8sSURfQ1VPVEFTLElEX1RJUE9GMTIsSURfVElUVUxBUixGTEFHX0RJRkVSLEZMQUdfQkFOREEsTlVNX0JPTEVUQSxOVU1fU0lJLE5VTV9WRU5ERURPUixOVU1fRjEyLFBSRUNJT19DT1NUTyxNT05UT19CUlVUTyxNT05UT19ERVNDVE8sTU9OVE9fTElRVUlELE1PTlRPX0FCT05PLENBTlRfVkVOVEEsTlVNX0NVRU5UQSxOVU1fUlVULERWX1JVVCxGRUNIQV9SRUFMLElEX05VTUVST19UUk4sRElTQUJMRSxOVU1fUlVUX0NPTVBSQURPUixEVl9SVVRfQ09NUFJBRE9SLEZMQUdfUkVDQVVEQUNJT04sRkxBR19GQUNUVVJBLEZMQUdfSU5URVJORVQsSURfQVVUT1JJWkEsQ0JBTkRBLEZMQUdfRU5MSU5FQSxOVU1fUEFNLElEX0VNUFJFU0EsVkFMT1JfQ1VPVEEsSURfU0tVLFZBTE9SX0FDT1JUQU1JRU5UTyxQUkVDSU9fTk9STUFMLFBSRUNJT19DT1NUT19VRixNT05UT19CUlVUT19VRixNT05UT19ERVNDVE9fVUYsTU9OVE9fTElRVUlEX1VGLE1PTlRPX0FCT05PX1VGLFZBTE9SX0NVT1RBX1VGLFZBTE9SX0FDT1JUQU1JRU5UT19VRixQUkVDSU9fTk9STUFMX1VGLElWQV9WRU5UQSxJVkFfVkVOVEFfVUYsU0lDLE5VTV9DT0xFR0lPLElEX1RJRU1QTyxJRF9OVU1fQ1VPVEFTLFBSRF9MVkxfQ0hJTEQsUFJFQ0lPX0NPU1RPX1YsQk1BVENILElEX0hVRUxMQSxDT0RfQVVUT1JJWkEsQ09EX0RFU0NVRU5UTyxJRF9DT05DSUxJTyxUUk5fVEVDSF9LRVksSURfUEFJU19QQU4sTU9OVE9fTElRVUlEX1VGX00yWE1VTkRPLE1PTlRPX0xJUVVJRF9VRl9NMlhUSUVOREEsQ09ESUdPX1ZFTlRBLENET0NVTUVOVE8sTkNBSkVSTyxNT05UT19JVkFfMSxNT05UT19JVkFfMixNT05UT19JVkFfMyxNT05UT19JVkFfNCxNT05UT19JVkFfNSxNT05UT19JTkdSRVNPX0JSVVRPLE1PTlRPX0lWQV82LE1PTlRPX0lWQV83LE1PTlRPX0lWQV84LE1PTlRPX0lWQV85LFBSRUNJT19DT1NUT19VUyxNT05UT19CUlVUT19VUyxNT05UT19ERVNDVE9fVVMsTU9OVE9fTElRVUlEX1VTLE1PTlRPX0FCT05PX1VTLFZBTE9SX0NVT1RBX1VTLFBSRUNJT19OT1JNQUxfVVMsSVZBX1ZFTlRBX1VTLERDT01QUkEsTk9SREVOQ01QLElEX1RSQU5TQUNfTkMsQ0VWRU5UT19OT1ZJT1MsQ1BST01PQ0lPTixCUE9SLERFU0NVRU5UT19JVkEsUElWQSxUS19WRU5ERURPUixJRF9WRU5ERURPUl9USUVOREEsRkxBR19OT1RBX0RFQklUTyxDT05UUkFUTyxDVFJBTlNBQyxOVU1fVkVOREVET1JfQ0FKRVJPLE5CSU5fVEFSSkVUQSxDT0RfT1BVTklDQSxJRF9TRUNUT1IsRkxBR19QUkVDSU9fTUFYSU1PLFBSRUNJT19PUklHSU5BTCxJVkFfT1JJR0lOQUwsSURfTE9DQUxfT01OSUNBTkFMLFBSRUNJT19DT1NUT19SRVAsUVRJQ0tFVF9DQU1CSU8sTkNPUlJFTEFUSVZPLElEX0NBTkFMX1ZFTlRBLEZMQUdfVlRBX1ZFUkRFLElEX01FVE9ET19ERVNQQUNITyxWQUxPUl9NRVJDQURFUklBLFZBTE9SX0NPTVBMRU1FTlRPLFZBTE9SX0JPTklGSUNBLElEX0NBTkFMX1ZUQV9DVUJPLENJTUVJLFBSRUNJT19WSUdFTlRFLFBSRUNJT19JTlRFUk5FVCIsImJ1Y2tldFNpemUiOiIzMDAiLCJmaWxlTmFtZVByZWZpeCI6Il9wYXJ0XyIsImRlZmF1bHRGb2xkZXIiOiJzcmMvdGVzdC9yZXNvdXJjZXMvIiwic2FsdCI6IjA3YzkyY2ZhMzc0NGJjZGIiLCJwYXNzRW5jcnlwdCI6InQzc3Rwd2RfIn0=";

        //Act
        ResponseEntity<String> response = restTemplate.postForEntity(destinationURL, bodyMessage, String.class);
        mylog.info("response body: {}", response.getBody());
        mylog.info("response code: {}", response.getStatusCode());
        
        //Assert
        assertEquals("OK", response.getBody());
    }
    
    @Test
    public void invokeControllerInvalidRequestThrowException() throws Exception {
        //Arrange
        String destinationURL = "http://localhost:" + port + "/encrypt";
        String bodyMessage = "YmFkIGpzb24gcmVxdWVzdA==";

        //Act
        ResponseEntity<String> response = restTemplate.postForEntity(destinationURL, bodyMessage, String.class);
        mylog.info("response code: {}", response.getStatusCode());
        
        //Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
    
    @Test
    public void invokeControllerInvalidBadRequestThrowException() throws Exception {
        //Arrange
        String destinationURL = "http://localhost:" + port + "/encrypt";
        String bodyMessage = "bad json request";

        //Act
        ResponseEntity<String> response = restTemplate.postForEntity(destinationURL, bodyMessage, String.class);
        mylog.info("response code: {}", response.getStatusCode());
        
        //Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
    
    @Test
    public void invokeControllerDefaultPathSuccessfully() throws Exception {
        //Arrange
        String destinationURL = "http://localhost:" + port + "/";

        //Act
        ResponseEntity<String> response = restTemplate.getForEntity(destinationURL, String.class);
        mylog.info("response code: {}", response.getStatusCode());
        
        //Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    

    @Test
    public void invokeControllerLivenessPathSuccessfully() throws Exception {
        //Arrange
        String destinationURL = "http://localhost:" + port + "/readiness";

        //Act
        ResponseEntity<String> response = restTemplate.getForEntity(destinationURL, String.class);
        mylog.info("response code: {}", response.getStatusCode());
        
        //Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
}