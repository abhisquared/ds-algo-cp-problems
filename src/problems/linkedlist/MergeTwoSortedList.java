package problems.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/800332?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 * https://www.youtube.com/watch?v=Xb4slcp1U38&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=30
 * 
 * */
public class MergeTwoSortedList {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// optimized merge approach used in merge operation in merge sort
	// time complexity O(n)
	// space complexity O(1)
	private static void type2() {
		Node<Integer> list1 = new Node<>(1, 4, 5, 7);
		Node<Integer> list2 = new Node<>(2, 3, 6, 8, 9);

		Node<Integer> head = null, headCopy = null, current = null;
		if (null != list1 && null != list2) {
			while (null != list1 && null != list2) {
				if (list1.data < list2.data) {
					current = list1;
					list1 = list1.next;
				} else {
					current = list2;
					list2 = list2.next;
				}
				if (null == head) {
					headCopy = current;
					head = headCopy;
				} else {
					headCopy.next = current;
					headCopy = headCopy.next;
				}
			}
			headCopy.next = null != list1 ? list1 : list2;
		} else if (null == list1) {
			head = list2;
		} else if (null == list2) {
			head = list1;
		}
		System.out.println(head);
	}

	// brute force approach
	// putting all items in list O(n1+n2)
	// sorting the list O((n1+n2)*log(n1+n2))
	// creating the the linked list with all the items
	// time complexity O(n1+n2)+O((n1+n2)*log(n1+n2))+O(n1+n2)
	// space complexity O(2*(n1+n2)) for list+linked list
	private static void type1() {
		Node<Integer> list1 = new Node<>(1, 4, 5, 7);
		Node<Integer> list2 = new Node<>(2, 3, 6, 8, 9);
		Node<Integer> list1Copy = list1, list2Copy = list2, head = null, headCopy = null;
		List<Integer> list = new ArrayList<>();
		while (null != list1Copy) {
			list.add(list1Copy.data);
			list1Copy = list1Copy.next;
		}
		while (null != list2Copy) {
			list.add(list2Copy.data);
			list2Copy = list2Copy.next;
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			if (null == head) {
				headCopy = new Node<Integer>(list.get(i));
				head = headCopy;
			} else {
				headCopy.next = new Node<Integer>(list.get(i));
				headCopy = headCopy.next;
			}
		}
		System.out.println(head);
	}

}