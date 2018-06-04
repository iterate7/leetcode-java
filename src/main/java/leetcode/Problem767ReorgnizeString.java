package leetcode;

import java.util.PriorityQueue;
/**
 * 
 * @author iterate7
 * @date 2018/6/1
 *
 */
public class Problem767ReorgnizeString {

	public static void main(String[] args) {

		String s = "abccdd";
		Problem767ReorgnizeString p = new Problem767ReorgnizeString();
		System.out.println(p.reorganizeString(s));
		System.out.println(p.reorganizeStringBaseOddEven(s));
	}
	
	/**
	 * 算法1：交叉排放最多字符法。
	 *  step1: 把每个字母和对应的次数统计出来；按序排序
	 *  step2: 每次取一个字符；原则是：从频度最高的字符取出来，如果和前面一个重复；则再去一次；如此反复；肯定不会重复；
	 *  step3： 有重复的单独列出来了，则是大于一半的字符是否存在；否则就按step1和step2依次做下去；
	 * 
	 * 
	 * 算法2：奇偶排放法。
	 *  step1：字母和对应次数统计，按频度排序；
	 *  step2： 在偶数位置，依次放字符；放完换下一个字符；如果放到结尾的时候，自动跳到首位1开始；都放奇数位；这样肯定不会存在重复；
	 *  step3： 重复还是单独拉出来判断。
	 *  
	 * 问题总结：
	 * 1. 不能摆放的单独判定；
	 * 2. 可以重组的，则有两种思路，一种是通过get到不同的字符来满足不能相同； 另一种思路则是通过位置隔开来满足不相邻。异曲同工。
	 * 3. 数据结构PriorityQueue的使用非常关键。
	 *  
	 * 
	 * 
	 * @param S
	 * @return
	 */
	public String reorganizeString(String s)
	{
		      int[] chars = new int[26];
				for(char c: s.toCharArray())
				{
					chars[c-'a']++;
				}
				
				//System.out.println(Arrays.toString(chars));
				
				PriorityQueue<int[]> char2fre =  new PriorityQueue<>((a, b) -> b[1] - a[1]);
				
				for(int i =0;i<chars.length;i++)
				{
					if(chars[i]>0)
					char2fre.add(new int[]{i,chars[i]});
				}
				int mostFre = char2fre.peek()[1];
				//System.out.println("mostFre:"+mostFre);
				if(mostFre>(s.length()+1)/2)
				{
					return "";
				}
				StringBuffer sb = new StringBuffer();
				while(!char2fre.isEmpty())
				{
					int first[] = char2fre.poll();
					char c =(char)( first[0]+'a');
					int fre = first[1];
					//满足直接放进去的条件
					if(sb.length()==0 || sb.toString().charAt(sb.length()-1)!=c)
					{
						sb.append(c);
						if(--fre>0)
							char2fre.add(new int[]{first[0],fre});
					}
					else //重复
					{
						int[] second = char2fre.poll();//这个值肯定是和last不同
						sb.append((char)(second[0]+'a'));
						if(--second[1]>0)
						char2fre.add(second);
						
						char2fre.add(first);//没用到的放过去！
					}
				}
				return sb.toString();
	}
	
	/**
	 * round-robin的思路。
	 * @param s
	 * @return
	 */
	public String reorganizeStringBaseOddEven(String s)
	{
	    int[] chars = new int[26];
					for(char c: s.toCharArray())
					{
						chars[c-'a']++;
					}
					
					//System.out.println(Arrays.toString(chars));
					
					PriorityQueue<int[]> char2fre =  new PriorityQueue<>((a, b) -> b[1] - a[1]);
					
					for(int i =0;i<chars.length;i++)
					{
						if(chars[i]>0)
						char2fre.add(new int[]{i,chars[i]});
					}
					int mostFre = char2fre.peek()[1];
					//System.out.println("mostFre:"+mostFre);
					if(mostFre>(s.length()+1)/2)
					{
						return "";
					}
					 
					char [] ret = new char[s.length()];
					int i = 0;
					//轮询
					while(!char2fre.isEmpty())
					{
						int[] ent = char2fre.poll();
						for(int j=0;j<ent[1];j++)								
						{
							char c =(char)( ent[0]+'a');
							ret[i] = c;
							i = i+2;
							if(i>=s.length())
								i = 1;
			
						}
					}
					
					
		StringBuffer sb = new StringBuffer();
		for(char c: ret)
			sb.append(c);
		return sb.toString();
	}
	

}
