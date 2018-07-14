package com.doctorcyj87.test;

import com.doctorcyj87.controller.Execute;
import com.doctorcyj87.utils.HttpsUtils;
import com.doctorcyj87.utils.ReaderHeader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author doctorcyj
 * @version V1.0
 * @Title: Demo
 * @date 2018/7/14 001413:17
 * @Description: TODO
 */
public class Demo {

    public static void main(String[] args) throws Exception {


        Map header = ReaderHeader.getHeader();
        Map<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("action","playmusic");
        hashMap.put("MusicID","163843");
        String response = HttpsUtils.get("https://m.vvvdj.com//play/play_ajax.asp", header, hashMap);
        Execute execute = new Execute();
        String fileName = execute.executeJs(response);
        String downloadPath = execute.getDownloadPath(fileName);
        System.out.println(downloadPath);
    }
}
