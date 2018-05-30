package leetcode;

/**
 * problem:
 * The Hamming distance between two integers is the number of positions at which 
 * the corresponding bits are different.
 * 
 * link:
 * https://leetcode.com/problems/hamming-distance/description/
 * 
 * solve:
 * xor, count(bit1)
 * 
 * @category bit-manipulation
 
 */
public class Problem461HammingDistance {

	
	/**
	 * algorithm:
	 * 1. t = x xor y; t has the all 1 bits, difference.
	 * 2. count the bit.
	 * @param x
	 * @param y
	 * @return
	 */
	 public int hammingDistance(int x, int y) {
		 
		 return Integer.bitCount(x^y);
	        
	    }
	 
	 /**
	  * algorithm:
	  * 1. t = x xor y; the hamming distance is the count of 1-bit.
	  * 2.  xor & (xor-1) to get most-left 1bit.
	  * @param x
	  * @param y
	  * @return
	  */
	 public int hammingDistance2(int x, int y) {
		 
		 int xor = (x^y);
		 
		   int cnt=0;
		    while (xor>0) {
		        cnt ++;
		        xor=xor&(xor-1);
		    }
		    return cnt;
	        
	    }
	

}
