package Priority_Queue;

/**
 * @author Heaven
 * 	利用栈实现了优先队列
 */
public class Priority_Queue_Stack<Item extends Comparable<Item>>{
	private  Node start;
	private  Node end;
	private static int N;
	
	private class Node{
		Item item;
		Node next;
		Node leep;
	}
	public  void Maxpq() {
	}
	public void Insert(Item item) {
		Node oldend = end;
		if (item.compareTo(end.item)>0) {
			Node temp =end.leep;
			Insert(item, temp);
			return;
		}
		if (isEmpty()) {
			start = end;
		}else {
			oldend.next = end;
		}
		N++;
		
	}
	public void Insert(Item item,Node temp) {
		if (item.compareTo(temp.item)>0) {//如果在大于
			temp = temp.leep;
			Insert(item, temp);
		}//不再大于了
		Node oldLeep = temp.leep;
		Node inputNode =new Node();
		inputNode.next = temp;
		temp.leep = inputNode;
		oldLeep.next =inputNode;
		inputNode.leep = oldLeep;
		N++;
	}
	public Item	delMax(){
		Item oldNode = end.item;
		end = end.leep;
		return oldNode;
	}
	public Item Max(){
		return end.item;
	}
	public static int size() {
		return N;
	}
	public static boolean isEmpty() {
		return N==0;
	}
}
