package hw04;

/**
 * Find the key associated with the minimum value in a tree.
 */
public class MinKeyFinder implements CS232Visitor<String, Integer> {
	private String minKey;
	private Integer minVal;

	public MinKeyFinder() {
		minKey = null;
		minVal = null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void visit(String key, Integer value) {
		if(minVal == null||value < minVal) { //if its the first value or if the current val is lower than recordMin adjust the variables
			minVal = value; //This function will update after each node 
			minKey = key;
		}
		

	}

	/**
	 * Get the key associated with the minimum value in the tree.
	 * 
	 * @return the key associated with the minimum value.
	 */
	public String getMinKey() {
		return minKey;
	}
	
	public static void main(String[] args) {
		String[]keys = {"A","B","C","D","E","F","G","H","I","J"};
		Integer[] vals = {100,90,80,70,60,10,40,30,20,30};
		 
		
		CS232LinkedBinaryTree<String,Integer> testTree = new CS232LinkedBinaryTree<>(keys, vals);
		MinKeyFinder visitor1 = new MinKeyFinder();
		testTree.visitPreOrder(visitor1);
		System.out.println("Min Key:"+ visitor1.getMinKey());
	}
}
