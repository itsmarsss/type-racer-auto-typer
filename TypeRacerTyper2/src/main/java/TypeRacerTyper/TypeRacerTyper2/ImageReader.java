package TypeRacerTyper.TypeRacerTyper2;

import java.awt.image.BufferedImage;
import net.sourceforge.tess4j.TesseractException;

public class ImageReader {

	static void readimage(BufferedImage image) {
		try {
			String text = UI.tesseract.doOCR(image).trim().replaceAll("\n", " ") + "\n";
			UI.textArea.setText(text);
		} catch (TesseractException e) {
			UI.textArea.setText("OCR error, please try again");
		}
	}
}