package com.cold.coldlauncher.infrastructure;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class TesterFabricGame {
    public static void main(String[] args) throws IOException {
        Player player = new Player();
        player.setName("test");
        player.setUuid("114-514");
        FabricGame fabricGame = new FabricGame("1.18.1","Test Game","D:\\minecraft\\.minecraft","0.15.7");
        HashMap<File,String[]> modInfo = fabricGame.getModInfo(ModUtil.getJarList(fabricGame.getPath()+"\\mods\\"));
        System.out.println(modInfo.get(new File("D:\\minecraft\\.minecraft\\mods\\[Carpet] fabric-carpet-1.20-1.4.112+v230608.jar"))[0]+modInfo.get(new File("D:\\minecraft\\.minecraft\\mods\\[Carpet] fabric-carpet-1.20-1.4.112+v230608.jar"))[1]);
        //fabricGame.launch(player);
    }
}
