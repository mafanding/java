import java.awt.*;
import javax.swing.*;

public class Stacker extends JFrame{
    Stacker(){
        super();
        setSize(430,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        JPanel commandPane=new JPanel();
        BoxLayout horizontal=new BoxLayout(commandPane,BoxLayout.X_AXIS);
        commandPane.setLayout(horizontal);
        JButton subscrible=new JButton("Subscrible");
        JButton unsubscrible=new JButton("Unsubscrible");
        JButton refresh=new JButton("Refresh");
        JButton save=new JButton("Save");
        commandPane.add(subscrible);
        commandPane.add(unsubscrible);
        commandPane.add(refresh);
        commandPane.add(save);
        JPanel textPane=new JPanel();
        JTextArea textArea=new JTextArea(8,40);
        JScrollPane scroll=new JScrollPane(textArea);
        FlowLayout flow=new FlowLayout();
        setLayout(flow);
        add(commandPane);
        add(scroll);
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
        new Stacker();
    }
}