package TwoSum;
/**
 * @author Administrator
 * 	此方法是简单的寻找一个数组中能有多少个两个数字可以相加为0
 *	为了避免简单for循环的运算太慢,引用了二分法和归并排序
	先排序再进行二分法查找,我们数组里面读取一个数据,然后查找对应的负数
 */

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;

public class TwoSum_BinarySearch {
	// 这个方法要注意:如果查找的数字在0-i之间,则表示是重复的
	public int count(int [] a) {
		int count = 0;
		Arrays.sort(a);//进行排序
		for (int i = 0; i < a.length; i++) {
			if (BinarySearch.rank(-a[i], a)>i) {//这里的判断语句就是防止重复
				count++;
			}
		}
		return count;
	}
}

