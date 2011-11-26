import Jama.*;

public class Simulator {
  public static void main (String[] argv) {
		Renderer rend = new CarRenderer();
		World world = new World();
		while(true) {
			Matrix curState = world.step();
			rend.update(curState);
			try { Thread.sleep(100); } catch(Exception e) {}
		}
	}
}
