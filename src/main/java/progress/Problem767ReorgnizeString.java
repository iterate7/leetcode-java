package progress;

import java.util.PriorityQueue;

public class Problem767ReorgnizeString {

	public static void main(String[] args) {

		String s = "aba";
		Problem767ReorgnizeString p = new Problem767ReorgnizeString();
		p.reorganizeString(s);
	}
	
	/**
	 * 某个�?大频度的字符超过�?半，失败返回�?
	 * 
	 * 成功的组合算法如下：
	 * 
	 * 1. 根据fre统计分块。相同的字符放在�?块�??
	 * 2. 从每个块中轮询，每次从一个块里提取一个字符；�?直如此继续下去，肯定不会存在相邻的�?�核心�?�路：每次都来自不同的block�?
	 * block之间就不相同，这个�?�路有点先聚类，然后抽取代表的意思�??
	 * 3. 直到每个block都不存在�?
	 * 这个可以使用PriorityQueue来实现�??
	 * 
	 * 
	 * 组合的算�?2�?
	 * 1. 根据fre继续分块和统计�??
	 * 2. 我们依旧是轮询，但是是每次把�?个块轮询完，把位置分为叉�?放置的�?�路，也就是每次都隔�?放；这样保证每个块的字符都无法连在一起�??
	 * 这个思路也是轮询思想�?
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
					//满足直接放进去的条件�?
					if(sb.length()==0 || sb.toString().charAt(sb.length()-1)!=c)
					{
						sb.append(c);
						if(--fre>0)
							char2fre.add(new int[]{first[0],fre});
					}
					else //重复�?
					{
						int[] second = char2fre.poll();//这个值肯定是和last不同�?
						sb.append((char)(second[0]+'a'));
						if(--second[1]>0)
						char2fre.add(second);
						
						char2fre.add(first);//没用到的放过去！
					}
				}
				return sb.toString();
	}
	

}
