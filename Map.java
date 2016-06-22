import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Map extends JFrame{
    Map(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360,350);
        MapPanel map=new MapPanel();
        add(map);
        setVisible(true);
    }

    public static void main(String[] args){
        new Map();
    }
}

class MapPanel extends JPanel{
    public void paintComponent(Graphics comp){
        Graphics2D comp2D=(Graphics2D)comp;
        comp2D.setColor(Color.blue);
        comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Rectangle2D.Float background=new Rectangle2D.Float(0F, 0F, (float)getSize().width, (float)getSize().height);
        comp2D.fill(background);
        comp2D.setColor(Color.white);
        BasicStroke pen=new BasicStroke(2F,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND);
        comp2D.setStroke(pen);
        for(int i=0;i<340;i+=10){
            for(int j=0;j<340;j+=10){
                Arc2D.Float wave=new Arc2D.Float(i , j, 10, 10, 0, -180, Arc2D.OPEN);
                comp2D.draw(wave);
            }
        }
        GradientPaint gp=new GradientPaint(0F,0F,Color.green,350F,350F,Color.orange,true);
        comp2D.setPaint(gp);
        GeneralPath f1=new GeneralPath();
        f1.moveTo(10F, 12F);
        f1.lineTo(234F, 15F);
        f1.lineTo(253F, 25F);
        f1.lineTo(261F, 71F);
        f1.lineTo(344F, 209F);
        f1.lineTo(336F, 278F);
        f1.lineTo(295F, 310F);
        f1.lineTo(259F, 274F);
        f1.lineTo(205F, 188F);
        f1.lineTo(211F, 171F);
        f1.lineTo(195F, 174F);
        f1.lineTo(191F, 118F);
        f1.lineTo(120F, 56F);
        f1.lineTo(94F, 68F);
        f1.lineTo(81F, 49F);
        f1.lineTo(12F, 37F);
        f1.closePath();
        comp2D.fill(f1);
        comp2D.setColor(Color.black);
        BasicStroke pen2=new BasicStroke();
        comp2D.setStroke(pen2);
        Ellipse2D.Float e1=new Ellipse2D.Float(235,140,15,15);
        Ellipse2D.Float e2=new Ellipse2D.Float(225, 130, 15, 15);
        Ellipse2D.Float e3=new Ellipse2D.Float(245, 130, 15, 15);
        comp2D.fill(e1);
        comp2D.fill(e2);
        comp2D.fill(e3);
    }
}