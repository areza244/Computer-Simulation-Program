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

public class Entity
{
    public static final char DEFAULT = 'G';
    private char appearance;

    public Entity()
    {
        setAppearance(DEFAULT);
    }

    public Entity(char newAppearance)
    {
        setAppearance(newAppearance);
    }

    public char getAppearance()
    {
        return(appearance);
    }

    private void setAppearance(char newAppearance)
    {
        appearance = newAppearance;
    }
}