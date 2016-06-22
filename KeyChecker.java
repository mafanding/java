import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyChecker extends JFrame{
    JLabel keyLabel=new JLabel("Key");

    KeyChecker(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,200);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        KeyMonitor monitor=new KeyMonitor(this);
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
        new KeyChecker();
    }
}

class KeyMonitor extends KeyAdapter{
    KeyChecker display;

    KeyMonitor(KeyChecker display){
        this.display=display;
    }

    public void keyTyped(KeyEvent e){
        display.keyLabel.setText(" "+e.getKeyChar());
        display.repaint();
    }
}