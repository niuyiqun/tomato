package com.sdu.demo;

import com.sdu.demo.entity.Food;
import com.sdu.demo.mapping.FoodMapper;
import com.sdu.demo.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author niu
 * @Description:
 * @date 2021/9/2416:40
 */


@RestController
@RequestMapping("/api")
public class UploadDownHandler {
    /**
     * 上传地址
     */
    @Value("${file.upload.path}")
    private String path;

    /**
     * 图片url前缀
     */
    @Value("${com.test.base_picture_url}")
    private String base_picture_url;

    @Autowired
    FoodMapper foodMapper;



    @PostMapping("/test")
    public String test(){
        return "成功访问";
    }

    @ResponseBody
    @PostMapping("/uploadPicture")
    public Result uploadPicture(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException, InterruptedException {

        //String base_picture_url = "http://localhost:8080/image/";


        //将文件保存到服务器指定位置
        try {
            //获取文件在服务器的储存位置
            File filePath = new File(path);
            System.out.println("文件的保存路径" + path);
            if (!filePath.exists() && !filePath.isDirectory()) {
                System.out.println("目录不存在，创建目录" + filePath);
                filePath.mkdir();
            }

            //获取原始文件名称（包括格式）
            String originalFileName = file.getOriginalFilename();
            System.out.println("原始文件名称" + originalFileName);

            //获取文件类型，以最后一个‘.’为标识
            String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
            System.out.println("文件类型" + type);

            //获取文件名称（不包含格式）
            String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

            //设置文件新名称：当前时间+文件名称（不包含格式）
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String date = sdf.format(d);
            String fileName = date + name + "." + type;
            System.out.println("新文件名称" + fileName);

            //在指定路径下创建文件
            File targetFile = new File(path, fileName);

            Map<String, Object> result = new HashMap<String, Object>();//定义结果


            file.transferTo(targetFile);
            System.out.println("上传成功");

            System.out.println(result);
            Food food = foodMapper.findByEnglishName(test1(fileName));
            Map m = new HashMap();
            m.put("food",food);
            return Result.success().data(m);
        } catch (Exception e) {
            System.out.println("上传失败");
//            result.put("code",400);
            e.printStackTrace();
            return Result.error().message("上传失败");
        }

//        result.put("code",200);
//        result.put("picture",base_picture_url+ fileName);


    }


    String test1(String filename) throws IOException, InterruptedException {
        String result = "";
        try {
            //这个方法是类似隐形开启了命令执行器，输入指令执行python脚本
            Process process = Runtime.getRuntime()
                    .exec("/root/anaconda3/envs/tensorflow/bin/python /usr/local/src/mechine_learn/ml_model_centos/food101_ResNet50.py -i " + path + filename);
            //这种方式获取返回值的方式是需要用python打印输出，然后java去获取命令行的输出，在java返回
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            result = input.readLine();//中文的话这里可能会有乱码，可以尝试转一下不过问题不大
//            result1 = new String(result.getBytes("iso8859-1"),"utf-8");
            input.close();
            ir.close();
            int re = process.waitFor();
            System.out.println("以下为结果");
            System.out.println(result);


        } catch (IOException | InterruptedException e) {
            System.out.println("调用python脚本并读取结果时出错：" + e.getMessage());
        }
        return result;
    }
}

