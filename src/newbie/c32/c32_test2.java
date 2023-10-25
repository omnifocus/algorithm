package newbie.c32;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class c32_test2 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }




    }


    public static void main(String[] args) {
       String str = "^sfs!sdf." ;
        System.out.println(str.replaceAll("\\p{P}","A"));
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i=0;i<lists.length;i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }

        ListNode head = queue.poll();

        ListNode next = head;

        if (head.next != null) {
            queue.add(head.next);
        }

        while (!queue.isEmpty()) {
           ListNode cur = queue.poll();
           if (cur.next != null) {
               queue.add(cur.next);
           }
           next.next = cur;
           next = next.next;
        }


        return head;
    }

}
