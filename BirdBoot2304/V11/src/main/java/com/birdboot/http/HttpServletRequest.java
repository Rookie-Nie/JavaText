package com.birdboot.http;

import jdk.jfr.events.SocketReadEvent;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpServletRequest implements Runnable{
    private Socket socket;
    //请求行相关信息
    private String method;//请求方式
    private String uri;//抽象路径
    private String protocol;//协议版本
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
        System.out.println("method:"+method);
        System.out.println("uri:"+uri);
        System.out.println("protocol:" +protocol);
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

    @Override
    public void run() {

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
}
