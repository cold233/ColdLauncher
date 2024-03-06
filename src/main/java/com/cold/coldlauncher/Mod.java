package com.cold.coldlauncher;

public class Mod {
    private String name;
    private String version;

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public Mod(String name, String version){
        this.name=name;
        this.version=version;

    }

    public void setVersion(String version) {
        this.version = version;
    }
}
