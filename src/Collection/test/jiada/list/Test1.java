package Collection.test.jiada.list;

import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Test1 {
public static void main(String[] args) {
	List list = new ArrayList();
	//ArrayList �ײ�ʵ�����飬�̲߳���ȫ��Ч�ʸߡ����Բ�ѯ�죬����ɾ����
	//LinkedList �ײ�ʵ�������̲߳���ȫ��Ч�ʸߡ����Բ�ѯ��������ɾ����
	//Vector �̰߳�ȫ�ģ�Ч�ʵ͡�
	PriorityQueue<Integer> pq= new PriorityQueue<>();
	Stack<Integer> s= new Stack<>();
	s.isEmpty();
	s.empty();
	Queue<Integer> q= new LinkedList<>();
	
Deque<Integer> dq= new LinkedList<>();

	
	list.add("aaa");
	list.add(123);
	list.add(new Date());
	list.add(new dog());
	
	System.out.println(list.size());
	List list2 = new ArrayList();
	list2.add(new Date());
	list2.add(123);
	list.addAll(list2);
	
	System.out.println("list size"+list.size());
//	System.out.println("list capacity"+a.length);
	System.out.println((int)'A');
}
}
class dog{
	
}
