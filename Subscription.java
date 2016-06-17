import javax.swing.*;

public class Subscription extends JFrame{
    String[] subs={"0xDECAFBAD","Cafe au lait","Hack the planet","Ideoplex","Inessential","Intertwingly","Markpasc","Postneo","RC3","Workbench"};
    JList subList=new JList(subs);

    Subscription(){
        super("Subscriptions");
        setSize(150,335);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane=new JPanel();
        JLabel subLabel=new JLabel("RSS Subscriptions: ");
        pane.add(subLabel);
        subList.setVisibleRowCount(8);
        JScrollPane scroller=new JScrollPane(subList);
        pane.add(scroller);
        add(pane);
        setVisible(true);
    }

    private static void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }

    public static void main(String[] args){
        setLookAndFeel();
        new Subscription();
    }
}