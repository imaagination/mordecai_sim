import Jama.*;

public class Agent {

	private Controller control;
	private Matrix lastState;

	public Agent(String controllerName) {
		if (controllerName.equals("KeyController")) {
			control = new KeyController();
		}
		else if (controllerName.equals("MouseController")) {
			StdOut.println("Creating mouse controller");
			control = new MouseController();
		}
		else {
			throw new RuntimeException("Agent: invalid controller type");
		}
	}

	public Matrix getControls() {
		Matrix position = new Matrix(2, 1);
		position.set(0, 0, lastState.get(2, 0));
		position.set(1, 0, lastState.get(3, 0));
		return control.getControls().minus(position);
	}

	public void observeState(Matrix state) {
		lastState = state;
	}
}

