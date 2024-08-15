//Description
//At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time
//(in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
//You must provide the correct change to each customer so that the net transaction is that the customer pays $5.
//Note that you do not have any change in hand at first.
//Given an integer array bills where bills[i] is the bill the ith customer pays,
//return true if you can provide every customer with the correct change, or false otherwise.

//Input: bills = [5,5,5,10,20]
//        Output: true

//Input: bills = [5,5,10,10,20]
//        Output: false

public class LemonadeChange860 {
    public static void main(String[] args) {
        LemonadeChange860 lemonadeChange860 = new LemonadeChange860();
        int[] example1 = new int[] {5, 5, 5, 10, 20};
        int[] example2 = new int[] {5, 5, 10, 10, 20};

        System.out.println("Example 1: " + lemonadeChange860.lemonadeChange(example1));
        System.out.println("Example 2: " + lemonadeChange860.lemonadeChange(example2));
    }

    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;

        for (int i : bills) {
            switch (i) {
                case 20 -> {
                    if (count10 >= 1 && count5 >= 1) {
                        --count10;
                        --count5;
                    } else if (count5 >= 3) {
                        count5 -= 3;
                    } else {
                        return false;
                    }
                }
                case 10 -> {
                    if (count5 >= 1) {
                        --count5;
                    } else {
                        return false;
                    }
                    ++count10;
                }
                case 5 -> {
                    ++count5;
                }
            }
        }

        return  true;
    }
}
