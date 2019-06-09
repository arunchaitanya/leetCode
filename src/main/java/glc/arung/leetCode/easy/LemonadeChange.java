package glc.arung.leetCode.easy;

public class LemonadeChange{

    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 =0;
        int count20 = 0;
        int len = bills.length;
        for (int i=0; i < len; i++){

           int bill =  bills[i];
            if (bill ==5) {
                count5++;
                continue;
            } else if (bill == 10){
                count5--;
                count10++;
                if(count5 < 0)
                    return false;
            } else if(bill ==20) {
                count20++;
                if(count10 >= 1){
                    count10--;
                    count5--;
                } else {
                    count5 = count5 -3;
                }
                if(count10 < 0 || count5 < 0)
                    return false;
            }
        }
        return true;
    }
}