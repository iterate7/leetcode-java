package leetcode;

/**
 * problem:
 * 
	Given a non-empty array of integers, every element appears twice except for one. Find that single one.
	
	Note:
	
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	
	Example 1:
	
	Input: [2,2,1]
	Output: 1
	Example 2:
	
	Input: [4,1,2,1,2]
	Output: 4
	
	solve:
	xor has the feature: a^a = 0; => a^b^a = b
	
	link:
	https://leetcode.com/problems/single-number/description/
	
 * @author iterate7
 * @date 2018/3/20
 * @category bit-manipulation 
 */
public class Problem136SingleNumber {

	/**
	 * a^b^a = a^a^b = 0^b=b
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res ^= nums[i];
		}
		return res;
	}
	 
}
