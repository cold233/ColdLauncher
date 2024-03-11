package com.cold.coldlauncher.infrastructure;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {
    private Icon icon;
    private String name;
    private String uuid;
    public Player(String nameIn){
        this.name=nameIn;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public boolean setUuid(String uuid) {
        this.uuid = uuid;
    }
    public boolean validateName(String name){
        String pattern="[a-z]";
        Pattern r = Pattern.compile(pattern);
        if(name.length()<3|name.length()>16) return false;
        else {
            Matcher matcher = r.matcher()
        }
    }
}
