package problems.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class StartingNodeOfCycle {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// enhanced tortoise method for finding linked list cycle approach
	// we will take two pointer slow and fast
	// and move them by one and two to find collision
	// let say slow and fast pointer moves c+ml+x and c+nl+x
	// where c is common distance, m and n is rotation taken before collision
	// l is the cycle length
	// x is collision distance from starting point of cycle
	// and let's say slow pointer goes d distance before collision
	// then fast pointer will be going 2d distance before collision
	// 2d-d = (c+nl+x) - (c+ml+x) => d = l*(n-m)
	// so d is multiple of cycle length
	// l*(n-m) = c+ml+x => c+x = l*(n-2m)
	// so c+x is also multiple of cycle length
	// that means after collision point if we go to x distance
	// then we will obviously get the starting of the cycle
	// which is also the duplicate number
	// time complexity of this more than O(n)
	// as it may rotate some cycles
	private static void type2() {
		Node<Integer> head = new Node<>(1, 2).cycle(new Node<>(10, 11), new Node<>(15, 30, 45));
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		while (null != fast && null != fast.next) {
			if (fast.next.next == null) {
				// no cycle is present
				// early break to reduce extra computation
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
			// we have found the collision
			if (slow == fast) {
				break;
			}
		}
		// again we will traverse from start
		// and slow pointer will also go as it is
		// and we know that after x distance start and slow pointer will collide
		Node<Integer> start = head;
		while (start != slow) {
			start = start.next;
			slow = slow.next;
		}
		System.out.println("starting node : " + start.data);
	}

	// brute force approach
	// time complexity o(n)
	// space complexity o(n)
	private static void type1() {
		Node<Integer> head = new Node<>(1, 2).cycle(new Node<>(10, 11), new Node<>(15, 30, 45));
		Set<Node<Integer>> set = new HashSet<>();
		while (null != head) {
			if (!set.contains(head)) {
				set.add(head);
				head = head.next;
			} else {
				break;
			}
		}
		System.out.println("starting node : " + head.data);
	}

}