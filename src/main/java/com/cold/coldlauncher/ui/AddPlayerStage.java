package com.cold.coldlauncher.ui;

import com.cold.coldlauncher.infrastructure.Player;
import com.cold.coldlauncher.infrastructure.PlayerList;
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

import static com.cold.coldlauncher.ui.MainGUI.*;

public class AddPlayerStage extends Application {
    @Override
    public void start(Stage stage){
        Text addPlayerCaption = new Text();
        addPlayerCaption.setFill(Color.RED);
        Text name = new Text("Player Name: ");
        TextField nameBox = new TextField();
        nameBox.setPrefColumnCount(36);
        HBox playerNameSetting = new HBox(10,name,nameBox);
        playerNameSetting.setAlignment(Pos.CENTER);
        Text uuid = new Text("Player UUID: ");
        TextField uuidBox = new TextField();
        uuidBox.setPrefColumnCount(36);
        HBox playerUuidSetting = new HBox(10,uuid,uuidBox);
        playerUuidSetting.setAlignment(Pos.CENTER);
        Button savePlayer = new Button("Save");
        Button cancelPlayer = new Button("Cancel");
        HBox buttonsPlayer = new HBox(200,savePlayer,cancelPlayer);
        buttonsPlayer.setAlignment(Pos.CENTER);

        VBox addPlayerRoot = new VBox(30,addPlayerCaption,playerNameSetting,playerUuidSetting,buttonsPlayer);
        addPlayerRoot.setBackground(Background.EMPTY);

        Scene addPlayer = new Scene(addPlayerRoot,600,200);
        Stage addPlayerStage = new Stage();
        addPlayerStage.setScene(addPlayer);
        addPlayerStage.initModality(Modality.APPLICATION_MODAL);
        addPlayerStage.setTitle("Adding Player...");
        addPlayerStage.show();


        savePlayer.setOnAction(e->{
                    if(Player.validateName(nameBox.getText())& Player.validateUUID(uuidBox.getText())) {
                        if(playerList.searchPlayerByName(nameBox.getText())!=-1) addPlayerCaption.setText("Existing Player name, use another name!");
                        else {
                            playerList.addPlayer(nameBox.getText(),uuidBox.getText());
                            /*
                            playerCheckBoxs.addBox(nameBox.getText());
                            playerListBox.getChildren().add(playerCheckBoxs.getPlayerCheckBoxes().get(playerCheckBoxs.searchBox(nameBox.getText())));
                            */
                            addPlayerStage.close();
                            nameBox.setText("");
                            uuidBox.setText("");
                            addPlayerCaption.setText("");
                        }
                    }
                    else if (Player.validateName(nameBox.getText())&!Player.validateUUID(uuidBox.getText())) addPlayerCaption.setText("Invalid UUID!");
                    else if (Player.validateUUID(uuidBox.getText())&!Player.validateName(nameBox.getText()))addPlayerCaption.setText("Invalid player name!");
                    else addPlayerCaption.setText("Invalid details! Check your input!");
                }
        );
        cancelPlayer.setOnAction(e->{
            addPlayerStage.close();
            nameBox.setText("");
            uuidBox.setText("");
            addPlayerCaption.setText("");
        });

    }
}
