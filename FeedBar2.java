import java.awt.*;
import javax.swing.*;

class FeedBar2 extends JFrame {
	FeedBar2(){
		super("FeedBar2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		JButton load=new JButton("Load");
		JButton save=new JButton("Save");
		JButton subscrible=new JButton("Subscrible");
		JButton unsubscrible=new JButton("Unsubscrible");
		JToolBar bar=new JToolBar();
		bar.add(load);
		bar.add(save);
		bar.add(subscrible);
		bar.add(unsubscrible);
		JMenuItem j1=new JMenuItem("Load");
		JMenuItem j2=new JMenuItem("Save");
		JMenuItem j3=new JMenuItem("Subscrible");
		JMenuItem j4=new JMenuItem("Unsubscrible");
		JMenu menu=new JMenu("Feeds");
		JMenuBar menuBar=new JMenuBar();
		menu.add(j1);
		menu.add(j2);
		menu.add(j3);
		menu.add(j4);
		menuBar.add(menu);
		JTextArea edit=new JTextArea(8,40);
		JScrollPane scroll=new JScrollPane(edit);
		BorderLayout bord=new BorderLayout();
		setLayout(bord);
		add("North",bar);
		add("Center",scroll);
		setJMenuBar(menuBar);
		pack();
		setVisible(true);
	}

	private void setLookAndFeel(){
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		new FeedBar2();
	}
}