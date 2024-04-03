package com.cold.coldlauncher.ui;

import com.cold.coldlauncher.infrastructure.PlayerList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ManagePlayerStage extends Application {
    private PlayerList playerList;
    private PlayerCheckBoxs playerCheckBoxs;
    private VBox playerListBox;
    private String selectedPlayerName;
    public ManagePlayerStage(PlayerList playerListIn,PlayerCheckBoxs playerCheckBoxsIn,VBox playerListBoxIn){
        this.playerList=playerListIn;
        this.playerCheckBoxs=playerCheckBoxsIn;
        this.playerListBox=playerListBoxIn;
    }

    public String getSelectedPlayerName() {
        return selectedPlayerName;
    }

    public void setSelectedPlayerName(String selectedPlayerName) {
        this.selectedPlayerName = selectedPlayerName;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Text playerListTitle = new Text("Players:");

        for(int i = 0;i<playerList.getPlayerList().size();i++){
            playerCheckBoxs.addBox(playerList.getPlayerList().get(i).getName());
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
            Stage edit = new Stage();
            EditPlayerStage editPlayerStage = new EditPlayerStage(playerList,playerCheckBoxs,playerListBox,selectedPlayerName);
            editPlayerStage.start(edit);
            managePlayerStage.close();
        });
    }
}
