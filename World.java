import Jama.*;

public class World {
  
	private Matrix state;
	private Matrix control;
	private Matrix controlSys;
	private Integrator integrator;

	public World(double dt, Matrix initCond, Matrix initControl, Matrix linSystem, Matrix controlSystem) {
		this.state = initCond.copy();
		this.control = initControl.copy();
		this.controlSys = controlSystem.copy();
		this.integrator = new EulerIntegrator(linSystem);
	}

	public void applyControl(Matrix newControl) {
		control = newControl.copy();
	}

	public Matrix step() {
		Matrix newState = integrator.integrate(state);
		Matrix controlEffect = controlSys.times(control);
		newState = newState.plus(controlEffect);
		state = newState;
	  return state;
	}

}
