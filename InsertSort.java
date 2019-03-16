package InsertSort;
/**
 * 
 * @author Heaven
 *	插入排序就是在我们一边第一层进行基础遍历
   *        然后第二层之中,我们将第一层的i和之前已经排序的进行比较,然后插进去之前排序好的
 */
public class InsertSort {
	public static void sort(Comparable[] a) {//进行排序的方法
		int N =a.length;
		for (int i = 1; i < N; i++) {//进行第一段排序
			for (int j = i; j >0 && less(a[j], a[j-1]); j--) {
				exch(a, j, j-1);//进行循环排序 
			}
		}
	}
	public static boolean less(Comparable a,Comparable a2) {//对元素进行比较
		return a.compareTo(a2) < 0;
	}
	private static void exch(Comparable[] a,int i,int j) {//进行交换
		Object n =a[i];
		a[i] = a[j];
		a[j] = (Comparable<Object>) n;
	}
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]+" ");
		}//进行输出
	}
	public static boolean isSorted(Comparable[] a) {//测试是否排序
		for (int i = 1; i < a.length; i++) {
			if (less(a[i],a[i-1])) {
				return false;
			}
		}
		return true;
	}
	
}
