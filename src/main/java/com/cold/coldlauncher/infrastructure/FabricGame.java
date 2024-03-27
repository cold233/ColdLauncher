package com.cold.coldlauncher.infrastructure;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class FabricGame extends Game implements ModUtil{
    private final String fabricVersion;
    private ModList mods;
    public FabricGame(String gameVersion,String displayNameIn,String path,String fabricVersion){
        super(gameVersion,displayNameIn,path);
        this.fabricVersion=fabricVersion;
        this.mods=new ModList();
    }

    @Override
    public boolean isModded() {
        return true;
    }

    @Override
    public boolean launch(Player player) throws IOException {

        ProcessBuilder pb = new ProcessBuilder("C:\\Windows\\System32\\cmd.exe -c \"cmd.exe start\"");
        String command="echo \"Started "+this.getDisplayName()+" with following information:\n\"";
        try{
            Runtime.getRuntime().exec(command,new String[]{"PATH=\"C:\\Windows\\System32\""});
        } catch (IOException e){
            e.printStackTrace();
        }
        /*String command="echo \"Started "+this.getDisplayName()+" with following information:\n\"";
        Runtime.getRuntime().exec(command);
        command="echo \"Minecraft Version: "+this.getVersion()+"\"";
        Runtime.getRuntime().exec(command);
        command="echo \"Forge Version: "+this.fabricVersion+"\"";
        Runtime.getRuntime().exec(command);
        command="echo \"";
        command+="Player information: \"";
        Runtime.getRuntime().exec(command);
        command="echo \"Name: "+player.getName()+"\"";
        Runtime.getRuntime().exec(command);
        command="echo \"UUID: "+player.getUuid()+"\"";
        Runtime.getRuntime().exec(command);
        //InputStream is = Runtime.getRuntime().exec(command).getInputStream();*/

        return true;
    }

    @Override
    public HashMap<File, String[]> getModInfo(ArrayList<File> jarList) {
        HashMap<File, String[]> ret = new HashMap<>();
        jarList.forEach(file -> {
            try {
                String[] str = new String[2];
                //System.out.println(file.getAbsolutePath());
                str[0]=ModUtil.parseFabricModName(ModUtil.getZipTextFileContent(file.getAbsolutePath(), "fabric.mod.json"));
                str[1]=ModUtil.parseFabricModVersion(ModUtil.getZipTextFileContent(file.getAbsolutePath(), "fabric.mod.json"));
                //System.out.println(str[0]);
                //System.out.println(str[1]);
                ret.put(file,str);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return ret;
    }

}
