public class World {
  
	private final double TIME_STEP = 0.1;

	private Integrator system;
	private Matrix state;

	public World() {
		// This is a [x_dot, y_dot, x, y] system with dt = 0.1
		double[] linSystem = {1.0, 0.0, 0.0, 0.0,
												  0.0, 1.0, 0.0, 0.0,
													0.1, 0.0, 1.0, 0.0,
													0.0, 0.1, 0.0, 1.0};
		Matrix sys = new Matrix(linSystem, 4);
		system = new EulerIntegrator(sys, TIME_STEP);

		double[] initCond = {20.0, 20.0, 0.0, 0.0};
	}

	public Matrix step() {
		state = system.integrate(state);
	}

}
