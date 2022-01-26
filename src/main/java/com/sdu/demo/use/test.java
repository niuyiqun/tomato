package com.sdu.demo.use;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.tensorflow.TensorFlow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: tomato.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-04-06 09:33
 **/

public class test {

    public static void main(String[] args) throws IOException {
//        PythonInterpreter interpreter = new PythonInterpreter();
//        interpreter.execfile("D:\\add.py");
//        String command = "cmd.exe /c cd"
//                + "D:\\python爬虫\\pythonProject"
//                + "&& start python main.py";
//        Process p = Runtime.getRuntime().exec(command);


        //方法二
//        PythonInterpreter interpreter = new PythonInterpreter();
//        interpreter.execfile("D:\\python爬虫\\demo1.py");
//
//        // 第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型
//        PyFunction pyFunction = interpreter.get("add", PyFunction.class);
//        int a = 5, b = 10;
//        //调用函数，如果函数需要参数，在Java中必须先将参数转化为对应的“Python类型”
//        PyObject pyobj = pyFunction.__call__(new PyInteger(a), new PyInteger(b));
//        System.out.println("the anwser is: " + pyobj);

        //方法三   简单调用完成

        // python food101_ResNet50.py -m test -i 预测图片地址
//        String [] s = new String[] {"python","food101_ResNet50.py","-m test",a}
        String a ="hello world";
        String[] params = new String[] { "python", "D:\\python爬虫\\demo2.py", a};  //相当于在控制台跑程序
        Process proc;
        try {
//            proc = Runtime.getRuntime().exec("cmd /c D:\\python爬虫\\demo2.py");// 执行py文件  怎么传参
            proc = Runtime.getRuntime().exec(params);// 执行py文件  怎么传参

            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {//python xxx.py -m test
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Runtime.getRuntime().exec("notepad.exe");

        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(date));

    }
}
