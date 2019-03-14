package Stack;
//第一个错误,公共类要和包名要一致

public class Stack<Item> {
	private	Node first;
	private int N;//元素的数量
	private class Node{
		Item item;
		Node next;//栈的位置
	}//开始实现常见方法
	public boolean isEmpty() {//是否为空
		return first == null;
	}
	public int size() {//查看元素数值
		return N;
	}
	public void push(Item item) {//添加元素
		Node usdNode = first;//第一转为之前的第一
		first = new Node();
		first.item = item;//导入item
		first.next = usdNode;
		N++;
	}
	public Item pop() {
		Item item = first.item;//导出数据
		first = first.next;
		N--;
		return item;	
	}
	//缺点:没有及时的对游离数据进行回收
}
