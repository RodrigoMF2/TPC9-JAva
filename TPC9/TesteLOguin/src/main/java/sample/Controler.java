package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controler {
    @FXML
    private Button cancelbutton;

    @FXML
    private Label loguinmassageerror;
    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    private void loguinButtononAction (ActionEvent e){


        if(usernameTextField.getText().isBlank()==false && passwordPasswordField.getText().isBlank() == false){
            loguinmassageerror.setText("you try to loguin");
            validateLogin();
        }else{
            loguinmassageerror.setText("please enter your username and password");
        }

    }
     public void  cancelbuttonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelbutton.getScene().getWindow();
        stage.close();

    }

    public void validateLogin(){
        DatabaseConection  connectNow = new DatabaseConection();
        Connection connectDB = connectNow.getConnection();

        String verify = " select count(1) from useracount where username = "+usernameTextField.getText().isBlank()+" and password = "+passwordPasswordField.getText().isBlank()+"";

        try {

            Statement statement = connectDB.createStatement();
            Result queryResult = statement.executarQuery(verifyLoguin);

            while(queryResult.next()){
                if (queryResult.getInt(1)==1 ){
                    loguinmassageerror.setText("Welcome");
                }else{
                    loguinmassageerror.setText("Invalid loguin. please try again");

                }
            }
        }catch(Exception e){

        }
    }
}
