import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Timer;

public class LifeModel implements ActionListener
{

	/*
	 *  This is the Model component.
	 */

	private static int SIZE = 60;
	private LifeCell[][] grid;
	
	LifeView myView;
	Timer timer;

	/** Construct a new model using a particular file */
	public LifeModel(LifeView view, String fileName) throws IOException
	{       
		int r, c;
		grid = new LifeCell[SIZE][SIZE];
		for ( r = 0; r < SIZE; r++ )
			for ( c = 0; c < SIZE; c++ )
				grid[r][c] = new LifeCell();

		if ( fileName == null ) //use random population
		{                                           
			for ( r = 0; r < SIZE; r++ )
			{
				for ( c = 0; c < SIZE; c++ )
				{
					if ( Math.random() > 0.85) //15% chance of a cell starting alive
						grid[r][c].setAliveNow(true);
				}
			}
		}
		else
		{                 
			Scanner input = new Scanner(new File(fileName));
			int numInitialCells = input.nextInt();
			for (int count=0; count<numInitialCells; count++)
			{
				r = input.nextInt();
				c = input.nextInt();
				grid[r][c].setAliveNow(true);
			}
			input.close();
		}

		myView = view;
		myView.updateView(grid);
	}

	/** Constructor a randomized model */
	public LifeModel(LifeView view) throws IOException
	{
		this(view, null);
	}

	/** pause the simulation (the pause button in the GUI */
	public void pause()
	{
		timer.stop();
	}
	
	/** resume the simulation (the pause button in the GUI */
	public void resume()
	{
		timer.restart();
	}
	
	/** run the simulation (the pause button in the GUI */
	public void run()
	{
		timer = new Timer(50, this);
		timer.setCoalesce(true);
		timer.start();
	}

	/** called each time timer fires */
	public void actionPerformed(ActionEvent e)
	{
		oneGeneration();
		myView.updateView(grid);
	}

	/** main logic method for updating the state of the grid / simulation */
	private void oneGeneration()
	{
		for (int row = 0; row < grid.length; row++) 
		{
			for (int col = 0; col < grid[row].length; col++)
			{
				int neighbours = 0;
				for (int x = -1; x <= 1; x++) 
				{
					for (int y = -1; y <= 1; y++) 
					{
						if ((x != 0 || y != 0) && x + row >= 0 && x + row < grid.length && y + col >= 0 && y + col < grid[row].length && grid[row + x][col + y].isAliveNow()) 
							neighbours++;
					}
				}

				if (grid[row][col].isAliveNow()) 
				{
					if (neighbours >= 2 && neighbours <= 3)
						grid[row][col].setAliveNext(true);
					else
						grid[row][col].setAliveNext(false);
				} 
				else if (!grid[row][col].isAliveNow()) 
				{
					if (neighbours == 3) 
						grid[row][col].setAliveNext(true);
				}
			}
		}
		
		for (int row = 0; row < grid.length; row++) 
		{
			for (int col = 0; col < grid[row].length; col++)
			{
				grid[row][col].setAliveNow(grid[row][col].isAliveNext());
			}
		}
	}
}

