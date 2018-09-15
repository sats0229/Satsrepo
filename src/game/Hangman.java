package game;

import java.util.Random;
import java.util.Scanner;

public class Hangman
{

    String word[] =
    {
        "japan", "qatar", "syria", "mongolia", "bahrain", "india"
    };
        
    public void playGame()
    {
        System.out.println("playgame method is invoked");
        int i, flag = 0, len, rnd, count = 0;
        String choice, temp;
        Random rd = new Random();
        Scanner input = new Scanner(System.in);
        rnd = rd.nextInt(6);
        len = word[rnd].length();
        char[] newString = new char[len];
        StringBuffer wrgString = new StringBuffer();
        for (int j = 0; j < len; j++)
        {
            System.out.print("_ ");
        }

        do
        {
            flag = 0;
            System.out.println("\nEnter Your Guess");
            try{
            String ch = input.nextLine().toLowerCase();
                if (ch.length()!=1)
                {
                    throw new WrongInputException();
                }

            count++;

            for (i = 0; i < len; i++)
            {
                if (word[rnd].charAt(i) == ch.charAt(0))
                {
                    newString[i] = word[rnd].charAt(i);
                    flag = 1;
                }
            }
            if (flag == 0)
            {
                flag = 1;
                wrgString.append(ch + ",");
                System.out.println("\nMisses: " + wrgString);
            }
            System.out.println(newString);
            temp = new String(newString);

            if (word[rnd].equals(temp))
            {
                System.out.println("---------- Congrats:) You won -----------");
                System.out.println("Do you want to play again (Y/N)");
                choice = input.nextLine();

                if (choice.equalsIgnoreCase("y"))
                {
                    playGame();
                }
                else
                {
                    showMenu();
                }
            }
            }
            catch (WrongInputException ex)
            {
                flag=1;
            }
        }
        while (flag != 0);

    }

    public void instructGame()
    {
        System.out.println("instructGame method is invoked");
    }

    public void exitGame()
    {
        System.out.println("exitGame method is invoked");
        System.exit(0);
    }

    public void showMenu()
    {
        int option = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("---------Menu---------");
        System.out.println("1. Play");
        System.out.println("2. Instruction");
        System.out.println("3. Exit");
        System.out.println("\nChoose the option");
        try{
        option = sc.nextInt();}
        catch (RuntimeException ex)
        {
            System.out.println("Please provide a valid numeric input");
            showMenu();
        }
        switch (option)
        {
            case 1:
                playGame();
                break;
            case 2:
                instructGame();
                break;
            case 3:
                exitGame();
                break;

            default:
                try{
                    throw new MenuInputException();
                }
                catch (Exception ex)
                {
                    showMenu();
                }
        }
    }

    public static void main(String[] args)
    {
        Hangman hg = new Hangman();
        hg.showMenu();
       
        //char aa[] = {'s','r','r'};
        System.out.println("rv");
       
    }

}
