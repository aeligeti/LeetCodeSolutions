package com.leetcode.p0014_longestcommonprefix;

/*
 * LeetCode 14. LongestCommonPrefix
 */
public class LongestCommonPrefixBruteForce implements ILongestCommonPrefix{

	@Override
	public String solve(String[] strs) {
		/* 
		 * The brute force approach to find the longest common prefix in an array of strings involves the following steps:
		 * find the shortest string (to optimize search)
		 * do a brute force search for each char in shortest string
		 * if there is no match in some string, return string up to index with last match.
		 */
		if(strs==null || strs.length==0){
			return "";
		}
        int minLength=Integer.MAX_VALUE;
        int minLengthIdx = 0;
        for(int i=0; i<strs.length; i++){
            if(strs[i].length()<minLength){
                minLength = strs[i].length();
                minLengthIdx = i;
            }
        }
        int idx = 0;
        int count =0;
        while(idx<minLength){
            char c = strs[minLengthIdx].charAt(idx);
            for(String str: strs){
                if(str.charAt(idx)!=c){
                    return strs[minLengthIdx].substring(0,count);
                } 
            }
            count++;
            idx++;
        }

        return count==0?"":strs[minLengthIdx].substring(0,count) ;
    }
	

	@Override
	public String name() {
		
		return "LongestCommonPrefixBruteForce";
	}
	

}
