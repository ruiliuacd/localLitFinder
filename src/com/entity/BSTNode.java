package com.entity;

public class BSTNode {
	public String keyword;
	public int weight;
	
	public BSTNode loNode;
	public BSTNode hiNode;
	
	public BSTNode(String keyword)
	{
		this.keyword = keyword;
	}
	
	public String toString()
	{
		return keyword;
	}

}
