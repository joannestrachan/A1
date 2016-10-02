package directory_reader;

import java.io.File;
import javax.swing.JFileChooser;

/**
 * Select, read, and print the contents of a directory.
 */
public class DirectoryReader {

	/**
	 * Select a directory, then print the full path to the directory and its
	 * contents, one per line. Prefix the contents with a hyphen and a space.
	 *
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fileChooser.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			System.out.println(file);

			// TODO: print the contents of the selected directory, one per
			// line. Prefix each line with a hyphen and a space: "- ".
			if (file.isDirectory()) {
				// Get a String array of the files in the directory
				File[] contents = file.listFiles();
				// Iterate over array contents recursively, using method 
				// printContents
				for (File i: contents) {
					printContents(i);
				}
			} else {
				// Print the current file
				System.out.println("- " + file.getName());
				
			}
		}
	}

public static void printContents(File s) {
	// Check if the current file is a directory
	if (s.isDirectory()) {
		// Print the current directory
		System.out.println("- " + s.getName() + "/");
		// Get a String array of the files in the directory
		File[] contents = s.listFiles();
		// Iterate over array contents recursively
		for (File i: contents) {
			printContents(i);
		}
	} else {
		// Print the current file
		System.out.println("- " + s.getName());
	}
}}

