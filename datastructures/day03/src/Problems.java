import java.util.*;

public class Problems {

    public static class Node {
        int val;
        Node next;

        Node(int d) {
            this.val = d;
            next = null;
        }
    }

    private static int[] remDig(int[] B, int index) { //removes digit from array given a specific index
        int[] rep = new int[B.length - 1];
        int count = 0;
        for (int i = 0; i < B.length; i++) {
            if (i != index) {
                rep[count] = B[i];
                count++;
            }
        }
        return rep; //returns an array
    }

    public static List<Integer> removeKDigits(int[] A, int k) {
        List<Integer> l = new LinkedList<>();
        if(k==A.length){
            return l;
        }
        for(int j=0; j<k;j++) {
            if(A[0]>A[1]){
                A=remDig(A,0);
                break;
            }
            int i=0;
             while (A[i]<A[i+1] && i!=A.length) {
                 if (i == A.length) {
                     A = remDig(A, i);
                 } else {
                     A = remDig(A, i + 1);
                 }
                 i++;
             }
            }
        for (int i = 0; i < A.length; i++) l.add(A[i]);
        return l;
    }



    public static boolean isPalindrome(Node n) {
//        int i=0;
//        int j=0;
//        while(i){
//            while(j!=null){
//                j=j+2;
//                i++;
//            }
//            break;
//        }
//        int size=j; //size +- 1

        //TODO: pointer that gets to the end at double speed, while single speed pointer moves to halfway
        //TODO: reverse the second half
        //TODO: Compare to first half
        return true;
    }

    public Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static String infixToPostfix(String s) {
        //split string
        String[] sarray1= s.split(" ");
        for(int i=0;i<sarray1.length;i++){
            if(sarray1[i].matches("\\(") || sarray1[i].matches("\\)")){
                sarray1=remStr(sarray1,i);
                i--;
            }
            else if(i!=sarray1.length-1 && (sarray1[i].matches(".+") || sarray1[i].matches("-")||sarray1[i].matches("/")||sarray1[i].matches(".*"))){
                String temp=sarray1[i+1];
                sarray1[i+1]=sarray1[i];
                sarray1[i]=temp;
                i++;
            }
        }
        String fin= new String();
        for(int i=0;i<sarray1.length;i++){
            if(i!=sarray1.length-1)
                fin=fin+sarray1[i]+" ";
            else
                fin=fin+sarray1[i];
        }
        System.out.println(fin);
        return fin;
    }
    private static String[] remStr(String[] B, int index) { //removes digit from array given a specific index
        String[] rep = new String[B.length - 1];
        int count = 0;
        for (int i = 0; i < B.length; i++) {
            if (i != index) {
                rep[count] = B[i];
                count++;
            }
        }
        return rep; //returns an array
    }
}
