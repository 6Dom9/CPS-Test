
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;


public class Main extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	//Width and Height of the JFrame
	public static final int WIDTH = 550;
    public static final int HEIGHT = 550;
    //Width and Height of the Button
	public static final int WIDTH1 = 450;
    public static final int HEIGHT1 = 450;
    
	//Adding the 3 main components
    //This is the label that counts the clicks
    private JLabel lblValue;
    //This is the integer that counts the clicks
    private int clicks = 0;
    //This is the timer
    int count;


    public static void main(String[] args)
    {
		// This creates two instances of Main,
		// which creates two different windows.
        Main counter1 = new Main( );
        counter1.setVisible(true);

        Main counter2 = new Main( );
        counter2.setVisible(true);
    }

	public Main( )
    {
		//Title that appears at the top of the page
        setTitle("CPS Test");
        //Close when the close button is pressed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Setting size of the frame
        setSize(WIDTH, HEIGHT);
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new FlowLayout( ));

		// This is the label for the amount of clicks
        lblValue = new JLabel("0");
        //Adding the counter onto the screen
        add(lblValue);
        //This is the button that adds 1 every time clicked
        JButton addButton = new JButton("Please Wait");
        addButton.addActionListener(this);
        //Setting size for button
        addButton.setSize(new Dimension(WIDTH1, HEIGHT1));
        addButton.setPreferredSize(new Dimension(WIDTH1, HEIGHT1));
        addButton.setMinimumSize(new Dimension(WIDTH1, HEIGHT1));
        addButton.setMaximumSize(new Dimension(WIDTH1, HEIGHT1));
        //Adding button onto screen
        add(addButton);

        //Adds the label for the timer. This changes after 1000 milliseconds to 1, and then counts every second
    	JLabel label = new JLabel("Starting Soon");
        setLayout(new GridBagLayout());
        //Adding timer onto the screen
        add(label);
        
        //Delay in milliseconds between number adding
        Timer timer = new Timer(1000, new ActionListener() {

          public void actionPerformed(ActionEvent e) {
            //Add 1 to count every interval of 1000 milliseconds
        	  count++;
        	  //Timer keeps ticking till this number is achieved
            if (count <= 5) {
              label.setText(Integer.toString(count));
            }
            //Will stop timer, remove the click button and will calculate how many clicks you got per second
            	else {
              ((Timer) (e.getSource())).stop();
              remove(addButton);
              remove(label);
              lblValue.setText("You clicked " + Integer.toString(clicks / 5) + " clicks per second.");
            }
            //Will change text from "Please Wait" to "Click Here" after timer delay has finished
            if (count == 1) {
                addButton.setText("Click Here");
            }
          }

        });
        //Start Timer
        timer.start();
        //Timer wont start for 1000 milliseconds
        timer.setInitialDelay(1000);

    }
    public void actionPerformed(ActionEvent e)
    {
		String actionCommand = e.getActionCommand( );
		
		//This will only work whilst the text is "Click Here". Wont work for 1000 milliseconds as the text is "Please Wait"
        if (actionCommand.equals("Click Here"))
        {
        	//Adds 1 to the click counter ever time it is clicked
        	lblValue.setText(Integer.toString(clicks += 1));

		}
    }
}