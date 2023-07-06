package birdboot.controller;

import birdboot.entity.User;
import birdboot.http.HttpServletRequest;
import birdboot.http.HttpServletResponse;

import java.io.*;

public class UserController {
    private static File userDir;

    static {
        userDir = new File("./users");
        if (!userDir.exists()){
            userDir.mkdirs();
        }
    }


    public void reg(HttpServletRequest request, HttpServletResponse response){
        System.out.println("开始处理注册请求！！！");


        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String nickName = request.getParameter("nickName");
        String ageStr = request.getParameter("age");

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

    public void login(HttpServletRequest request,HttpServletResponse response){
        System.out.println("正在处理用户登录！！！");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");

        if (userName==null || userName.isEmpty() ||
            passWord==null || passWord.isEmpty()){
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
            User user =(User)ois.readObject();
            if(passWord.equals(user.getPassWord())){
                response.sendRedirect("/login_success.html");
            }else {
                response.sendRedirect("/login_fail.html");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
