package cn.sirbox.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class utils {
      public static String datetostring(Date date){
          SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String s1 = sdf.format(date);
          return s1;
      }
      
      public static Date stringtodate(String s) throws ParseException{
          Date d=new SimpleDateFormat("yyyy-MM-dd").parse(s);
          return d;
      }
      
      
      public static String string2MD5(String str) {
          MessageDigest md5 = null;
          try {
              md5 = MessageDigest.getInstance("MD5");
          } catch (Exception e) {
              e.printStackTrace();
              return "";
          }
          char[] charArray = str.toCharArray();
          byte[] byteArray = new byte[charArray.length];

          for (int i = 0; i < charArray.length; i++)
              byteArray[i] = (byte) charArray[i];
          byte[] md5Bytes = md5.digest(byteArray);
          StringBuffer hexValue = new StringBuffer();
          for (int i = 0; i < md5Bytes.length; i++) {
              int val = ((int) md5Bytes[i]) & 0xff;
              if (val < 16)
                  hexValue.append("0");
              hexValue.append(Integer.toHexString(val));
          }

          // 优化密文, 保证密文纯字符
          String result = hexValue.toString().replaceAll("[-]", "");
          return result;

      }
      public static void main(String[] args) {
          Pattern p = Pattern.compile("[a-z0-9A-Z]{6,16}");
          Matcher m = p.matcher("ddssss");
          System.out.println(m.matches());
          if (m.find()){
            System.out.println("1axs");
          }
          System.out.println("dsa");
    }
      
}
