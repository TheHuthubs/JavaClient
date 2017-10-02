package parsers;

import graphicInterface.MainFrame;

import javax.swing.*;
import java.awt.*;

public class LedsActionParser
{
    public Integer getLedNumberToTurnOn(JTextField ledNumberToTurnOnInput)
    {

        int ledToTurnOn = Integer.valueOf(ledNumberToTurnOnInput.getText());
        // we have only 4 leds installed in arduino board, let's check
        if ( ledToTurnOn > 0 && ledToTurnOn < 5 ) {
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
}
