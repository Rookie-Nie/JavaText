package com.birdboot.controller;

import com.birdboot.annotation.Controller;
import com.birdboot.annotation.RequestMapping;
import com.birdboot.entity.User;
import com.birdboot.http.HttpServletRequest;
import com.birdboot.http.HttpServletResponse;

import java.io.*;

@Controller
public class UserController {
    private static File userDir;
    static {
        userDir = new File("./users");
        if (!userDir.exists()){
            userDir.mkdirs();
        }
    }
    @RequestMapping("/regUser")
    public void reg(HttpServletRequest request, HttpServletResponse response){
        System.out.println("开始处理用户注册！！！");
        //1、获取表单数据
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String nickName = request.getParameter("nickName");
        String ageStr = request.getParameter("age");
        System.out.println(userName+","+passWord+","+nickName+","+ageStr);
        //必要的验证
        if (userName==null || userName.isEmpty() ||
            passWord==null || passWord.isEmpty() ||
            nickName==null || nickName.isEmpty() ||
            ageStr==null || ageStr.isEmpty() ||
            !ageStr.matches("[0-9]+")){

            response.sendRedirect("/reg_info_error.html");
            return;
        }
        int age = Integer.parseInt(ageStr);
        User user = new User(userName,passWord,nickName,age);


        File userFile = new File(userDir,userName+".obj");
        if (userFile.exists()){
            response.sendRedirect("/have_user.html");
            return;
        }
        try (
            FileOutputStream fos = new FileOutputStream(userFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        ){
            oos.writeObject(user);
            response.sendRedirect("/reg_success.html");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/loginUser")
    public void login(HttpServletRequest request,HttpServletResponse response){
        System.out.println("开始处理用户登录！！！");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        System.out.println(userName+","+passWord);

        if (userName==null || userName.isEmpty() ||
            passWord==null || userName.isEmpty()){
            response.sendRedirect("/login_fail.html");
            return;
        }

        File userFile = new File(userDir,userName+".obj");
        if (!userFile.exists()){
            response.sendRedirect("/login_fail.html");
            return;
        }
        try (
            FileInputStream fis = new FileInputStream(userFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
        ){

            User user = (User) ois.readObject();
            if (passWord.equals(user.getPassWord())){
                response.sendRedirect("/login_success.html");
            }else {
                response.sendRedirect("/login_fail.html");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
