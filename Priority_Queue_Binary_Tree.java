package Priority_Queue;

public class Priority_Queue_Binary_Tree<Key extends Comparable<Key>>{
	private Key[] pq;//静态数组
	private int N = 0;
	public void MaxPQ(int maxN) {
		pq  = (Key[])new Comparable[maxN+1];//创建一个 大于N 1的数组
		N = maxN;//N为数组的数量
	}
	public boolean isEmpty() {
		return N==0;
	}
	public int size() {
		return N;
	}
	public void insert(Key input) {//插入
		pq[++N] = input;
		swim(N);//进行排序
	}
	public Key delMax(){//输出最大
		Key max = pq[1];//获取
		exch(pq, 1, N--);//交换
		pq[N++] = null;//防止溢出
		sink(1);//向下排序
		return max;//输出
	}
	private void swim(int k) {
		while(k>1&&less(pq[k/2], pq[k])) {//如果大于1,且比父节点大
			exch(pq, k/2, k);//交换
			k = k/2;//递归
		}
	}
	private void sink(int k) {
		while (2*k<=N) {//子节点小于数组
			int j= 2*k;
			if (j<N &&less(pq[j], pq[j+1])) {//只要不溢出且比子节点小
				j++;//加大索引
			}
			while (!less(pq[k], pq[j]))
				break;//如果大于则退出
			exch(pq, k, j);//交换
			k = j;//然后递归
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
}
