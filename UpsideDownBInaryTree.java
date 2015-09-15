package Algorithm_PART1;
import Data.TreeNode;
import Data.PrintBinaryTree;

public class UpsideDownBInaryTree {
	
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		
		PrintBinaryTree.printInorder(n1);
		System.out.println();
		PrintBinaryTree.printInorder(upsideDown(n1));
		
				
		
	}
	
	public static TreeNode lastNode = null;
	public static TreeNode newRoot = null;
	
	public static TreeNode upsideDown(TreeNode root){
		if(root==null || root.left==null) return root;
        TreeNode nRoot=upsideDown(root.left);
        root.left.right=root;
        root.left.left=root.right;
        root.left=null;
        root.right=null;
        return nRoot;		
    } 
	
}
