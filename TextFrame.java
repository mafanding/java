import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextFrame extends JFrame{
    TextFrame(String text,String fontName){
        super();
        setSize(425,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TextFramePanel sf=new TextFramePanel(text,fontName);
        add(sf);
        setVisible(true);
    }

    public static void main(String[] args){
        if(args.length<1){
            System.out.println("Error");
            System.exit(-1);
        }
        new TextFrame(args[0],args[1]);
    }
}

class TextFramePanel extends JPanel{
    String text,fontName;

    TextFramePanel(String text,String fontName){
        super();
        this.text=text;
        this.fontName=fontName;
    }

    public void paintComponent(Graphics comp){
        super.paintComponent(comp);
        Graphics2D comp2D=(Graphics2D)comp;
        comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Font font=new Font(fontName,Font.BOLD,18);
        comp2D.setFont(font);
        int x=(getSize().width-getFontMetrics(font).stringWidth(text))/2;
        int y=getSize().height/2;
        comp2D.drawString(text, x, y);
    }
}