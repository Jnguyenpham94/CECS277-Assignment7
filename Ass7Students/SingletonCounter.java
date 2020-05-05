
public class SingletonCounter 
{
	private static SingletonCounter mObj = null;
	public static SingletonCounter getInstance()
	{
		if(mObj == null) mObj = new SingletonCounter();
		return mObj;
	}
	
	public int getCounter()
	{
		int c = mCounter++;
		return c;
	}
	
	private SingletonCounter()
	{
		mCounter = 1;
	}
	
	private int mCounter;
}
