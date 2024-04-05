package com.cold.coldlauncher.ui;

import com.cold.coldlauncher.infrastructure.Player;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static com.cold.coldlauncher.ui.MainGUI.playerCheckBoxs;
import static com.cold.coldlauncher.ui.MainGUI.playerList;

public class EditPlayerStage extends Application {
    private String targetPlayerName;
    public EditPlayerStage(){
    }

    public void setTargetPlayerName(String targetPlayerName) {
        this.targetPlayerName = targetPlayerName;
    }

    public String getTargetPlayerName() {
        return targetPlayerName;
    }

    @Override
    public void start(Stage stage){
        Text editPlayerCaption = new Text();
        editPlayerCaption.setFill(Color.RED);
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

        VBox editPlayerRoot = new VBox(15,editPlayerCaption,playerNameSetting,playerUuidSetting,buttonsPlayer);
        editPlayerRoot.setBackground(Background.EMPTY);

        Scene editPlayer = new Scene(editPlayerRoot,200,200);
        Stage editPlayerStage = new Stage();
        editPlayerStage.setScene(editPlayer);
        editPlayerStage.initModality(Modality.APPLICATION_MODAL);
        editPlayerStage.setTitle("Editing "+getTargetPlayerName()+" ...");
        editPlayerStage.show();

        int index = playerList.searchPlayerByName(targetPlayerName);
        nameBox.setText(targetPlayerName);
        uuidBox.setText(playerList.getPlayerList().get(index).getUuid());

        savePlayer.setOnAction(e->{
                    if(Player.validateName(nameBox.getText())& Player.validateUUID(uuidBox.getText())) {

                    playerList.getPlayerList().get(index).setName(nameBox.getText());
                    playerList.getPlayerList().get(index).setUuid(uuidBox.getText());
                    playerCheckBoxs.getPlayerCheckBoxes().get(index).setText(nameBox.getText());
                    editPlayerStage.close();
                    nameBox.setText("");
                    uuidBox.setText("");
                    editPlayerCaption.setText("");
                    }
                    else if (Player.validateName(nameBox.getText())&!Player.validateUUID(uuidBox.getText())) editPlayerCaption.setText("Invalid UUID!");
                    else if (Player.validateUUID(uuidBox.getText())&!Player.validateName(nameBox.getText()))editPlayerCaption.setText("Invalid player name!");
                    else editPlayerCaption.setText("Invalid details! Check your input!");
                }
        );
        cancelPlayer.setOnAction(e->{
            editPlayerStage.close();
            nameBox.setText("");
            uuidBox.setText("");
            editPlayerCaption.setText("");
        });

    }
}
