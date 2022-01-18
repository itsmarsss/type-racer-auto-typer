package TypeRacerTyper.TypeRacerTyper2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Typer {
	
	private static Robot robot;
	static void startyping(String text) throws AWTException {
		
		robot = new Robot();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		
		for(int i = 0; i < text.length(); i++) {
			switch (text.charAt(i)) {
			case 'a': Type(KeyEvent.VK_A); break;
			case 'b': Type(KeyEvent.VK_B); break;
			case 'c': Type(KeyEvent.VK_C); break;
			case 'd': Type(KeyEvent.VK_D); break;
			case 'e': Type(KeyEvent.VK_E); break;
			case 'f': Type(KeyEvent.VK_F); break;
			case 'g': Type(KeyEvent.VK_G); break;
			case 'h': Type(KeyEvent.VK_H); break;
			case 'i': Type(KeyEvent.VK_I); break;
			case 'j': Type(KeyEvent.VK_J); break;
			case 'k': Type(KeyEvent.VK_K); break;
			case 'l': Type(KeyEvent.VK_L); break;
			case 'm': Type(KeyEvent.VK_M); break;
			case 'n': Type(KeyEvent.VK_N); break;
			case 'o': Type(KeyEvent.VK_O); break;
			case 'p': Type(KeyEvent.VK_P); break;
			case 'q': Type(KeyEvent.VK_Q); break;
			case 'r': Type(KeyEvent.VK_R); break;
			case 's': Type(KeyEvent.VK_S); break;
			case 't': Type(KeyEvent.VK_T); break;
			case 'u': Type(KeyEvent.VK_U); break;
			case 'v': Type(KeyEvent.VK_V); break;
			case 'w': Type(KeyEvent.VK_W); break;
			case 'x': Type(KeyEvent.VK_X); break;
			case 'y': Type(KeyEvent.VK_Y); break;
			case 'z': Type(KeyEvent.VK_Z); break;
			case 'A': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_A); break;
			case 'B': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_B); break;
			case 'C': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_C); break;
			case 'D': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_D); break;
			case 'E': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_E); break;
			case 'F': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_F); break;
			case 'G': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_G); break;
			case 'H': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_H); break;
			case 'I': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_I); break;
			case 'J': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_J); break;
			case 'K': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_K); break;
			case 'L': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_L); break;
			case 'M': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_M); break;
			case 'N': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_N); break;
			case 'O': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_O); break;
			case 'P': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_P); break;
			case 'Q': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Q); break;
			case 'R': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_R); break;
			case 'S': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_S); break;
			case 'T': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_T); break;
			case 'U': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_U); break;
			case 'V': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_V); break;
			case 'W': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_W); break;
			case 'X': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_X); break;
			case 'Y': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Y); break;
			case 'Z': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Z); break;
			case '`': Type(KeyEvent.VK_BACK_QUOTE); break;
			case '0': Type(KeyEvent.VK_0); break;
			case '1': Type(KeyEvent.VK_1); break;
			case '2': Type(KeyEvent.VK_2); break;
			case '3': Type(KeyEvent.VK_3); break;
			case '4': Type(KeyEvent.VK_4); break;
			case '5': Type(KeyEvent.VK_5); break;
			case '6': Type(KeyEvent.VK_6); break;
			case '7': Type(KeyEvent.VK_7); break;
			case '8': Type(KeyEvent.VK_8); break;
			case '9': Type(KeyEvent.VK_9); break;
			case '-': Type(KeyEvent.VK_MINUS); break;
			case '=': Type(KeyEvent.VK_EQUALS); break;
			case '~': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_QUOTE); break;
			case '!': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_1); break;
			case '@': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_2); break;
			case '#': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_3); break;
			case '$': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_4); break;
			case '%': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_5); break;
			case '^': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_6); break;
			case '&': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_7); break;
			case '*': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_8); break;
			case '(': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_9); break;
			case ')': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_0); break;
			case '_': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_MINUS); break;
			case '+': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_EQUALS); break;
			case '\t': Type(KeyEvent.VK_TAB); break;
			case '\n': Type(KeyEvent.VK_ENTER); break;
			case '[': Type(KeyEvent.VK_OPEN_BRACKET); break;
			case ']': Type(KeyEvent.VK_CLOSE_BRACKET); break;
			case '\\': Type(KeyEvent.VK_BACK_SLASH); break;
			case '{': doType(KeyEvent.VK_SHIFT, KeyEvent. VK_OPEN_BRACKET); break;
			case '}': doType(KeyEvent.VK_SHIFT, KeyEvent. VK_CLOSE_BRACKET); break;
			case '|': doType(KeyEvent.VK_SHIFT, KeyEvent. VK_BACK_SLASH); break;
			case ';': Type(KeyEvent.VK_SEMICOLON); break;
			case ':': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_SEMICOLON); break;
			case '\'': Type(KeyEvent.VK_QUOTE); break;
			case '"': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_QUOTE); break;
			case ',': Type(KeyEvent.VK_COMMA); break;
			case '<': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_COMMA); break;
			case '.': Type(KeyEvent.VK_PERIOD); break;
			case '>': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_PERIOD); break;
			case '/': Type(KeyEvent.VK_SLASH); break;
			case '?': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_SLASH); break;
			case ' ': Type(KeyEvent.VK_SPACE); break;
			}
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {}
		}
	}
	
	private static void Type(int keyCode1) {
		robot.keyPress(keyCode1);
		robot.keyRelease(keyCode1);
	}

	private static void doType(int keyCode1, int keyCode2) {
		robot.keyPress(keyCode1);
		robot.keyPress(keyCode2);
		robot.keyRelease(keyCode2);
		robot.keyRelease(keyCode1);
	}
	
}