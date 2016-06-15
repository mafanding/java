import javax.swing.*;

public class SimpleFrame extends JFrame{
    SimpleFrame(){
        super("Frame Title");
        setSize(300,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setVisible(true);
    }

    private static void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception e){

        }
    }

    public static void main(String[] args){
        setLookAndFeel();
        new SimpleFrame();
    }
}