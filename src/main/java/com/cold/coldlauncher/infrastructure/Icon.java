package com.cold.coldlauncher.infrastructure;

public class Icon {
    private String path;
    private boolean isDefault;
    private final String defaultPath="default path,to be given in future develop";
    public Icon(){
        this.path=defaultPath;
        this.isDefault=true;
    }
    public boolean isChanged(){
        return !isDefault;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
        this.isDefault=false;
    }
}
