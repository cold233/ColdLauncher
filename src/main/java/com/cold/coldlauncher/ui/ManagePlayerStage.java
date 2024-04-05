package com.cold.coldlauncher.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Optional;

import static com.cold.coldlauncher.ui.MainGUI.*;

public class ManagePlayerStage extends Application {
    private String selectedPlayerName;
    private ScrollPane playerListPane = new ScrollPane(playerListBox);
    public ManagePlayerStage(){
    }
    public String getSelectedPlayerName() {
        return selectedPlayerName;
    }

    public ScrollPane getPlayerListPane() {
        return playerListPane;
    }

    public void setSelectedPlayerName(String selectedPlayerName) {
        this.selectedPlayerName = selectedPlayerName;
    }

    @Override
    public void start(Stage stage) {
        Text playerListTitle = new Text("Players:");
        Text playerListInfo = new Text();

        playerListPane.setHmax(300);
        playerListPane.setVmax(100);
        playerListPane.setHmin(300);
        playerListPane.setFitToHeight(true);

        Button deletePlayer = new Button("Delete");
        Button editPlayer = new Button("Edit");
        HBox managerPlayerButtons = new HBox(20,deletePlayer,editPlayer);

        playerCheckBoxs.removeAllBox();
        for(int i=0;i<playerListBox.getChildren().size();i++){
            playerListBox.getChildren().remove(i);
        }
        for(int i = 0; i< playerList.getPlayerList().size(); i++){
            playerCheckBoxs.addBox(playerList.getPlayerList().get(i).getName());
        }
        for (int i=0;i< playerCheckBoxs.getPlayerCheckBoxes().size();i++){
            playerListBox.getChildren().add(playerCheckBoxs.getPlayerCheckBoxes().get(i));
        }

        VBox managePlayerRoot = new VBox(10,playerListTitle,playerListInfo,playerListPane,managerPlayerButtons);
        Scene managePlayer = new Scene(managePlayerRoot,250,400);
        Stage managePlayerStage = new Stage();
        managePlayerStage.setScene(managePlayer);
        managePlayerStage.initModality(Modality.APPLICATION_MODAL);
        managePlayerStage.setTitle("Player Profile Manage");
        managePlayerStage.show();

        for (int i=0;i<playerCheckBoxs.getPlayerCheckBoxes().size();i++){
            int finalI = i;
            playerCheckBoxs.getPlayerCheckBoxes().get(i).setOnAction(e->{
                if(playerCheckBoxs.getPlayerCheckBoxes().get(finalI).isSelected()){
                    for (int j=0;j<finalI;j++) playerCheckBoxs.getPlayerCheckBoxes().get(j).setSelected(false);
                    for (int j=finalI+1;j<playerCheckBoxs.getPlayerCheckBoxes().size();j++) playerCheckBoxs.getPlayerCheckBoxes().get(j).setSelected(false);
                    this.setSelectedPlayerName(playerCheckBoxs.getPlayerCheckBoxes().get(finalI).getText());
                }
            });
        }

        editPlayer.setOnAction(e->{
            if(getSelectedPlayerName()!=null){
                playerListInfo.setText("");
                Stage edit = new Stage();
                EditPlayerStage editPlayerStage = new EditPlayerStage();
                editPlayerStage.setTargetPlayerName(playerCheckBoxs.getSelected());
                editPlayerStage.start(edit);
                managePlayerStage.close();
            }
            else {
                playerListInfo.setFill(Color.RED);
                playerListInfo.setText("Please select a player first!");
            }
        });
        deletePlayer.setOnAction(e->{
            String name = MainGUI.managePlayerStage.getSelectedPlayerName();
            Alert playerDeleteConfirmation = new Alert(Alert.AlertType.CONFIRMATION);
            playerDeleteConfirmation.setTitle("Delete Confirmation");
            playerDeleteConfirmation.setHeaderText("Deleting "+name );
            playerDeleteConfirmation.setContentText("Click OK to proceed.");
            if(name!=null&name!="No player selected!"){
                managePlayerStage.close();
                playerListInfo.setText("");
                Optional<ButtonType> result = playerDeleteConfirmation.showAndWait();
                if(result.get()==ButtonType.OK){
                    MainGUI.playerList.deletePlayerByName(name);
                    playerCheckBoxs.getPlayerCheckBoxes().remove(playerCheckBoxs.searchBox(name));
                    playerListBox.getChildren().removeAll();
                    this.setSelectedPlayerName(null);
                }
                else playerDeleteConfirmation.close();
            }
            else {
                playerListInfo.setFill(Color.RED);
                playerListInfo.setText("Please select a player first!");
            }
        });
    }
}
