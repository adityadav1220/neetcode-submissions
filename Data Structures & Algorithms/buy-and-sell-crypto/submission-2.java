class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=Integer.MIN_VALUE;

        for(int i=0;i<prices.length;i++){
            int profit=prices[i]-minPrice;
            if(profit>0){
                maxProfit=Math.max(maxProfit,profit);
            }
            minPrice=Math.min(minPrice,prices[i]);
        }
        if(maxProfit==Integer.MIN_VALUE){return 0;}
        return maxProfit;
    }
}
