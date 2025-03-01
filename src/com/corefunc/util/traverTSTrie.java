package com.corefunc.util;

import com.corefunc.entities.TSTNode;

public class traverTSTrie {
	public static void traverl(TSTNode root)
	{
		if(root == null)
		{
			return;
		}
		TSTNode currentNode = root;
		System.out.println("data:"+currentNode.data+" splitchar:"+currentNode.splitchar);
		traverl(currentNode.eqNode);
		traverl(currentNode.loNode);
		traverl(currentNode.hiNode);
	}
	

}
