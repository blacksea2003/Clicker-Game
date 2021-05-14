package clicker;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UpgradeWindow {

	List<Upgrade> upgrades;
	Money money;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	Upgrade UpgradeClass;

	JLabel currency;
	JLabel error = new JLabel("Not Enough Money!");
	JButton fans;
	JButton ram;
	JButton motherboard;
	JButton cpu;
	JButton gpu;
	JButton build;

	public UpgradeWindow(List<Upgrade> upgrades, Money money, GameWindow winMain) {
		this.upgrades = upgrades;
		this.money = money;

		currency = new JLabel("money: " + money.Pmoney);

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.pack();

		// add to panel/frame
		fans = new JButton(upgrades.get(0).displayName + " | cost: " + upgrades.get(0).cost);
		panel.add(fans);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		ram = new JButton(upgrades.get(1).displayName + " | cost: " + upgrades.get(1).cost);
		panel.add(ram);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		motherboard = new JButton(upgrades.get(2).displayName + " | cost: " + upgrades.get(2).cost);
		panel.add(motherboard);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		cpu = new JButton(upgrades.get(3).displayName + " | cost: " + upgrades.get(3).cost);
		panel.add(cpu);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		gpu = new JButton(upgrades.get(4).displayName + " | cost: " + upgrades.get(4).cost);
		panel.add(gpu);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		panel.add(currency);
		
		error.setVisible(false);
		error.setForeground(Color.RED);
		panel.add(error);

		build = new JButton("Build my pc | cost: 1000");
		panel.add(build);
		
		
		frame.add(panel);

		// event listeners
		fans.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked fans");
				if (money.Pmoney >= upgrades.get(0).cost) {
					money.addMultiplier(upgrades.get(0).multiplier);
					upgrades.get(0).PurchaseUpgrade();
					refresh();
					winMain.refresh();
				}else {
					ErrorLabel();
				}
			}
		});

		ram.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked ram");
				if (money.Pmoney >= upgrades.get(1).cost) {
					money.addMultiplier(upgrades.get(1).multiplier);
					upgrades.get(1).PurchaseUpgrade();
					refresh();
					winMain.refresh();
				}else {
					ErrorLabel();
				}
			}
		});

		motherboard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked motherboard");
				if (money.Pmoney >= upgrades.get(2).cost) {
					money.addMultiplier(upgrades.get(2).multiplier);
					upgrades.get(2).PurchaseUpgrade();
					refresh();
					winMain.refresh();
				}else {
					ErrorLabel();
				}
			}
		});

		cpu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked cpu");
				if (money.Pmoney >= upgrades.get(3).cost) {
					money.addMultiplier(upgrades.get(3).multiplier);
					upgrades.get(3).PurchaseUpgrade();
					refresh();
					winMain.refresh();
				}else {
					ErrorLabel();
				}
			}
		});

		gpu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked gpu");
				if (money.Pmoney >= upgrades.get(4).cost) {
					money.addMultiplier(upgrades.get(4).multiplier);
					upgrades.get(4).PurchaseUpgrade();
					refresh();
					winMain.refresh();
				}else {
					ErrorLabel();
				}
			}
		});
		
		build.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (money.Pmoney >= 1000) {
					try {
					    Desktop.getDesktop().browse(new URL("https://drive.google.com/file/d/15Qnw8VN5fi-cdAdoD4teLYB89yvxatRw/view?usp=sharing").toURI());
					} catch (Exception e1) {}
					frame.dispose();
					winMain.dispose();
				}else {
					ErrorLabel();
				}
			}
		});
		
		

	}
	
	public void ErrorLabel() {
		error.setVisible(true);
		int delay = 3000; //milliseconds
		   ActionListener taskPerformer = new ActionListener() {
		       public void actionPerformed(ActionEvent evt) {
		           error.setVisible(false);
		       }
		   };
		   new javax.swing.Timer(delay, taskPerformer).start();
	}
	

	public void OpenWindow() {
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(300, 400);
		frame.setLocation(350, 0);
		currency.setText("money: " + String.valueOf(money.Pmoney));
	}

	public void refresh() {
		currency.setText("money: " + String.valueOf(money.Pmoney));
		fans.setText(upgrades.get(0).displayName + " | cost: " + upgrades.get(0).cost);
		ram.setText(upgrades.get(1).displayName + " | cost: " + upgrades.get(1).cost);
		motherboard.setText(upgrades.get(2).displayName + " | cost: " + upgrades.get(2).cost);
		cpu.setText(upgrades.get(3).displayName + " | cost: " + upgrades.get(3).cost);
		gpu.setText(upgrades.get(4).displayName + " | cost: " + upgrades.get(4).cost);
		error.setVisible(false);
		panel.revalidate();
		
	}

}
