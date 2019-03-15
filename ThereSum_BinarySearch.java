package TwoSum;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;

public class ThereSum_BinarySearch {
	public int count(int [] a) {
		int count = 0;
		Arrays.sort(a);//进行排序
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (BinarySearch.rank((-a[i]-a[j]),a)<j) {//继承上一个问题的问题,我们这里要求不能小于J
					count ++;
				}
			}
		}
		return count;
	}
}
