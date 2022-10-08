public class InsertHead {
    public SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        if (llist != null) {
            SinglyLinkedListNode oldHead = llist;
            llist = new SinglyLinkedListNode(data);
            llist.next = oldHead;
        } else {
            llist = new SinglyLinkedListNode(data);
        }
        return llist;
    }
}
