package com.abi.ir.tweetir.app;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import javax.swing.JOptionPane;

public class PartCFileMerger {

	public static void main(String[] args) throws IOException {
		// TODO find an appropriate way for this
		PartCFileMerger partC = new PartCFileMerger();

		// Before joining the files ensure that the i/p files are properly
		// cleansed
		String urlInputFolder = "Tweets";
		String urlConsolidatedFile = "SolrInput/consolidated.json";
		File inputFolder = new File(urlInputFolder);
		File consolidatedFile = new File(urlConsolidatedFile);
		partC.mergeTweetFiles(inputFolder, new FileOutputStream(consolidatedFile));
		// appending the end of the array
		JOptionPane.showMessageDialog(null,
				"append the end of the array to the newly create file and add commas using notepad++");
	}

	private void mergeTweetFiles(File inputFolder, FileOutputStream fileOutputStream) throws IOException {
		if (inputFolder.isDirectory()) {
			File[] inputFiles = inputFolder.listFiles();
			// adding the start of the array
			fileOutputStream.write('[');
			FileChannel outputChannel = fileOutputStream.getChannel();
			FileInputStream fis;
			for (File inputFile : inputFiles) {
				fis = new FileInputStream(inputFile);
				FileChannel inputChannel = fis.getChannel();
				// the second parameter corresponds to the position at which the
				// data has to be written in the output channel
				outputChannel.transferFrom(inputChannel, outputChannel.size(), inputChannel.size());
				fis.close();
			}

		}
	}
}
