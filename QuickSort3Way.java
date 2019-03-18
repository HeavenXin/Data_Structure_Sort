package QuickSort;
/**
 * 
 * @author Heaven
 *	使用三向切分来进行快速排序,优化了含有相同元素的数组
 */
public class QuickSort3Way {
	public static void sort(Comparable[] a) {// 进行排序的方法
		sort(a, 0, a.length- 1);
	}
	private static void sort(Comparable[] a,int start,int end) {// 进行排序的方法
		if (end<=start) 
			return;
		int x = start;
		int i = start + 1;
		int y = end;//设置条件
		Comparable v = a[start];
		while (i<=y) {//不断缩小未确定的范围,如果写成了start会出现指针报错
			int cmp = a[i].compareTo(v);
			if (cmp<0)//如果小于
				exch(a, x++, i++);//交换两者,使小的值在前
			else if (cmp>0)//如果大于 
				exch(a, i, y--);//交换两者,使大值在后面,i不自增的原因是要看是否还有大的
			else
				i++;//相同则自增
		}//现在有小于v的(start,x-1),等于的(x,y),大于的(y+1,end)
		sort(a, start, x-1);
		sort(a, y+1, end);
	}
	

	public static boolean less(Comparable a, Comparable a2) {// 对元素进行比较
		return a.compareTo(a2) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {// 进行交换
		Object n = a[i];
		a[i] = a[j];
		a[j] = (Comparable<Object>) n;
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		} // 进行输出
	}

	public static boolean isSorted(Comparable[] a) {// 测试是否排序
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Double[] a = new Double[500];
		for (int j = 0; j < 500; j++) {
			a[j] = Math.random();// 随机添加随机数
		}
		sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
