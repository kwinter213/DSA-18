package your_code;

import java.util.LinkedList;

/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue {
    private LinkedList<Integer> ll;
    public MyPriorityQueue() {ll=new LinkedList<Integer>();
    }

    public void enqueue(int item) {
        boolean flag=false; //whether or not we have added the item
        if(ll.size()==0) {
            ll.add(item);
        }
        else {
            LinkedList<Integer> temp0= new LinkedList<Integer>();
            while (ll.size()>0){
                int temp=ll.removeFirst();
                if(temp<item){
                    temp0.addLast(temp);
                }
                else{
                    temp0.addLast(item);
                    temp0.addLast(temp);
                    flag=true;
                    while(ll.size()>0){
                        temp0.add(ll.removeFirst());
                    }
                }
            }
            if(!flag){
                temp0.add(item);
            }
            ll=temp0;
        }
    }

    /**
     * Return and remove the largest item on the queue.
     */
    public int dequeueMax() {
        if(ll.size()>0) {
            return ll.removeLast();
        }
        else{
            return Integer.parseInt(null);
        }
    }

}