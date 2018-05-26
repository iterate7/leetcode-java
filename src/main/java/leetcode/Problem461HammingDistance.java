package leetcode;

/**
 * https://leetcode.com/problems/hamming-distance/description/
 *
 */
public class Problem461HammingDistance {

	 public int hammingDistance(int x, int y) {
		 
		 return Integer.bitCount(x^y);
	        
	    }
	 
	 
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
