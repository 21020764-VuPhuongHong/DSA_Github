public class CompareTwoLists {
    public boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode p1 = head1;
        SinglyLinkedListNode p2 = head2;
        while (p1.next != null && p2.next != null) {
            if (p1.data != p2.data) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1.next != null || p2.next != null) {
            return false;
        }
        return true;
    }
}
