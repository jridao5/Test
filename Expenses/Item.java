
/**
 * Write a description of class Expense here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    private String description;
    private double cost;

    public Item(String description, double cost)
    {
        this.description = description;
        this.cost = cost;
    }

    public String getDescription()
    {
        return description;
    }

    public double getCost()
    {
        return cost;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public String toString()
    {
        return "Item:  " + description + '\n' + "Cost:  " + cost;
    }

}