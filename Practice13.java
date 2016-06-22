import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Practice13 extends JFrame{
    Practice13(int radius,int x,int y,String color){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(3*radius,3*radius);
        CPanel circular=new CPanel(radius,x,y,color);
        add(circular);
        setVisible(true);
    }

    public static void main(String[] args){
        if(args.length<4){
            System.exit(-1);
        }
        new Practice13(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]),args[3]);
    }
}

class CPanel extends JPanel{
    int radius,x,y;
    Color color;
    CPanel(int radius,int x,int y,String color){
        super();
        this.radius=radius;
        this.x=x;
        this.y=y;
        this.color=Color.decode(color);
    }

    public void paintComponent(Graphics comp){
    Graphics2D comp2D=(Graphics2D)comp;
    comp2D.setColor(color);
    Ellipse2D.Float ee=new Ellipse2D.Float((float)x, (float)y, (float)radius, (float)radius);
    comp2D.fill(ee);
    }
}