
public class tester {
	public static void main(String[] args) {
		String name = "Mega Man";
		String console = "Nintendo Entertainment System";
		String search = "mAn";
		VideoGame vg = new VideoGame(name, console);
		String temp1 = vg.getVideoGameName().toLowerCase();
		String temp2 = search.toLowerCase();
		int i = temp1.indexOf(temp2);
		if(i>=0)
			System.out.println("Works, found: "+vg.toString());
		else
			System.out.println("Doesn't work");

	}

}
