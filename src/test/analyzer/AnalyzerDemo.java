package test.analyzer;

import com.corefunc.util.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.util.Version;
public class AnalyzerDemo {
	private static final String[] examples={"the quick brown fox jumped over the lazy dogs","XY&Z Corpararion - xyz@example.com"};
	static String path="F:/199801/test";
	static String path1="K:/xxx/AddressSeg/dic/s";

	
	
	private static final Analyzer[] analyzers = new Analyzer[]{
		//new WhitespaceAnalyzer(Version.LUCENE_35),
		new SimpleAnalyzer(Version.LUCENE_35),
		//new StopAnalyzer(Version.LUCENE_35),
		new StandardAnalyzer(Version.LUCENE_35)
	};
	
	public static void main(String[]args)throws IOException
	{
		String[] strings=examples;
		if(args.length>0)
		{
			strings=args;
		}
		for(int i=0;i<strings.length;i++)
		{
			analyzer(strings[i]);
			System.out.println();
		}
		
		///////////////////////
		//BufferedReader reader=null;
		File[] files=new File(path).listFiles();
		for(int i=0;i<files.length;i++)
		{
			//reader=new BufferedReader(new FileReader(files[i]));
			analyzer(files[i]);
		}
	}
	private static void analyzer(String text)throws IOException
	{
		System.out.println("Analyzing\""+text+"\"");
		for(int i=0;i<analyzers.length;i++)
		{
			Analyzer analyzer=analyzers[i];
			String name = analyzer.getClass().getName();
			System.out.println(name+":");
			System.out.print("  ");
			AnalyzerUtils.displayTokens(analyzer, text);
			System.out.println();
		}
	}
	
/////////////////////////////////文件////////////////////
	private static void analyzer(File file)throws IOException
	{
		System.out.println("Analyzing\""+file+"\"");
		for(int i=0;i<analyzers.length;i++)
		{
			Analyzer analyzer=analyzers[i];
			String name = analyzer.getClass().getName();
			System.out.println(name+":");
			System.out.print("  ");
			AnalyzerUtils.displayTokens(analyzer, file);
			System.out.println();
		}
	}
}