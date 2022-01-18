package TypeRacerTyper.TypeRacerTyper2;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

public class ScreenSelector {

	private static Point point1, point2;
	private static JPanel p = new JPanel(), p2 = new JPanel(), p3 = new JPanel(), p4 = new JPanel();
	static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	static void screenselect() throws AWTException {
		final JFrame selection = new JFrame();
		selection.setUndecorated(true);
		selection.setBackground(new Color(0, 0, 0, 200));
		selection.setSize(screen);
		try {
			selection.setIconImage(new ImageIcon(new File(ScreenSelector.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent()+"\\icon.png").getImage());
		} catch (URISyntaxException e) {}
		
		final JButton exitButton = new JButton("×");
		exitButton.setBackground(new Color(231, 234, 237));
		exitButton.setBorderPainted(false);
		exitButton.setFocusable(false);
		GroupLayout groupLayout = new GroupLayout(selection.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(screen.width, Short.MAX_VALUE)
					.addComponent(exitButton))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(exitButton)
					.addContainerGap(screen.height, Short.MAX_VALUE))
		);
		selection.getContentPane().setLayout(groupLayout);
		UI.frame.setAlwaysOnTop(false);
		selection.toFront();
		selection.setVisible(true);
		
		exitButton.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				UI.TakeScreenButton.setEnabled(true);
				UI.StartTyping.setEnabled(true);
				selection.dispose();
				UI.frame.setAlwaysOnTop(true);
			}
			public void mouseEntered(MouseEvent e) {
				exitButton.setBackground(new Color(232, 17, 35));
				exitButton.setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent e) {
				exitButton.setBackground(new Color(231, 234, 237));
				exitButton.setForeground(Color.BLACK);
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		
		selection.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
				int bx = (int) point1.getX(), by = (int) point1.getY();
				int ex = e.getX(), ey = e.getY();
				
				int screenx = (int) screen.getWidth(), screeny = (int) screen.getHeight();
				
				int minbey = Math.min(by, ey), maxbex = Math.max(bx, ex) ,maxbey = Math.max(by, ey), absbey = Math.abs(by-ey);
				
				selection.getContentPane().add(p);
				p.setBackground(new Color(0, 0, 0, 200));
				p.setLocation(0, 0);
				p.setSize(screenx, minbey);
				
				selection.getContentPane().add(p2);
				p2.setBackground(new Color(0, 0, 0, 200));
				p2.setLocation(0, minbey);
				p2.setSize(Math.min(bx, ex), absbey);
				
				selection.getContentPane().add(p3);
				p3.setBackground(new Color(0, 0, 0, 200));
				p3.setLocation(maxbex, minbey);
				p3.setSize(screenx-maxbex, absbey);
				
				selection.getContentPane().add(p4);
				p4.setBackground(new Color(0, 0, 0, 200));
				p4.setLocation(0, maxbey);
				p4.setSize(screenx, screeny-maxbey);
				
				selection.setBackground(new Color(0, 0, 0, 1));
			}
			public void mouseMoved(MouseEvent e) {}
		});
		
		selection.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				point1 = e.getPoint();
			}
			public void mouseReleased(MouseEvent e) {
				point2 = e.getPoint();
				UI.TakeScreenButton.setEnabled(true);
				UI.StartTyping.setEnabled(true);
				selection.dispose();
				UI.frame.setAlwaysOnTop(true);
				try {
					ScreenShotter.screenshot(point1, point2);
				} catch (AWTException e1) {}
			}
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
	}
}
