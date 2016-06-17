import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class FeedInfo extends JFrame{
    private JLabel nameLabel=new JLabel("Name: ",SwingConstants.RIGHT);
    private JTextField name;
    private JLabel urlLabel=new JLabel("URL: ",SwingConstants.RIGHT);
    private JTextField url;
    private JLabel typeLabel=new JLabel("Type: ",SwingConstants.RIGHT);
    private JTextField type;

    FeedInfo(){
        super("FeedInfo");
        setSize(400,145);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        String response1=JOptionPane.showInputDialog(null,"Enter the site name:");
        name=new JTextField(response1,20);
        String response2=JOptionPane.showInputDialog(null,"Enter the site address: ");
        url=new JTextField(response2,20);
        String[] choice={"Personal","Commercial","Unknown"};
        int response3=JOptionPane.showOptionDialog(null, "What type of site is it?", "Site type", 0, JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);
        type=new JTextField(choice[response3],20);

        setLayout(new GridLayout(3,2));
        add(nameLabel);
        add(name);
        add(urlLabel);
        add(url);
        add(typeLabel);
        add(type);
        setLookAndFeel();
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
        new FeedInfo();
    }
}