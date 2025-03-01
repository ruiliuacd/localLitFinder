package com.index_search;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.*;
import org.apache.lucene.search.*;

import org.apache.lucene.store.*;
import org.apache.lucene.util.*;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.analyzer.MyAnalyzer;

public class testSearch {
	/*
	public static void main(String args[]) throws IOException, ParseException
	{
		String indexDir = "K:/aaaa";
		String q = "rules";
		search(indexDir,q);
	}
	*/
	public static String search(String indexDir,String q) throws IOException,ParseException
	{
		String rs = "";
		Directory dir = FSDirectory.open(new File(indexDir));
		IndexSearcher is = new IndexSearcher(dir);
		QueryParser parser = new QueryParser(Version.LUCENE_35,"content",new StandardAnalyzer(Version.LUCENE_35));
		Term t = new Term("content",q);
		Query query = new TermQuery(t);//parser.parse(q);
		
		TopDocs hits = is.search(query, 10);
		for(ScoreDoc scoreDoc:hits.scoreDocs)
		{
			Document doc = is.doc(scoreDoc.doc);
			rs+=(" 文件路径"+doc.getField("filename").stringValue()+"\n");
			System.out.println("fangfa1"+doc.getField("filename"));
			System.out.println("fangfa2"+doc.getField("filename").stringValue());
			//System.out.println(doc.get("content"));
		}
		is.close();
		return rs;
	}

}
