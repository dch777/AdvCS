//Name: Dhruv Chanana
//Period: 3B

import java.util.*;

public class Square 
{
	public static final int SPACE = 0;
	public static final int WALL = 1;
	public static final int START = 2;
	public static final int EXIT = 3;

	public static final char WORKING = 'o';
	public static final char EXPLORED = '.';
	public static final char PATH = 'x';

	private int type;
	private int row;
	private int col;
	private char status = ' ';

	public Square(int row, int col, int type)
	{
		this.row = row;
		this.col = col;
		this.type = type;
	}

	public String toString()
	{
		switch (type) 
		{
			case WALL: return "#";
			case START: return "S";
			case EXIT: return "E";
			default:
			{
				if (status == ' ')
				{
					return "_";
				} else {
					return Character.toString(status);
				}
			}
		}
	}

	public boolean equals(Square obj)
	{
		return obj.getCol() == col && obj.getRow() == row;
	}

	public void reset()
	{
		status = ' ';
	}

	public int getRow() 
	{
		return row;
	}

	public int getCol() 
	{
		return col;
	}

	public int getType() 
	{
		return type;
	}

	public char getStatus() 
	{
		return status;
	}

	public void setStatus(char s)
	{
		status = s;
	}
}
