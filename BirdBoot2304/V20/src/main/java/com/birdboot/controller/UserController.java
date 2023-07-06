package com.birdboot.controller;

import com.birdboot.annotation.Controller;
import com.birdboot.annotation.RequestMapping;
import com.birdboot.entity.User;
import com.birdboot.http.HttpServletRequest;
import com.birdboot.http.HttpServletResponse;
import com.birdboot.util.DBUtil;
import com.mysql.cj.xdevapi.DbDoc;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

        try (Connection connection = DBUtil.getConnection();){
            String checkSql = "SELECT id FROM userinfo WHERE username=?;";
            PreparedStatement ps1 = connection.prepareStatement(checkSql);
            ps1.setString(1,userName);
            ResultSet resultSet = ps1.executeQuery();
            if (resultSet.next()){
                response.sendRedirect("/have_user.html");
            }else {
                String insSql = "INSERT INTO userinfo(username, password, nickname, age) " +
                        "VALUES (?,?,?,?);";
                PreparedStatement ps2 = connection.prepareStatement(insSql);
                ps2.setString(1,userName);
                ps2.setString(2,passWord);
                ps2.setString(3,passWord);
                ps2.setInt(4,age);
                int i = ps2.executeUpdate();
                if (i>0){
                    response.sendRedirect("/reg_success.html");
                }else{
                    response.sendRedirect("/reg_info_error.html");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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

        try (Connection connection = DBUtil.getConnection();){
            String sql ="SELECT username,password,nickname \n" +
                    "FROM userinfo WHERE username=? AND password=?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,passWord);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                response.sendRedirect("/login_success.html");
            }else {
                response.sendRedirect("/login_fail.html");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @RequestMapping("/updatePWD")
    public void updatePWD(HttpServletRequest request,HttpServletResponse response){
        System.out.println("开始修改密码！");
        String userName = request.getParameter("userName");
        String oldPWD = request.getParameter("oldPWD");
        String newPWD = request.getParameter("newPWD");
        System.out.println(userName+","+oldPWD+","+newPWD);
        if (userName == null || userName.isEmpty() ||
            oldPWD == null || oldPWD.isEmpty() ||
            newPWD == null || newPWD.isEmpty()){
            response.sendRedirect("/update_fail.html");
            return;
        }

        try (Connection connection = DBUtil.getConnection();){
            String sql1 = "SELECT username,password,nickname\n" +
                    "FROM userinfo WHERE username=? AND password=?;";
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setString(1,userName);
            ps1.setString(2,oldPWD);
            ResultSet resultSet = ps1.executeQuery();
            if (resultSet.next()){
                String sql2 ="UPDATE userinfo SET password=? WHERE username=?;";
                PreparedStatement ps2 = connection.prepareStatement(sql2);
                ps2.setString(1,newPWD);
                ps2.setString(2,userName);
                int i = ps2.executeUpdate();
                if (i>0){
                    response.sendRedirect("/update_success.html");
                }else {
                    response.sendRedirect("/update_fail.html");
                }
            }else {
                response.sendRedirect("/update_fail.html");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
