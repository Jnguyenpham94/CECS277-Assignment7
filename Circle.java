
public class Circle extends Shape 
{
	public Circle(int counter, int radius)
	{
		super(counter);
		mRadius = radius;
	}
	
	public String display()
	{
		return "Circle: " + super.display() + ", Radius = " + mRadius;
	}
	
	private int mRadius;

}
