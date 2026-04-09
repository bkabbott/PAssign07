package keypad;

import javafx.scene.control.Button;

/**
 * StyledKeyPadPane - extends KeyPadPane with ATM-style button styling.
 */
public class StyledKeyPadPane extends KeyPadPane {

    private static final String BTN_STYLE =
        "-fx-background-color: #3c3c3c;" +
        "-fx-text-fill: #e0e0e0;" +
        "-fx-font-size: 15px;" +
        "-fx-font-weight: bold;" +
        "-fx-border-color: #222;" +
        "-fx-border-width: 1;" +
        "-fx-min-width: 55px;" +
        "-fx-min-height: 45px;" +
        "-fx-background-radius: 4;";

    private static final String BLANK_STYLE =
        "-fx-background-color: #222222;" +
        "-fx-text-fill: #222222;" +
        "-fx-border-color: #1a1a1a;" +
        "-fx-min-width: 55px;" +
        "-fx-min-height: 45px;" +
        "-fx-background-radius: 4;";

    public StyledKeyPadPane() {
        super(); // ATM layout
        for (Button b : listButtons) {
            b.setStyle(BTN_STYLE);
        }
        btnBlank1.setStyle(BLANK_STYLE);
        btnBlank2.setStyle(BLANK_STYLE);
        this.setHgap(6);
        this.setVgap(6);
    }
}
