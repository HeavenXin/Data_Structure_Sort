package QuickSort;

public class QuickSort {
	public static void sort(Comparable[] a) {// 进行排序的方法
		sort(a, 0, a.length - 1);
	}
	public static void sort(Comparable[] a,int start,int end) {// 进行排序的方法
		if (end<=start) 
			return;
		int mid = partition(a, start, end);
		sort(a, start, mid-1);
		sort(a, mid+1, end);
	}

	private static int partition(Comparable[] a, int start, int end) {// 进行断点寻找
		int i = start;// 初始化变量
		int j = end + 1;
		Comparable temp = a[start];
		while (true) {// 设置无限循环
			while (less(a[++i], temp)) {
				if (i == end) {// 进行判断是否一直小于,从头到尾
					break;
				}
			}
			while (less(temp, a[--j])) {
				if (j == start) {
					break;
				}
			}
			if (i >= j)
				break;
			exch(a, i, j);// 上面两个如果都遇到违反条件的,进行交换
		}
		exch(a, start, j);// 交换到中间
		return j;// 交换完成,返回
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
