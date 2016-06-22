import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TitleChanger extends JFrame implements ActionListener{
    JButton b1;
    JButton b2;

    TitleChanger(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        b1=new JButton("Rosen");
        b2=new JButton("Guilden");
        b1.addActionListener(this);
        b2.addActionListener(this);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        Object source=e.getSource();
        if(source==b1){
            setTitle("Rosen");
        }else{
            setTitle("Guilden");
        }
        repaint();
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
        new TitleChanger();
    }
}