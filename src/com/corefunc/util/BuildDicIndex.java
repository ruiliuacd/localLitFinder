package com.corefunc.util;
import java.io.*;

import org.apache.lucene.analysis.*;
import org.apache.lucene.index.*;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.util.Version;
import org.apache.lucene.store.*;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.wltea.analyzer.lucene.IKAnalyzer;
/*
 * 使用空格分词器 将字典文件建立索引
 */
public class BuildDicIndex {
	private IndexWriter writer;
	public BuildDicIndex(String indexDir,String dictFile) throws Exception
	{
		BuildDicIndex indexer = new BuildDicIndex(indexDir);
		int numIndexed;
		try {
			numIndexed = indexer.index(dictFile, new TextFilesFilter());
		}finally{
			indexer.close();
		}
		
	}
	
	public BuildDicIndex(String indexDir) throws IOException
	{
		Directory dir = FSDirectory.open(new File(indexDir));
		IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_35,new WhitespaceAnalyzer(Version.LUCENE_35));
		writer = new IndexWriter(dir,conf);
	}
	
	public void close() throws CorruptIndexException, IOException
	{
		writer.close();
	}
	
	public int index(String dictFile,FileFilter filter)throws Exception
	{
		File[] files = new File(dictFile).listFiles();
		for(File f:files)
		{
			if(!f.isDirectory()&&
			!f.isHidden()&&
			f.exists()&&
			f.canRead()&&
			(filter == null || filter.accept(f)))
				indexFile(f);
		}
		return writer.numDocs();
	}
	private void indexFile(File f)throws Exception
	{
		System.out.println("Idexing"+f.getCanonicalPath());
		Document doc = getDocument(f);
		writer.addDocument(doc);
	}
	protected Document getDocument(File f)throws Exception
	{
		Document doc = new Document();
		//词典的词怎么存 ？？？
		doc.add(new Field("token",new FileReader(f)));
		return doc;
	}
	
	protected static class TextFilesFilter  implements FileFilter
	{
		public boolean accept(File path)
		{
			return path.getName().toLowerCase().endsWith(".txt");
		}
	}

}
