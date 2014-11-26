package Chapter_07;

/**
 * Chapter 7 Exercise 24:
 *
 *      (Simulation: coupon collector’s problem)
 *      Coupon collector is a classic statistics problem with many practical applications.
 *      The problem is to pick objects from a set of objects repeatedly and find out
 *      how many picks are needed for all the objects to be picked at least once.
 *      A variation of the problem is to pick cards from a shuffled deck of 52 cards
 *      repeatedly and find out how many picks are needed before you see one of each suit.
 *      Assume a picked card is placed back in the deck before picking another.
 *      Write a program to simulate the number of picks needed to get four cards from
 *      each suit and display the four cards picked (it is possible a card may be picked twice).
 *
 * Created by Luiz Arantes Sa on 8/28/14.
 */
public class Exercise_24 {

    public static void main(String[] args) {

        boolean spades = false;
        boolean hearts = false;
        boolean diamond = false;
        boolean clubs = false;

        String[] cardSequence = new String[4];
        int index = 0;
        int pickCount = 0;
        while (!spades || !hearts || !diamond || !clubs) {

            String card = revealCard(getCard());
            pickCount++;


            if (card.contains("Spades") && !spades) {
                cardSequence[index++] = card;
                spades = true;
            } else
            if (card.contains("Hearts") && !hearts) {
                cardSequence[index++] = card;
                hearts = true;
            } else
            if (card.contains("Diamond") && !diamond) {
                cardSequence[index++] = card;
                diamond = true;
            } else
            if (card.contains("Clubs") && !clubs) {
                cardSequence[index++] = card;
                clubs = true;
            }

        }

        for (int i = 0; i < cardSequence.length; i++) {
            System.out.println(cardSequence[i]);
        }
        System.out.println("Pick count = " + pickCount);


    }


    public static int getCard(){
        return (int)(Math.random() * 52);
    }

    public static String revealCard(int cardNum) {

        String[] suit = {"Spades", "Hearts", "Diamonds", "Clubs", };
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        int suitNum = cardNum / 13;
        int rankNum = cardNum % 13;

        return  ranks[rankNum] + " of " + suit[suitNum];

    }
}
