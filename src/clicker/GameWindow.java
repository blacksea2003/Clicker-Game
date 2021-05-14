package clicker;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Image.*;
import java.awt.event.*;

// https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
// https://docs.oracle.com/javase/tutorial/uiswing/layout/flow.html
// https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/CardLayoutDemoProject/src/layout/CardLayoutDemo.java

@SuppressWarnings("serial")
public class GameWindow extends JFrame {

	// Where instance variables are declared:

	static final String BUTTONPANEL = "Card with JButtons";
	static final String TEXTPANEL = "Card with JTextField";

	static final boolean RIGHT_TO_LEFT = false;

	JLabel lblCurrency;
	JPanel cards;
	JLabel money;
	Money currency;
	UpgradeWindow uWindow;
    Container pane;
	
	// default constructor
	public GameWindow() {

	}

	// initialize the game window with a title from the JFrame
	public GameWindow(String windowTitle) {
		super(windowTitle);

		// initialize the window classes
		cards = new JPanel();
		money = new JLabel("0");
	}

	// create and show the graphical user interface in the JFrame
	public void createAndShowGUI() {
		
		createGridBagLayout(this.getContentPane());
	}
	
	public void refresh() {
		lblCurrency.setText("" + currency.Pmoney);
	}
	

	private void createGridBagLayout(Container pane) {
		this.pane = pane;
		// create a grid based layout for placing components.
		GridBagLayout gridLayout = new GridBagLayout();
		pane.setLayout(gridLayout);

		// create the constrants for the components to be added to the layout.
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1;

		JButton btnUpgrades = new JButton("Upgrades");
		gridLayout.setConstraints(btnUpgrades, constraints);
		pane.add(btnUpgrades, constraints);

		btnUpgrades.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked upgrades");
				uWindow.OpenWindow();
			}
		});
		
		if (currency != null) {
			// Currency label
			lblCurrency = new JLabel(String.valueOf(currency.Pmoney), SwingConstants.CENTER);
			constraints.gridwidth = 0;
			constraints.weightx = 0;
			constraints.gridheight = 1;
			constraints.gridx = 0;
			constraints.gridy = 2;
			gridLayout.setConstraints(lblCurrency, constraints);
			pane.add(lblCurrency);
			pane.revalidate();
		}

		// image

		String userDirectory = System.getProperty("user.dir");
		String imageDirectory = userDirectory + "\\src\\computer.png";
		try {
			BufferedImage image = ImageIO.read(new File(imageDirectory));
			Image scaledImage = image.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
			constraints.weightx = 0;
			constraints.gridy = 1;
			constraints.gridx = 0;

			JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
			imageLabel.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent me) {
					System.out.println("computer clicked");

					if (currency != null) {
						currency.add(1);
						lblCurrency.setText(String.valueOf(currency.Pmoney));
						uWindow.refresh();
					}

				}
			});

			gridLayout.setConstraints(imageLabel, constraints);
			pane.add(imageLabel);
		} catch (IOException ex) {
			System.out.println("Error getting image");
			JLabel errorLabel = new JLabel("Error loading image");
			pane.add(errorLabel);
		}

		pane.revalidate();
		
		
		

	}
	
	 
	 

	public void initializeGame(Money m, UpgradeWindow u) {
		currency = m;
		uWindow = u;

	}
	
	
	
	

}