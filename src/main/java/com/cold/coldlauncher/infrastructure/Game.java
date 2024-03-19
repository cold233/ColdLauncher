package com.cold.coldlauncher.infrastructure;

public abstract class Game {
    private String version;
    private String displayName;
    private String path;
    private boolean modded;
    private Icon icon;

    public Game(String versionIn, String displayNameIn) {
        this.version = versionIn;
        this.displayName = displayNameIn;
        this.icon = new Icon();
        this.modded = false;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getVersion() {
        return version;
    }

    public abstract boolean isModded();

    public abstract boolean launch(Player player);
}
