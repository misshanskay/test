package cn.sirbox.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class email {
		public static String toemail(String to,String sub){
			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            // 设置参数
            mailSender.setHost("smtp.163.com");
            mailSender.setUsername(config.getKeyValue("email"));
            mailSender.setPassword(config.getKeyValue("emailpassword"));
            SimpleMailMessage smm = new SimpleMailMessage();
            // 设定邮件参数
            smm.setFrom(mailSender.getUsername());
           
            smm.setTo(to);
            smm.setSubject(sub);
            String password=rodom();
            smm.setText(password);
            // 发送邮件
            mailSender.send(smm);
            return password;
		}
		
		public static String rodom(){
	         int i = (int)(Math.random()*89+10);
	    	
	    	int q = (int)(Math.random()*26+65);
	    	int w = (int)(Math.random()*26+97);
	    	int e = (int)(Math.random()*26+65);
	    	int r = (int)(Math.random()*26+97);
	    	char a=(char)q;
	    	char s=(char)w;
	    	char d=(char)e;
	    	char f=(char)r;
	    	StringBuffer sb= new StringBuffer();
	    	sb.append(i);
	    	sb.append(a);
	    	sb.append(s);
	    	sb.append(d);
	    	sb.append(f);
	    	String m=sb.toString();
	    	return m;
	    }

		public static void toemail(String to, String sub, String s) {
			// TODO Auto-generated method stub
			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            // 设置参数
            mailSender.setHost("smtp.163.com");
            mailSender.setUsername("15311487686@163.com");
            mailSender.setPassword("han123456");
            SimpleMailMessage smm = new SimpleMailMessage();
            // 设定邮件参数
            smm.setFrom(mailSender.getUsername());
           //要发送的邮箱地址
            smm.setTo(to);
            //主题
            smm.setSubject(sub);
            //内容
            smm.setText(s);
            // 发送邮件
            mailSender.send(smm);
            
		}
}
