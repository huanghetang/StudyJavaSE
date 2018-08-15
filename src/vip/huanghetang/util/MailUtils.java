package vip.huanghetang.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * �ʼ������ͷ���ģ��
 * msgsendssample
 * @author zhoumo
 * @createTime 2018/05/21
 */
public class MailUtils {

	
	/**
	 * 
	 * @param to �����˵�ַ
	 * @param from �����˵�ַ
	 * @param host smtp��������ַ
	 * @param subject ���͵��ʼ�����
	 * @param msgText ���͵��ʼ���������
	 */
	public static void sendMail(String to,String from,String host,String subject,String msgText){

	    //�����˵�ַ
//		String to = "zm@hht.com";
		//�����˵�ַ
//		String from = "mm@hht.com";
		//��������ַ
//		String host = "localhost";
		//�Ƿ����̨��ӡdebug
		boolean debug = true;
		//���͵��ʼ�����
//		String subject = "����ף��";
		//���͵��ʼ���������
//		String msgText = "�������,��������.";
		// create some properties and get the default Session
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		if (debug) props.put("mail.debug", debug);

		Session session = Session.getInstance(props, null);
		session.setDebug(debug);
		
		try {
		    // create a message
		    MimeMessage msg = new MimeMessage(session);
		    msg.setFrom(new InternetAddress(from));
		    InternetAddress[] address = {new InternetAddress(to)};
		    msg.setRecipients(Message.RecipientType.TO, address);
		    msg.setSubject(subject);
		    msg.setSentDate(new Date());
		    // If the desired charset is known, you can use
		    // setText(text, charset)
		    msg.setText(msgText);
		    
		    Transport.send(msg);
		} catch (MessagingException mex) {
		    System.out.println("\n--Exception handling in msgsendsample.java");

		    mex.printStackTrace();
		    System.out.println();
		    Exception ex = mex;
		    do {
			if (ex instanceof SendFailedException) {
			    SendFailedException sfex = (SendFailedException)ex;
			    Address[] invalid = sfex.getInvalidAddresses();
			    if (invalid != null) {
				System.out.println("    ** Invalid Addresses");
				for (int i = 0; i < invalid.length; i++) 
				    System.out.println("         " + invalid[i]);
			    }
			    Address[] validUnsent = sfex.getValidUnsentAddresses();
			    if (validUnsent != null) {
				System.out.println("    ** ValidUnsent Addresses");
				for (int i = 0; i < validUnsent.length; i++) 
				    System.out.println("         "+validUnsent[i]);
			    }
			    Address[] validSent = sfex.getValidSentAddresses();
			    if (validSent != null) {
				System.out.println("    ** ValidSent Addresses");
				for (int i = 0; i < validSent.length; i++) 
				    System.out.println("         "+validSent[i]);
			    }
			}
			System.out.println();
			if (ex instanceof MessagingException)
			    ex = ((MessagingException)ex).getNextException();
			else
			    ex = null;
		    } while (ex != null);
		}
		
	}
	
	public static void main(String[] args) {
	    //�����˵�ַ
		String to = "zm@hht.com";
		//�����˵�ַ
		String from = "mm@hht.com";
		//��������ַ
		String host = "localhost";
		//�Ƿ����̨��ӡdebug
		boolean debug = true;
		//���͵��ʼ�����
		String subject = "����ף��1111";
		//���͵��ʼ���������
		String msgText = "�������,��������.1111";
		
		sendMail(to, from, host, subject, msgText);
	}
}
