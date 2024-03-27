package com.cold.coldlauncher.infrastructure;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TesterModUtil {

    public static void main(String[] args) throws IOException {
        ArrayList<File> arrayList = ModUtil.getJarList("D:\\MC\\.minecraft\\versions\\167\\mods");
        for (int i=0;i< arrayList.size();i++){
            System.out.println(arrayList.get(i).getName());
        }
        String json = ModUtil.getZipTextFileContent("D:\\MC\\.minecraft\\versions\\167\\mods\\[Carpet] fabric-carpet-1.20-1.4.112+v230608.jar","fabric.mod.json");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(json);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(ModUtil.parseFabricModName(json) + " " + ModUtil.parseFabricModVersion(json));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String mf= ModUtil.getZipTextFileContent("D:\\MC\\.minecraft\\versions\\1.18.2-Forge_40.2.0\\mods\\[暮色森林] twilightforest-1.18.2-4.1.1494-universal.jar","META-INF/mods.toml");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(mf);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(ModUtil.parseForgeModName(mf) + " " + ModUtil.parseForgeModVersion(mf));
    }
}
