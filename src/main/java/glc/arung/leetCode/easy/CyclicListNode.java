package glc.arung.leetCode.easy;

class ListNode{
    int val;
    ListNode next;

    ListNode(int x){
        val = x;
        next = null;
    }

}

public class CyclicListNode {

    public boolean hasCycle(ListNode head) {
        if ( head == null || head.next == null )
            return false;
        // we already checked head and slowItr are not null
        ListNode slowItr = head.next;
        ListNode fastItr = slowItr.next; 
        boolean result = false;
        while ( fastItr == null ) {
            // check slowItr == fastItr
            if ( slowItr == fastItr ) {
                result = true;
                break;
            }
            
            slowItr = slowItr.next; 
            if( slowItr == null || fastItr.next == null )
                break; // default value is already false;
            
            fastItr = fastItr.next.next; // fastItr is always twice the previous value    
        }

        return result;
    }

    public static void main(String[] args) {
        CyclicListNode c = new CyclicListNode();

        ListNode head = new ListNode(3);
        ListNode next = new ListNode(2);
        head.next = next;
        next.next = new ListNode(0);
        next.next.next = head;
        System.out.println( true == c.hasCycle(head) );
    }
}