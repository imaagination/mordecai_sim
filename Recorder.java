import Jama.*;
import java.io.*;

public class Recorder {

	private String filepath;
	private File file;
	private FileWriter fileWriter;

	public Recorder(String path) {
		try {
			filepath = path;
			file = new File(filepath);
			if (!file.canWrite()) {
				file.createNewFile();
			}
			fileWriter = new FileWriter(file);
		}
		catch (Exception e) {}
	}

	public boolean recordState(Matrix state) {
		try {
			for (int i = 0; i < state.getRowDimension(); i++) {
				fileWriter.write(Double.toString(state.get(i, 0)));
				fileWriter.write(",");
			}
			fileWriter.write("\n");
		}
		catch (Exception e) { return false; }
		
		return true;
	}

}
