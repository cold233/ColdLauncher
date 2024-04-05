package com.cold.coldlauncher.ui;

import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class PlayerCheckBoxs {
    private ArrayList<CheckBox> playerCheckBoxes;


    public PlayerCheckBoxs(){
        this.playerCheckBoxes=new ArrayList<>();
    }
    public String getSelected(){
        for (int i=0;i<this.getPlayerCheckBoxes().size();i++){
            if(this.getPlayerCheckBoxes().get(i).isSelected()) return this.getPlayerCheckBoxes().get(i).getText();
        }
        return "No player selected!";
    }
    public int searchBox(String name){
        for (int i=0;i< getPlayerCheckBoxes().size();i++){
            if(getPlayerCheckBoxes().get(i).getText().equals(name)) return i;
        }
        return -1;
    }
    public ArrayList<CheckBox> getPlayerCheckBoxes(){
        return this.playerCheckBoxes;
    }
    public boolean addBox(String name){
        if(searchBox(name)<0){
            getPlayerCheckBoxes().add(new CheckBox(name));
            return true;
        }
        else return false;
    }
    public void removeAllBox(){
        for(int i=0;i<this.getPlayerCheckBoxes().size();i++){
            this.getPlayerCheckBoxes().remove(i);
        }
    }

    public static void main(String[] args) {
        PlayerCheckBoxs playerCheckBoxs=new PlayerCheckBoxs();
        System.out.println(playerCheckBoxs.addBox("Test"));
        System.out.println(playerCheckBoxs.addBox("Test"));
        System.out.println(playerCheckBoxs.addBox("Cold"));

    }
}
