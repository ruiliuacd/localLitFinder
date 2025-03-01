package com.index_search;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.LinkedList;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.*;
import org.wltea.analyzer.lucene.IKAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.util.Version;
import com.analyzer.MyAnalyzer;
import com.util.PdfExtractor;
import com.util.filter.PdfFilesFilter;

//import test.*;

public class testIndexer {
	private IndexWriter writer;
	private FileFilter pdfFilter = new PdfFilesFilter();
	
	public testIndexer(String indexDir) throws CorruptIndexException, LockObtainFailedException, IOException
	{
		Directory dir = FSDirectory.open(new File(indexDir));
		writer = new IndexWriter(dir,new StandardAnalyzer(Version.LUCENE_35),true,IndexWriter.MaxFieldLength.UNLIMITED);
		writer.setUseCompoundFile(false);
	}
	public void close() throws CorruptIndexException, IOException
	{
		writer.close();
	}
	 private void GetOneDir(File file , LinkedList list){
	      //每个文件夹遍历都会调用该方法
	      System.out.println("Dir==>" + file.getAbsolutePath());   
	      File[] files = file.listFiles();
//	      sumdir += 1;
	      if (files == null || files.length == 0) {
	           return ;
	      }

	      for (File f : files) {
	          if (f.isDirectory()) {
	              list.add(f);
	          } else {
	               //这里列出当前文件夹根目录下的所有文件
	               System.out.println("file==>" + f.getAbsolutePath());
	          }
	     }
	 }	
	public void assortDirtoIndex(String dataDir)
	{
	    File[] filest = new File(dataDir).listFiles();
  	    for (File f: filest) {
      	  
    	      if (!f.isDirectory() &&
    	          !f.isHidden() &&
    	          f.exists() &&
    	          f.canRead() &&
    	          (pdfFilter == null || pdfFilter.accept(f))) {
    	        try {
    				indexPDFile(f);
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    	      }
    	    }	    
	    
	    LinkedList list = new LinkedList();
	    
//	    try{
	    	
			File pdfDirFile=new File(dataDir);
			GetOneDir(pdfDirFile, list); //调用遍历文件夹根目录文件的方法
			File tmp;
		      while (!list.isEmpty()) {
		    	  
		          tmp = (File) list.removeFirst();
		          
		          //这个地方的判断有点多余，但是为了保险还是给个判断了，正常情况列表中是只有文件夹的
		          //但是不排除特殊情况，例如：本身是文件夹的目标在压入堆栈之后变成了文件
		          if (tmp.isDirectory()) {
		        	  File[] files=new File(tmp.getAbsolutePath()).listFiles();
		              GetOneDir(tmp, list);
			      	    for (File f: files) {
				        	  
				      	      if (!f.isDirectory() &&
				      	          !f.isHidden() &&
				      	          f.exists() &&
				      	          f.canRead() &&
				      	          (pdfFilter == null || pdfFilter.accept(f))) {
				      	        try {
				      				indexPDFile(f);
				      			} catch (Exception e) {
				      				// TODO Auto-generated catch block
				      				e.printStackTrace();
				      			}
				      	      }
				      	    }
		          } else {
		        	  System.out.println("file==>" + tmp.getAbsolutePath());
		          }
		     }
	    	
//	    }catch (NullPointerException e) {
//			// TODO Auto-generated catch block
//			System.out.println("cuo");
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("cuo cuo");
//			System.exit(-1);
//		}
	    
//	    for (File f: files) {
//	      if (!f.isDirectory() &&
//	          !f.isHidden() &&
//	          f.exists() &&
//	          f.canRead() &&
//	          (pdfFilter == null || pdfFilter.accept(f))) {
//	        try {
//				indexPDFile(f);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	      }
//	    }
	}
	
	public void indexPDFile(File file) throws Exception
	{
//    		File file = new File(filename);
		System.out.print("indexPDFile");
		System.out.println(file);
//		System.out.println(PdfExtractor.getText(file));
		Document doc = new Document();
		doc.add(new Field("filename",file.getAbsolutePath(),Field.Store.YES,Field.Index.NOT_ANALYZED_NO_NORMS));
		doc.add(new Field("content",PdfExtractor.getText(file),Field.Store.YES,Field.Index.ANALYZED));
		writer.addDocument(doc);
	}
	
	public static void main(String args[])
	{
		String path="k:/aaaa";
		String pdfDir="k:/";
		try {
			testIndexer indx = new testIndexer(path);
			indx.assortDirtoIndex(pdfDir); 
			indx.close();
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
