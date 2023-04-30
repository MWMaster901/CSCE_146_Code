//FOR TESTING ONLY
//FOR TESTING ONLY
public class tester {
	private static LinkedBST<shape> sBST = new LinkedBST<shape>();
	private static shape aShape = new shape("Circle", 1, 1);
	private static shape bShape = new shape("Rectangle", 2, 4);
	private static shape cShape = new shape("Right Triangle", 1, 2);
	private static shape dShape = new shape("Circle", 4, 4);
	public static void main(String[] args) {
		//FOR TESTING ONLY
		sBST.add(aShape);
		sBST.add(bShape);
		sBST.add(cShape);
		sBST.add(dShape);
		sBST.printInOrder();
		//FOR TESTING ONLY
	}

}
