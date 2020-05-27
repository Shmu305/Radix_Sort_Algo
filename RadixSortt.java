/**************************************************************
 
 Purpose/Description: This program implemets radix sort using buckets

**************************************************************/
package radixsortt;
import java.util.ArrayList;

public class RadixSortt
{
    
    
    public static void main(String[] args)
    {
        int[] input = {4, 2, 28, 44, 428, 88, 2468};
        radixSort(input);
        for(int i = 0; i < input.length; i++){
            System.out.print(input[i] + ", " );
        }
    }
    public static void radixSort(int[] array){
        int placeVal = 1;
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for(int i = 0;i<buckets.length;i++){
            buckets[i] = new ArrayList<>();
        }
        int maxVal = findMax(array);
        int numOfIterations = findIterations(maxVal);
        while(numOfIterations > 0){
            for(int i = 0; i < array.length; i++){
                int number = array[i]/placeVal;
                if(number%2!=0){
                    System.out.println("Odd digit in keys, program exited");
                    System.exit(0);
                }
                buckets[number%10].add(array[i]);
                
            }//end for loop
            int i = 0;
            for (ArrayList<Integer> bucket : buckets)
            {
                for (int j = 0; j < bucket.size(); j++)
                {
                    array[i++] = bucket.get(j);
                }
                bucket.clear();
            }
            placeVal *= 10;
            numOfIterations -= 1;
            
        }//end while loop
            
    }//end radixSort
    public static int findMax(int[] array){
        int max = array[0];
        for(int i = 0; i< array.length; i++){
            if(array[i]>max){
                max = array[i];
            }
        }
        return max;
    }//end findMax
    
    public static int findIterations(int max){
        int iterations = 0;
        while(max>0){
            iterations += 1;
            max/=10;
        }
        return iterations;
    }//end find iterations
}//end class...
    
    

        
    
    
