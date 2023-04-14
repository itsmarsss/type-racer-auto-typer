package TypeRacerTyper.TypeRacerTyper2;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.sourceforge.tess4j.Tesseract;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.URISyntaxException;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;

public class UI {
	static JFrame frame = new JFrame();
	static JButton TakeScreenButton = new JButton("Select Text Area");
	static JButton StartTyping = new JButton("Type");
	static JTextArea textArea = new JTextArea();
	static Tesseract tesseract = new Tesseract();
	private static int posX = 0, posY = 0;
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, URISyntaxException {
		String parent = new File(UI.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();
		LookAndFeel defaultlf = UIManager.getLookAndFeel();
		frame = new JFrame();
		frame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		frame.setAlwaysOnTop(true);
		frame.setSize(310, 210);
		frame.setUndecorated(true);
		frame.setIconImage(new ImageIcon(parent+"\\icon.png").getImage());

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenuItem menuItem = new JMenuItem("Type Racer Auto Typer (Tesseract OCR)");
		menuItem.setFont(new Font("Arial", Font.BOLD, 10));
		menuItem.setBackground(new Color(231, 234, 237));
		menuItem.setEnabled(false);
		menuBar.add(menuItem);

		final JButton InfoButton = new JButton("🛈");
		InfoButton.setBackground(new Color(231, 234, 237));
		InfoButton.setBorderPainted(false);
		InfoButton.setFocusable(false);
		menuBar.add(InfoButton);

		final JButton CloseButton = new JButton("×");
		CloseButton.setBackground(new Color(231, 234, 237));
		CloseButton.setBorderPainted(false);
		CloseButton.setFocusable(false);
		menuBar.add(CloseButton);

		TakeScreenButton.setBackground(Color.LIGHT_GRAY);
		TakeScreenButton.setBorderPainted(false);
		TakeScreenButton.setFocusable(false);
		frame.getContentPane().add(TakeScreenButton, BorderLayout.NORTH);

		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
		scrollPane.setBorder(null);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		UIManager.setLookAndFeel(defaultlf);

		textArea.setFont(new Font("Arial", Font.PLAIN, 12));
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);

		StartTyping.setBackground(Color.LIGHT_GRAY);
		StartTyping.setBorderPainted(false);
		StartTyping.setFocusable(false);
		frame.getContentPane().add(StartTyping, BorderLayout.SOUTH);
		
		String tessdata = parent+"\\tessdata";
		if(new File(tessdata).exists()) {
			tesseract.setDatapath(tessdata);
		}else {
			textArea.setText("OCR data file is missing, can't read image.\n\n *Please reinstall.*");
		}

		menuItem.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				posX = e.getX();
				posY = e.getY();
			}
		});
		menuItem.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){		
				frame.setLocation(e.getXOnScreen()-posX, e.getYOnScreen()-posY);
			}
		});

		InfoButton.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				textArea.setText("Join our Discord: https://discord.gg/K8hgFHWeJQ"
						+ "Visit YouTube Channel: https://www.youtube.com/watch?v=aULvJVE6Shc"
						+ "\n\nINFORMATION: "
						+ "\n\n\t---How To Use---"
						+ "\nmethod #1:"
						+ "\n   A. Inspect the Type Racer page and copy the unselectable text"
						+ "\n   B. Paste the text into the textbox"
						+ "\n   C. Type the first word (because it isn't there when you copied the text)"
						+ "\n   D. Press \"Type\" when there are less than 2 seconds left and click into the Type Racer textbox"
						+ "\n"
						+ "\nmethod #2:"
						+ "\n   A. Press \"Select Text Area\""
						+ "\n   B. Press and drag your mouse until the white rectangle covers all the text (It's best to zoom in the website for more accurate results)"
						+ "\n   C. Edit the text in the text box for incorrect words or punctuations"
						+ "\n   D. Press \"Type\" when there are less than 2 seconds left and click into the type racer textbox"
						+ "\n\n\t---This Application---"
						+ "\n   - simulates keystrokes to type"
						+ "\n   - uses Tesseract OCR to read your selection area"
						+ "\n   - reads English by default (can be changed in \"C:\\Program Files (x86)\\Type Racer Typer\\tessdata\" if you know how to)"
						+ "\n   - is written in Java (by Marsss)");
				textArea.setCaretPosition(0);
			}
			public void mouseEntered(MouseEvent e) {
				InfoButton.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) {
				InfoButton.setBackground(new Color(231, 234, 237));
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});

		CloseButton.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			public void mouseEntered(MouseEvent e) {
				CloseButton.setBackground(new Color(232, 17, 35));
				CloseButton.setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent e) {
				CloseButton.setBackground(new Color(231, 234, 237));
				CloseButton.setForeground(Color.BLACK);
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});

		TakeScreenButton.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				TakeScreenButton.setEnabled(false);
				StartTyping.setEnabled(false);
				try {
					ScreenSelector.screenselect();
				} catch (AWTException e1) {}
			}
			public void mouseEntered(MouseEvent e) {
				TakeScreenButton.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) {
				TakeScreenButton.setBackground(Color.LIGHT_GRAY);
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});

		StartTyping.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				try {
					Typer.startyping(textArea.getText());
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			}
			public void mouseEntered(MouseEvent e) {
				StartTyping.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) {
				StartTyping.setBackground(Color.LIGHT_GRAY);
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});

		frame.setVisible(true);
	}
}
