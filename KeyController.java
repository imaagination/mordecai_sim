import Jama.*;

public class KeyController implements Controller {
	
	private static final int KEY_UP = 1;
	private static final int KEY_RIGHT = 2;
	private static final int KEY_DOWN = 3;
	private static final int KEY_LEFT = 4;

	public Matrix getControls() {
		Matrix controlVec = new Matrix(4, 1);
		controlVec.set(0, 1, StdDraw.isKeyPressed(KEY_UP) ? 1 : 0);
		controlVec.set(0, 1, StdDraw.isKeyPressed(KEY_RIGHT) ? 1 : 0);
		controlVec.set(0, 1, StdDraw.isKeyPressed(KEY_DOWN) ? 1 : 0);
		controlVec.set(0, 1, StdDraw.isKeyPressed(KEY_LEFT) ? 1 : 0);
		return controlVec;
	}

}
