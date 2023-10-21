import java.util.Arrays;
/**
 *
 * @author Alee
 */


public class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        if (arr == null) {
            return null;
        }
        
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    
                    System.out.println(Arrays.toString(arr));
                }
            }
        }
        
        return arr;
    }
}
