public class ReverseList {
    public SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        SinglyLinkedListNode curr = llist;
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode temp = null;
        while (curr != null) {
            temp = prev;
            prev = curr;
            curr = curr.next;
            prev.next = temp;
        }
        return prev;
    }
}
