/*
 * Christopher Schweninger
 */
public class CSCE146VectorCalculator {

	private double[] vector1;
	private double[] vector2;
	//I don't have a defualt constructor, becuase I'm not exactly sure how I would have a "default" contstruction...
	public CSCE146VectorCalculator(int vectorSize)
	{
		vector1 = new double[vectorSize];
		vector2 = new double[vectorSize];
	}
	//Getters
	public double[] getVector1()
	{
		return this.vector1;
	}
	public double[] getVector2()
	{
		return this.vector2;
	}
	//Setters
	public void setVector1(int position, double value)
	{
		vector1[position] = value;
	}
	public void setVector2(int position, double value)
	{
		vector2[position] = value;
	}
	//This function adds two arrays of the same size then prints the final array
	public static void addVectors(double[] array1, double[] array2)
	{
		double[] sumVector = new double[array1.length];
		for(int i=0; i<array1.length; i++)
		{
			sumVector[i] = array1[i] + array2[i];
		}
		CSCE146VectorCalculator.printVector(sumVector);
	}
	//This function subtracts two arrays of the same size then prints the final array
	public static void subtractVectors(double[] array1, double[] array2)
	{
		double[] differenceVector = new double[array1.length];
		for(int i=0; i<array1.length; i++)
		{
			differenceVector[i] = array1[i] - array2[i];
		}
		CSCE146VectorCalculator.printVector(differenceVector);
	}
	//This function finds the length of a vector/array and RETURNS the length
	public static double vectorLength(double[] array1)
	{
		double length = 0;
		double temp = 0;
		for(int i=0; i<array1.length; i++)
		{
			temp = temp + (array1[i] * array1[i]);
		}
		//Apparently java.lang.Math may be needed for this command to work depending on what is auto imported
		length = Math.sqrt(temp);
		return length;
	}
	//This function simply prints the contents of an array
	public static void printVector(double[] array1)
	{
		for(int i=0; i<array1.length; i++)
		{
			System.out.print(array1[i]+ " ");
		}
		System.out.println();
	}
}
