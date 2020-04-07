package com.company;
//Sean Gorham 2020

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class GUI extends JFrame implements ActionListener{
    private Container C;
    private JLabel title;
    private JLabel whatToDecrypt;
    private JTextField decrypt;
    private JLabel decyphered;
    private JTextArea message;
    private JButton submit;
    private JButton reset;
    private JLabel name;

    public void myGUI(){
        setTitle("Caesar Cipher");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        C = getContentPane();
        C.setLayout(null);

        title = new JLabel("Caesar Cipher");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300,30);
        title.setLocation(300, 30);
        C.add(title);

        whatToDecrypt = new JLabel("Message to decipher");
        whatToDecrypt.setFont((new Font("Arial", Font.PLAIN, 20)));
        whatToDecrypt.setSize(200,30);
        whatToDecrypt.setLocation(100,100);
        C.add(whatToDecrypt);

        decrypt = new JTextField();
        decrypt.setFont(new Font("Arial", Font.PLAIN, 20));
        decrypt.setSize(190, 30);
        decrypt.setLocation(300,100);
        C.add(decrypt);

        decyphered = new JLabel("Deciphered text");
        decyphered.setFont(new Font("Arial", Font.PLAIN, 20));
        decyphered.setSize(200, 30);
        decyphered.setLocation(100, 200);
        C.add(decyphered);

        message = new JTextArea();
        message.setFont(new Font("Arial", Font.PLAIN, 20));
        message.setSize(500, 250);
        message.setLocation(300, 200);
        message.setLineWrap(true);
        C.add(message);

        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN, 20));
        submit.setSize(100,100);
        submit.setLocation(150, 450);
        submit.addActionListener(this);
        C.add(submit);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 20));
        reset.setSize(100,100);
        reset.setLocation(400, 450);
        reset.addActionListener(this);
        C.add(reset);

        name = new JLabel("Sean Gorham 2020");
        name.setFont(new Font("Arial", Font.PLAIN, 10));
        name.setSize(100,100);
        name.setLocation(600, 500);
        C.add(name);



        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submit){
            if(decrypt.getText().equals("")){
                message.setText("Please input a message to decipher");
            }
            //TO DO add the Caesar Cipher here
            Cipher myCipher = new Cipher();
            message.setText(myCipher.caesarCipher(decrypt.getText()));

        }else if(e.getSource() == reset){
            String def = "";
            decrypt.setText(def);
            message.setText(def);

        }
    }
}
