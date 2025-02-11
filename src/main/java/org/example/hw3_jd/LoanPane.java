package org.example.hw3_jd;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import static java.lang.Float.parseFloat;

public class LoanPane extends GridPane {
    private TextField monthlyPayment;
    private TextField totalPayment;
    private TextField annualInterestRate;
    private TextField numYears;
    private TextField loanAmount;

    public LoanPane() {
        Font font = new Font(18);

        Label inputLabel = new Label("Annual Interest Rate:");
        inputLabel.setFont(font);
        GridPane.setHalignment(inputLabel, HPos.RIGHT);

        Label inputLabel2 = new Label("Number of Years:");
        inputLabel2.setFont(font);
        GridPane.setHalignment(inputLabel2, HPos.RIGHT);

        Label inputLabel3 = new Label("Loan amount:");
        inputLabel3.setFont(font);
        GridPane.setHalignment(inputLabel3, HPos.RIGHT);

        Label outputLabel = new Label("Monthly Payment:");
        outputLabel.setFont(font);
        GridPane.setHalignment(outputLabel, HPos.RIGHT);

        Label outputLabel2 = new Label("Total Payment:");
        outputLabel2.setFont(font);
        GridPane.setHalignment(outputLabel2, HPos.RIGHT);

        monthlyPayment = new TextField();
        monthlyPayment.setFont(font);
        monthlyPayment.setPrefWidth(200);
        monthlyPayment.setAlignment(Pos.CENTER);
        monthlyPayment.setOnAction(this::processReturn);

        totalPayment = new TextField();
        totalPayment.setFont(font);
        totalPayment.setPrefWidth(200);
        totalPayment.setAlignment(Pos.CENTER);
        totalPayment.setOnAction(this::processReturn);

        annualInterestRate = new TextField();
        annualInterestRate.setFont(font);
        annualInterestRate.setPrefWidth(200);
        annualInterestRate.setAlignment(Pos.CENTER);
        annualInterestRate.setOnAction(this::processReturn);

        numYears = new TextField();
        numYears.setFont(font);
        numYears.setPrefWidth(200);
        numYears.setAlignment(Pos.CENTER);
        numYears.setOnAction(this::processReturn);

        loanAmount = new TextField();
        loanAmount.setFont(font);
        loanAmount.setPrefWidth(200);
        loanAmount.setAlignment(Pos.CENTER);
        loanAmount.setOnAction(this::processReturn);

        setAlignment(Pos.CENTER);
        setHgap(20);
        setVgap(10);
        setStyle("-fx-background-color: #ffffff");

        add(inputLabel, 0, 0);
        add(annualInterestRate, 1, 0);
        add(inputLabel2, 0, 1);
        add(numYears, 1, 1);
        add(inputLabel3, 0, 2);
        add(loanAmount, 1, 2);
        add(outputLabel, 0, 3);
        add(monthlyPayment, 1, 3);
        add(outputLabel2, 0, 4);
        add(totalPayment, 1, 4);
    }

    public void processReturn(ActionEvent event)
    {
        double intRate = Double.parseDouble(annualInterestRate.getText());
        int years = Integer.parseInt(annualInterestRate.getText());
        double amountBorrowed = Double.parseDouble(annualInterestRate.getText());

        double monthlyPaymentFinal = monthlyPaymentCalculation(intRate, years, amountBorrowed);
        double totalPaymentFinal = totalPaymentCalculation(intRate, years, amountBorrowed);

        monthlyPayment.setText(monthlyPaymentFinal + "");
        totalPayment.setText(totalPaymentFinal + "");

    }

    public double monthlyPaymentCalculation(double interestRate, int years, double amountBorrowed){
        double payment = 0;



        return payment;

    }

    public double totalPaymentCalculation(double interestRate, int years, double amountBorrowed){
        return 0;

    }

}


