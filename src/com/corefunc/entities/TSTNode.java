package com.corefunc.entities;

public class TSTNode {
	//考虑一下元素是否需要赋值为null??????????
	public String data = null;        //这里的类型以后要改成lucene中的语汇单元
	
	public TSTNode loNode; //left        
	public TSTNode eqNode; //middle
	public TSTNode hiNode; //right

	public char splitchar; 
	
	public TSTNode(char splitchar)
	{
		this.splitchar = splitchar;
	}
	public String toString()
	{
		return "splitchar:"+splitchar;
	}
}
