import Jama.*;

public class Agent {

	private Controller control;

	public Agent() {
		control = new KeyController();
	}

	public Matrix getControls() {
		return control.getControls();
	}

	public void observeState(Matrix state) {
		
	}
}

