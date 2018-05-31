package progress;
/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public String toString()
    {
    	return val+"";
    }
}
class Solution {
  /**
	 * 翻转整个链表然后和原始链表对�?
	 * @param head
	 * @return
	 */
	    public boolean isPalindrome(ListNode head) {
	    	
	    	ListNode secondHalfHead = new ListNode(-1);
	    	ListNode fast = head;
	    	ListNode slow = head;
	    	
	    	//找中点，方法是一个k速度；一�?2k速度；当fast结束的时候，slow自然就是�?半！
	    	while(fast!=null && fast.next!=null)
	    	{
	    		fast = fast.next.next;
	    		slow = slow.next;
	    	}
	    	
	    	
	    	if(fast!=null) //奇数
	    	{
	    		slow = slow.next; //再往前走�?个（中间的那个）
	    	}
	    	if(slow==null)//�?1�?
	    		return true;
	    	System.out.println(slow+","+fast);
	    	
	    	//reverse nodes�? �?始对slow进行翻转�?
	    	slow = reverse(slow);
	    	System.out.println("secondHead:"+secondHalfHead);
//	    	while(secondHalfHead!=null)
//	    	{
//	    		System.out.print(secondHalfHead.val+"->");
//	    		secondHalfHead = secondHalfHead.next;
//	    		
//	    	}
	    	
	    	//compare对比
	    	while(secondHalfHead.next!=null && head.next!=null)
	    	{
	    		if(secondHalfHead.next.val!=head.val) return false;
	    		secondHalfHead = secondHalfHead.next;
	    		head = head.next;
	    	}
	    	
	        return true;
	}
	    
		public ListNode reverse(ListNode head) {
    	    ListNode prev = null;
    	    while (head != null) {
    	        ListNode next = head.next;
    	        head.next = prev;
    	        prev = head;
    	        head = next;
    	    }
    	    return prev;
    	}
}

public class Problem234PalindromeLinkedList {
   
	public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
    
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
           
        	ListNode head = stringToListNode(line);
            
            boolean ret = new Solution().isPalindrome(head);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}