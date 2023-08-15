//brute force:
// class Solution {
//     public int maxProfit(int[] prices) {
//         int maxProfit1 = 0;
//         int maxProfit2 = 0;
//         for(int i=0; i<prices.length; i++){ // j = sell i = buy
//                 for(int j=i+1; j<prices.length; j++){
//                     if(prices[i]==prices[j] || prices[i]>prices[j]){
//                         maxProfit1 = 0;
//                     } 
//                     else{
//                         maxProfit2 = Math.max((prices[j] - prices[i]), maxProfit2);
//                     }
//                 }
//         }
//         return Math.max(maxProfit1, maxProfit2);
//     }
// }
class Solution {
    public int maxProfit(int[] prices) {
        int leastBuy = Integer.MAX_VALUE;
        int maxProfit = 0; 
        for(int i = 0; i < prices.length; i++){
            leastBuy = Math.min(prices[i], leastBuy);
            maxProfit = Math.max((prices[i] - leastBuy), maxProfit);
        }
        return maxProfit;
    }
}