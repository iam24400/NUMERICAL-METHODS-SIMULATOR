package controllers;

import falseposition_methods.FalsePositionCalculate;
import falseposition_methods.FalsePositionTable;       
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class FalsePositionController implements Initializable{
    
    @Override public void initialize(URL url, ResourceBundle rb) {}
     
    @FXML private Stage theStage;
    @FXML private Scene theScene;
    @FXML private Parent theRoot;
    @FXML private Label label_fx2;
    @FXML private Label label_xLU2;
    @FXML private Label label_Es2;
    @FXML private Label label_string2;
    @FXML private TextField textField_A2;
    @FXML private TextField textField_B2;
    @FXML private TextField textField_C2;
    @FXML private TextField textField_D2;
    @FXML private TextField textField_xL2;
    @FXML private TextField textField_xU2;
    @FXML private TextField textField_Es2;
    @FXML private TableView<FalsePositionTable> table_Bisection2;
    @FXML private TableColumn<FalsePositionTable, Double> column_Iteration2;
    @FXML private TableColumn<FalsePositionTable, Double> column_xL2;
    @FXML private TableColumn<FalsePositionTable, Double> column_xM2;
    @FXML private TableColumn<FalsePositionTable, Double> column_xU2;
    @FXML private TableColumn<FalsePositionTable, Double> column_FxL2;
    @FXML private TableColumn<FalsePositionTable, Double> column_FxM2;
    @FXML private TableColumn<FalsePositionTable, Double> column_FxU2;
    @FXML private TableColumn<FalsePositionTable, Double> column_Ea2;
    private SceneController sc  = new SceneController();
    
    @FXML public void goHome2(ActionEvent event) throws IOException{
        sc.sceneHome(event); 
    }
    
    @FXML public void goBack2(ActionEvent event) throws IOException{
        sc.sceneBisection_Definition(event); 
    }
    
    @FXML public void falsepositionScene(ActionEvent event) throws IOException{
        theRoot = FXMLLoader.load(getClass().getResource("/fxmls/FalsePosition_Inputs.fxml"));
        theStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        theScene = new Scene(theRoot);
        theStage.setScene(theScene);
        theStage.show();
    }
        
    
    @FXML public void confirmButton2() {
        
        try{
            String text_A = textField_A2.getText();
            String text_B = textField_B2.getText();
            String text_C = textField_C2.getText();
            String text_D = textField_D2.getText();
            String text_xL = textField_xL2.getText();
            String text_xU = textField_xU2.getText();
            String text_Es = textField_Es2.getText();
            
            double A = Double.parseDouble(text_A);
            double B = Double.parseDouble(text_B);
            double C = Double.parseDouble(text_C);
            double D = Double.parseDouble(text_D);
            double xL = Double.parseDouble(text_xL);
            double xU = Double.parseDouble(text_xU);
            double Es = Double.parseDouble(text_Es);

            label_fx2.setText("f(x)  =  " + text_A +"x^3  +  "+ text_B +"x^2  +  "+ text_C +"x  +  "+ text_D);
            label_xLU2.setText("xL  =  " + text_xL +"\t\txU  =  "+ text_xU);
            label_Es2.setText("Es  =  " + text_Es + "%");

            FalsePositionCalculate FPC = new FalsePositionCalculate();
            FPC.runBracketingMethods(A, B, C, D, xL, xU, Es);
            int iter2 = FPC.getNum_iter();
            Double[][] bcArr2 = FPC.getTableList();

            column_Iteration2.setCellValueFactory(new PropertyValueFactory<FalsePositionTable, Double>("column_Iteration2"));
            column_xL2.setCellValueFactory(new PropertyValueFactory<FalsePositionTable, Double>("column_xL2"));
            column_xM2.setCellValueFactory(new PropertyValueFactory<FalsePositionTable, Double>("column_xM2"));
            column_xU2.setCellValueFactory(new PropertyValueFactory<FalsePositionTable, Double>("column_xU2"));
            column_FxL2.setCellValueFactory(new PropertyValueFactory<FalsePositionTable, Double>("column_FxL2"));
            column_FxM2.setCellValueFactory(new PropertyValueFactory<FalsePositionTable, Double>("column_FxM2"));
            column_FxU2.setCellValueFactory(new PropertyValueFactory<FalsePositionTable, Double>("column_FxU2"));
            column_Ea2.setCellValueFactory(new PropertyValueFactory<FalsePositionTable, Double>("column_Ea2"));

            table_Bisection2.setItems(FalsePositionList(iter2, bcArr2));

        } catch (Exception e){
            label_string2.setText("Error! Please enter numbers only or fill up all text field before confirming...");
        }  
    }
                 
    public ObservableList<FalsePositionTable>  FalsePositionList(int iter2, Double[][] bcArr2){
        
        ObservableList<FalsePositionTable> fpList = FXCollections.observableArrayList();
        for (int i = 0; i < iter2; i++){     
                fpList.add(new FalsePositionTable(bcArr2[i][0], bcArr2[i][1], bcArr2[i][2], 
                        bcArr2[i][3], bcArr2[i][4], bcArr2[i][5], bcArr2[i][6], bcArr2[i][7]));
            }
    
        return fpList;
    }
    
}
