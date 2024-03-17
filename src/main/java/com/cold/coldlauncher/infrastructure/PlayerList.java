package com.cold.coldlauncher.infrastructure;

import java.util.ArrayList;

public class PlayerList {
    ArrayList<Player> playerList;
    public PlayerList(){
        this.playerList=new ArrayList<>();
    }
    public int searchPlayerName(String name){
        for (int i=0;i<playerList.size();i++){
            if(playerList.get(i).getName().equals(name)) return i;
        }
        return -1;
    }
    public int searchPlayerUUID(String uuid){
        for (int i=0;i<playerList.size();i++){
            if(playerList.get(i).getUuid().equals(uuid)) return i;
        }
        return -1;
    }
    public boolean addPlayer(String name, String uuid){
        Player tmp = new Player();
        if(tmp.setName(name)&tmp.setUuid(uuid)){
            if(searchPlayerName(name)>=0) return false;
            else {
                this.playerList.add(tmp);
                return true;
            }
        }
        else return false;
    }
    public boolean delPlayerName(String name){
        int i = searchPlayerName(name);
        if(i<0) return false;
        else {
            this.playerList.remove(i);
            return true;
        }
    }
    public boolean delPlayerUUID(String uuid){
        int i = searchPlayerUUID(uuid);
        if(i<0) return false;
        else {
            this.playerList.remove(i);
            return true;
        }
    }
}
