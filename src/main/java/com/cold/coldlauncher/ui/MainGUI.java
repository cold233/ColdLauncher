package com.cold.coldlauncher.ui;

import com.cold.coldlauncher.infrastructure.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MainGUI extends Application {
    public static PlayerList playerList = new PlayerList();
    public static PlayerCheckBoxs playerCheckBoxs=new PlayerCheckBoxs();
    public static VBox playerListBox = new VBox(5);
    public static AddPlayerStage addPlayerStage = new AddPlayerStage();
    public static ManagePlayerStage managePlayerStage = new ManagePlayerStage();
    @Override
    public void start(Stage stage) {
        //Main window
        MenuBar bar = new MenuBar();
        Menu game = new Menu("Game");
        Menu player = new Menu("Player");
        Menu newGame = new Menu("Import Game...");
        Menu manageGame = new Menu("Manage Game");
        Menu newPlayerMenu = new Menu("Add Player Profile");
        Menu managePlayerMenu = new Menu("Manage Player Profiles");
        game.getItems().addAll(newGame,manageGame);
        player.getItems().addAll(newPlayerMenu,managePlayerMenu);

        bar.getMenus().addAll(game,player);

        Text gameTitle = new Text("Import a game to show");
        Text gameVersion = new Text();
        Text modStatus = new Text();

        HBox gameInfo = new HBox(10,gameVersion,modStatus);
        VBox gameText = new VBox(5,gameTitle,gameInfo);
        gameInfo.setAlignment(Pos.CENTER_LEFT);
        gameText.setAlignment(Pos.CENTER_LEFT);

        Text playerName = new Text("Create a player to show");
        Text playerUuid = new Text();
        VBox playerText = new VBox(5,playerName,playerUuid);
        playerText.setAlignment(Pos.CENTER_LEFT);

        Button start = new Button("Start");

        VBox mainRoot = new VBox(40,bar,gameText,playerText,start);
        mainRoot.setAlignment(Pos.TOP_LEFT);
        mainRoot.setBackground(Background.EMPTY);

        playerListBox.setMinHeight(350);

        Scene mainScene = new Scene(mainRoot,500,400);

        //Add player stage
        Stage stage1 = new Stage();


        //Manage player stage
        Stage stage2 = new Stage();



        //Actions for main window
        newPlayerMenu.setOnAction(e ->addPlayerStage.start(stage1));
        managePlayerMenu.setOnAction(e->{
            //managePlayerStage.setSelectedPlayerName(playerCheckBoxs.getSelected());
            managePlayerStage.start(stage2);

        });
        stage.setScene(mainScene);
        stage.setTitle("Cold Launcher");
        stage.show();
    }
}
