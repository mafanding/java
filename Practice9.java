import javax.swing.*;

public class Practice9 extends JFrame{

    Practice9(){
        super("Practice9");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane=new JPanel();
        JButton start=new JButton("Start");
        JButton stop=new JButton("Stop");
        JButton pause=new JButton("Pause");
        JLabel usernameLabel=new JLabel("Username: ");
        JLabel passwordLabel=new JLabel("Password: ");
        JTextField username=new JTextField(10);
        JPasswordField password=new JPasswordField(10);
        pane.add(start);
        pane.add(stop);
        pane.add(pause);
        pane.add(usernameLabel);
        pane.add(username);
        pane.add(passwordLabel);
        pane.add(password);
        add(pane);
        pack();
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
        new Practice9();
    }
}