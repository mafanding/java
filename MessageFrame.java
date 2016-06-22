import javax.swing.*;

public class MessageFrame extends JFrame{
    MessageFrame(){
        super();
        setSize(380,120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        MessagePanel mpane=new MessagePanel();
        add(mpane);
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
        new MessageFrame();
    }
}