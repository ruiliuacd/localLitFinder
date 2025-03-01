package com.corefunc.util;

import com.corefunc.entities.BSTNode;

public class TagBST {
	private BSTNode root;
	private int size;
	
	public BSTNode getRoot()
	{
		return root;
	}
	
	public TagBST(BSTNode root)
	{
		this.root = root;
		size++;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public boolean insert(String word)
	{
		boolean flag = insertTagBST(word,this.root);
		if(flag)size++;
		return flag;
		
	}
	
	public boolean insertTagBST(String word,BSTNode root)
	{
		if(root == null)
		{
			this.root = new BSTNode(word);
			return true;
		}
		else if(root.keyword.compareTo(word)>0)
		{
			if(root.loNode != null)
			{
				return insertTagBST(word,root.loNode);
			}
			else
			{
				root.loNode = new BSTNode(word);
				return true;
			}
		}
		else if(root.keyword.compareTo(word) < 0)
		{
			if(root.hiNode != null)
			{
				return insertTagBST(word,root.hiNode);
			}
			else
			{
				root.hiNode = new BSTNode(word);
				return true;
			}
		}
		else
		{
			root.weight++;
			return true;
		}
	}
	public void printString()
	{
		travelString(root);
	}
	public void travelString(BSTNode root)
	{
		String result = null;
		
		
		if(root !=null)
		{
			System.err.println(root.keyword+":"+root.weight);
			if(root.loNode != null)
			{
				travelString(root.loNode);
			}
			if(root.hiNode != null)
			{
				travelString(root.hiNode);
			}
		}
	}

}
