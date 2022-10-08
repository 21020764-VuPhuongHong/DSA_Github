public class MergeLists {
    public SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode temp1 = head1;
        SinglyLinkedListNode temp2 = head2;
        SinglyLinkedListNode newNode  = null;
        SinglyLinkedListNode newHead = null;

        while (temp1 != null && temp2 != null) {
            if (temp1.data < temp2.data) {
                if (newNode == null) {
                    newNode = temp1;
                    newHead = newNode;
                } else {
                    newNode.next = temp1;
                    newNode = newNode.next;
                }
                temp1 = temp1.next;
            } else {
                if (newNode == null) {
                    newNode = temp2;
                    newHead = newNode;
                } else {
                    newNode.next = temp2;
                    newNode = newNode.next;
                }
                temp2 = temp2.next;
            }
        }

        while (temp1 != null) {
            newNode.next = temp1;
            newNode = newNode.next;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            newNode.next = temp2;
            newNode = newNode.next;
            temp2 = temp2.next;
        }
        return newHead;
    }
}
