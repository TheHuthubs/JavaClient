package utils;

import javax.swing.*;

public class Cracker {

    public static int getLedNumberToTurnOn(JCheckBox ledCheckBox) {
        String checkBoxString = ledCheckBox.getText();
        String ledNumber = checkBoxString.substring(checkBoxString.lastIndexOf(" ") + 1);
        int ledNumberToLigh = Integer.valueOf(ledNumber);

        return ledNumberToLigh;
    }

}