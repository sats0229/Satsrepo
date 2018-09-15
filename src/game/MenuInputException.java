
package game;

public class MenuInputException extends RuntimeException
{

    public MenuInputException()
    {
        System.out.println("Please provide a valid input(1-3)");
    }
    
}
