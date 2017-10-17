package graphicInterface;

import ledActions.LightLeds;
import utils.Cracker;
import utils.MessageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.util.Map;

public class MainFrame
{

    // Creates a check box with text and specifies whether or not it is initially selected.
    public JCheckBox ledCheckBox10 = new JCheckBox("Led 10", false);
    public JCheckBox ledCheckBox11 = new JCheckBox("Led 11", false);
    public JCheckBox ledCheckBox12 = new JCheckBox("Led 12", false);
    public JCheckBox ledCheckBox13 = new JCheckBox("Led 13", false);
    // creating an array for looping over in order to create an action listener for each checkBox
    public JCheckBox ledsArray[] = {ledCheckBox10,ledCheckBox11,ledCheckBox12,ledCheckBox13};

    LightLeds lightLeds = new LightLeds();


    public MainFrame() {
        this.createMainFrame();
    }

    public void createMainFrame() {

        JFrame frame = new JFrame(MessageUtil.WELCOME_TO_ARDUINO);
        JLabel mainLabel = new JLabel(MessageUtil.ARDUINO_LED_SERVER_APP);
        JLabel commandLabel  = new JLabel(MessageUtil.WHICH_LED_TO_LIGHT);
        Font mainLableFont = new Font("Courier", Font.BOLD ,40);
        Font commandLineFont = new Font("Courier", Font.BOLD,25);
        JPanel checkBoxPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();


        // Building the main window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().add(checkBoxPanel);
        // setting windows look-N-feel
        JFrame.setDefaultLookAndFeelDecorated(true);

        // handling text attributes
        Map mainLableFontAttributes = mainLableFont.getAttributes();
        mainLabel.setForeground(Color.BLUE);
        mainLableFontAttributes.put(TextAttribute.UNDERLINE,TextAttribute.UNDERLINE_ON);
        mainLabel.setFont(mainLableFont.deriveFont(mainLableFontAttributes));

        Map commandLableFontAttributes = commandLineFont.getAttributes();
        commandLabel.setFont(commandLineFont.deriveFont(commandLableFontAttributes));


        // Manage the constraints
        constraints.insets = new Insets(30, 10, 30, 10);

        // Let's add some components to the panel

        // adding main label (title) to panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        checkBoxPanel.add(mainLabel,constraints);

        // adding led choice title to panel
        constraints.gridx = 0;
        constraints.gridy = 1;
        checkBoxPanel.add(commandLabel,constraints);

        // adding Led 10 to panel
        constraints.gridx = 0;
        constraints.gridy = 2;
        ledCheckBox10.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent checkBoxEvent) {
                try {
                    ledChackBoxStateChanged(checkBoxEvent);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        checkBoxPanel.add(ledCheckBox10,constraints);

        // adding Led 11 to panel
        constraints.gridx = 0;
        constraints.gridy = 3;
        ledCheckBox11.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent checkBoxEvent) {
                try {
                    ledChackBoxStateChanged(checkBoxEvent);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        checkBoxPanel.add(ledCheckBox11,constraints);

        // adding Led 12 to panel
        constraints.gridx = 0;
        constraints.gridy = 4;
        ledCheckBox12.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent checkBoxEvent) {
                try {
                    ledChackBoxStateChanged(checkBoxEvent);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        checkBoxPanel.add(ledCheckBox12,constraints);

        // adding Led 13 to panel
        constraints.gridx = 0;
        constraints.gridy = 5;
            ledCheckBox13.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent checkBoxEvent) {
                    try {
                        ledChackBoxStateChanged(checkBoxEvent);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
        checkBoxPanel.add(ledCheckBox13,constraints);

        // Let's packing all together
        frame.pack();

    }

    public void ledChackBoxStateChanged(ItemEvent e) throws IOException, ClassNotFoundException {

        Object ledSource = e.getItemSelectable();
        for (int ledNumber = 0; ledNumber < 4; ledNumber++ ) {

            if (ledSource == ledsArray[ledNumber])
            {
                // SELECTED - turn on led
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    lightLeds.setNumberOfLedsToLight(Cracker.getLedNumberToTurnOn(ledsArray[ledNumber]));
                    lightLeds.createClient();
                }
                else // DESELECTED - turn off led
                {
                lightLeds.setNumberOfLedsToLight(Cracker.getLedNumberToTurnOff(ledsArray[ledNumber]));
                lightLeds.createClient();
                }
            }
        }
    }
}