import Jama.*;

interface Integrator {
	
	// Integrate one time step
	// Takes as an argument a vector representing the state at t
	// Returns a vector representing the state at t + 1
  Matrix integrate(Matrix s); 

}
