package com.cold.coldlauncher.ui;

import javafx.scene.control.CheckBox;

import java.util.ArrayList;

public class ArraylistTest {
    private ArrayList<String> playerCheckBoxes;

    public ArraylistTest(){
        this.playerCheckBoxes=new ArrayList<>();
    }
    public int searchBox(String name){
        for (int i=0;i< getPlayerCheckBoxes().size();i++){
            if(getPlayerCheckBoxes().get(i).equals(name)) return i;
        }
        return -1;
    }
    public ArrayList<String> getPlayerCheckBoxes(){
        return this.playerCheckBoxes;
    }
    public boolean addBox(String name){
        if(searchBox(name)<0){
            getPlayerCheckBoxes().add(new String(name));
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        ArraylistTest playerCheckBoxs=new ArraylistTest();
        System.out.println(playerCheckBoxs.searchBox("test"));
        System.out.println(playerCheckBoxs.addBox("Test"));
        System.out.println(playerCheckBoxs.addBox("Test"));
        System.out.println(playerCheckBoxs.addBox("Cold"));

    }
}
