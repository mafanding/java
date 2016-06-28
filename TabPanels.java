import java.awt.*;
import javax.swing.*;

class TabPanels extends JFrame {
	TabPanels(){
		super("TabPanels");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setSize(480,218);
		JPanel mainSettings=new JPanel();
		JPanel advancedSettings=new JPanel();
		JPanel privacySettings=new JPanel();
		JPanel emailSettings=new JPanel();
		JPanel securitySettings=new JPanel();
		JTabbedPane tabs=new JTabbedPane();
		tabs.add("Main",mainSettings);
		tabs.add("Advanced",advancedSettings);
		tabs.add("Privacy",privacySettings);
		tabs.add("Email",emailSettings);
		tabs.add("Security",securitySettings);
		add(tabs);
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
		new TabPanels();
	}
}