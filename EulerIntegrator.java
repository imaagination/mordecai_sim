import Jama.*;

public class EulerIntegrator implements Integrator {

	private double dt;
  private Matrix trans;

	public EulerIntegrator() {
    this.dt = 1;
		double[] linSystem = {1.0, 0.0, 0.0, 1.0};
		trans = new Matrix(linSystem, 2);
	}

	public EulerIntegrator(Matrix linSystem, double dt) {
    trans = linSystem.copy();
		this.dt = dt;
	}

	public void setTimeStep(double dt) {
		this.dt = dt;
	}

	public Matrix integrate(Matrix s) {
    return integrate(s, this.dt);
  }

	// Advances the state by time by repeatedly advancing dt
	public Matrix integrate(Matrix s, double time) {
    Matrix initState = s.copy();
		for (int i = 0; i < Math.floor(time / dt); i++) {
			Matrix finState = trans.times(initState);
			initState = finState;
		}
		return initState;
	}

}
