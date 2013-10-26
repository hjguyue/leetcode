 public class Solution {
    public int divide(int dividend, int divisor) {
        long l_dividend = dividend;
        long l_divisor  = divisor;

        long result = 0;
        if (dividend == 0)
            return 0;
        
        long x = Math.abs(l_dividend);
        long y = Math.abs(l_divisor);
        
        while(x >= y){
            long k = 0;
            while(x >= (y<<k) && ((y<<k)-1) <= Integer.MAX_VALUE){
                k++;
            }
            if(x < (y<<k) || ((y<<k)-1) > Integer.MAX_VALUE)
                k--;
            x -= (y<<k);
            result += (1<<k);
        }   

        if (dividend < 0)
            result = -result;
        if (divisor < 0)
            result = -result;
        return (int)result;
    }
}

// public class Solution {
//     public int divide(int dividend, int divisor) {
//         long l_dividend = dividend;
//         long l_divisor  = divisor;

//         long result = 0;
//         if (dividend == 0)
//             return 0;
        
//         long x = Math.abs(l_dividend);
//         long y = Math.abs(l_divisor);
        
//         while(x >= y){
//             long k = 0;
//             do 
//                 k++;
//             while (x >= (y<<k) && ((y<<k)-1) <= Integer.MAX_VALUE);
//             k--;
//             x -= (y<<k);
//             result += (1<<k);
//         }   

//         if (dividend < 0)
//             result = -result;
//         if (divisor < 0)
//             result = -result;
//         return (int)result;
//     }
// }