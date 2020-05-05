
public class Square extends Shape 
{
	public Square(int counter, int side)
	{
		super(counter);
		mSide = side;
	}
	
	public String display()
	{
		return "Square: " + super.display() + ", Side = " + mSide;
	}
	
	private int mSide;
}
