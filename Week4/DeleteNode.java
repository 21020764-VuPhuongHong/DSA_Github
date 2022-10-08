public class DeleteNode {
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        if (llist != null) {
            if (position > 0) {
                SinglyLinkedListNode p = llist;
                int count = 0;
                while (count < position - 1 && p.next != null) {
                    p = p.next;
                    count++;
                }
                if (p.next.next != null) {
                    p.next = p.next.next;
                }
            } else {
                llist = llist.next;
            }
        }
        return llist;
    }
}
