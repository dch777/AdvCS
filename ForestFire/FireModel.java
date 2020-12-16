public class FireModel
{
    public static int SIZE = 47;
    private static FireCell[][] myGrid;
    private FireView myView;

    public FireModel(FireView view)
    {
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }

    public static void recursiveFire(FireCell cell, int x, int y)
    {
	    if (cell.getStatus() == FireCell.GREEN) 
	    {
		    cell.setStatus(FireCell.BURNING);
		    if (y > 0 && myGrid[y - 1][x].getStatus() == FireCell.GREEN) 
		    {
			    recursiveFire(myGrid[y - 1][x], x, y - 1);
		    }
		    if (x > 0 && myGrid[y][x - 1].getStatus() == FireCell.GREEN) 
		    {
			    recursiveFire(myGrid[y][x - 1], x - 1, y);
		    }
		    if (x < 46 && myGrid[y][x + 1].getStatus() == FireCell.GREEN) 
		    {
			    recursiveFire(myGrid[y][x + 1], x + 1, y);
		    }
	    }
    }

    public void solve()
    {
	int width = myGrid[0].length;
	int height = myGrid.length;
	for (int i = 0; i < width; i++)
	{
		recursiveFire(myGrid[height - 1][i], i, height - 1);
	}
	for (FireCell cell : myGrid[0])
	{
		if (cell.getStatus() == FireCell.BURNING)
		{
			System.out.println("Onett is in trouble!");
			myView.updateView(myGrid);
			return;
		}
	}
	System.out.println("Onett is safe");
        myView.updateView(myGrid);
    }

}
