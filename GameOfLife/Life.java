import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
    this is the Controller component
 */

class Life extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private LifeView view;
	private LifeModel model;
	private JButton runButton, pauseButton, resumeButton, resetButton, colorButton;
	private JTextField fileInput;

	/** construct a randomized starting grid */
	Life() throws IOException
	{
		this(null);
	}
	
	/** construct a grid using the info in text file */
	Life(String fileName) throws IOException
	{
		super("Conway's Life");

		// build the buttons
		JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		runButton = new JButton("Run");
		runButton.addActionListener(this);
		runButton.setEnabled(true);
		controlPanel.add(runButton);
		pauseButton = new JButton("Pause");
		pauseButton.addActionListener(this);
		pauseButton.setEnabled(false);
		controlPanel.add(pauseButton);
		resumeButton = new JButton("Resume");
		resumeButton.addActionListener(this);
		resumeButton.setEnabled(false);
		controlPanel.add(resumeButton);
		colorButton = new JButton("Choose Color");
		colorButton.addActionListener(this);
		colorButton.setEnabled(true);
		controlPanel.add(colorButton);
		resetButton = new JButton("Reset");
		resetButton.addActionListener(this);
		resetButton.setEnabled(true);
		controlPanel.add(resetButton);
		fileInput = new JTextField("blinker.lif", 10);
		fileInput.addActionListener(this);
		fileInput.setEnabled(true);
		controlPanel.add(fileInput);

		// build the view
		view = new LifeView();
		view.setBackground(Color.white);

		// put buttons, view together
		Container c = getContentPane();
		c.add(controlPanel, BorderLayout.NORTH);
		c.add(view, BorderLayout.CENTER);

		// build the model
		model = new LifeModel(view, fileName);
	}

	public void actionPerformed(ActionEvent e)
	{
		JButton b = (JButton)e.getSource();
		if ( b == runButton )
		{
			model.run();
			runButton.setEnabled(false);
			pauseButton.setEnabled(true);
			resumeButton.setEnabled(false);
		}
		else if ( b == pauseButton )
		{
			model.pause();
			runButton.setEnabled(false);
			pauseButton.setEnabled(false);
			resumeButton.setEnabled(true);
		}
		else if ( b == resumeButton )
		{
			model.resume();
			runButton.setEnabled(false);
			pauseButton.setEnabled(true);
			resumeButton.setEnabled(false);
		}
		else if ( b == resetButton )
		{
			model.pause();
			System.out.println(fileInput.getText());
			try
			{
				if (fileInput.getText().equals("")) 
					model = new LifeModel(view, null);
				else
					model = new LifeModel(view, fileInput.getText());
				runButton.setEnabled(true);
				pauseButton.setEnabled(false);
				resumeButton.setEnabled(false);
			}
			catch(IOException ex)
			{
				JOptionPane.showMessageDialog(this, "Invalid Filename");
				runButton.setEnabled(false);
				pauseButton.setEnabled(false);
				resumeButton.setEnabled(true);
			}
		}
		else if ( b == colorButton )
		{
			view.setColor();
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		Life conway = new Life("glgun13.lif"); //parameterize to start w/ a particular file
		
		conway.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		conway.setSize(570, 640);
		conway.setVisible(true);
	}
}
