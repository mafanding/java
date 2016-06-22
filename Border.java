import java.awt.*;
import javax.swing.*;

public class Border extends JFrame{
    Border(){
        super("Border");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(240,280);
        setLookAndFeel();
        setLayout(new BorderLayout());
        JButton nButton=new JButton("North");
        JButton sButton=new JButton("South");
        JButton wButton=new JButton("West");
        JButton eButton=new JButton("East");
        JButton cButton=new JButton("Center");
        add(nButton,BorderLayout.NORTH);
        add(sButton,BorderLayout.SOUTH);
        add(eButton,BorderLayout.EAST);
        add(wButton,BorderLayout.WEST);
        add(cButton,BorderLayout.CENTER);
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
        new Border();
    }
}