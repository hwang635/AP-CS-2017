import java.util.ArrayList;

import javax.swing.JFileChooser;

public class Tester {

	public static void main(String[] args) {

		String workingDir = System.getProperty("user.dir");
		JFileChooser chooser = new JFileChooser(workingDir);
		//FileNameExtensionFilter filter = new FileNameExtensionFilter(
		//"JPG & GIF Images", "jpg", "gif");
		//chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " +
					chooser.getSelectedFile().getName());

			ArrayList<String> fileData = FileIO.readFile(chooser.getSelectedFile().getAbsolutePath());			
			for(String s : fileData) {
				System.out.println(s);
			}

			FileIO.writeFile("testfile", fileData);
		}
	}

}