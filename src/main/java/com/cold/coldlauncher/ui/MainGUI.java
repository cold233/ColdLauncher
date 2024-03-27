package com.cold.coldlauncher.ui;

import com.cold.coldlauncher.infrastructure.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainGUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        PlayerList playerList = new PlayerList();
        Player test = new Player();

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

        VBox mainRoot = new VBox(30,bar,gameText,playerText,start);
        mainRoot.setAlignment(Pos.TOP_LEFT);
        mainRoot.setBackground(Background.EMPTY);

        Scene mainScene = new Scene(mainRoot,400,300);

        //Add player window
        Text addPlayerCaption = new Text();
        addPlayerCaption.setFill(Color.RED);
        Text name = new Text("Player Name: ");
        TextField nameBox = new TextField();
        HBox playerNameSetting = new HBox(10,name,nameBox);
        playerNameSetting.setAlignment(Pos.CENTER);
        Text uuid = new Text("Player UUID: ");
        TextField uuidBox = new TextField();
        HBox playerUuidSetting = new HBox(10,uuid,uuidBox);
        playerUuidSetting.setAlignment(Pos.CENTER);
        Button savePlayer = new Button("Save");
        Button cancelPlayer = new Button("Cancel");
        HBox buttonsPlayer = new HBox(50,savePlayer,cancelPlayer);

        VBox addPlayerRoot = new VBox(15,addPlayerCaption,playerNameSetting,playerUuidSetting,buttonsPlayer);
        addPlayerRoot.setBackground(Background.EMPTY);

        Scene addPlayer = new Scene(addPlayerRoot,200,200);
        Stage addPlayerStage = new Stage();
        addPlayerStage.setScene(addPlayer);
        addPlayerStage.initModality(Modality.APPLICATION_MODAL);
        addPlayerStage.setTitle("Adding Player...");


        //Manage player window
        Text playerListTitle = new Text("Players:");
        VBox playerListBox = new VBox(5);
        for(int i = 0;i<playerList.getPlayerList().size();i++){
            playerListBox.getChildren().add(new CheckBox(playerList.getPlayerList().get(i).getName()));
        }
        ScrollPane playerListPane = new ScrollPane(playerListBox);
        playerListPane.setHmax(300);
        playerListPane.setVmax(100);

        Button deletePlayer = new Button("Delete");
        Button editPlayer = new Button("Edit");
        HBox managerPlayerButtons = new HBox(20,deletePlayer,editPlayer);

        VBox managePlayerRoot = new VBox(10,playerListTitle,playerListPane,managerPlayerButtons);
        Scene managePlayer = new Scene(managePlayerRoot,250,400);
        Stage managePlayerStage = new Stage();
        managePlayerStage.setScene(managePlayer);
        managePlayerStage.initModality(Modality.APPLICATION_MODAL);
        managePlayerStage.setTitle("Player Profile Manage");


        //Actions for main window
        newPlayerMenu.setOnAction(e ->addPlayerStage.show());
        managePlayerMenu.setOnAction(e->{
            for(int i = 0;i<playerList.getPlayerList().size();i++){
                playerListBox.getChildren().add(new CheckBox(playerList.getPlayerList().get(i).getName()));
            }
            managePlayerStage.show();
        });

        //Actions for add player
        savePlayer.setOnAction(e->{
            if(test.validateName(nameBox.getText())& test.validateUUID(uuidBox.getText())) {
                playerList.addPlayer(nameBox.getText(),uuidBox.getText());
                addPlayerStage.close();
                nameBox.setText("");
                uuidBox.setText("");
                addPlayerCaption.setText("");
            }
            else if (test.validateName(nameBox.getText())&!test.validateUUID(uuidBox.getText())) addPlayerCaption.setText("Invalid UUID!");
            else if (test.validateUUID(uuidBox.getText())&!test.validateName(nameBox.getText()))addPlayerCaption.setText("Invalid player name!");
            else addPlayerCaption.setText("Invalid details! Check your input!");
                }
        );
        cancelPlayer.setOnAction(e->{
            addPlayerStage.close();
            nameBox.setText("");
            uuidBox.setText("");
            addPlayerCaption.setText("");
        });

        //Actions for manage player
        editPlayer.setOnAction(e->{
        });

        stage.setScene(mainScene);
        stage.setTitle("Cold Launcher");
        stage.show();
    }
}
