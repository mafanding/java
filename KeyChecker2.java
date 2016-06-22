import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyChecker2 extends JFrame {
    JLabel keyLabel=new JLabel("key");

    KeyChecker2(){
        super();
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        KeyAdapter monitor=new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                keyLabel.setText(""+e.getKeyChar());
                repaint();
            }
        };
        setFocusable(true);
        addKeyListener(monitor);
        add(keyLabel);
        setVisible(true);
    }

    private static void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        setLookAndFeel();
        new KeyChecker2();
    }
}