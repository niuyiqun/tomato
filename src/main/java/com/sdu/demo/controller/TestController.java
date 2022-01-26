//package com.sdu.demo.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.sdu.demo.mapping.DailyTakeinMapper;
//import com.sdu.demo.mapping.FoodMapper;
//import com.sdu.demo.mapping.MemorandumMapper;
//import com.sdu.demo.service.FoodService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.sql.Timestamp;
//import java.util.Date;
//
///**
// * @program: tomato.java
// * @description:
// * @author: NiuYiq
// * @create: 2021-03-20 13:10
// **/
//
//@RestController
//public class TestController {
//
//        // 这里的是application.properties中配置的地址
//        @Value("${uploadpic.path}")
//        private String uploadPicPath;
//
//
//        // 主界面
//        @GetMapping("/")
//        public String listUploadedFiles(Model model) throws IOException {
//
//
//            model.addAttribute("messages", "cpxxxxx");
//            return "uploadPic";
//        }
//
//
//        // 文件上传按钮action
//        @PostMapping("/uploadPic")
//        public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Model model) throws Exception {
//
//
//            // 存储图片到本地
//            storePic(file);
//            redirectAttributes.addFlashAttribute("message", "成功上传" + file.getOriginalFilename() + "!");
//            System.out.println("上传的文件名字：" + file.getOriginalFilename());
//            model.addAttribute("picName", file.getOriginalFilename()); // 将文件传输成功之后的名字传回界面，用于展示图片
//            return "uploadPic";
//        }
//
//
//        private String storePic(MultipartFile file) throws Exception {
//            String filename = StringUtils.cleanPath(file.getOriginalFilename());
//            try {
//
//
//                try (InputStream inputStream = file.getInputStream()) {
//                    Files.copy(inputStream, Paths.get(uploadPicPath + filename), // 这里指定了下载的位置
//                            StandardCopyOption.REPLACE_EXISTING);
//                }
//            }
//            catch (IOException e) {
//                throw new Exception("失败！" + filename, e);
//            }
//            return filename;
//        }
//
//
//
//}
