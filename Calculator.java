import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements FocusListener{
    JTextField v1,v2,sum;
    JLabel plus,equals;

    Calculator(){
        super();
        setSize(350,90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        v1=new JTextField("0",5);
        v2=new JTextField("0",5);
        plus=new JLabel("+");
        equals=new JLabel("=");
        sum=new JTextField("0",5);
        v1.addFocusListener(this);
        v2.addFocusListener(this);
        sum.setEnabled(false);
        add(v1);
        add(plus);
        add(v2);
        add(equals);
        add(sum);
        setVisible(true);
    }

    public void focusGained(FocusEvent e){
        try{
            float total=Float.parseFloat(v1.getText())+Float.parseFloat(v2.getText());
            sum.setText(""+total);
        }catch(NumberFormatException nef){
            v1.setText("0");
            v2.setText("0");
            sum.setText("0");
        }
    }

    public void focusLost(FocusEvent e){
        focusGained(e);
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
        new Calculator();
    }
}