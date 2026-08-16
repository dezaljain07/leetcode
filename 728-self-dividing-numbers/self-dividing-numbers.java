import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = left; i <= right; i++) {
            int temp = i;
            boolean isSelfDividing = true;
            
            while (temp > 0) {
                int digit = temp % 10; 
                
                if (digit == 0 || i % digit != 0) {
                    isSelfDividing = false;
                    break;
                }
                
                temp = temp / 10; 
            }
             
            if (isSelfDividing) {
                result.add(i);
            }
        }
        return result;
    }
}