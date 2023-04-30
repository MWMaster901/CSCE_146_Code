/*
 * Christopher Schweninger
 */
import java.util.Scanner;
public class CSCE146Homework00 {

	public static void main(String[] args) 
	{
		//Introduction and initialization
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to vector calculator.\n "
				+ "This program can add or subtract two vectors (of same size)\n "
				+ "and can find the length of a given vector.");
		boolean quit = false;
		int vLength = 0;
		double temp = 0.0;
		while(!quit)
		{
			printChoices();
			int choice = keyboard.nextInt();
			switch(choice)
			{
			case 1:
				//Add 2 Vectors
				System.out.println("Please define the vectors size. (Integer)");
				vLength = keyboard.nextInt();
				//As a way of ensuring the two vectors are of the same size, when initializing the arrays, I use the same size integer
				//to make sure that the arrays can be added/subtracted to each other
				if(vLength <= 0)
				{
					System.out.println("INVALID VECTOR SIZE, RETURNING TO MENU.");
					break;
				}
				temp = 0.0;
				//By using a class, it allows reuse of these functions
				CSCE146VectorCalculator vectorsADD = new CSCE146VectorCalculator(vLength);
				//Admittedly I could simplify this \/\/ into a static method, but I choose to keep it here
				//because the current need for the program doesn't hyper-simplification.
				for(int i=0; i<vLength; i++)
				{
					i++;
					System.out.println("Please enter vector datapoint "+i+" for Vector 1. (Double)");
					i--;
					temp = keyboard.nextDouble();
					vectorsADD.setVector1(i, temp);
				}
				for(int i=0; i<vLength; i++)
				{
					i++;
					System.out.println("Please enter vector datapoint "+i+" for Vector 2. (Double)");
					i--;
					temp = keyboard.nextDouble();
					vectorsADD.setVector2(i, temp);
				}
				CSCE146VectorCalculator.addVectors(vectorsADD.getVector1(), vectorsADD.getVector2());
				break;
			case 2:
				//Subtract 2 Vectors
				System.out.println("Please define the vectors size. (Integer)");
				vLength = keyboard.nextInt();
				if(vLength <= 0)
				{
					//Errors like this just kick the user back to menu
					System.out.println("INVALID VECTOR SIZE, RETURNING TO MENU.");
					break;
				}
				temp = 0.0;
				CSCE146VectorCalculator vectorsSUB = new CSCE146VectorCalculator(vLength);
				//The same vector data filling in system that I used above
				for(int i=0; i<vLength; i++)
				{
					i++;
					System.out.println("Please enter vector datapoint "+i+" for Vector 1. (Double)");
					i--;
					temp = keyboard.nextDouble();
					vectorsSUB.setVector1(i, temp);
				}
				for(int i=0; i<vLength; i++)
				{
					i++;
					System.out.println("Please enter vector datapoint "+i+" for Vector 2. (Double)");
					i--;
					temp = keyboard.nextDouble();
					vectorsSUB.setVector2(i, temp);
				}
				CSCE146VectorCalculator.subtractVectors(vectorsSUB.getVector1(), vectorsSUB.getVector2());
				break;
			case 3:
				//Find the length
				System.out.println("Please define the vector size. (Integer)");
				vLength = keyboard.nextInt();
				if(vLength <= 0)
				{
					System.out.println("INVALID VECTOR SIZE, RETURNING TO MENU.");
					break;
				}
				temp = 0.0;
				CSCE146VectorCalculator vectorsLength = new CSCE146VectorCalculator(vLength);
				//Only need to do one array filling since only one vector is being inputted.
				for(int i=0; i<vLength; i++)
				{
					i++;
					System.out.println("Please enter vector datapoint "+i+" for the vector. (Double)");
					i--;
					temp = keyboard.nextDouble();
					vectorsLength.setVector1(i, temp);
				}
				//This is the only one of the three functions that doesn't automatically print the output, because
				//I didn't see major need in creating another static method
				double fLength = CSCE146VectorCalculator.vectorLength(vectorsLength.getVector1());
				System.out.println("The length of the vector is: "+fLength);
				break;
			case 4:
				//Menu quit option
				quit = true;
				System.out.println("Have a nice day");
				break;
				default:
					System.out.println("INVALID INPUT, TRY AGAIN");
			}
		}

	}
	//Even though this static method only has ONE command, it's here because I wasn't sure if I needed to put more.
	private static void printChoices()
	{
		System.out.println("1. Add two vectors\n"
				+ "2. Subtract two vectors\n"
				+ "3. Find length of a vector\n"
				+ "4. Exit");
	}
	
	

}
