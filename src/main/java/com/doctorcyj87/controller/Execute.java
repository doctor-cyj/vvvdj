package com.doctorcyj87.controller;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;

import java.io.*;

/**
 * @author doctorcyj
 * @version V1.0
 * @Title: Execute
 * @date 2018/7/14 001414:12
 * @Description: 执行JS函数
 */
public class Execute {

    /*
     * @Author doctorcyj
     * @Description //
     *              根据网页相应内容解密文件名
     * @Date  2018/7/14 0014
     * @Param
            [param] 歌曲详细信息
     * @return java.lang.String 歌曲文件名
     **/
    public String executeJs(String param) throws Exception {

        V8 v8 = V8.createV8Runtime();
        String js = "";
        String filePath = this.getClass().getClassLoader().getResource("vvvdj.js").getPath();
        InputStreamReader read = new InputStreamReader(
                new FileInputStream(filePath),"utf-8");//考虑到编码格式
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        StringBuilder sb = new StringBuilder("");
        while((lineTxt = bufferedReader.readLine()) != null){
            sb.append(lineTxt);
        }
        read.close();
        js = sb.toString();
        v8.executeVoidScript(js);
        V8Array parameters = new V8Array(v8).push(param);
        String result = v8.executeStringFunction("add", parameters);
        return result;
    }


    /*
     * @Author doctorcyj
     * @Description //根据文件名字拼接下载地址
     * @Date  2018/7/14 0014
     * @Param
            [fileName]  文件名字
     * @return java.lang.String
     **/
    public String getDownloadPath(String fileName){

        return "http://tm.vvvdj.com/mp4/"+fileName+".mp4";
    }

}
