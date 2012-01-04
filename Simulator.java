import Jama.*;

public class Simulator {
  private Renderer rend;
	private World world;
	private Agent agent;
	private Recorder recorder = null;
	private double timeStep;

	private Matrix readMat(int h, int w, In stream) {
		Matrix r = new Matrix(h, w);
		for (int i = 0; i < h; i++) 
			for (int j = 0; j < w; j++)
				r.set(i, j, stream.readDouble());
		
		return r;
	}

	private Renderer readRend(In stream) {
		String line = stream.readLine();
		// ** CAN I USE REFLECTION HERE TO SPECIFY THE TYPE OF RENDERER? **
		if (line.equals("GravityRenderer")) {
			return new GravityRenderer();
		}
		return null;
	}

	public void read(String filename) {
		// Spec variables
		int stateDim = 0;
		int controlDim = 0;
		Matrix initCond = null;
		Matrix initControl = null;
		Matrix linSystem = null;
		Matrix contSystem = null;
		String physController = "";
		String trajectoryFile = "";

    In specFile = new In(filename);
		String curLine;
		while ((curLine = specFile.readLine()) != null) {
			// Clean line
			// curLine.gsub(" ", "");
			
			if (curLine.equals("time_step")) {
				timeStep = specFile.readDouble();
				StdOut.println("Time step: " + timeStep);
			}
			else if (curLine.equals("state_dimension")) {
				stateDim = specFile.readInt();
				StdOut.println("State dimension: " + stateDim);
			}
			else if (curLine.equals("control_dimension")) {
				controlDim = specFile.readInt();
				StdOut.println("Control dimension: " + controlDim);
			}
			else if (curLine.equals("initial_conditions")) {
				initCond = readMat(stateDim, 1, specFile);
				StdOut.println("Initial conditions:");
				initCond.print(2, 1);
			}
			else if (curLine.equals("initial_controls")) {
				initControl = readMat(controlDim, 1, specFile);
				StdOut.println("Initial controls:");
				initCond.print(2, 1);
			}
			else if (curLine.equals("linear_system")) {
				linSystem = readMat(stateDim, stateDim, specFile);
				StdOut.println("Linear system:");
				linSystem.print(2, 1);	
			}
			else if (curLine.equals("physical_controller")) {
				physController = specFile.readLine();
				StdOut.println("Physical controller: " + physController);
			}
			else if (curLine.equals("control_system")) {
				contSystem = readMat(stateDim, controlDim, specFile);
				StdOut.println("Control system:");
				contSystem.print(2, 1);
			}
			else if (curLine.equals("renderer")) {
				rend = readRend(specFile);
			}
			else if (curLine.equals("trajectory_file")) {
				trajectoryFile = specFile.readLine();
			}	
		}

		// Initialize instance variables
		world = new World(timeStep, initCond, initControl, linSystem, contSystem);
		agent = new Agent(physController);
		if (!trajectoryFile.equals("")) recorder = new Recorder(trajectoryFile);
	}

	public void advance() {
		Matrix curState = world.getState();

		// If trajectory recording is enabled, do so
		if (recorder != null) recorder.recordState(curState);

		agent.observeState(curState);
		Matrix newControls = agent.getControls();
		world.applyControl(newControls);
		curState = world.step();
		rend.update(curState);
	}

	public double getTimeStep() {
		return timeStep;
	}
  public static void main (String[] argv) {
		Simulator sim = new Simulator();
		sim.read(argv[0]);
		while(true) {
			sim.advance();
			try { Thread.sleep((int)(1000 * sim.getTimeStep())); } catch(Exception e) {}
		}
	}
}
