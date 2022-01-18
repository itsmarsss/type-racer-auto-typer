package TypeRacerTyper.TypeRacerTyper2;

import java.awt.AWTException;
//import java.awt.GraphicsConfiguration;
//import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
//import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class ScreenShotter {
	static void screenshot(Point point1, Point point2) throws AWTException {
		int x = (int) point1.getX(), y = (int) point1.getY();
		int width = (int) Math.abs(point1.getX() - point2.getX()), height = (int) Math.abs(point1.getY() - point2.getY());

//		GraphicsConfiguration GC = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
//		AffineTransform AT = GC.getDefaultTransform();
//		double zoomX = AT.getScaleX();
//		double zoomY = AT.getScaleX();
		//try {
			Rectangle screenRect = new Rectangle(ScreenSelector.screen);
			BufferedImage wholescreen = new Robot().createScreenCapture(screenRect);
//			BufferedImage text = wholescreen.getSubimage((int)(x/zoomX), (int)(y/zoomY), (int)(width/zoomX), (int)(height/zoomY));
			BufferedImage text = wholescreen.getSubimage(x, y, width, height);
			ImageReader.readimage(text);
		//}catch(Exception e) {
		//	UI.textArea.setText("ERROR");
		//}

	}
}
