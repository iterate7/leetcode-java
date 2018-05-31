package leetcode;

/**
 * 
 * link:https://leetcode.com/problems/palindrome-number/description/
 * problem:
		Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
		
		Example 1:
		
		Input: 121
		Output: true
		Example 2:
		
		Input: -121
		Output: false
		Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
		Example 3:
		
		Input: 10
		Output: false
		Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * solve:
 * algorithm 1: convert into string, and reverse string, thenequals.
 * algorithm 2: two pointers, one from left, the other from right, using mod and divide base.
 * algorithm 3: reverse the number and decide if it's equal.
 * 
 * 
 * 
 * category: palindrome; two-pointer
 * 
 * @author iterate7
 */
public class Problem9PalindromeNumber {
	
	private int radix = 10;
	
	public static void main(String[] args) {

		Problem9PalindromeNumber pp = new Problem9PalindromeNumber();
		int k= 1000021;
		for (int i = 0; i < k; i++) {
			boolean actual = pp.isPalindromeByReverseInteger(i);
			boolean value = pp.isPalindromeByTwoPointer(i);
			if (actual != value || actual)
			{
				System.out.println(i + "   " + value + "," + actual);
			}
		}

	}

	public boolean isPalindromeByReverseString(int x) {
		return new StringBuffer(x + "").reverse().toString().equals(x + "");
	}

	/**
	 * reverse all from integer aspect and decide =.
	 * 
	 * @param x
	 * @return
	 */
	public boolean isPalindromeByReverseInteger(int x) {
		int copyX = x;
		if (copyX < 0 || (copyX != 0 && copyX % radix == 0))
		{
			return false;
		}
		int sum = 0;
		while (copyX > sum) {
			sum = sum * radix + copyX % radix;
			copyX = copyX / radix;
		}
		return (copyX == sum) || (copyX == sum / radix);
	}

	/**
	 * two pointer
	 * 
	 * @param x
	 * @return
	 */
	public boolean isPalindromeByTwoPointer(int x) {
		
		if (x < 0)
		{
			return false;
		}
		if (x < radix)
		{
			return true;
		}
		
		
		int leftexp = (int) Math.log10(x);
		int rightexp = (int) Math.log10(1);

		int copyX = x;
		
		
		/**
		 * 比如：取1234中的2；那么需要： x(第三位，百位)= x %(10^3) /(10^2)
		 */
		while (copyX > 0) {

			long leftMod = (long) (Math.pow(10, leftexp));
			long rightMod = (long) (Math.pow(10, rightexp));

			long right = copyX / (rightMod) % 10;
			long left = copyX / (leftMod) % 10;

			if (left != right) {
				return false;
			}

			leftexp--;
			rightexp++;
			if (leftexp <= rightexp || leftexp <= 0)
			{
				break;
			}
		}

		return true;

	}

}
