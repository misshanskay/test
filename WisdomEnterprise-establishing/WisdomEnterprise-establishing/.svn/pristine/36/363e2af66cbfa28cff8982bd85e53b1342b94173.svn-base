package cn.sirbox.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class fileupload {
    public static String fileupload(MultipartFile file,String m){
        long length = file.getSize();
        if(length>1024*1024){
            return "图片大于1M!";
        }
        
       String fileExtendName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
       if(!".png".equals(fileExtendName)){
            return "请传png的图片!";
       }
        try {
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(new File(m)));
           stream.write(bytes);
           
             stream.close();
       } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
        return "success";
    }
}
