package com.cold.coldlauncher.infrastructure;

import java.util.ArrayList;

public class PlayerList {
    private ArrayList<Player> playerList;
    public PlayerList(){
        this.playerList=new ArrayList<>();
    }
    public ArrayList<Player> getPlayerList(){
        return this.playerList;
    }
    public int searchPlayerByName(String name){
        for (int i=0;i<playerList.size();i++){
            if(playerList.get(i).getName().equals(name)) return i;
        }
        return -1;
    }
    public int searchPlayerByUUID(String uuid){
        for (int i=0;i<playerList.size();i++){
            if(playerList.get(i).getUuid().equals(uuid)) return i;
        }
        return -1;
    }
    public boolean addPlayer(String name, String uuid){
        Player tmp = new Player();
        if(tmp.setName(name)&tmp.setUuid(uuid)){
            if(searchPlayerByName(name)>=0) return false;
            else {
                this.playerList.add(tmp);
                return true;
            }
        }
        else return false;
    }
    public boolean deletePlayerByName(String name){
        int i = searchPlayerByName(name);
        if(i<0) return false;
        else {
            this.playerList.remove(i);
            return true;
        }
    }
    public boolean deletePlayerByUUID(String uuid){
        int i = searchPlayerByUUID(uuid);
        if(i<0) return false;
        else {
            this.playerList.remove(i);
            return true;
        }
    }
}
