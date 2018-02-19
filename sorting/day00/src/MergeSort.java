
public class MergeSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;

    /**
     * This is the recursive step in which you split the array up into
     * a left and a right portion, sort them, and then merge them together.
     * Use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     *
     * TODO
     * Best-case runtime:
     * Worst-case runtime:
     * Average-case runtime:
     *
     * Space-complexity:
     */
    @Override
    public int[] sort(int[] array) {
        int a[]=new int[array.length/2];
        int b[]=new int[array.length/2];
        if(array.length<=INSERTION_THRESHOLD){
            InsertionSort IS = new InsertionSort();
            return IS.sort(array);
        }
        System.arraycopy(array,0, a,array.length/2,array.length/2);
        System.arraycopy(array,array.length/2,b,array.length,array.length/2);
        return merge(sort(a), sort(b));
    }

    /**
     * Given two sorted arrays a and b, return a new sorted array containing
     * all elements in a and b. A test for this method is provided in `SortTest.java`
     */
    public int[] merge(int[] a, int[] b) {
        int sorted[]=new int[a.length+b.length];
        int counta=0;
        int countb=0;
        for(int i =0;i<sorted.length;i++){
            if(countb<b.length && (a[counta]>b[countb] || counta>=a.length)){
                sorted[i]=a[counta];
                counta++;
            }
            else if(counta<a.length) {
                sorted[i]=b[countb];
                countb++;
            }
        }
        return sorted;
    }

}
