package Trees;

public class BinaryTreeAlgos {
	public static void main(String[] args) {
		int[] in = {4, 2, 5, 1, 6, 3};
		int[] pre = {1, 2, 4, 5, 3, 6};
		
		Node root = buildTreefromTraversals(in, pre, 0, in.length - 1);
		System.out.println(root.getLeft().getRight().getKey());
	}
	
	static int preIndex = 0 ;
	/**
	 * Builds tree from inorder and preOrder traversak
	 * @param in inorder array
	 * @param pre preorder array
	 * @param start index of inorder array
	 * @param end index of preorder array
	 * @returns Root of Binary Tree
	 */
	public static Node buildTreefromTraversals(int[] in, int[] pre, int start, int end){
		if(start > end)
			return null;
		
		Node node = new Node(pre[preIndex++]);
		if(start == end)
			return node ;
		
		int inIndex = searchInInorder(in, start, end, node.getKey());
		node.setLeft(buildTreefromTraversals(in, pre, start, inIndex - 1));
		node.setRight(buildTreefromTraversals(in, pre, inIndex + 1, end));
		
		return node; 
	}
	private static int searchInInorder(int[] in, int start, int end, int key) {
		for(int i = start ; i <= end ; i++){
			if(in[i] == key)
				return i ;
		}
		
		return -1;
	}
}
