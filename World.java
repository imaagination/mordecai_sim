import Jama.*;

public class World {
  
	private final double TIME_STEP = 1.0;

	private Integrator system;
	private Matrix state;

	public World() {
		// This is a [x_dot, y_dot, x, y] system with dt = 0.1
		double[] linSystem = {1.0, 0.0, 0.1, 0.0,
												  0.0, 1.0, 0.0, 0.1,
													0.0, 0.0, 1.0, 0.0,
													0.0, 0.0, 0.0, 1.0};
		Matrix sys = new Matrix(linSystem, 4);
		system = new EulerIntegrator(sys, TIME_STEP);

		double[] initCond = {20.0, 20.0, 0.0, 0.0};
		state = new Matrix(initCond, 4);
	}

	public World(String filename) {
		// Read from file
		StdOut.println("Reading simulated world from " + filename);
		In specFile = new In(filename);
		specFile.readLine();
		int stateDim = specFile.readInt();
		StdOut.println("State dimension: " + stateDim);
		specFile.readLine();
		specFile.readLine();
		specFile.readLine();
		Matrix initCond = new Matrix(stateDim, 1);
		for (int i = 0; i < stateDim; i++) {
			StdOut.println(i);
			initCond.set(i, 0, specFile.readDouble());
		}
		StdOut.println("Initial conditions: ");
		initCond.print(2, 1);
		specFile.readLine();
		specFile.readLine();
		specFile.readLine();
		Matrix sys = new Matrix(stateDim, stateDim);
		for (int i = 0; i < stateDim; i++) {
      for (int j = 0; j < stateDim; j++) {
				sys.set(i, j, specFile.readDouble());
			}
		}
		StdOut.println("Linear system: ");
		sys.print(2, 1);

		// Initialize world
		system = new EulerIntegrator(sys, TIME_STEP);
		state = initCond;
	}

	public Matrix step() {
		Matrix newState = system.integrate(state);
		state = newState;
	  return state;
	}

}
