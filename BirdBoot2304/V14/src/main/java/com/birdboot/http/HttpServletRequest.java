package com.birdboot.http;

import jdk.jfr.events.SocketReadEvent;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
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
        String[] data = uri.split("\\?");
        requestURI = data[0];
        if (data.length>1){
            queryString = data[1];
            parseParameters(queryString);
        }


        System.out.println("requestURI:"+requestURI);
        System.out.println("queryString:"+queryString);
        System.out.println("parameters:"+parameters);
    }

    private void parseParameters(String line){
        String[] message = line.split("&");
        for (String str : message){
            String[] paras = str.split("=",2);
            parameters.put(paras[0],paras[1]);
        }
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
            headers.put(massage[0].toLowerCase(),massage[1]);
        }
        System.out.println("headers:"+headers);
    }
    //解析消息正文
    private void parseContent(){
        //根据请求方式是否为POST决定是否要解析正文
        if("post".equalsIgnoreCase(method)){
            String contentLength = getHeader("Content-Length");
            if (contentLength != null){
                int cl = Integer.parseInt(contentLength);
                System.out.println("正文长度："+cl);
                //读取正文数据
                byte[] data = new byte[cl];
                try {
                    InputStream in = socket.getInputStream();
                    in.read(data);//将正文数据全部读入到data数组中
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //根据Content-Type来分析正文类型并进行对应的解析
                String contentType = getHeader("Content-Type");
                if (contentType != null){
                    if ("application/x-www-form-urlencoded".equals(contentType)){
                        String line = new String(data, StandardCharsets.ISO_8859_1);
                        System.out.println("正文内容："+line);
                        parseParameters(line);
                    }
                }
            }
        }
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
        return headers.get(name.toLowerCase());
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
