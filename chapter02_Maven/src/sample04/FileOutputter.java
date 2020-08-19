package sample04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileOutputter implements Outputter {
	private String filePath, fileName;
	
	public FileOutputter() {
		System.out.println(" FileOutputter()");
	}
	@Autowired
	public void setFilePath(@Value("/Volumes/Samsung USB/java/spring")String filePath) {
		System.out.println(" setFilePath(String filePath)");
		this.filePath = filePath;
	}
	@Autowired
	public void setFileName(@Value("result.txt")String fileName) {
		System.out.println(" setFileName(String fileName)");
		this.fileName = fileName;
	}

	@Override
	public void output(String message) {
		System.out.println(" output(String message)");
		
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
