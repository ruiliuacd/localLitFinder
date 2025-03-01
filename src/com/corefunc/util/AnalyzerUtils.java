package com.corefunc.util;

import java.io.*;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.tokenattributes.*;

public class AnalyzerUtils {
	public static void displayTokens(Analyzer analyzer,String text)throws IOException
	{
		displayTokens(analyzer.tokenStream("suiyi", new StringReader(text)));
	}
	
	public static void displayTokens(TokenStream stream)throws IOException
	{
		TermAttribute term = stream.addAttribute(TermAttribute.class);
		while(stream.incrementToken())
		{
			System.out.print("["+term.term()+"]");
		}
	}
////////////////////////////对文件/////////////////////////////
	public static void displayTokens(Analyzer analyzer,File file)throws IOException
	{
		displayTokens(analyzer.tokenStream("suiyi", new FileReader(file)));
	}
	

}
