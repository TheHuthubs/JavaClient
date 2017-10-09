package parsers;

import javax.swing.*;

public class LedsActionParser {

    public Integer getLedNumberToTurnOn(JTextField ledNumberToTurnOnInput) {

        try {
                int ledToTurnOn = Integer.parseInt(ledNumberToTurnOnInput.getText());
                // we have only 4 leds installed in Arduino board (10,11,12,13), let's check
                if (ledToTurnOn > 9 && ledToTurnOn < 14)
                {
                    System.out.println("going to turn led number: " + ledToTurnOn);
                    return ledToTurnOn;
                }
                else
                {
                System.out.println("Led number is not exist in arduino board!!");
                //todo: can popup a new window with a relevant error message
                return null;
                }
            }
            catch (NumberFormatException ex)
            {
                System.out.println("Only integer numbers between 10 to 13 allow here");
                return null;
            }
    }
}
