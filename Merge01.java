package Merge;

/**
 * 
 * @author Heaven 对归并的优化,即在归并过程中,使用插入排序进行优化 而且在其基础上,进行了是否需要递归的测试
 */
public class Merge03 {

	private static void insertSort(Comparable[] a, int x, int y) {
		for (int i = x; i <= y; i++) {// 进行第一段排序
			for (int j = i; j > x && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);// 进行循环排序
			}
		}
	}

	public static void sort(Comparable[] a) {// 进行排序方法1
		Comparable[] aux = a.clone(); // 复制数组
		sort(a, aux, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, Comparable[] aux, int x, int y) {
		// 重载上面方法
		if (y <= x + 7) {
			insertSort(aux, x, y);
			return;
		}
		int mid = x + (y - x) / 2;// 获取数组中间数
		sort(aux, a, x, mid);// 左半边递归排序
		sort(aux, a, mid + 1, y);// 右半边递归排序
		if (less(a[mid], a[mid + 1])) {
			System.arraycopy(a, x, aux, x, y-x+1);
			return;
		}
		merge(a, aux, x, mid, y);// 最后总和
	}

	public static void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {// 进行排序的方法
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				dst[k] = src[j++];
			else if (j > hi)
				dst[k] = src[i++];
			else if (less(src[j],src[i]))
				dst[k] = src[j++];
			else
				dst[k] = src[i++];
		}

	}

	public static boolean less(Comparable a, Comparable a2) {// 对元素进行比较
		return a.compareTo(a2) <= 0;
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

	public static void main(String[] args) {// 验证是否正确
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
