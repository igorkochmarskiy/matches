import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        long numberOfSquares = 4;
        System.out.println(numberOfSquares + " squares, " + calculateNumberOfMatches(numberOfSquares) + " matches");
    }

    static  long calculateNumberOfMatches(long numberOfSquares){
        if(numberOfSquares==1){
            return 4;
        }
        if(numberOfSquares==2){
            return 7;
        }
        long numberOfMathes = 7; // number of matches for 2 squares
        long amountOfTwoInSequence = 1;
        boolean selector = true;

        long lastTwosAmount = 0;
        for (long i = 2; i < numberOfSquares; i++) {
            if(selector){
                numberOfMathes +=3;
                selector = false;
            }else{
                long numbersLeft = numberOfSquares - i;
                long amountOfTwo = Math.min(numbersLeft,amountOfTwoInSequence);
                numberOfMathes +=2*amountOfTwo;
                i+=amountOfTwo-1;
                if(amountOfTwoInSequence==lastTwosAmount){
                    amountOfTwoInSequence++;
                }else {
                    lastTwosAmount = amountOfTwoInSequence;
                }
                selector = true;
            }
        }
        return numberOfMathes;
    }
}
