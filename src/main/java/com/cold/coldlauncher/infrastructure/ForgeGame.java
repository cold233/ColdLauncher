package com.cold.coldlauncher.infrastructure;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ForgeGame extends Game implements ModUtil{
    private final String forgeVersion;
    private ModList mods;
    public ForgeGame(String mcVersion,String displayName,String pathIn,String forgeVersionIn){
        super(mcVersion,displayName,pathIn);
        this.forgeVersion=forgeVersionIn;
    }

    @Override
    public boolean isModded() {
        return true;
    }

    @Override
    public HashMap<File, String[]> getModInfo(ArrayList<File> jarList) {
        HashMap<File, String[]> ret = new HashMap<>();
        jarList.forEach(file -> {
            try {
                ret.put(file, new String[]{ModUtil.parseForgeModName(ModUtil.getZipTextFileContent(file.getAbsolutePath(), "META-INF/mods.toml")), ModUtil.parseForgeModVersion(ModUtil.getZipTextFileContent(file.getAbsolutePath(), "META-INF/mods.toml"))});
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return ret;
    }

    @Override
    public boolean launch(Player player) throws IOException {
        String command="echo \"Started "+this.getDisplayName()+" with following information:\n";
        command+="Minecraft Version: "+this.getVersion()+"\n";
        command+="Forge Version: "+this.forgeVersion+"\n\"";
        Runtime.getRuntime().exec(command);
        command="echo \"";
        command+="Player information: \nName: "+player.getName();
        command+="\nUUID: "+player.getUuid()+"\"";
        Runtime.getRuntime().exec(command);
        return true;
    }
}
