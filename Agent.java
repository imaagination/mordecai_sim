import Jama.*;

public class Agent {

	private Controller control;

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
		return control.getControls();
	}

	public void observeState(Matrix state) {
		
	}
}

