package com.sdu.demo.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileUtil {

    public static String uploadPath = "/usr/local/src/image";
//    public static String ImagePath = "";

    public static String handlePicture(String part,MultipartFile file){
        //文件命名
        String type = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = UUID.randomUUID().toString()+type;

        File dest;
        dest = new File(uploadPath+'/'+part+'/'+fileName);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return uploadPath+'/' + part+'/' + fileName;
    }
}
