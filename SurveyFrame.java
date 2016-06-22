import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SurveyFrame extends JFrame{
    SurveyFrame(){
        super();
        setSize(290,140);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        SurveyWizard wiz=new SurveyWizard();
        add(wiz);
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
        new SurveyFrame();
    }
}