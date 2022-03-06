package com.eguru.website.classobject;

import java.util.*;
import javax.mail.*;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.Transport;

public class Mailing {
	public static String mail(String mailid,int a) throws Exception {
		System.out.println("Preparing to send email");
	      Properties prop = new Properties();
	      prop.put("mail.smtp.auth","true");
	      prop.put("mail.smtp.starttls.enable", "true");
	      prop.put("mail.smtp.host", "smtp.gmail.com");
	      prop.put("mail.smtp.port","587");
	      
	      String myAcc = "contact.eguru.website@gmail.com";
	      String pass = "Sthiy@11602";
	      Session session = Session.getInstance(prop,new Authenticator(){
	          @Override
	          protected PasswordAuthentication getPasswordAuthentication(){
	              return new PasswordAuthentication(myAcc,pass);
	          }
	      });
	      String s = getRandomNumberString();
	      String text;
	      if(a==1) {
          	text = "Your Confirmation OTP for Completion of Registration is "+s;
          }else {
          	text = "Your Confirmation OTP for Retrieval of Your Account is "+s;
          }
	      Message message = prepareMessage(session,myAcc,mailid,text);
	      
	      Transport.send(message);
	      System.out.println("Email Sent Successfully");
	      return s;
	}
	private static Message prepareMessage(Session session, String myAcc, String rec,String text){
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAcc));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(rec));
            message.setSubject("Welcome to E Guru");
            message.setText(text);
            return message;
        }catch(Exception e){
           // Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    public static String getRandomNumberString() {
    	// It will generate 6 digit random Number.
    	// from 0 to 999999
    	Random rnd = new Random();
    	int number = rnd.nextInt(999999);
    	// this will convert any number sequence into 6 character.
    	return String.format("%06d", number);
    }
}
