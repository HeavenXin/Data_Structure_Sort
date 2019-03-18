package ShellSort;
/**
 * 
 * @author Heaven
 *	使用一个自增数组完成希尔排序
 */
public class ShellSort_test {
	public static void sort(Comparable[] a) {
		int N = a.length;
		int[] h = new int[2];// h数组
		int tempH = 1;// h数组的第一个元素
		int t;
		for (t = 0; tempH < N / 3; t++) {
			if (t >= h.length)// h数组扩容
			{
				int[] temp = new int[(h.length +1)];
				for (int i = 0; i < h.length; i++) {
					temp[i] = h[i];
				}
				h = temp;
			}
			h[t] = tempH;
			tempH = tempH * 3 + 1;//1,4,13
		}
		while (t >=0) {
			for (int i = h[t]; i < N; i++) {
				for (int j = i; j >= h[t] && less(a[j], a[j - h[t]]); j -= h[t]) {
					exch(a, j, j-h[t]);
				}
			}
			t--;
		}

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
