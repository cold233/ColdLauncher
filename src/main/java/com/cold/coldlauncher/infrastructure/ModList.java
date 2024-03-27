package com.cold.coldlauncher.infrastructure;

import java.util.ArrayList;

public class ModList {
    private ArrayList<Mod> modList;
    public ModList(){
        this.modList=new ArrayList<>();
    }
    public int searchMod(String name){
        for (int i=0;i<modList.size();i++){
            if(modList.get(i).getName().equals(name)) return i;
        }
        return -1;
    }
    public boolean addMod(Mod modIn){
        if(searchMod(modIn.getName())<0) {
            this.modList.add(modIn);
            return true;
        }
        else return false;
    }
    public boolean deleteMod(String name){
        int i=searchMod(name);
        if(i<0) return false;
        else {
            this.modList.remove(i);
            return true;
        }
    }
}
