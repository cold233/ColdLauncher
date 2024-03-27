package com.cold.coldlauncher.infrastructure;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public interface ModUtil {
    static ArrayList<File> getJarList(String dir) {
        File tmp = new File(dir);
        //FileInputStream[] list = tmp.list()
        File[] list = tmp.listFiles();
        ArrayList<File> ret=new ArrayList<>();
        if(list != null){
            for (int i=0;i<list.length;i++){
                if(list[i].getName().endsWith(".jar")) ret.add(list[i]);
            }
        }
        return ret;
    }
    static String getZipTextFileContent(String zipFileName,String textPath) throws IOException {
        ZipInputStream zipInputStream;
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(zipFileName);
            zipInputStream = new ZipInputStream(
                    new BufferedInputStream(inputStream), StandardCharsets.UTF_8
            );
            ZipEntry ze;
            StringBuilder txtStr = new StringBuilder();
            while ((ze = zipInputStream.getNextEntry()) != null){
                if(!ze.isDirectory() && ze.getName().equals(textPath)){
                    byte[] b = new byte[1024];
                    int leng;
                    while ((leng = zipInputStream.read(b)) != -1){
                        txtStr.append(new String(b,0,leng));
                    }
                    break;
                }

            }
            inputStream.close();
            zipInputStream.close();
            return txtStr.toString();
        } catch (IOException e){
            System.out.println("Error: "+e.getMessage());
            return null;
        }
    }
    static String parseFabricModVersion(String json){
        json=json.split("\"version\":")[1];
        json=json.split("\",")[0];
        json=json.split("\"")[1];
        return json;
    }
    static String parseForgeModVersion(String mf){
        mf=mf.split("version=\"")[1];
        mf=mf.split("\"")[0];
        return mf;
    }
    static String parseFabricModName(String json){
        json=json.split("\"name\":")[1];
        json=json.split("\",")[0];
        json=json.split("\"")[1];
        return json;
    }
    static String parseForgeModName(String mf){
        mf=mf.split("displayName=\"")[1];
        //System.out.println(mf);
        mf=mf.split("\"")[0];
        return mf;
    }
    HashMap<File,String[]> getModInfo(ArrayList<File> jarList);
}
