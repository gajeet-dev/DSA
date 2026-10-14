import java.util.PriorityQueue;

class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pQueue = new PriorityQueue<>(
        (a, b) -> Integer.compare(a.val, b.val));

    for (ListNode node : lists) {
      if (node != null) {
        pQueue.add(node);
      }
    }

    ListNode dummy = new ListNode(0, null);
    ListNode curr = dummy;

    while (!pQueue.isEmpty()) {
      ListNode node = pQueue.poll();

      if (node.next != null) {
        pQueue.add(node.next);
      }

      curr.next = node;
      curr = curr.next;
    }

    return dummy.next;
  }
}
