package cn.sirbox.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class config {   
    //属性文件的路径   
    
     public static String getKeyValue(String key) {  
      
        CompositeConfiguration config = new CompositeConfiguration();
        
        try {
            config.addConfiguration(new PropertiesConfiguration("dataSource.properties"));
        } catch (ConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return config.getString(key);   
    }   
  
  
      
      public static String writeProperties(String keyname,String keyvalue) {          
        
            
          PropertiesConfiguration config;
        try {
            config = new PropertiesConfiguration("dataSource.properties");
            config.setProperty(keyname, keyvalue);
            config.save();
            return config.getString(keyname);
        } catch (ConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          
         
            return null;
            
            
    }   
  
  
    //测试代码   
   public static void main(String[] args) throws ConfigurationException {
      
       PropertiesConfiguration config = new PropertiesConfiguration("dataSource.properties");
       config.setProperty("abc", "2221");
       config.save();
       System.out.println(config.getString("abc"));
       
       
      
}
} 
