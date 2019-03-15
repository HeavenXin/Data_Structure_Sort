package UF;
/**
 * 
 * @author Heaven
 *	此方法我们进一步优化UF结构
 *	采用树的方式,只需要将两个节点的根节点连接即可
 */
public class UF_02 {
	private int [] id;
	private int count;//剩余分量的数量
	public UF_02(int N) {
		id = new int [N];//创建一个数组格式来存储触点
		count = N;
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	public int count() {//调查数字
		return  count;
	}
	public boolean connected(int p,int q) {//检测连接
		return (find(p)==find(q));
	}
	/**
	 * 
	 * 在此次我们增加额外的判断,便于进行寻找根节点
	 */
	public int find(int p) { //查询所在标识符
		if (p != id[p]) {
			p = id[p];
		}
		return p;
	}
	/**
	 * 
	 * 在此次我们增加额外的优化,将两个根节点统一
	 */
	public void union(int p,int q) {//两者之间添加连接,请先确定两者是否连接
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) {
			return ;
		}//不然进行赋值
		id[pRoot] = qRoot;
	}
	public static void main(String[] args) {//常见用例
		int N = 10;//设置输入
		UF_02 uf =new UF_02(N);
		int count = uf.count;
		int p = 3;
		int q = 8;
		if (!uf.connected(p, q)) {
			uf.union(p, q);
			System.out.println(p+" "+q);
		}
	}
}