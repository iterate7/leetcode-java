package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * link:https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 * problem:
		Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
		
		Find all the elements of [1, n] inclusive that do not appear in this array.
		
		Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
		
		Example:
		
		Input:
		[4,3,2,7,8,2,3,1]
		
		Output:
		[5,6]
		
 * solve:
 * 	algorithm:
 * 	 1. use the sign(x) to get the state of exist.
 * 	 2. use the index of array to record the value
 * 	 3. index-1 to avoid to out of bound of array
 * 
 * tag: array; index;
 * @author iterate7
 *
 */
public class Problem448FindAllNumbersDisappearedInAnArray {

	public static void main(String[] args) {

		Problem448FindAllNumbersDisappearedInAnArray nin = new Problem448FindAllNumbersDisappearedInAnArray();
		int nums[] = new int[]{3,4,5,2,1,6,1};
		//nums = new int[]{1,3,3,4,5,6};
		List<Integer> ret = nin.findDisappearedNumbers(nums);
		System.out.println(ret);
		
	}
	
	   /**
			 * 
			 * @param nums list of numbers
			 * @param n [1,n]
			 * @return numbers of not exist in nums
			 */
			public  List<Integer> findDisappearedNumbers(int[] nums)
			{
				int numsCopy [] = Arrays.copyOf(nums, nums.length);
				List<Integer> ret = new ArrayList<Integer>();
				int n = nums.length;
				for (int item : numsCopy) {
					
					//get the value of current; the real value is abs; sign is used by the history of record.
					item = Math.abs(item); 
					
					//the index is used? if use, continue; the number is visited before.
					if(numsCopy[item-1]<0) 
						continue;
					
					//keep the original number
					int value = Math.abs(numsCopy[item - 1]);
					numsCopy[item - 1] = -1; // record the state by using sign(value-1)<0
					numsCopy[item - 1] = -value;// keep the original number

				}

				boolean findNotExist = false;
				for (int i = 0; i < n; ++i) {
					if (numsCopy[i] > 0) {
						findNotExist = true;
						//System.out.println(i + 1);
						 ret.add(i+1);
					}
				}

				if (!findNotExist)
				{
					//System.out.println("NONE");
					return null;
				}
				else
				return ret ;
			}
	
	
	/**
	 * 1. mark all index
	 * 2. for all index and collect
	 * 
	 * @param nums
	 * @return
	 */
	public List<Integer> findDisappearedNumbersBaseMoreSpace(int[] nums) {
        boolean[] marked = new boolean[nums.length];
      for(int i=0; i < nums.length; ++i) {
         int val = nums[i];
         marked[val-1] = true;
      }
      List<Integer> result = new ArrayList<Integer>();
      for(int i=0; i < nums.length; ++i) {
         if(!marked[i]) {
            result.add(i+1);
         }
      }
      return result;
  }

}
