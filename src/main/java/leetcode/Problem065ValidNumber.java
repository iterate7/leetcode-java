package leetcode;

/**
 * link:https://leetcode.com/problems/valid-number/description/
 * 
 * problem:
		Validate if a given string is numeric.
		
		Some examples:
		"0" => true
		" 0.1 " => true
		"abc" => false
		"1 a" => false
		"2e10" => true

 * algorithm:
	state transfer check.
	three state: pointseen, eseen, numberseen;
	switch each character:
	1. see number; numberseen = true;
	2. see dot; pointseen->pointseen(error); eseen->pointseen(error); numberseen->pointseen(accepted)
	3. see e:  eseen->eseen(error); pointseen->eseen(error) 
	4. see +/-: before must be e!
	
 * tag: math, string, skill of state transfer
 *  
 * @author iterate7
 * @date 2018/01/02
 *
 */
public class Problem065ValidNumber {
	
	
	
	/**
	 * 算法描述；
	 * 状态记忆和转移检测的思路。
	 * 1. 看到了数字，记忆。
	 * 2. 如果遇到点，前面的状态是e或者有点了，错误转移状态。
	 * 3. 如果遇到了e，前面是e或者无数字，错误转移状态。
	 * 4. -/+前面必须是e，否则则是错误状态转移。
	 * 总结一下：
	 * 
	 * @param s
	 * @return
	 */
	 public static boolean isNumber(String s) {
		 	if(s==null)
		 	{
		 		return false;
		 	}
	        s = s.trim();
	        boolean pointSeen = false;
	        boolean eSeen = false;
	        boolean numberSeen = false;
	        for(int i=0; i<s.length(); i++) {
	            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
	                numberSeen = true;
	            } else if(s.charAt(i) == '.') {
	                if(eSeen || pointSeen)
	                {  
	                	return false;
	                	}
	                pointSeen = true;
	            } else if(s.charAt(i) == 'e') {
	                if(eSeen || !numberSeen)
	                {
	                	return false;
	                }
	              //e后必须带数字
	                 numberSeen = false; 
	                 
	                eSeen = true;
	            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
	                if(i != 0 && s.charAt(i-1) != 'e')
	                {
	                	return false;
	                }
	            } else
	            {
	            	return false;
	            }
	        }
	        return numberSeen;
	    }
	 /*
	 public static void main(String args[])
		{
			test(1, "123", true);
		    test(2, " 123 ", true);
		    test(3, "0", true);
		    test(4, "0123", true);  //Cannot agree
		    test(5, "00", true);  //Cannot agree
		    test(5, "0e", false);  //
		    test(6, "-10", true);
		    test(7, "-0", true);
		    test(8, "123.5", true);
		    test(9, "123.000000", true);
		    test(10, "-500.777", true);
		    test(11, "0.0000001", true);
		    test(12, "0.00000", true);
		    test(13, "0.", true);  //Cannot be more disagree!!!
		    test(14, "00.5", true);  //Strongly cannot agree
		    test(15, "123e1", true);
		    test(16, "1.23e10", true);
		    test(17, "0.5e-10", true);
		    test(18, "1.0e4.5", false);
		    test(19, "0.5e04", true);
		    test(20, "12 3", false);
		    test(21, "1a3", false);
		    test(22, "", false);
		    test(23, "     ", false);
		    test(24, null, false);
		    test(25, ".1", true); //Ok, if you say so
		    test(26, ".", false);
		    test(27, "2e0", true);  //Really?!
		    test(28, "+.8", true);  
		    test(29, " 005047e+6", true);  //Damn = =|||
		}
	 
	public static void test(int no, String input, boolean isNum)
	{
		 System.out.println(isNumber(input)==isNum);
	}
	*/
	

}
