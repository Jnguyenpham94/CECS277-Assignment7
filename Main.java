import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		if(args.length != 1)
		{
			printUsage();
			System.exit(1);
		}
		
		List<String> input = null;
		try
		{
			input = getInput(args[0]);
		}
		catch(Throwable exp)
		{
			System.out.println("Received error: " + exp.getMessage() + " opening/reading file: " + args[0]);
			System.exit(2);	
		}
		
		List<ShapeComponent> components = getShapes(input);
		
		for(ShapeComponent sc : components)
		{
			System.out.println(sc.display());
		}
		
	}
	
	private static List<String> getInput(String fileName) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File(fileName));
		List<String> input = new ArrayList<String>();
		
		while(sc.hasNextLine()) input.add(sc.nextLine());
		
		sc.close();
		
		return input;
	}
	
	private static void printUsage()
	{
		System.out.println("Needs one argument: name of input file");
	}
	
	private static List<ShapeComponent> getShapes(List<String> input)
	{
		List<ShapeComponent> shapes = new ArrayList<ShapeComponent>();
		
		int circleRadius = 5;
		int squareSide = 1;
		
		int size = input.size();
		int index = 0;
		
		while(index < size)
		{	
			SingletonCounter s = SingletonCounter.getInstance();
			
			String line = input.get(index);
			
			if(line.equals("LISTSTART"))
			{
				ShapeComposite sCom = new ShapeComposite();
				
				line = input.get(++index);
				while(!line.equals("LISTEND"))
				{
					if(line.equals("Circle"))
					{
						Shape c = (Shape) new Circle(s.getCounter(), circleRadius++);
						sCom.add(c);
					}
					else if(line.equals("Square"))
					{
						Shape sq = (Shape) new Square(s.getCounter(), squareSide++);
						sCom.add(sq);
					}
					line = input.get(++index);
				}
				
				shapes.add(sCom);
				++index;
			}
			else if(line.equals("Circle"))
			{
				Shape c = (Shape) new Circle(s.getCounter(), circleRadius++);
				shapes.add(c);
				++index;
			}
			else if(line.equals("Square"))
			{
				Shape sq = (Shape) new Square(s.getCounter(), squareSide++);
				shapes.add(sq);
				++index;
			}
			else
			{
				System.out.println("Error in input: " + line);
			}	
		}
		
		return shapes;
	}

}
