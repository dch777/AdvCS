import java.util.*;

public class HorsingAround
{
    public static int totalWidth(ArrayList<Animal> animals)
    {
	int totalWidth = 0;
	for (int i = 0; i < animals.size(); i++) 
	{
	     totalWidth += animals.get(i).getWidth();
	}
	return totalWidth;
    }

    public static Animal tallestAnimal(ArrayList<Animal> animals)
    {
	Animal tallestAnimal = animals.get(0);
	for (int i = 0; i < animals.size(); i++) 
	{
	     if (tallestAnimal.getHeight() < animals.get(i).getHeight())
	     {
	          tallestAnimal = animals.get(i);
	     }
	}
	return tallestAnimal;
    }

    public static int countYourChickens(ArrayList<Animal> animals)
    {
	int totalChickens = 0;
	for (int i = 0; i < animals.size(); i++) 
	{
	     if (animals.get(i).getName().equals("chicken"))
	     {
	          totalChickens++;
	     }
	}
        return totalChickens;
    }

    public static ArrayList<String> inventory(ArrayList<Animal> animals)
    {
	ArrayList<String> animalNames = new ArrayList<String>();
	for (int i = 0; i < animals.size(); i++) 
	{
	     animalNames.add(animals.get(i).getName());
	}
	return animalNames;
    }

    public static void pestControl(ArrayList<Animal> animals)
    {
	for (int i = 0; i < animals.size(); i++) 
	{
	     if (animals.get(i).getName().equals("mouse"))
	     {
	          animals.remove(i);
	     }
	}
    }

    public static void horsingAround(ArrayList<Animal> animals)
    {
	for (int i = 0; i < animals.size(); i += 2) 
	{
	     animals.add(i, new Animal("horse"));
	}
	animals.add(new Animal("horse"));
    }

    public static void feelingSheepish(ArrayList<Animal> animals)
    {
	ArrayList<Integer> coords = new ArrayList<Integer>();
	for (int i = 0; i < animals.size(); i++) 
	{
	     if (animals.get(i).getName().equals("sheep"))
	     {
	          coords.add(i);
	     }
	}
	for (int i = 0; i < coords.size(); i++) 
	{
	     if (coords.get(i) > 0)
		animals.set(coords.get(i) - 1, new Animal("sheep"));
	     if (coords.get(i) < animals.size() - 1)
		animals.set(coords.get(i) + 1, new Animal("sheep"));
	}
    }

    public static void selectionSort(ArrayList<Animal> animals)
    {
	for (int i = 0; i < animals.size(); i++) 
	{
		int max = i;
		for (int j = i; j < animals.size(); j++) 
		{
			if (animals.get(j).getHeight() > animals.get(max).getHeight())
				max = j;
		}
		Animal tmp = animals.get(max);
		animals.set(max, animals.get(i));
		animals.set(i, tmp);
	}
    }
}
