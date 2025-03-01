package com.analyzer;

import java.io.*;


import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.analysis.tokenattributes.FlagsAttribute;

import com.entity.TSTNode;
import com.util.DicTSTrie;

public class MyTokenizer extends Tokenizer {
	public File file=new File("K:/数据挖掘/搜索引擎/揭秘搜索引擎随书光盘/Char04/AddressSeg/dic/s/新建 文本文档.txt");
	private DicTSTrie dic = new DicTSTrie(file);
	private TermAttribute termAtt;
	private FlagsAttribute flagsAtt;
	private static final int IO_BUFFER_SIZE = 4096;
	private char[] ioBuffer = new char[IO_BUFFER_SIZE];
	
	private boolean done;
	private int i = 0;
	private int upto = 0;
	
	public MyTokenizer(Reader reader)
	{
		super(reader);
		this.termAtt = (TermAttribute)addAttribute(TermAttribute.class);
		//this.flagsAtt = (FlagsAttribute)addAttribute
		this.done = false;
	}
	public void resizeIOBuffer(int newSize)
	{
		if(ioBuffer.length < newSize)
		{// not big enough, create s new array with slight over allocation and preserve content
			final char[] newCharBuffer = new char[newSize];
			System.arraycopy(ioBuffer, 0, newCharBuffer, 0, ioBuffer.length);
			ioBuffer = newCharBuffer;
		}
	}

	@Override
	public boolean incrementToken() throws IOException {
		// TODO Auto-generated method stub
		if(!done)
		{
			clearAttributes();
			done = true;
			upto = 0;
			while(true)
			{
				final int length = input.read(ioBuffer,upto,ioBuffer.length - upto);
				if(length == -1)break;
				upto += length;
				if(upto == ioBuffer.length)
					resizeIOBuffer(upto * 2);
			}
		}
		if(i<upto)
		{
			//System.out.println("dic.root:::::::"+dic.root);
			//System.out.println(ioBuffer);
			//TSTNode dicroot = dic.root;
			char[] word = dic.matchLong(ioBuffer, i);//, dicroot);
			if(word!=null)              ///////说明匹配成功
			{
				termAtt.setTermBuffer(word, 0, word.length);
				i += word.length;
				System.out.println("看看筛出来的单词word是什么："+word);
			}
			else
			{
				//termAtt.setTermBuffer(ioBuffer, i, 1);
				++i;   //下次匹配点在这个字符之后
			}
			return true;
		}
		return false;
	}

}
