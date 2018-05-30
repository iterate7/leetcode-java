package leetcode;

/**
 * link:https://leetcode.com/problems/number-of-1-bits/description/
 * problem:
		Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
		
		Example 1:
		
		Input: 11
		Output: 3
		Explanation: Integer 11 has binary representation 00000000000000000000000000001011 
		Example 2:
		
		Input: 128
		Output: 1
		Explanation: Integer 128 has binary representation 00000000000000000000000010000000 		
 * solve:
 * algorithm 1. yes, you can Integer.bitCount, but this is not the focus.
 * algorithm 2. using & 1 to find the last bit; and move right and left set 0 >>>.
 * algorithm 3. n & (n-1) to turn off the most-right bit-1.
 *  
 * category: bit-manipulation
 * 
 * @author iterate7
 *
 */
public class Problem191NumberOf1Bits {
	

	/**skill:
	 * n & 1==1  odd
	 * n & 0==0  even
	 * @param n
	 * @return
	 */
	public static int hammingWeight(int n) {
		int ones = 0;
	    	while(n!=0) {
	    		ones = ones + (n & 1); //(n & 1) = last bit is 0 or 1?
	    		n = n>>>1; //move right, the most left most be set 0.
	    	}
	    	return ones;
	}
	

	 /**
	  * refer:	http://www.catonmat.net/blog/low-level-bit-hacks-you-absolutely-must-know/
	  * n & (n-1)
	  * skill:Turn off the rightmost 1-bit.
	  * @param n
	  * @return
	  */
	  public int hammingWeight2(int n) {
	        int count = 0;
	        while(n != 0){ //n>0 is wrong
	            n = n & (n-1);
	            count++;
	        }
	        return count;
	    }
}
