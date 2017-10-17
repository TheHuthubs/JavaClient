package utils;

import javax.swing.*;

public class Cracker {

    private static final int LED_ON_SUFFIX = 1;
    private static final int MULTIPLE_FACTOR = 10;

    /**
     * For turning ON the led, we will send the led number + suffix 1:
     * For turning led 10 we will send --> 101
     *
     * For turning OFF the led, we will send the led number + suffix 0:
     * For turning led 10 we will send --> 100
     *
     */


    // Returning on led
    public static int getLedNumberToTurnOn(JCheckBox ledCheckBox) {
        String checkBoxString = ledCheckBox.getText();
        String ledNumber = checkBoxString.substring(checkBoxString.lastIndexOf(" ") + 1);
        int ledNumberToLigh = Integer.valueOf(ledNumber);

        return ( ledNumberToLigh * MULTIPLE_FACTOR) + LED_ON_SUFFIX;
    }

    // Returning off led
    public static int getLedNumberToTurnOff(JCheckBox ledCheckBox) {
        String checkBoxString = ledCheckBox.getText();
        String ledNumber = checkBoxString.substring(checkBoxString.lastIndexOf(" ") + 1);
        int ledNumberToLigh = Integer.valueOf(ledNumber);

        return ( ledNumberToLigh * MULTIPLE_FACTOR );
    }
}