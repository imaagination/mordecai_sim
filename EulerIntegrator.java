import Jama.*;

public class EulerIntegrator implements Integrator {

  private Matrix trans;

	public EulerIntegrator(Matrix linSystem) {
    trans = linSystem.copy();
	}

	public Matrix integrate(Matrix s) {
		Matrix newState = integrate(s, 1.0);
		return newState;
  }

	// Advances the state by time by repeatedly advancing dt
	public Matrix integrate(Matrix s, double time) {
    Matrix initState = s.copy();
		for (int i = 0; i < Math.floor(time); i++) {
			Matrix finState = trans.times(initState);
			initState = finState;
		}
		return initState;
	}

}
