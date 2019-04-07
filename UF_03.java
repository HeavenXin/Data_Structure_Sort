package UF;
/**
 * 
 * @author Heaven
 *	此方法我们利用了权重的方法,列出两个数组,一个记录树结构,一个记录树的大小
 *	每当有新的连接,我们就直接寻找两个触点的根节点,将较小的树根节点连接到大的树根节点里面
 */
public class UF_03 {
	private int[] sz;//记录各树的数量级
	private int[] id;//记录各树的索引
	private int count;
	public  void WeightedQuickUnionUF(int N) {//创建两个数组
		count = N;
		id = new int [N];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
		sz = new int [N];
		for (int i = 0; i < sz.length; i++) {
			sz[i] = 1;
		}
	}
	public int size() {
		return count;
	}//返回数量
	public boolean connected(int p,int q) {
		return find(p) == find(q);
	}
	private int find(int p) {//注意,这一步我要返回的是根节点
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}
	public void union(int p,int q) {
		int n = find(p);
		int m = find(q);
		if (n == m) 
			return;
		if (sz[n]>sz[m]) {//如果大于,那么把m贴在n上
			id[m] = n;
			sz[n]+=sz[m];
		}else {
			id[n] = m;
			sz[m]+=sz[n];
		}
		count--;
	}
}
