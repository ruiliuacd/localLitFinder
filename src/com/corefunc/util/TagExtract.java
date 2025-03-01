package com.corefunc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.analysis.tokenattributes.FlagsAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;

import com.corefunc.entities.BSTNode;
import com.corefunc.myanalyzer.MyAnalyzer;

public class TagExtract {
	//public Document doc = new Document();
	
	public static void main(String args[])
	{
		String dicdir = "K:/xxx/AddressSeg/dic/s";
		String datafilepath="L:/书/my.txt";
		String indexDir = "l:\\书\\index";
		TagBST tagbst = buildTagBST(datafilepath,dicdir);
		try {
			tagIndex(FSDirectory.open(new File(indexDir)),tagbst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public static Document tagIndex(Directory indexDir,TagBST tagbst) throws CorruptIndexException, LockObtainFailedException, IOException
	{
		Document doc = new Document();
		MyAnalyzer analyzer = new MyAnalyzer();
		IndexWriter writer = new IndexWriter(indexDir,analyzer,true,IndexWriter.MaxFieldLength.UNLIMITED);
		
		String result = null;
		
		BSTNode root = tagbst.getRoot();
		addDocByTravel(root,doc);
		writer.addDocument(doc);
		writer.close();
		return doc;

		//analyzer.tokenStream(fieldName, reader)
	}

	/////////////////这是通过递归方法将TagBST树中的元素及其权值取出，所以递归中每一层栈都保存一个doc会比较费内存。
	private static void addDocByTravel(BSTNode root,Document doc)
	{
		String result = null;
		
		if(root !=null)
		{
			System.err.println(root.keyword+":"+root.weight);
			doc.add(new Field("tag",root.keyword+""+Integer.toString(root.weight),Field.Store.YES,Field.Index.NOT_ANALYZED_NO_NORMS));
			if(root.loNode != null)
			{
				addDocByTravel(root.loNode,doc);
			}
			if(root.hiNode != null)
			{
				addDocByTravel(root.hiNode,doc);
			}
		}
	}
////////////////////////下面这个FOR循环 将一个文本文件 以各个字典分词，但是有个bug，///////
		///////是跨行的词将无法识别。另外读取文件效率较低，可参考《lucene分析与应用》31页的if语句中的读文件方法
	public static TagBST buildTagBST(String txtData,String DicDir)
	{
		//DicTSTrie dictstrie = new DicTSTrie();
		/////////////////////////////加载词典///////////////
		File[] files=new File(DicDir).listFiles();
		DicTSTrie[] s = new DicTSTrie[files.length];
		for(int i=0;i<files.length;i++)
		{
		s[i] = new DicTSTrie(files[i]);
		System.out.println("s[i].root.data：：        "+s[i].root.data);
		}
		//////////////////////////////
		for(int i=0;i<files.length;i++)
		{
		System.out.println(i);
		traverTSTrie.traverl(s[i].root);
		}
		
		TagBST tagbst = new TagBST(new BSTNode("一"));// 这个"一"想办法去掉啊！
		
		for(int i=0;i<s.length;i++)
		{
				
				File datafile = new File(txtData);
				BufferedReader reader = null;
				try {
					System.out.println("以行为单位读取文件内容，一次读一整行：");
					reader = new BufferedReader(new FileReader(datafile));
					String tempString = null;
					int line = 1;
					// 一次读入一行，直到读入null为文件结束
					while ((tempString = reader.readLine()) != null) {
						// 显示行号
						System.out.println("line " + line + ": " + tempString);
						s[i].wordSegment(tempString);
	/////////////////
						int senlen = tempString.length();
						int j=0;
						
						while(j < senlen)
						{
							String word = s[i].matchLong(tempString,j);
							if(word!=null)       ///已经匹配上了
							{
								j += word.length();
								tagbst.insert(word);
								//System.out.print(word+" ");
							}
							else          ///如果字典中没有 就按单字切分
							{
								word = tempString.substring(j,j+1);
								//System.out.print(word+" ");
								++j;
							}
						}
						
	/////////////
						
						
						line++;
					}
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (reader != null) {
						try {
							reader.close();
						} catch (IOException e1) {
						}
					}
				}
		}
///////////////////////
		System.out.println();
		System.out.println("/////////////////");
		tagbst.printString();
		return tagbst;
	}



}
