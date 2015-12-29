// Jannie Li
// APCS1 pd10
// HW27 -- Objectify Your Array Tools
// 2015-11-9

public class ArrayUtils {

    public static void main(String[] args) {

	Object[] dreamers = {1,2,3,4};
	Object[] sleepers = {"cinder","box","open","locks"};
	Object[] daydreamers = {5,"above",2,"below",5,"above",2,"below"};

	
	// testing stringify
	
	System.out.println(stringify(dreamers));
	System.out.println(stringify(sleepers));
	System.out.println(stringify(daydreamers));

	
	// testing freq

	System.out.println(freq(daydreamers,"above"));
	System.out.println(freq(daydreamers,5));
    }

    

    // =======================================
    // A static method to populate an existing array
    // with randomly generated ints.
    
    public static void populate(int[] arrs, int lowerB, int upperB) {
	int count = 0;
	int aLen = arrs.length;

	// calculates random number between bounds
	while (count < aLen) {
	    arrs[count] = (((int)(Math.random()*(upperB-lowerB))) + lowerB);
	    count ++;
	}
    }



    // =======================================
    // A static method to return a String version of
    // an array of ints.
    // edited to work with Objects[] -- HW27

    public static String stringify(Object[] arrs) {
	String ret = "{";

	// for each, add to return string with a comma
	for (Object x : arrs) {
	    ret += x + ",";
	}

	// get rid of trailing comma
	return ret.substring(0,ret.length()-1) + "}";
    }



    
// =======================================
// HW 27 Additions
// =======================================

// HW25 linSearch and freq fxns

    
    // =======================================
    // return first index at which target is found
    // -1 if target not in array
    
    public static Object linSearch( Object[] a, Object target ) {
	int ret = -1; // if not in the array

	// return index when you reach the target
	for (int i = 0 ; i < a.length ; i++ ) {
	    if (a[i] == target) {
		ret = i;
		return ret;
	    }
	}

	return ret;
    }
    

    
    // =======================================
    // return how many times target appears in array
    
    public static Object freq( Object[] a, Object target ) {
	int count = 0;

	// add one every time you encounter the target
	for (Object x : a ) {
	    if (x == target) {
		count++;
	    }
	}

	return count;	  
    }


}



