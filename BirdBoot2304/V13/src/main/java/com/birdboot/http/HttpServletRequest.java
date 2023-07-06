package com.birdboot.http;

import jdk.jfr.events.SocketReadEvent;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpServletRequest{
    private Socket socket;
    //请求行相关信息
    private String method;//请求方式
    private String uri;//抽象路径
    private String protocol;//协议版本

    private String requestURI;//保存uri中“？”左侧的请求部分
    private String queryString;//保存uri中“？”右侧的参数部分
    private Map<String,String> parameters = new HashMap<>();//保存每一组参数

    //消息头相关信息
    private Map<String,String> headers = new HashMap<>();

    public HttpServletRequest(Socket socket) throws IOException, EmptyRequestException {
        this.socket = socket;
        //1、解析请求行
        parseRequestLine();
        //2、解析消息头
        parseHeaders();
        //3、解析正文
        parseContent();



    }

    //解析请求行
    private void parseRequestLine() throws IOException, EmptyRequestException {
        String line = readLine();

        if (line.isEmpty()){
            throw new EmptyRequestException();
        }

        System.out.println("请求行："+line);

        String[] data = line.split("\\s");
        method = data[0];
        uri = data[1];
        protocol = data[2];

        //进一步解析uri
        parseURI();

        System.out.println("method:"+method);
        System.out.println("uri:"+uri);
        System.out.println("protocol:" +protocol);
    }

    //进一步解析uri
    private void parseURI(){
         /*
            uri有两种情况:
            1:不含有参数的
              例如: /index.html
              直接将uri的值赋值给requestURI即可.

            2:含有参数的
              例如:/regUser?username=fancq&password=123456&nickname=chuanqi&age=22
              将uri中"?"左侧的请求部分赋值给requestURI
              将uri中"?"右侧的参数部分赋值给queryString
              将参数部分首先按照"&"拆分出每一组参数，再将每一组参数按照"="拆分为参数名与参数值
              并将参数名作为key，参数值作为value存入到parameters中。
                requestURI:/regUser
                queryString:username=fancq&password=123456&nickname=chuanqi&age=22
                parameters:
                    key             value
                  username          fancq
                  password          123456
                  nickname          chuanqi
                  age               22
         */
        if (uri.contains("?")){
            String[] data = uri.split("\\?");
            requestURI = data[0];
            queryString = data[1];
            String[] message = queryString.split("&");
            for (String str : message){
                String[] paras = str.split("=",2);
                parameters.put(paras[0],paras[1]);
            }
        }else {
            requestURI = uri;
        }


        System.out.println("requestURI:"+requestURI);
        System.out.println("queryString:"+queryString);
        System.out.println("parameters:"+parameters);
    }

    //解析消息头
    private void parseHeaders() throws IOException {
        String line = readLine();
        while (true) {
            line = readLine();
            if (line.isEmpty()) {
                break;
            }
            String[] massage = line.split(":\\s");
            headers.put(massage[0],massage[1]);
        }
        System.out.println("headers:"+headers);
    }
    //解析消息正文
    private void parseContent(){

    }


    /**
     * 读取客户端发送过来的一行字符串
     * @return
     */
    private String readLine() throws IOException {
        InputStream in = socket.getInputStream();

        char pre = 'a',cur = 'a';
        StringBuilder builder = new StringBuilder();
        int d;
        while ((d = in.read()) != -1){
            cur = (char)d;
            if(pre == 13 && cur == 10){
                break;
            }
            builder.append(cur);
            pre = cur;
        }
        return builder.toString().trim();
    }

    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getHeader(String name) {
        return headers.get(name);
    }

    public String getRequestURI() {
        return requestURI;
    }

    public String getQueryString() {
        return queryString;
    }

    public String getParameter(String name) {
        return parameters.get(name);
    }
}
