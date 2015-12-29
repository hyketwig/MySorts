
import java.util.ArrayList;

public class MySorts {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) 
    {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }


    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) 
    {
	int randomIndex;
	//setup for traversal fr right to left
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static boolean isSorted( ArrayList<Comparable> data ) {
	for (int i = 0; i < data.size() - 1; i++) {
	    if (data.get(i).compareTo(data.get(i+1)) > 0) {
		return false;
	    }
	}
	return true;
    }

    
    // VOID version of bogoSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bogoSortV( ArrayList<Comparable> data )
    {
	
	while (isSorted(data) == false) {
	    shuffle(data);
	}
	
    }//end bogoSortV -- O(infinity)



    // ArrayList-returning bogoSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> 
        bogoSort( ArrayList<Comparable> input ) 
    {

	ArrayList<Comparable> ret = new ArrayList<Comparable>();

	//copy values
	for (Comparable x : input) {
	    ret.add(x);
	}

	//sort
	bogoSortV(ret);
	return ret;
	
    }//end bogoSort -- O(infinity)


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data )
    {

	//need n - 1 passes
	for (int pass = data.size() - 1; pass > 0; pass--) {

	    //pass through by swapping from right
	    for (int i = data.size() - 1; i > 0; i--) {
		if (data.get(i).compareTo(data.get(i-1)) < 0) 
		    data.set( i, data.set( i - 1, data.get(i) ) );
	    }
	    
	}
	
    }//end bubbleSortV -- O(n^2)


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
    {
	ArrayList<Comparable> ret = new ArrayList<Comparable>();

	//copy input
	for (int b = 0; b < input.size(); b++) {
	    ret.add(input.get(b));
	}

	//sort
	bubbleSortV(ret);
	return ret;
	
    }//end bubbleSort -- O(n^2)


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) 
    {

	int minInd = 0; //index where min value is

	for (int b = 0 ; b < data.size() ; b++) {

	    //offset search for min each round
	    for (int i = b ; i < data.size() ; i++) {
		if (data.get(i).compareTo(data.get(minInd)) < 0) {
		    minInd = i;
		}
	    }

	    //compare current index's value to minInd's value
	    if (data.get(b).compareTo(data.get(minInd)) > 0) {
		data.set( b, data.set( minInd, data.get(b) ) );
	    }
	    else {
		minInd++;
		//if it's not bigger, it is the minInd (or equiv)
		//advance minInd to maintain offset (doesn't switch back)
	    }

	}
	
    }//end selectionSort -- O(n^2)


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> 
	selectionSort( ArrayList<Comparable> input ) 
    {

	ArrayList<Comparable> ret = new ArrayList<Comparable>();

	//copy values
	for (Comparable x : input) {
	    ret.add(x);
	}

	//sort
	selectionSortV(ret);
	return ret;
	
    }//end selectionSort -- O(n^2)
}
