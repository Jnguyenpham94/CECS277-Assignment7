import java.util.ArrayList;


public class ShapeComposite extends ShapeComponent 
{
	@Override
	public String display()
	{
		String result = "I am a Composite containing:";
		for(ShapeComponent s : mList) result += "\n" + s.display();
		result += "\nEnd of Composite";
		
		return result;
	}
	
	public void add(ShapeComponent s)
	{
		mList.add(s);
	}
	
	private ArrayList<ShapeComponent> mList = new ArrayList<ShapeComponent>();
	

}
