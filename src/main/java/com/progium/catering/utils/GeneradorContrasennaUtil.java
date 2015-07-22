package com.progium.catering.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class GeneradorContrasennaUtil {

	private final static String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static int largoContrasenna = 6;
	
	
	public static String generarContrasenna()
	{
	    String contrasenna=""; 
	    int longitudBase = base.length();
	    
	    for(int i=0; i<largoContrasenna;i++){
	        int numeroRandom = (int)(Math.random()*(longitudBase));
	        String caracter = base.substring(numeroRandom, numeroRandom+1);
	        contrasenna=contrasenna+caracter;
	    }
	    
	    return contrasenna;
	}
	
	public static String encriptarContrasenna(String contrasenna) throws NoSuchAlgorithmException{
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    byte[] passBytes = contrasenna.getBytes();
	    md.reset();
	    byte[] digested = md.digest(passBytes);
	    StringBuffer sb = new StringBuffer();
	    for(int i=0;i<digested.length;i++){
	        sb.append(Integer.toHexString(0xff & digested[i]));
	    }
	    return sb.toString();
	}
}
