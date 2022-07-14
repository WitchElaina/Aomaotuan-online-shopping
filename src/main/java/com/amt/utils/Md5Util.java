package com.amt.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

	public static void main(String[] args) {
		System.out.println(getHash("123456","sha-256"));
	}
	
	
	public static String getHash(String source, String hashType) {  
        StringBuilder sb = new StringBuilder();  
        MessageDigest md5;  
        try {  
            md5 = MessageDigest.getInstance(hashType);  
            md5.update(source.getBytes());  
            for (byte b : md5.digest()) {  
                sb.append(String.format("%02X", b));
            }  
            return sb.toString();  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }


}
