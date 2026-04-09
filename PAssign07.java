/**
 * File: PAssign07.java
 * Author: Brian Abbott
 * Course: CSCI 1302 - Programming Principles II
 * Description: JavaFX ATM machine GUI using the custom KeyPadPane class.
 *
 * Hello-World GitHub tutorial: https://github.com/bkabbott/hello-world
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import keypad.StyledKeyPadPane;

public class PAssign07 extends Application {

    @Override
    public void start(Stage primaryStage) {

        // ── Outer ATM body ──────────────────────────────────────────────
        VBox atmBody = new VBox(10);
        atmBody.setPadding(new Insets(20));
        atmBody.setAlignment(Pos.CENTER);
        atmBody.setStyle(
            "-fx-background-color: #2b2b2b;" +
            "-fx-border-color: #111111;" +
            "-fx-border-width: 4;" +
            "-fx-border-radius: 12;" +
            "-fx-background-radius: 12;"
        );

        // ── Bank header ──────────────────────────────────────────────────
        Label bankName = new Label("FIRST NATIONAL BANK");
        bankName.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        bankName.setTextFill(Color.web("#f0c040"));
        bankName.setAlignment(Pos.CENTER);

        Label atmLabel = new Label("ATM");
        atmLabel.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        atmLabel.setTextFill(Color.web("#aaaaaa"));

        // ── Screen ───────────────────────────────────────────────────────
        VBox screen = new VBox(8);
        screen.setPadding(new Insets(12));
        screen.setAlignment(Pos.CENTER);
        screen.setStyle(
            "-fx-background-color: #1a3a1a;" +
            "-fx-border-color: #444;" +
            "-fx-border-width: 3;" +
            "-fx-border-radius: 4;" +
            "-fx-background-radius: 4;"
        );
        screen.setPrefSize(260, 140);

        Label welcomeMsg = new Label("Welcome");
        welcomeMsg.setFont(Font.font("Courier New", FontWeight.BOLD, 16));
        welcomeMsg.setTextFill(Color.web("#00ff44"));

        Label prompt = new Label("Please enter your PIN:");
        prompt.setFont(Font.font("Courier New", 12));
        prompt.setTextFill(Color.web("#00cc33"));

        TextField pinDisplay = new TextField("____");
        pinDisplay.setEditable(false);
        pinDisplay.setAlignment(Pos.CENTER);
        pinDisplay.setStyle(
            "-fx-background-color: #0d260d;" +
            "-fx-text-fill: #00ff44;" +
            "-fx-font-family: 'Courier New';" +
            "-fx-font-size: 20px;" +
            "-fx-border-color: #004400;" +
            "-fx-border-width: 1;"
        );
        pinDisplay.setPrefWidth(160);

        screen.getChildren().addAll(welcomeMsg, prompt, pinDisplay);

        // ── Card slot ────────────────────────────────────────────────────
        HBox cardSlotArea = new HBox(8);
        cardSlotArea.setAlignment(Pos.CENTER);

        Label cardLabel = new Label("INSERT CARD");
        cardLabel.setFont(Font.font("Arial", 10));
        cardLabel.setTextFill(Color.web("#888888"));

        Rectangle cardSlot = new Rectangle(80, 10);
        cardSlot.setFill(Color.web("#111111"));
        cardSlot.setStroke(Color.web("#555555"));
        cardSlot.setStrokeWidth(1.5);
        cardSlot.setArcWidth(4);
        cardSlot.setArcHeight(4);

        cardSlotArea.getChildren().addAll(cardLabel, cardSlot);

        // ── KeyPadPane (ATM layout, styled) ──────────────────────────────
        StyledKeyPadPane keyPad = new StyledKeyPadPane();
        keyPad.setAlignment(Pos.CENTER);

        // ── Action buttons (CLEAR / ENTER) ────────────────────────────────
        HBox actionButtons = new HBox(12);
        actionButtons.setAlignment(Pos.CENTER);

        Button clearBtn = new Button("CLEAR");
        clearBtn.setStyle(
            "-fx-background-color: #8b0000;" +
            "-fx-text-fill: white;" +
            "-fx-font-weight: bold;" +
            "-fx-min-width: 80px;" +
            "-fx-min-height: 36px;" +
            "-fx-background-radius: 4;"
        );

        Button enterBtn = new Button("ENTER");
        enterBtn.setStyle(
            "-fx-background-color: #005500;" +
            "-fx-text-fill: white;" +
            "-fx-font-weight: bold;" +
            "-fx-min-width: 80px;" +
            "-fx-min-height: 36px;" +
            "-fx-background-radius: 4;"
        );

        actionButtons.getChildren().addAll(clearBtn, enterBtn);

        // ── Cash dispenser slot ────────────────────────────────────────────
        HBox dispenserArea = new HBox(8);
        dispenserArea.setAlignment(Pos.CENTER);

        Label dispenserLabel = new Label("CASH");
        dispenserLabel.setFont(Font.font("Arial", 10));
        dispenserLabel.setTextFill(Color.web("#888888"));

        Rectangle dispenserSlot = new Rectangle(120, 14);
        dispenserSlot.setFill(Color.web("#111111"));
        dispenserSlot.setStroke(Color.web("#555555"));
        dispenserSlot.setStrokeWidth(1.5);
        dispenserSlot.setArcWidth(2);
        dispenserSlot.setArcHeight(2);

        dispenserArea.getChildren().addAll(dispenserLabel, dispenserSlot);

        // ── Assemble ATM body ─────────────────────────────────────────────
        atmBody.getChildren().addAll(
            bankName,
            atmLabel,
            screen,
            cardSlotArea,
            keyPad,
            actionButtons,
            dispenserArea
        );

        // ── Root scene ─────────────────────────────────────────────────────
        StackPane root = new StackPane(atmBody);
        root.setStyle("-fx-background-color: #1a1a1a;");
        root.setPadding(new Insets(30));

        Scene scene = new Scene(root, 380, 580);

        primaryStage.setTitle("First National Bank ATM");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
