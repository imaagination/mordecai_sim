import Jama.*;

public class MouseController implements Controller {

	public Matrix getControls() {
		Matrix controlVec = new Matrix(2, 1);
		controlVec.set(0, 0, StdDraw.mouseX());
		controlVec.set(1, 0, StdDraw.mouseY());

		return controlVec;
	}

}
