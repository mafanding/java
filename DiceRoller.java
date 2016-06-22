import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

public class DiceRoller extends JFrame implements ActionListener,PropertyChangeListener{
    JTextField[] total=new JTextField[16];
    JButton roll;
    JTextField quantity;
    DiceWorker worker;

    DiceRoller(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(850,145);
        JPanel topPanel=new JPanel();
        topPanel.setLayout(new GridLayout(1,16));
        for(int i=0;i<16;i++){
            total[i]=new JTextField("0",4);
            JLabel label=new JLabel((i+3)+": ");
            JPanel cell=new JPanel();
            cell.add(label);
            cell.add(total[i]);
            topPanel.add(cell);
        }
        JPanel bottomPanel=new JPanel();
        JLabel quantityLabel=new JLabel("Times To roll:");
        quantity=new JTextField("0",5);
        roll=new JButton("Roll");
        roll.addActionListener(this);
        bottomPanel.add(quantityLabel);
        bottomPanel.add(quantity);
        bottomPanel.add(roll);
        setLayout(new GridLayout(2,1));
        add(topPanel);
        add(bottomPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        int timesToRoll;
        try{
            timesToRoll=Integer.parseInt(quantity.getText());
            worker=new DiceWorker(timesToRoll);
            worker.addPropertyChangeListener(this);
            worker.execute();
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void propertyChange(PropertyChangeEvent e){
        try{
            int[] result=(int[])worker.get();
            for(int i=0;i<result.length;i++){
                total[i].setText(""+result[i]);
            }
        }catch(Exception ex){
                System.out.println(ex.getMessage());
                ex.printStackTrace();
        }
    }

    private static void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception e){

        }
    }

    public static void main(String[] args){
        new DiceRoller();
    }
}