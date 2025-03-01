package test;

import java.io.IOException;

import org.apache.lucene.queryParser.ParseException;

import com.corefunc.util.DicSearcher;

public class testDicSearcher {
	public static String indexDir="F:/199801/index";
	public static String q="张";
	public static String q2="士们同胞朋友们们k女先生";
	public static void main(String args[])
	{
		try {
			DicSearcher d = new DicSearcher(indexDir,q2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
