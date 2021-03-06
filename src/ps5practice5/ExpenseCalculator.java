package ps5practice5;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Create a GUI Java FX application that implements a monthly expense
 * calculator. See the attached image for the screen design.
 *
 * @author Your Name Here
 */
public class ExpenseCalculator extends Application {

    private TextField tfRent, tfUtilities, tfFood, tfOther, tfTotal;

    @Override
    public void start(Stage primaryStage) {

        Text txTitle = new Text("Expense Calculator");
        txTitle.setStyle("-fx-font-size: 28pt;");
        HBox hBoxTitle = new HBox();
        hBoxTitle.setAlignment(Pos.CENTER);
        hBoxTitle.getChildren().add(txTitle);

        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-hgap: 10; -fx-vgap: 10; -fx-padding: 20; -fx-alignment: center;");

        Label lbMonth = new Label("Month Name");
        lbMonth.setStyle("-fx-font-size: 14pt;");
        gridPane.add(lbMonth, 0, 0);

        ObservableList<String> options = FXCollections.observableArrayList(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
        final ComboBox comboBox = new ComboBox(options);
        gridPane.add(comboBox, 1, 0);
//------------------------------------------------------------------------------
        Label lbRent = new Label("Rent");
        lbRent.setStyle("-fx-font-size: 14pt;");
        gridPane.add(lbRent, 0, 1);

        tfRent = new TextField();
        tfRent.setAlignment(Pos.BASELINE_RIGHT);
        gridPane.add(tfRent, 1, 1);
//------------------------------------------------------------------------------
        Label lbUtilities = new Label("Utilities");
        lbUtilities.setStyle("-fx-font-size: 14pt;");
        gridPane.add(lbUtilities, 0, 2);

        tfUtilities = new TextField();
        tfUtilities.setAlignment(Pos.BASELINE_RIGHT);
        gridPane.add(tfUtilities, 1, 2);
//------------------------------------------------------------------------------
        Label lbFood = new Label("Food");
        lbFood.setStyle("-fx-font-size: 14pt;");
        gridPane.add(lbFood, 0, 3);

        tfFood = new TextField();
        tfFood.setAlignment(Pos.BASELINE_RIGHT);
        gridPane.add(tfFood, 1, 3);
//------------------------------------------------------------------------------
        Label lbOther = new Label("Other");
        lbOther.setStyle("-fx-font-size: 14pt;");
        gridPane.add(lbOther, 0, 4);

        tfOther = new TextField();
        tfOther.setAlignment(Pos.BASELINE_RIGHT);
        gridPane.add(tfOther, 1, 4);
//------------------------------------------------------------------------------

        Label lbTotal = new Label("Total");
        lbTotal.setStyle("-fx-font-size: 14pt;");
        gridPane.add(lbTotal, 0, 5);

        tfTotal = new TextField();
        tfTotal.setAlignment(Pos.BASELINE_RIGHT);
        tfTotal.setEditable(false);
        gridPane.add(tfTotal, 1, 5);

        Button btnCalculate = new Button();
        btnCalculate.setText("Calculate");
        btnCalculate.setStyle("-fx-font-size: 16pt; -fx-padding: 10; -fx-text-fill: #ff0000;");
        btnCalculate.setOnAction((ActionEvent e) -> calculate());
//----------------------------CLEAR BUTTON--------------------------------------
        Button btnClear = new Button("Clear");
        // TODO - add a button that when pressed will clear each of the numeric text fields
        btnClear.setStyle("-fx-font-size: 16pt; -fx-padding: 10; -fx-text-fill: black;");
        gridPane.getChildren().add(btnClear);
        btnClear.setOnAction((ActionEvent e) -> {
        tfRent.setText("");
        tfUtilities.setText("");
        tfFood.setText("");
        tfOther.setText("");
        });
//------------------------------------------------------------------------------
        HBox hBoxBtn = new HBox();
        hBoxBtn.setAlignment(Pos.CENTER);
        hBoxBtn.setSpacing(20);
        hBoxBtn.getChildren().addAll(btnClear, btnCalculate);

        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-padding: 20;");
        borderPane.setTop(hBoxTitle);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(hBoxBtn);

        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Monthly Expenses");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculate() {
        double rent, utilities, food, other, total;
        if (tfRent.getText().equals("")) {
            tfRent.setText("0.00");
        }
        if (tfUtilities.getText().equals("")) {
            tfUtilities.setText("0.00");
        }
        if (tfFood.getText().equals("")) {
            tfFood.setText("0.00");
        }
        if (tfOther.getText().equals("")) {
            tfOther.setText("0.00");
        }

        rent = Double.parseDouble(tfRent.getText());
        utilities = Double.parseDouble(tfUtilities.getText());
        food = Double.parseDouble(tfFood.getText());
        other = Double.parseDouble(tfOther.getText());

        double total1 = rent + utilities + food + other;
        tfTotal.setText(String.format("%.2f", total1));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
