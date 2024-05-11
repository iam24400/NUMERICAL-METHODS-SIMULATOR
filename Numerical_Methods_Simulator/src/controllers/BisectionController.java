package controllers;

import bisection_methods.BisectionCalculate;
import bisection_methods.BisectionTable;
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


public class BisectionController implements Initializable{
    
    @Override public void initialize(URL url, ResourceBundle rb) {}
     
    @FXML private Stage theStage;
    @FXML private Scene theScene;
    @FXML private Parent theRoot;
    @FXML private Label label_fx1;
    @FXML private Label label_xLU1;
    @FXML private Label label_Es1;
    @FXML private Label label_string1;
    @FXML private TextField textField_A1;
    @FXML private TextField textField_B1;
    @FXML private TextField textField_C1;
    @FXML private TextField textField_D1;
    @FXML private TextField textField_xL1;
    @FXML private TextField textField_xU1;
    @FXML private TextField textField_Es1;
    @FXML private TableView<BisectionTable> table_Bisection1;
    @FXML private TableColumn<BisectionTable, Double> column_Iteration1;
    @FXML private TableColumn<BisectionTable, Double> column_xL1;
    @FXML private TableColumn<BisectionTable, Double> column_xM1;
    @FXML private TableColumn<BisectionTable, Double> column_xU1;
    @FXML private TableColumn<BisectionTable, Double> column_FxL1;
    @FXML private TableColumn<BisectionTable, Double> column_FxM1;
    @FXML private TableColumn<BisectionTable, Double> column_FxU1;
    @FXML private TableColumn<BisectionTable, Double> column_Ea1;
    private SceneController sc  = new SceneController();
    
    @FXML public void goHome(ActionEvent event) throws IOException{
        sc.sceneHome(event); 
    }
    
    @FXML public void goBack(ActionEvent event) throws IOException{
        sc.sceneBisection_Definition(event); 
    }
    
    @FXML public void bisectionScene(ActionEvent event) throws IOException{
        theRoot = FXMLLoader.load(getClass().getResource("/fxmls/Bisection_Inputs.fxml"));
        theStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        theScene = new Scene(theRoot);
        theStage.setScene(theScene);
        theStage.show();
    }
        
    
    @FXML public void confirmButton() {
        
        try{
            String text_A = textField_A1.getText();
            String text_B = textField_B1.getText();
            String text_C = textField_C1.getText();
            String text_D = textField_D1.getText();
            String text_xL = textField_xL1.getText();
            String text_xU = textField_xU1.getText();
            String text_Es = textField_Es1.getText();
            
            double A = Double.parseDouble(text_A);
            double B = Double.parseDouble(text_B);
            double C = Double.parseDouble(text_C);
            double D = Double.parseDouble(text_D);
            double xL = Double.parseDouble(text_xL);
            double xU = Double.parseDouble(text_xU);
            double Es = Double.parseDouble(text_Es);
            
            label_fx1.setText("f(x)  =  (" + text_A +")x^3  +  ("+ text_B +")x^2  +  ("+ text_C +")x  +  ("+ text_D +")");   
            label_xLU1.setText("xL  =  " + text_xL +"\t\txU  =  "+ text_xU);
            label_Es1.setText("Es  =  " + text_Es + "%");

            BisectionCalculate BC = new BisectionCalculate();
            BC.runBracketingMethods(A, B, C, D, xL, xU, Es);
            int iter = BC.getNum_iter();
            Double[][] bcArr = BC.getTableList();

            column_Iteration1.setCellValueFactory(new PropertyValueFactory<BisectionTable, Double>("column_Iteration1"));
            column_xL1.setCellValueFactory(new PropertyValueFactory<BisectionTable, Double>("column_xL1"));
            column_xM1.setCellValueFactory(new PropertyValueFactory<BisectionTable, Double>("column_xM1"));
            column_xU1.setCellValueFactory(new PropertyValueFactory<BisectionTable, Double>("column_xU1"));
            column_FxL1.setCellValueFactory(new PropertyValueFactory<BisectionTable, Double>("column_FxL1"));
            column_FxM1.setCellValueFactory(new PropertyValueFactory<BisectionTable, Double>("column_FxM1"));
            column_FxU1.setCellValueFactory(new PropertyValueFactory<BisectionTable, Double>("column_FxU1"));
            column_Ea1.setCellValueFactory(new PropertyValueFactory<BisectionTable, Double>("column_Ea1"));

            table_Bisection1.setItems(BisectionList(iter, bcArr));

        } catch (Exception e){
            label_string1.setText("Error! Please enter numbers only or fill up all text field before confirming...");
        }
    }
                 
    public ObservableList<BisectionTable>  BisectionList(int iter, Double[][] bcArr){
        
        ObservableList<BisectionTable> BisecList = FXCollections.observableArrayList();
        for (int i = 0; i < iter; i++){     
                BisecList.add(new BisectionTable(bcArr[i][0], bcArr[i][1], bcArr[i][2], 
                        bcArr[i][3], bcArr[i][4], bcArr[i][5], bcArr[i][6], bcArr[i][7]));
            }
    
        return BisecList;
    }
     
}
