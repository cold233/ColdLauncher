package com.cold.coldlauncher.infrastructure;

import java.io.IOException;

public class NonModedGame extends Game{

    public NonModedGame(String versionIn, String displayNameIn, String pathIn) {
        super(versionIn, displayNameIn, pathIn);
    }

    @Override
    public boolean isModded() {
        return false;
    }

    @Override
    public boolean launch(Player player) throws IOException {
        return false;
    }
}
