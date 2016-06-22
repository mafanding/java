import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MousePrank extends JFrame implements ActionListener{
    MousePrank(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,220);
        setLayout(new BorderLayout());
        JLabel message=new JLabel("Click to close this program");
        add(BorderLayout.NORTH,message);
        PrankPanel prank=new PrankPanel();
        prank.ok.addActionListener(this);
        add(BorderLayout.CENTER,prank);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        System.exit(0);
    }

    public Insets getInsets(){
        return new Insets(40,10,10,10);
    }

    private static void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        setLookAndFeel();
        new MousePrank();
    }
}

class PrankPanel extends JPanel implements MouseMotionListener{
    JButton ok=new JButton("Ok");
    int buttonX,buttonY,mouseX,mouseY;
    int width,height;

    PrankPanel(){
        super();
        setLayout(null);
        addMouseMotionListener(this);
        buttonX=buttonY=110;
        ok.setBounds(new Rectangle(buttonX,buttonY,70,20));
        add(ok);
    }

    public void mouseMoved(MouseEvent e){
        mouseX=e.getX();
        mouseY=e.getY();
        width=(int)getSize().getWidth();
        height=(int)getSize().getHeight();
        if(Math.abs((mouseX+35)-buttonX)<50){
            buttonX=moveButton(mouseX,buttonX,width);
            repaint();
        }
        if(Math.abs((mouseY+10)-buttonY)<50){
            buttonY=moveButton(mouseY,buttonY,height);
            repaint();
        }
    }

    public void mouseDragged(MouseEvent e){

    }

    private int moveButton(int mouseAt,int buttonAt,int border){
        if(buttonAt<mouseAt){
            buttonAt--;
        }else{
            buttonAt++;
        }
        if(buttonAt>(border-20)){
            buttonAt=10;
        }
        if(buttonAt<0){
            buttonAt=border-80;
        }
        return buttonAt;
    }

    public void paintComponent(Graphics comp){
        super.paintComponent(comp);
        ok.setBounds(buttonX, buttonY, 70, 20);
    }
}