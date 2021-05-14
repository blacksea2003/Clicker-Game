package clicker;

import javax.swing.*;

import java.net.URL;
import java.util.*;

public class Program {

	public static void main(String[] args) {
		// create the game window
		
		 JWindow jwin = new JWindow();
		 jwin.getContentPane()
		 .add(
		 new JLabel("Loading Game",
		 SwingConstants.CENTER));
		 jwin.setBounds(200, 200, 200, 100);
		 jwin.setVisible(true);

		 try {
		 Thread.sleep(3000);
		 } catch (InterruptedException e) {
		 e.printStackTrace();
		 }

		 jwin.setVisible(false);
		 jwin.dispose();
		
		URL url = Program.class.getResource("/src/computer.png");
		
		GameWindow winMain = new GameWindow("clicker");
		winMain.setResizable(false);
		winMain.setVisible(true);
		winMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		winMain.setSize(300, 400);
		
		Money money = new Money();

		List<Upgrade> upgrades = new ArrayList<Upgrade>();
		upgrades.add(new Upgrade("Fans", 1.1f, 25, money));
		upgrades.add(new Upgrade("Ram", 1.2f, 50, money));
		upgrades.add(new Upgrade("Motherboard", 1.3f, 100, money));
		upgrades.add(new Upgrade("CPU", 1.5f, 200, money));
		upgrades.add(new Upgrade("GPU", 2f, 300, money));

		
		UpgradeWindow uWindow = new UpgradeWindow(upgrades, money, winMain);

		winMain.initializeGame(money, uWindow);

		// create the GUI for the window.
		winMain.createAndShowGUI();
		
		
	}
}

