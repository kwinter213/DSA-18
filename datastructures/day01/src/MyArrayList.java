public class MyArrayList {
    private Cow[] elems;
    private int size; //aka the number of cows

    // Runtime: O(1) (this is O(10), because this is the runtime no matter what the input.
    public MyArrayList() {
        elems=new Cow[10];
        size=0;
    }

    // Runtime: O(1)
    public MyArrayList(int capacity) {
        elems= new Cow[capacity];
        size=0;
    }

    // Runtime: O(1) (assuming we never run over capacity)
    public void add(Cow c) { //adds cow, increases size if need be
        if(size==elems.length){
            increaseSize();
        }
        elems[size]=c;
        size=size+1;

    }

    // Runtime: O(1)
    public int size() { //returns number of cows
        return size;
    }

    // Runtime: O(1)
    public Cow get(int index) { //returns desired cow
        if (elems[index]!= null) //if the element exist, return the cow
            return elems[index];
        else //else throw an exception
            throw new IndexOutOfBoundsException();
    }

    // Runtime: O(N)
    public Cow remove(int index) { //removes a cow if it needs to get killed, returns dead cow
        if(size<=0.25*elems.length){ //decreases size if there is a lot of empty room
            decreaseSize();
        }
        if (index<size-1) {
            Cow removedCow=elems[index];
            for(int i=index; i<size-1; i++){
                elems[i]=elems[i+1];
            }
            elems[size-1]=null;
            size=size-1;
            return removedCow;
        }
        else
            throw new IndexOutOfBoundsException();
    }

    // Runtime: O(N)
    public void add(int index, Cow c) { //adds a cow at desired index, throws out of bounds exception if the index is out of bounds, increases capacity if need be
        if(size==elems.length){
            increaseSize();
        }
        if(index<=size) {
            Cow tempCow = c;
            for (int i = index; i < size - 1; i++) {
                Cow tempCow2 = elems[i];
                elems[i] = tempCow;
                tempCow = tempCow2;
            }
            size=size+1;
        }
        else
            throw new IndexOutOfBoundsException();

    }


    //Runtime O(N)
    public void increaseSize(){ //increases capacity by double
            Cow[] elemsTemp = new Cow[elems.length * 2];
            System.arraycopy(elems, 0, elemsTemp, 0, size);
            elems = elemsTemp;
    }

    //Runtime O(N)
    public void decreaseSize(){ //decreases capacity to be half size
        if(elems.length/2>1) {
            Cow[] elemsTemp = new Cow[elems.length / 2];
            System.arraycopy(elems, 0, elemsTemp, 0, size);
            elems = elemsTemp;
        }
    }
}
