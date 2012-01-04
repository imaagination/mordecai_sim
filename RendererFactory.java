public class RendererFactory {
	public static Renderer getRenderer(String name) {
		if (name.equals("GravityRenderer")) {
			return new GravityRenderer();
		}
		
		return null;
	}
}
