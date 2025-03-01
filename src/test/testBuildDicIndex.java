package test;

import com.corefunc.util.BuildDicIndex;

public class testBuildDicIndex {
	static String indexDir="F:/199801/index";
	static String dicDir="F:/199801";
	public static void main(String args[]){

		try {
			BuildDicIndex ss = new BuildDicIndex(indexDir, dicDir);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
