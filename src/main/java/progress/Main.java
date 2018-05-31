package progress;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner cin = new Scanner(System.in);
		
			// input & prepare
			int length = cin.nextInt();
			int [] nums = new int[length];
			for(int i=0;i<nums.length;i++)
				nums[i] = cin.nextInt();
//			 int nums [] = new int[]{4, 5, -2 ,-9 ,8 ,4, -7 ,3};
			
			//find
			System.out.print(findIndexSubArrayNotMinus(nums));
		
	}
	   
	    
	    /**
		 * 算法思路：
		 * 方法1： greedy搜索；(估计会超时)
		 * 方法2： 应该可以用动态规划的方法解决（时间来不及调试了）
		 * 
		 * @param nums list of numbers
		 * @return index
		 */
		public static int findIndexSubArrayNotMinus(int[] nums)
		{
			
			for(int i=0;i<nums.length;i++)
			{
				 if(nums[i]<0)
					 continue;
				 boolean find = true;
//				 System.out.println(nums[i]);
				 int sum_i[] = new int[nums.length];
				 sum_i[i] = nums[i];
				 for(int k=i+1;k<nums.length;k++)
				 {
					 sum_i[k]=sum_i[k-1]+nums[k];
					 if(sum_i[k]<0)
					 {
						 find = false;
						 break;
					 }
				 }
				 for(int k=0;k<i;k++)
				 {	
					 sum_i[k]=sum_i[(k+nums.length-1)%nums.length]+nums[k];
					 if(sum_i[k]<0)
					 {
						 find = false;
						 break;
					 }
				 }
				 
					
				 
//				 for(int next=0;next<nums.length;next++)
//				 {
//					 
//					 int merge = sumSubArray(nums,i,next);
//					 System.out.println(i+","+next+",merge:"+merge);
//					 if(merge<0)
//					 {
//						 find = false;
//						 break;
//					 }
//				 }
				 if(find)
				 return i;
			}
			
			 return -1;
		}
		
		
		public static int sumSubArray(int nums[],int i,int j)
		{
			int sum = 0;
			if(i<=j)
			for(int idx = i;idx<=(j);idx++)
				sum+=nums[idx%nums.length];
			else
			{
				for(int idx = i;idx<=(j+nums.length);idx++)
					sum+=nums[idx%nums.length];
			}
			return sum;
		}
	}