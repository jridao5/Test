
/**
 * Write a description of class Expense here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Expense
{
    public static void main(String[] args)
    {
        Queue<Item> wishList = new LinkedList<Item>();
        String[] monthList = {"January","February","March","April","May","June","July","August","September","October","November"};
        int itemCost=0;
        boolean inside=true,outside=true;
        String itemDescription="";
        int monthlySavings,currentBalance=0,monthCtr=0;
        Scanner sc = new Scanner(System.in);

        String carriageReturn;

        System.out.print("Amount of discrtionary money to set aside monthly: $");
        monthlySavings=sc.nextInt();
        carriageReturn=sc.nextLine();

        while(outside)
        {
            monthCtr=monthCtr%12;
            while(inside)
            {
                System.out.println("Enter an item description, N to move to the next month or Q to quit.");
                itemDescription = sc.next();
                if(itemDescription.equals("Q") ||itemDescription.equals("q"))
                {
                    outside=false;
                    inside=false;
                }    
                else if(itemDescription.equals("N") ||itemDescription.equals("n"))
                {
                    monthCtr++;
                    currentBalance += monthlySavings;

                    inside=false;
                }
                else{
                    System.out.print("Enter the cost of the item: $");
                    itemCost=sc.nextInt();                    
                    Item itemInput= new Item(itemDescription, itemCost);
                    wishList.add(itemInput);
                }

                carriageReturn = sc.nextLine();
            }
            while(!wishList.isEmpty())
            {
                if(!wishList.isEmpty()){
                    Item itemFinder = new Item("",0);
                    itemFinder=wishList.peek();
                    if(currentBalance >=itemFinder.getCost()){
                        System.out.println("You've purchased your: " +wishList.remove());
                        currentBalance -= itemFinder.getCost();
                    }
                    else if (currentBalance<itemFinder.getCost())
                    break;
                }
            }
            inside=true;
        }
    }
}