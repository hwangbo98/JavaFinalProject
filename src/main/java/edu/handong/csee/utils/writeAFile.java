package edu.handong.csee.utils;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class writeAFile{
	
	public static void wFile(ArrayList<String> lines, String targetFileName) {
	
	try {
		
		for(int i=1; i<=2; i++) {
			String fileName = targetFileName + i + ".csv";
			
			File file = new File(fileName);
			FileOutputStream fileOutput = new FileOutputStream(file);
			DataOutputStream dataOutput = new DataOutputStream(fileOutput);
			
			for(String line: lines) {
				dataOutput.write((line+"\n").getBytes());
				
				if(!file.exists()) {
					file.getParentFile().mkdirs();
				}
				
			}
			dataOutput.close();
			fileOutput.close();
		}
	
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
