import Jama.*;
import java.awt.event.KeyEvent;

public class KeyController implements Controller {
	
	private static final int KEY_UP = KeyEvent.VK_I;
	private static final int KEY_RIGHT = KeyEvent.VK_L;
	private static final int KEY_DOWN = KeyEvent.VK_K;
	private static final int KEY_LEFT = KeyEvent.VK_J;

	public Matrix getControls() {
		Matrix controlVec = new Matrix(4, 1);
		controlVec.set(0, 0, StdDraw.isKeyPressed(KEY_UP) ? 1 : 0);
		controlVec.set(1, 0, StdDraw.isKeyPressed(KEY_RIGHT) ? 1 : 0);
		controlVec.set(2, 0, StdDraw.isKeyPressed(KEY_DOWN) ? 1 : 0);
		controlVec.set(3, 0, StdDraw.isKeyPressed(KEY_LEFT) ? 1 : 0);
		return controlVec;
	}

}
