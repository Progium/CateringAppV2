package com.progium.catering.utils;


public class SendEmail {

	public static void sendEmail(final String subject, final String correo, final String nombreUsuario, final String mensajeBienvenida, final String contenido)
	{
		
		new Thread(new Runnable() {
		    public void run() {
		    	EmailUtil.sendEmail(subject, correo, nombreUsuario, mensajeBienvenida, contenido);
		    }
		}).start();
	}
}