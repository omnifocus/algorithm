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
public class c32 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }




    }



    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        if (lists == null){
            return null;
        }
        for (int i=0 ; i<lists.length;i++) {
            //要判断，否则直接add报错
            if (lists[i] != null)
                pq.add(lists[i]);
        }

        ListNode head = pq.poll();
        if (head == null)
            return null;
        ListNode pre = head;
        if (pre.next != null) {
            pq.add(pre.next);
        }
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            if (cur.next != null){
                pq.add(cur.next);
            }
            pre.next = cur;
            pre = pre.next;
        }

        return head;

    }
}
