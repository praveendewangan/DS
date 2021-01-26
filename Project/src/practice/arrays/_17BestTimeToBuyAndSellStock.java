package practice.arrays;

public class _17BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;

        for(int price : prices){
            if(price < lsf){
                lsf = price;
            }
            pist = price - lsf;
            if(pist > op){
                op = pist;
            }
        }
        return op;
    }
}
