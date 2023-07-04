public class T203 {
    //直接使用原来的链表来进行删除操作
    /*public ListNode removeElements(ListNode head, int val) {
        // 删除头结点
        // 注意这里要用while而不能用if
        // 因为可能连着几个结点的值都为val
        // 循环条件写head！=null是因为：
        // 1.可能传进来的是空链表
        // 2.可能链表中全部结点的值都为val，删除完后head为null，再访问head.val会报错
        while ( head!=null && head.val==val){
            head=head.next;
        }

        // 删除非头结点
        ListNode cur=head;
        while (cur!=null && cur.next!=null){
            if (cur.next.val==val){
                cur.next=cur.next.next;
            }else {
                cur=cur.next;
            }
        }
        return head;
    }*/

    //设置一个虚拟头结点再进行删除操作
    public ListNode removeElements(ListNode head, int val) {
        if (head==null)
            return head;
        // 设置一个虚拟头结点
        ListNode dummyHead = new ListNode();
        // 将虚拟头结点指向head，这样方面后面做删除操作
        dummyHead.next=head;
        ListNode cur = dummyHead;
        while (cur.next!=null){
            if (cur.next.val==val)
                cur.next=cur.next.next;
            else
                cur=cur.next;
        }
        return dummyHead.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

