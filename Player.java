import java.util.*;
import Jama.*;

public class Player {
	
	public static void main(String[] args) {
		String datafile = args[0];
		System.out.println("Datafile: " + datafile);
		In datastream = new In(datafile);

		Renderer renderer = RendererFactory.getRenderer(args[1]);

		double timestep = Double.parseDouble(args[2]);

		String state;
		while ((state = datastream.readLine()) != null) {
			StringTokenizer tok = new StringTokenizer(state, ",");
			Matrix stateVec = new Matrix(tok.countTokens(), 1);
			for (int i = 0; i < stateVec.getRowDimension(); i++) {
				stateVec.set(i, 0, Double.parseDouble(tok.nextToken()));
			}

			renderer.update(stateVec);

			try { Thread.sleep((int)(1000 * timestep)); }
			catch (Exception e) {}
		}
	}

}
