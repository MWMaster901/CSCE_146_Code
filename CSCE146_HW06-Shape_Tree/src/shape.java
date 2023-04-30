/*
 * By Christopher Schweninger
 */
public class shape implements Comparable<shape>
{
	private String type;
	private int shapeParameter1;
	private int shapeParameter2;
	private double shapeArea;
	private static final double PI = 3.14;
	public shape()
	{
		this.setType("Circle");
		this.setFirstParam(1);
		this.setSecondParam(1);
		calcArea();
	}
	public shape(String aType, int param1, int param2)
	{
		this.setType(aType);
		this.setFirstParam(param1);
		this.setSecondParam(param2);
		calcArea();
	}
	public void setType(String aType)
	{
		if(aType != null)
			if(aType.equalsIgnoreCase("Circle") || aType.equalsIgnoreCase("Right Triangle") || aType.equalsIgnoreCase("Rectangle"))
				this.type = aType;
			else
				this.type = "Circle";
		else
			this.type = "Circle";
	}
	public void setFirstParam(int aParam)
	{
		if(aParam > 0)
			this.shapeParameter1 = aParam;
		else
			this.shapeParameter1 = 1;
	}
	public void setSecondParam(int aParam)
	{
		if(aParam > 0)
			this.shapeParameter2 = aParam;
		else
			this.shapeParameter2 = 1;
	}
	public void calcArea()
	{
		if(this.type.equalsIgnoreCase("Circle"))
			this.shapeArea = shapeParameter1 * shapeParameter1 * PI;
		else if(this.type.equalsIgnoreCase("Right Triangle"))
			this.shapeArea = (shapeParameter1 * shapeParameter2) / 2;
		else
			this.shapeArea = shapeParameter1 * shapeParameter2;
	}
	public String getShapeType()
	{
		return this.type;
	}
	public int getFirstParam()
	{
		return this.shapeParameter1;
	}
	public int getSecondParam()
	{
		return this.shapeParameter2;
	}
	public double getArea()
	{
		return this.shapeArea;
	}
	public String toString()
	{
		return "Shape: "+this.type+" Param1: "+this.shapeParameter1+" Param2: "+this.shapeParameter2+" Area: "+this.shapeArea;
	}
	public boolean doesEqual(shape aShape)
	{
		//Quite the mouthful
		return aShape != null && this.type.equalsIgnoreCase(aShape.getShapeType()) && this.shapeParameter1 == aShape.getFirstParam()
				&& this.shapeParameter2 == aShape.getSecondParam() && this.shapeArea == aShape.getArea();
	}
	public int compareTo(shape aShape)
	{
		if(aShape == null)
			return -1;
		else if(this.shapeArea != aShape.getArea())
		{
			double temp = this.shapeArea - aShape.getArea();
			if(temp > 0)
				return 1;
			else
				return -1;
		}
		else
			return this.type.compareToIgnoreCase(aShape.getShapeType());
	}
}
