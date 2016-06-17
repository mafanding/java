import javax.swing.*;

public class Authenticator extends JFrame{
    JTextField username=new JTextField(15);
    JPasswordField password=new JPasswordField(15);
    JTextArea comments=new JTextArea(4,15);
    JButton ok=new JButton("Ok");
    JButton cancel=new JButton("Cancel");

    Authenticator(){
        super("Account Infomation");
        setSize(300,220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane=new JPanel();
        JLabel usernameLabel=new JLabel("Username: ");
        JLabel passwordLabel=new JLabel("Password: ");
        JLabel commentsLabel=new JLabel("Comments: ");
        comments.setLineWrap(true);
        comments.setWrapStyleWord(true);
        pane.add(usernameLabel);
        pane.add(username);
        pane.add(passwordLabel);
        pane.add(password);
        pane.add(commentsLabel);
        pane.add(comments);
        pane.add(ok);
        pane.add(cancel);
        add(pane);
        setVisible(true);
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
        new Authenticator();
    }
}