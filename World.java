/*
Author: Amirreza Pazira 
UCID: 30133500 
Tutorial: 08

Version: 20-Feb-2021

Program: Computer Simulation Program

Features: Creates a 5x5 simulation world by using a 2D array - An Entity can move in this simulated world - 
Each element of the world is a reference to an Entity object -
All elements will be null but one element will refer to an Entity object - 
User can enter a destination for the Entity's next location -
User can enter the next destination multiple times unless he/she enters a negative integer for either the Row or the Column -
The Entity appearance can be changed but not bu the user - Every Entity moves will be displayed - 

Limitations: It Can't create a World bigger than 5x5 - If a negative integer is entered by the user simulation ends - 
Entity's starting location cannot be changed - User can't change the Entity's appearance - There can be only one Entity per simulation

*/

// Importing Scanner class to get user's input 
import java.util.Scanner;
public class World{
	private Entity [][] anEntity; // A reference to array for our world
	// Variables for the next destination entered by the user
	private int destinationRow; 
    private int destinationColumn;
    // Variables for the Entity's starting location
    private final int START_ROW = 1;
    private final int START_COLUMN = 1;
    // Variables for the Entity's current location
    private int currentRow = 0;
    private int currentColumn = 0;
    // Variables for the World size
    private final int MAX_ROW = 10;
	private	final int MAX_COLUMN = 10;
	// Variable for the Simulation runtime
	private boolean run = false;

	// Features: Constructor method for Creating our world and 
	// calling the wipe method initializing each array element to 'null' except the starting
	// location which is [1][1] this element will refer to an Entity object.  
	public World(){
        anEntity = new Entity[MAX_ROW][MAX_COLUMN];
        wipe();
        anEntity[START_ROW][START_COLUMN] = new Entity();
        currentRow = START_ROW;
		currentColumn = START_COLUMN;

	}
	// Features: Main method of our program this method will ask the user for the Entity's next location and it will
	// check the input to see if it's in our world range then it will pass that input to newLocation method to
	// change the Entity's location - This method can end the Simulation - Gets called multiple times 
	// Limitations: Can't change the Entity's location by itself    
	public void simulation(){
		Scanner in = new Scanner(System.in);
		System.out.println();
		System.out.print("Destination Row (0-4): ");
		destinationRow = in.nextInt();
		System.out.print("Destination Column (0-4): ");
		destinationColumn = in.nextInt();
		if ((destinationRow < 0) || (destinationColumn < 0)){
			System.out.println("The destination Row/column: " + destinationRow +"/"+ destinationColumn + " is way beyond this World!");
			System.out.println("Entity is lost forever! ");
			System.out.println("End of Simulation!");
			run = true;
		}
		else if ((destinationRow >= MAX_ROW) || (destinationColumn >= MAX_COLUMN)){
			System.out.println("The destination Row/column: " + destinationRow +"/"+ destinationColumn + " is beyond this World!");
			System.out.println("Entity was lost, but found his way back!");
		}
		else if ((destinationRow >= 0) && (destinationColumn < MAX_COLUMN)){
			System.out.println("Entity is moving!");
			newLocation(destinationRow,destinationColumn);
		}
	}
	// Features: Method for changing the Entity's location based on the parameter passed to it by simulation method 
	// It can change the previous location to null and change the current location if the new location is same as the current location
	// it will notify the user and won't change anything
	// Limitations: Can't change the Entity's location by itself needs a parameter to do that 
	public void newLocation(int newRow,int newColumn){
		if ((currentRow == newRow) && (currentColumn == newColumn))
			System.out.println("Same location, Entity is not moving!");
		else{
			anEntity[newRow][newColumn] = new Entity();
			anEntity[currentRow][currentColumn] = null;
			currentRow = newRow;
			currentColumn = newColumn;
		}
	}
	// Features: Method for displaying the world and the Entity's location - 
	// It can bound every location or element of our world in a cell by drawing lines around them -
	// Can access the Entity's appearance - Gets called after every move
	// Limitations: Can't change the Entity's appearance 
	public void display(){
		int r;
        int c;
        int i;
        int m;
        for (r = 0; r < MAX_ROW; r++){
        	for (i = 0; i < MAX_ROW; i++)
        		System.out.print("  - ");
        	System.out.println();
        	System.out.print("| ");
            for (c = 0; c < MAX_COLUMN; c++){
                if (anEntity[r][c] == null)
                    System.out.print("  | ");
                else
                    System.out.print(anEntity[currentRow][currentColumn].getAppearance() +" | ");
            }
            System.out.println();
        }
        for (m = 0; m < MAX_ROW; m++)
        	System.out.print("  - ");
	}
	// Features: Method for initializing each array element to 'null'
	// Limitations: Gets called only once
	public void wipe(){
        int i;
        int m;
        for (i = 0; i < MAX_ROW; i++){
            for (m = 0; m < MAX_COLUMN; m++){
                anEntity[i][m] = null;
            }    
        }
    }
    // Features: Method for starting the simulation by using a while loop it will keep calling the simulation method until the user enters a negative integer
    // which it will change the run variable to True which then ends the simulation - It will call display method after each move 
	// Limitations: Can't change or access anything in this program - Can't end or stop the simulation by itself
    public void startSimulation(){
		while (run == false){
			display();
	    	simulation();
	}
    }
}	