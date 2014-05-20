import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;


public class Game {
	private JFrame window;
	private JPanel view;
	private JPanel inputSection;
	private JPanel hud;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private int activeMon;
	private Wallopsmon[] player;
	private Wallopsmon opponent;
	
	public Game() {
		
		initVars();
		formatVars();
		addComps();
		
		window.setVisible(true);
	}
	
	public void formatVars() {
		Rectangle rect = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		window.setSize(new Dimension(rect.width,rect.height));
		
		setSize(view, new Dimension(2*window.getWidth()/3, window.getHeight()));
		setSize(inputSection, new Dimension(window.getWidth()/3, window.getHeight()/2));
		setSize(hud, new Dimension(window.getWidth()/3, window.getHeight()/2));
		
		view.add(player[0].getImage());
		
		window.setLayout(new GridBagLayout());
		
		inputSection.setLayout(new GridLayout(2,2));
		
		view.setBackground(Color.BLUE);
		hud.setBackground(Color.CYAN);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setSize(Component c, Dimension d) {
		c.setPreferredSize(d);
		c.setMaximumSize(d);
		c.setMinimumSize(d);
		c.setSize(d);
	}
	
	public void addComps() {
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 1.0;
		c.weighty = 1.0;
		
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 2;
		c.gridheight = 2;
		c.gridx = 0;
		c.gridy = 0;
		window.add(view, c);
		
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 2;
		window.add(hud, c);
		c.gridy = 1;
		window.add(inputSection, c);

		inputSection.add(button1);
		inputSection.add(button2);
		inputSection.add(button3);
		inputSection.add(button4);
	}
	
	public void initVars() {
		window = new JFrame("Wallopsmon");
		view = new JPanel();
		inputSection = new JPanel();
		hud = new JPanel();
		player = new Wallopsmon[6];
		activeMon = 0;
		player[activeMon] = Wallopsmon.MUD_DOG_WHELK;
		button1 = new JButton(player[0].getMoveOne().getName());
		button2 = new JButton(player[0].getMoveTwo().getName());
		button3 = new JButton(player[0].getMoveThree().getName());
		button4 = new JButton(player[0].getMoveFour().getName());
	}
}
