import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FeedBar extends JFrame{
    FeedBar(){
        super("FeedBar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        JButton load=new JButton("Load");
        JButton save=new JButton("Save");
        JButton subscribe=new JButton("Subscribe");
        JButton unsubscribe=new JButton("Unsubscribe");
        JToolBar bar=new JToolBar();
        bar.add(save);
        bar.add(load);
        bar.add(subscribe);
        bar.add(unsubscribe);
        JTextArea edit=new JTextArea(8,40);
        JScrollPane scroll=new JScrollPane(edit);
        BorderLayout bord=new BorderLayout();
        setLayout(bord);
        add("South",bar);
        add("Center",scroll);
        pack();
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
        new FeedBar();
    }
}