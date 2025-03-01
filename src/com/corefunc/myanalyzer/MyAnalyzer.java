package com.corefunc.myanalyzer;

import java.io.*;

import org.apache.lucene.analysis.*;

public class MyAnalyzer extends Analyzer {
	public TokenStream tokenStream(String fieldName,Reader reader)
	{
		TokenStream stream = new MyTokenizer(reader);
		return stream;
	}
}
