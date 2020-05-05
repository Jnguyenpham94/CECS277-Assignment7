
public abstract class Shape extends ShapeComponent
{
	public Shape(int count)
	{
		mCount = count;
	}
	
	public String display()
	{
		return "Count = " + mCount;
	}
	
	private int mCount;
}
