package com.util;

import com.entity.TSTNode;
import java.io.*;

import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.util.Version;
import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.tokenattributes.*;

public class DicTSTrie {
	
	public TSTNode root;
	
	public DicTSTrie(File file)
	{
		WhitespaceAnalyzer analyzer = new WhitespaceAnalyzer(Version.LUCENE_35);
		try {
			///////////////注意 这里有个域名 suiyi想办法去掉 可能会影响后面工作
		TokenStream stream = analyzer.tokenStream("suiyi", new FileReader(file));
		TermAttribute term = stream.addAttribute(TermAttribute.class);
		
			while(stream.incrementToken())
			{
				String key = term.term();
				System.out.println(key);
				addWord(key);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public DicTSTrie()
	{
		
	}
	
	private TSTNode addWord(String key)
	{
		
		if ("".equals(key)) {
			return null;
		}
		
		if (root == null) {
			root = new TSTNode(key.charAt(0));
			//root.data = "sdfffffff";
		}
		
		TSTNode currentNode = root;
		int charIndex = 0;
		while(true)
		{
			int charComp = key.charAt(charIndex) - currentNode.splitchar;
			////等于
			if(charComp == 0)
			{
				charIndex++;
				if(charIndex == key.length())
				{
					currentNode.data = key;
					return currentNode;//是否要返回 再议
				}
				if(currentNode.eqNode == null)
				{
					currentNode.eqNode = new TSTNode(key.charAt(charIndex));
					//////////////////////////////////////////currentNode.eqNode.data=key;
				}
				currentNode = currentNode.eqNode;	
			}
			///小于
			else if(charComp<0)
			{
				if(currentNode.loNode == null)
				{
					currentNode.loNode = new TSTNode(key.charAt(charIndex));
					/////////////////////////////////////////////currentNode.loNode.data = key;
				}
				currentNode = currentNode.loNode;
			}
			/////大于
			else
			{
				if(currentNode.hiNode == null)
				{
					currentNode.hiNode = new TSTNode(key.charAt(charIndex));
					////////////////////////////////////////////////currentNode.hiNode.data = key;
				}
				currentNode = currentNode.hiNode;
			}
			
		}
	}
////////////////////////////需指定查找那个字典书，即需要指定根节点///////
	public String matchLong(String key,int offset)//,TSTNode rootNode)
	{
		String ret = null;
		if(key == null || root ==null||"".equals(key))
		{
			return ret;
		}
		TSTNode currentNode = root;
		int charIndex = offset;
		while(true)
		{
			if(currentNode == null){    //说明为没有直接后继 所以为终端节点，也就是最大长度匹配
				return ret;
			}
			int charComp = key.charAt(charIndex) - currentNode.splitchar;
			
			if(charComp == 0)           //相等 但不一定是最大长度匹配， 要通过上面的判断
			{
				charIndex++;
				
				if(currentNode.data != null)
				{
					ret = currentNode.data;
				}
				if(charIndex == key.length())
				{
					return ret;        //此时没有到达字典的终端节点 但是词已经终结
				}
				currentNode = currentNode.eqNode;
			}
			else if(charComp <0)
			{
				currentNode = currentNode.loNode;
			}
			else
			{
				currentNode = currentNode.hiNode;
			}
		}
	}
/////////////////	
	public static String matchLong(String key,int offset,TSTNode rootNode)
	{
		String ret = null;
		if(key == null || rootNode ==null||"".equals(key))
		{
			return ret;
		}
		TSTNode currentNode = rootNode;
		int charIndex = offset;
		while(true)
		{
			if(currentNode == null){    //说明为没有直接后继 所以为终端节点，也就是最大长度匹配
				return ret;
			}
			int charComp = key.charAt(charIndex) - currentNode.splitchar;
			
			if(charComp == 0)           //相等 但不一定是最大长度匹配， 要通过上面的判断
			{
				charIndex++;
				
				if(currentNode.data != null)
				{
					ret = currentNode.data;
				}
				if(charIndex == key.length())
				{
					return ret;        //此时没有到达字典的终端节点 但是词已经终结
				}
				currentNode = currentNode.eqNode;
			}
			else if(charComp <0)
			{
				currentNode = currentNode.loNode;
			}
			else
			{
				currentNode = currentNode.hiNode;
			}
		}
	}
	
	public char[] matchLong(char[] key,int offset)//,TSTNode rootNode)
	{
		String ret = null;
		if(key == null || root ==null||"".equals(key))
		{
			return null;//ret.toCharArray();
		}
		TSTNode currentNode = root;
		//
		int charIndex = offset;
		while(true)
		{
			System.out.println(currentNode);
			if(currentNode == null){    //说明为没有直接后继 所以为终端节点，也就是最大长度匹配
				
				if(ret == null)
				{
					return null;
				}
				System.out.println(ret);
				return ret.toCharArray();
			}
			int charComp = key[charIndex] - currentNode.splitchar;
			//System.out.println("执行了没有啊 我的神 应该与“相等 的 时候”同时出现");
			
			if(charComp == 0)           //相等 但不一定是最大长度匹配， 要通过上面的判断
			{
				charIndex++;
				
				if(currentNode.data != null)
				{
					ret = currentNode.data;
					//System.out.println("相等 的 时候 ：：：："+ret);
				}
				if(charIndex == key.length)
				{
					return ret.toCharArray();        //此时没有到达字典的终端节点 但是词已经终结
				}
				currentNode = currentNode.eqNode;
			}
			else if(charComp <0)
			{
				currentNode = currentNode.loNode;
			}
			else
			{
				currentNode = currentNode.hiNode;
			}
		}
	}

	public static char[] matchLong(char[] key,int offset,TSTNode rootNode)
	{
		String ret = null;
		if(key == null || rootNode ==null||"".equals(key))
		{
			return null;//ret.toCharArray();
		}
		TSTNode currentNode = rootNode;
		//
		int charIndex = offset;
		while(true)
		{
			System.out.println(currentNode);
			if(currentNode == null){    //说明为没有直接后继 所以为终端节点，也就是最大长度匹配
				
				if(ret == null)
				{
					return null;
				}
				System.out.println(ret);
				return ret.toCharArray();
			}
			int charComp = key[charIndex] - currentNode.splitchar;
			//System.out.println("执行了没有啊 我的神 应该与“相等 的 时候”同时出现");
			
			if(charComp == 0)           //相等 但不一定是最大长度匹配， 要通过上面的判断
			{
				charIndex++;
				
				if(currentNode.data != null)
				{
					ret = currentNode.data;
					//System.out.println("相等 的 时候 ：：：："+ret);
				}
				if(charIndex == key.length)
				{
					return ret.toCharArray();        //此时没有到达字典的终端节点 但是词已经终结
				}
				currentNode = currentNode.eqNode;
			}
			else if(charComp <0)
			{
				currentNode = currentNode.loNode;
			}
			else
			{
				currentNode = currentNode.hiNode;
			}
		}
	}
	
	public void wordSegment(String sentence)
	{
		int senlen = sentence.length();
		int i=0;
		
		while(i < senlen)
		{
			String word = matchLong(sentence,i);
			if(word!=null)       ///已经匹配上了
			{
				i += word.length();
				System.out.print(word+" ");
			}
			else          ///如果字典中没有 就按单字切分
			{
				word = sentence.substring(i,i+1);
				System.out.print(word+" ");
				++i;
			}
		}
	}
	
	public  static void wordSegment(String sentence,TSTNode rootNode)
	{
		int senlen = sentence.length();
		int i=0;
		
		while(i < senlen)
		{
			String word = matchLong(sentence,i,rootNode);
			if(word!=null)       ///已经匹配上了
			{
				i += word.length();
				System.out.print(word+" ");
			}
			else          ///如果字典中没有 就按单字切分
			{
				word = sentence.substring(i,i+1);
				System.out.print(word+" ");
				++i;
			}
		}
	}
}
