import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Alphabet extends JFrame{
    Alphabet(){
        super("Alphabet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(360,120);
        FlowLayout lm=new FlowLayout(FlowLayout.LEFT);
        setLayout(lm);
        JButton a=new JButton("Alibi");
        JButton b=new JButton("Burglar");
        JButton c=new JButton("Corpse");
        JButton d=new JButton("Deadbeat");
        JButton e=new JButton("Evidence");
        JButton f=new JButton("Fugitive");
        add(a);
        add(b);
        add(c);
        add(e);
        add(f);
        setVisible(true);
    }

    private void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        new Alphabet();
    }
}