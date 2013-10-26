public class Solution {
    public double pow(double x, int n) {
        double result = 1;
            
        int num = Math.abs(n);
        int level = 1;
        while(num > 0){
            num = num / 2;
            level++;
        }
        num = Math.abs(n);
        
        double f[] = new double[Math.max(level,2)];
        f[0] = 1.0;
        f[1] = x;
        for(int i = 2; i < level; i++){
            f[i] = f[i-1] * f[i-1];
        }
        
        int count = 1;
        while(num > 0){
            if(num % 2 == 1)
                result *= f[count];
            count ++;
            num = num / 2;
        }
        
        if (n < 0)
            result = 1.0 / result;
        return result;       
    }
}