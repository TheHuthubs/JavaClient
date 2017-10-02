package graphicInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

public class MainFrame implements ActionListener
{
    TextField text = new TextField(20);
    public void createMainFrame() {

        JFrame frame = new JFrame("Welcome to Arduino LED lighting application");
        JLabel mainLable = new JLabel("Arduino LED server application");
        JLabel commandLable  = new JLabel("How many LEDs would you like to light, bitch? :");
        Font mainLableFont = new Font("Courier", Font.BOLD ,40);
        Font commandLineFont = new Font("Courier", Font.BOLD,25);
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        JButton sendButton = new JButton("Send to arduino");
        JTextField commandTextField = new JTextField(15);
        GridBagConstraints constraints = new GridBagConstraints();


        // Building the main window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().add(buttonPanel);
        // setting windows look-N-feel
        JFrame.setDefaultLookAndFeelDecorated(true);

        // handling text attributes
        Map mainLableFontAttributes = mainLableFont.getAttributes();
        mainLable.setForeground(Color.BLUE);
        mainLableFontAttributes.put(TextAttribute.UNDERLINE,TextAttribute.UNDERLINE_ON);
        mainLable.setFont(mainLableFont.deriveFont(mainLableFontAttributes));

        Map commandLableFontAttributes = commandLineFont.getAttributes();
        commandLable.setFont(commandLineFont.deriveFont(commandLableFontAttributes));


        // Building buttons,
        sendButton.setSize(200,50);
        sendButton.setVerticalTextPosition(AbstractButton.CENTER);
        sendButton.setHorizontalTextPosition(AbstractButton.LEADING);
        sendButton.setVisible(true);
        // setting an action listener to the button so it can detect a click
        sendButton.addActionListener(this);


        // Manage the constraints
        //constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(30, 10, 30, 10);

        // Let's add some components to the panel

        // adding command line text label
        constraints.gridx = 0;
        constraints.gridy = 0;
        buttonPanel.add(mainLable,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        buttonPanel.add(commandLable,constraints);

        // adding command line window
        constraints.gridx = 2;
        buttonPanel.add(commandTextField,constraints);

        // adding send button
        constraints.gridx = 3;
        constraints.gridy = 1;
        buttonPanel.add(sendButton,constraints);


        // Let's packing all together
        frame.pack();

    }

        public void actionPerformed(ActionEvent e) {
            // todo: write the code which send the command to the server
            System.out.println("Sending to arduino ");
        }

}