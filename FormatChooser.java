import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FormatChooser extends JFrame implements ItemListener{
    String[] formats={"choose format","Atom","RSS 0.92","RSS 1.0","RSS 2.0"};
    String[] descriptions={"Atom weblog and syndication format","RSS syndication format 0.92","RSS/RDF syndication format 1.0","RSS syndication format 2.0"};
    JComboBox formatBox=new JComboBox();
    JLabel descriptionLabel=new JLabel(" ");

    FormatChooser(){
        super();
        setSize(420,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        for(int i=0;i<formats.length;i++){
            formatBox.addItem(formats[i]);
        }
        formatBox.addItemListener(this);
        add(BorderLayout.NORTH,formatBox);
        add(BorderLayout.CENTER,descriptionLabel);
        setVisible(true);
    }

    public void itemStateChanged(ItemEvent e){
        int choice=formatBox.getSelectedIndex();
        if(choice>0){
            descriptionLabel.setText(descriptions[choice-1]);
        }
    }

    public Insets getInsets(){
        return new Insets(50,10,10,10);
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
        new FormatChooser();
    }
}