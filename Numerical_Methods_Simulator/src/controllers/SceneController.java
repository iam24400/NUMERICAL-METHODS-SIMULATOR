package controllers;

import java.io.IOException;
import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class SceneController implements Initializable{

    @FXML private Stage theStage;
    @FXML private Scene theScene;
    @FXML private Parent theRoot;
    @FXML private Pane fadingPane;
    @FXML private Pane fadingHomePane;
    
    
    @Override public void initialize(URL url, ResourceBundle rb) {
        FadeTransition fadingFX = new FadeTransition();
        fadingFX.setDuration(Duration.millis(1000));
        fadingFX.setNode(fadingHomePane);
        fadingFX.setFromValue(0);
        fadingFX.setToValue(1);
        fadingFX.play();
        
        
    }
 
    @FXML public void sceneHome(ActionEvent event) throws IOException {
        theRoot = FXMLLoader.load(getClass().getResource("/fxmls/Home.fxml"));
        theStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        theScene = new Scene(theRoot);
        theStage.setScene(theScene);
        theStage.show();
        }
    
    public void sceneBisection_Definition(ActionEvent event) throws IOException {
        theRoot = FXMLLoader.load(getClass().getResource("/fxmls/Bisection_Definition.fxml"));
        theStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        theScene = new Scene(theRoot);
        theStage.setScene(theScene);
        theStage.show();
        }
    
    public void sceneFalsePosition_Definition(ActionEvent event) throws IOException {      
        theRoot = FXMLLoader.load(getClass().getResource("/fxmls/FalsePosition_Definition.fxml"));
        theStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        theScene = new Scene(theRoot);
        theStage.setScene(theScene);
        theStage.show();
    }
    
    public void sceneTangent_Definition(ActionEvent event) throws IOException {
         theRoot = FXMLLoader.load(getClass().getResource("/fxmls/Tangent_Definition.fxml"));
         theStage = (Stage)((Node)event.getSource()).getScene().getWindow();
         theScene = new Scene(theRoot);
         theStage.setScene(theScene);
         theStage.show();
         }
    
    public void sceneSecant_Definition(ActionEvent event) throws IOException {
         theRoot = FXMLLoader.load(getClass().getResource("/fxmls/Secant_Definition.fxml"));
         theStage = (Stage)((Node)event.getSource()).getScene().getWindow();
         theScene = new Scene(theRoot);
         theStage.setScene(theScene);
         theStage.show();
         }
    
    public void sceneJacobi_Definition(ActionEvent event) throws IOException {
         theRoot = FXMLLoader.load(getClass().getResource("/fxmls/Jacobi_Definition.fxml"));
         theStage = (Stage)((Node)event.getSource()).getScene().getWindow();
         theScene = new Scene(theRoot);
         theStage.setScene(theScene);
         theStage.show();
         }
    
    public void sceneGaussSeidel_Definition(ActionEvent event) throws IOException {
         theRoot = FXMLLoader.load(getClass().getResource("/fxmls/GaussSeidel_Definition.fxml"));
         theStage = (Stage)((Node)event.getSource()).getScene().getWindow();
         theScene = new Scene(theRoot);
         theStage.setScene(theScene);
         theStage.show();
         }
    
    public void sceneNewton_Definition(ActionEvent event) throws IOException {
         theRoot = FXMLLoader.load(getClass().getResource("/fxmls/NewtonInterpolation_Definition.fxml"));
         theStage = (Stage)((Node)event.getSource()).getScene().getWindow();
         theScene = new Scene(theRoot);
         theStage.setScene(theScene);
         theStage.show();
         }
    
    public void sceneLagrange_Definition(ActionEvent event) throws IOException {
         theRoot = FXMLLoader.load(getClass().getResource("/fxmls/LagrangeInterpolation_Definition.fxml"));
         theStage = (Stage)((Node)event.getSource()).getScene().getWindow();
         theScene = new Scene(theRoot);
         theStage.setScene(theScene);
         theStage.show();
         }
    
    public void sceneTrapezoidal_Definition(ActionEvent event) throws IOException {
         theRoot = FXMLLoader.load(getClass().getResource("/fxmls/TrapezoidalRule_Definition.fxml"));
         theStage = (Stage)((Node)event.getSource()).getScene().getWindow();
         theScene = new Scene(theRoot);
         theStage.setScene(theScene);
         theStage.show();
         }
    
    public void sceneSimpsons13_Definition(ActionEvent event) throws IOException {
         theRoot = FXMLLoader.load(getClass().getResource("/fxmls/Simpsons13Rule_Definition.fxml"));
         theStage = (Stage)((Node)event.getSource()).getScene().getWindow();
         theScene = new Scene(theRoot);
         theStage.setScene(theScene);
         theStage.show();
         }
    
    public void sceneSimpsons38_Definition(ActionEvent event) throws IOException {
         theRoot = FXMLLoader.load(getClass().getResource("/fxmls/Simpsons38Rule_Definition.fxml"));
         theStage = (Stage)((Node)event.getSource()).getScene().getWindow();
         theScene = new Scene(theRoot);
         theStage.setScene(theScene);
         theStage.show();
         }

    public void sceneBisection(ActionEvent event) throws IOException {
        BisectionController bc = new BisectionController();
        bc.bisectionScene(event);
        }
    
    public void sceneFalsePosition(ActionEvent event) throws IOException {
        FalsePositionController fp = new FalsePositionController();
        fp.falsepositionScene(event);
        }
    
    

    @FXML public void fadeOpeningToHome(){
        FadeTransition fadingFX = new FadeTransition();
        fadingFX.setDuration(Duration.millis(1000));
        fadingFX.setNode(fadingPane);
        fadingFX.setFromValue(1);
        fadingFX.setToValue(0);
        fadingFX.play();
        
        fadingFX.setOnFinished((ActionEvent event) -> {
            try {
                theRoot = FXMLLoader.load(getClass().getResource("/fxmls/Home.fxml"));
                theStage = (Stage) fadingPane.getScene().getWindow();
                theScene = new Scene(theRoot);
                theStage.setScene(theScene);
            } catch (IOException ex) {
                Logger.getLogger(SceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }


    
}
     
