
public class InsertionSort extends SortAlgorithm {
    /**
     * Use the insertion sort algorithm to sort the array
     *
     * TODO
     * Best-case runtime: O(n)
     * Worst-case runtime: O(n^2)
     * Average-case runtime:
     *
     * Space-complexity:O(1)
     */
    @Override
    public int[] sort(int[] array) {

        for(int i=1;i<array.length;i++){
            for(int j=i-1;j>=0;j--){
                if(array[j]>=array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        return array;
    }
}
