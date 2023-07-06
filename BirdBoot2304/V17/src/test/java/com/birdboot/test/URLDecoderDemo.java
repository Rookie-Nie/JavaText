package com.birdboot.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLDecoderDemo {
    public static void main(String[] args) {
        String line = "/loginUser?userName=%E5%B0%8F%E8%81%82&passWord=nnn";
        try {
            line = URLDecoder.decode(line,"UTF-8");
            System.out.println(line);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
