package sample04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter {
	private String filePath, fileName;
	
	public FileOutputter() {
		System.out.println("2. FileOutputter()");
	}
	
	public void setFilePath(String filePath) {
		System.out.println("3. setFilePath(String filePath)");
		this.filePath = filePath;
	}


	public void setFileName(String fileName) {
		System.out.println("4. setFileName(String fileName)");
		this.fileName = fileName;
	}

	@Override
	public void output(String message) {
		System.out.println("8. output(String message)");
		
		try {
			//FileWriter fileWriter = new FileWriter(filePath+fileName);
			FileWriter fileWriter = new FileWriter(new File(filePath,fileName));
			fileWriter.write(message);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
