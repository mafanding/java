import javax.swing.*;

public class IconFrame extends JFrame{
    JButton ebook,usb,directory,movie;

    IconFrame(){
        super("IconFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane=new JPanel();
        ImageIcon ebookIcon=new ImageIcon("ebook.png");
        ImageIcon usbIcon=new ImageIcon("usb.png");
        ImageIcon movieIcon=new ImageIcon("movie.png");
        ImageIcon directoryIcon=new ImageIcon("directory.png");
        ebook=new JButton("Ebook",ebookIcon);
        usb=new JButton("Usb",usbIcon);
        movie=new JButton("Movie",movieIcon);
        directory=new JButton("Directory",directoryIcon);
        pane.add(ebook);
        pane.add(usb);
        pane.add(movie);
        pane.add(directory);
        add(pane);
        pack();
        setVisible(true);
    }

    public static void main(String[] args){
        new IconFrame();
    }
}