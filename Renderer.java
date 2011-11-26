import Jama.*;

interface Renderer {
  
	// Draw state s according to the rules of the renderer
	public void update(Matrix s);

}
