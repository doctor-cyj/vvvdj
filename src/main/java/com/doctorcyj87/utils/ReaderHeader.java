package com.doctorcyj87.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author doctorcyj
 * @version V1.0
 * @Title: ReaderHeader
 * @date 2018/7/14 001413:00
 * @Description: 读取请求头配置文件
 */
public class ReaderHeader {

    public ReaderHeader() {
    }

    public static Map getHeader() {

        String path = ReaderHeader.class.getResource("/").getPath();
//        System.out.println(path);
        String line = null;
        Map<String, String> map = new HashMap<String, String>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path + "header.txt"));
            while ((line = bufferedReader.readLine()) != null) {
                //读取到#号开头表示注释
                if (line.startsWith("#")){
                    continue;
                }
                map.put(line.split(":")[0], line.split(":")[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取异常");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    /*
     * @Author doctorcyj
     * @Description //TODO
     * @Date
     * @Param
            [path]  配置文件存储路径
     * @return java.util.Map
     **/
    public static Map getHeader(String path) {
        String line = null;
        Map<String, String> map = new HashMap<String, String>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            while ((line = bufferedReader.readLine()) != null) {
                //读取到#号开头表示注释
                if (line.startsWith("#")){
                    continue;
                }
                map.put(line.split(":")[0], line.split(":")[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取异常");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

}
