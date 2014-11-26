package Chapter_09;

import ToolKit.Stock;

/**
 * Chapter 9 Exercise 2:
 *
 *      (The Stock class) Following the example of the Circle class in Section 9.2,
 *      design a class named Stock that contains:
 *
 *           ■ A string data field named symbol for the stock’s symbol.
 *           ■ A string data field named name for the stock’s name.
 *           ■ A double data field named previousClosingPrice that stores the stock price for the previous day.
 *           ■ A double data field named currentPrice that stores the stock price for the current time.
 *           ■ A constructor that creates a stock with the specified symbol and name.
 *           ■ A method named getChangePercent() that returns the percentage changed from previousClosingPrice to currentPrice.
 *
 *      Draw the UML diagram for the class and then implement the class.
 *      Write a test program that creates a Stock object with the stock symbol ORCL,
 *      the name Oracle Corporation,and the previous closing price of 34.5.
 *      Set a new current price to 34.35 and display the price-change percentage.
 *
 * Created by Luiz Arantes Sa on 9/1/14.
 */
public class Exercise_02 {

    public static void main(String[] args) {

        Stock stock1 = new Stock("ORCL", "Oracle Corporation");
        stock1.setCurrentPrice(34.5);
        stock1.setCurrentPrice(34.35);
        System.out.println("Stock name: " + stock1.getName() + " Symbol: " + stock1.getSymbol());
        System.out.println("previous price: " + stock1.getPreviousClosingPrice());
        System.out.println("current price: " + stock1.getCurrentPrice());
        System.out.println("Percent changed: " + stock1.getChangePercent());

    }






}
