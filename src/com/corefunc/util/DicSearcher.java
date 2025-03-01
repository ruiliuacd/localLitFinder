package com.corefunc.util;

import java.io.*;

import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.*;
import org.apache.lucene.util.Version;
public class DicSearcher {
	public DicSearcher(String indexDir,String q) throws IOException, ParseException
	{
		Directory dir = FSDirectory.open(new File(indexDir));
		IndexSearcher is = new IndexSearcher(dir);
		QueryParser parser = new QueryParser(Version.LUCENE_35,"token",new WhitespaceAnalyzer(Version.LUCENE_35));
		Query query = parser.parse(q);
		TopDocs hits = is.search(query, 10);
		
		System.err.println("FOUND:"+hits.totalHits+"documents matched query:"+q+":");
		
		for(ScoreDoc scoreDoc : hits.scoreDocs)
		{
			Document doc = is.doc(scoreDoc.doc);
			System.out.print(doc.get("token"));
		}
		is.close();
	}

}
