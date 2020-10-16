//Name: Dhruv Chanana
//Period: 3B

import java.util.*;

public class Melody 
{
	private Queue<Note> notes;

	public Melody(Queue<Note> song) 
	{
		notes = song;
	}

	public double getTotalDuration()
	{
		double totalDuration = 0;
		int repeated = 0;
		int tmp = 0;
		
		for (int i = 0; i < notes.size(); i++)
		{
			if (notes.peek().isRepeat() && repeated == 0)
			{
				tmp = 1;
				repeated++;
			}
			else if (notes.peek().isRepeat() && repeated == 1) 
			{
				i -= tmp + 1;
				repeated++;
			}
			else if (repeated == 1)
			{
				tmp++;
			}

			totalDuration += notes.peek().getDuration();
			notes.offer(notes.poll());
		}

		return totalDuration;
	}

	public String toString()
	{
		String str = "";

		for (int i = 0; i < notes.size(); i++)
		{
			str += notes.peek().toString();
			notes.offer(notes.poll());
		}

		return str;
	}

	public void changeTempo(double tempo)
	{
		for (int i = 0; i < notes.size(); i++)
		{
			notes.peek().setDuration(notes.peek().getDuration() * tempo);
			notes.offer(notes.poll());
		}
	}

	public void reverse()
	{
		Stack<Note> tmp = new Stack<Note>();

		while (!notes.isEmpty())
		{
			tmp.push(notes.poll());
		}

		while (!tmp.isEmpty())
		{
			notes.offer(tmp.pop());
		}
	}

	public void append(Melody other)
	{
		Queue<Note> melody = other.getNotes();
		while (!melody.isEmpty())
		{
			notes.offer(melody.poll());
		}
	}

	public void play()
	{
		int tmp = 0;
		int repeated = 0;

		for (int i = 0; i < notes.size(); i++)
		{
			if (notes.peek().isRepeat() && repeated == 0)
			{
				tmp = 1;
				repeated++;
			}
			else if (notes.peek().isRepeat() && repeated == 1) 
			{
				i -= tmp + 1;
				repeated++;
			}
			else
			{
				tmp++;
			}

			notes.peek().play();
			notes.offer(notes.poll());
		}
	}

	public Queue<Note> getNotes()
	{
		return notes;
	}
}
