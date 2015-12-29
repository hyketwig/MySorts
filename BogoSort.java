//Jannie Li
//APCS1 pd10
//HW- -- -
//2015-12-23


import java.util.ArrayList;


public class BogoSort {

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
	
    }//end bogoSortV



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
	
    }//end bogoSort -- O(n^2)


    public static void main(String[] args) {

	
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	bogoSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	
	//===============for VOID methods=============
	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	bogoSortV(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	
	//==========for AL-returning methods==========
	glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	ArrayList glenSorted = bogoSort( glen );
	System.out.println( "sorted version of ArrayList glen:\n" 
	+ glenSorted );
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	ArrayList cocoSorted = bogoSort( coco );
	System.out.println( "sorted version of ArrayList coco:\n" 
	+ cocoSorted );
	System.out.println( "ArrayList coco after sorting:\n" + coco );

    }//end main

}//end class SelectionSort
