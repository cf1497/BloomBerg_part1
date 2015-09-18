package Algorithm_Part1;
import data.PrintTree;
import data.TreeNode;

public class LowestAncestor {
	
	public static void main(String[] args){
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3= new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n5.left = n3;
		n5.right = n7;
		n3.left = n2;
		n3.right = n4;
		n2.left = n1;
		n7.left = n6;
		
		//PrintTree.preOrderPrint(n5);
		TreeNode n =  lAC_BST(n5, n7, n6);
		System.out.println(n.val);
		
		
		
		
	}
	
	// Binary Tree Method : O(n)
	public static TreeNode lAC_BT(TreeNode root, TreeNode p, TreeNode q){
		
		if(root==null || root==p || root==q){
			return root;	
		}
		
		
		TreeNode left = lAC_BT(root.left, p, q);
		TreeNode right = lAC_BT(root.right,p,q);
		
		if(left!=null && right !=null){
			return root;
		}
		
		if(left!=null){
			return left;
		}
		
		if(right!=null){
			return right;
		}
		
		return null;
	}
	
	//Method: Binary Search Tree: O(lgnS)
	public static TreeNode lAC_BST(TreeNode root, TreeNode p1, TreeNode p2){
		if(root==null){
			return null;
		}
		
		if((root.val-p1.val)*(root.val-p2.val)<=0){
			return root;
		}else if(p1.val<root.val){
			return lAC_BST(root.left, p1, p2);
		}else{
			return lAC_BST(root.right,p1,p2);
		}
		
	
	}
}
















