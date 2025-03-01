package test;

import com.corefunc.util.FileTools;

public class testFileTools {
	public static void main(String[] args) {
		String fileName = "L:/书/testfolder1/output0.txt";
		//FileTools.readFileByBytes(fileName);
		FileTools.readFileByChars(fileName);
		FileTools.readFileByLines(fileName);
		FileTools.readFileByRandomAccess(fileName);
	}

}
