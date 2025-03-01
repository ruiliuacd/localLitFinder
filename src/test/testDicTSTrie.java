package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.corefunc.entities.TSTNode;
import com.corefunc.util.DicTSTrie;
import com.corefunc.util.traverTSTrie;

public class testDicTSTrie {
	public static void main(String args[]) throws IOException
	{
		
		String dicdir = "K:/数据挖掘/搜索引擎/揭秘搜索引擎随书光盘/Char04/AddressSeg/dic/s";
		String datafilepath="L:/书/my.txt";
/////////////////////////////加载词典///////////////
		File[] files=new File(dicdir).listFiles();
		DicTSTrie[] s = new DicTSTrie[files.length];
		for(int i=0;i<files.length;i++)
		{
			s[i] = new DicTSTrie(files[i]);
			System.out.println("aaaaaaaaaaaaaaaaaaa"+s[i].root.data);
		}
//////////////////////////////	
		/*
		for(int i=0;i<files.length;i++)
		{
			System.out.println(i);
			traverTSTrie.traverl(s[i].root);
			
		}
		*/
////////////////////////下面这个FOR循环 将一个文本文件 以各个字典分词，但是有个bug，///////
		///////是跨行的词将无法识别。另外读取文件效率较低，可参考《lucene分析与应用》31页的if语句中的读文件方法
		DicTSTrie dictstrie = new DicTSTrie();
		for(int i=0;i<s.length;i++)
		{
					File datafile = new File(datafilepath);
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
						dictstrie.wordSegment(tempString,s[i].root);
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
		

	}

}
