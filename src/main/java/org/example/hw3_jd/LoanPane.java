package org.example.hw3_jd;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


public class LoanPane extends GridPane {
    private TextField monthlyPayment;
    private TextField totalPayment;
    private TextField annualInterestRate;
    private TextField numYears;
    private TextField loanAmount;

    public LoanPane() {
        Font font = new Font(18);

        // Initializes a button.
        Button push = new Button("Calculate");
        push.setOnAction(this::processReturn);
        GridPane.setHalignment(push, HPos.RIGHT);

        // Initializes Annual Interest Rate Label.
        Label inputLabel = new Label("Annual Interest Rate:");
        inputLabel.setFont(font);
        GridPane.setHalignment(inputLabel, HPos.LEFT);

        // Initializes Number of Years label.
        Label inputLabel2 = new Label("Number of Years:");
        inputLabel2.setFont(font);
        GridPane.setHalignment(inputLabel2, HPos.RIGHT);

        // Initializes Loan amount label.
        Label inputLabel3 = new Label("Loan amount:");
        inputLabel3.setFont(font);
        GridPane.setHalignment(inputLabel3, HPos.RIGHT);

        // Initializes Monthly Payment label.
        Label outputLabel = new Label("Monthly Payment:");
        outputLabel.setFont(font);
        GridPane.setHalignment(outputLabel, HPos.RIGHT);

        // Initializes Total Payment Label.
        Label outputLabel2 = new Label("Total Payment:");
        outputLabel2.setFont(font);
        GridPane.setHalignment(outputLabel2, HPos.RIGHT);

        // Initializes Monthly Payment text box.
        monthlyPayment = new TextField();
        monthlyPayment.setFont(font);
        monthlyPayment.setPrefWidth(200);
        monthlyPayment.setAlignment(Pos.CENTER_RIGHT);

        // Initializes Total Payment text box.
        totalPayment = new TextField();
        totalPayment.setFont(font);
        totalPayment.setPrefWidth(200);
        totalPayment.setAlignment(Pos.CENTER_RIGHT);

        // Initializes Annual Interest Rate text box.
        annualInterestRate = new TextField();
        annualInterestRate.setFont(font);
        annualInterestRate.setPrefWidth(200);
        annualInterestRate.setAlignment(Pos.CENTER_RIGHT);

        // Initializes Number of Years text box.
        numYears = new TextField();
        numYears.setFont(font);
        numYears.setPrefWidth(200);
        numYears.setAlignment(Pos.CENTER_RIGHT);

        // Initializes Loan Amount text box.
        loanAmount = new TextField();
        loanAmount.setFont(font);
        loanAmount.setPrefWidth(200);
        loanAmount.setAlignment(Pos.CENTER_RIGHT);

        // Determines spacing.
        setAlignment(Pos.CENTER);
        setHgap(20);
        setVgap(10);
        //Sets background color to white.
        setStyle("-fx-background-color: #ffffff");

        // Adding textboxes and labels to the grid pane.
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
        add(push, 1, 5);

    }

    public void processReturn(ActionEvent event)
    {
        // Initialize intRate to annualInterestRate TextField.
        double intRate = Double.parseDouble(annualInterestRate.getText());
        // Initializes years to numYears TextField.
        int years = Integer.parseInt(numYears.getText());
        // Initializes amountBorrowed to loanAmount TextField.
        double amountBorrowed = Double.parseDouble(loanAmount.getText());

        // Determines monthly payment.
        double monthlyPaymentFinal = monthlyPaymentCalculation(intRate, years, amountBorrowed);
        // Determines amount needed to be payed.
        double totalPaymentFinal = totalPaymentCalculation(intRate, years, amountBorrowed);

        // Formats the string to 2 decimal places.
        String payment = String.format( "%.2f", monthlyPaymentFinal);
        // Formats the string to 2 decimal places.
        String entirePayment = String.format( "%.2f", totalPaymentFinal);

        // Changes the monthlyPayment TextField to the monthly payment and adds a dollar sign.
        monthlyPayment.setText("$" + payment);
        // Changes the totalPayment TextField to the total payment and adds a dollar sign.
        totalPayment.setText("$" + entirePayment);

    }

    public double monthlyPaymentCalculation(double interestRate, int years, double amountBorrowed){
        // Initializes monthly interest rate from the percentage yearly interest rate.
        double r = interestRate / 12 / 100;
        double P = amountBorrowed;
        // number of months of the loan.
        double n = years * 12;

        // Formula to calculate the monthly payment.
        return (P * r * Math.pow((1 + r), n)) / ((Math.pow((1 + r), n)) - 1 );

    }

    public double totalPaymentCalculation(double interestRate, int years, double amountBorrowed){
        // Total payment calculated from each monthly payment multiplied by the number of months.
        double totalPayment = years * 12 * monthlyPaymentCalculation(interestRate, years, amountBorrowed);

        return totalPayment;

    }

}


