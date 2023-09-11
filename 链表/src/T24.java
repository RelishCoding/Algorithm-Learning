public class T24 {
    //非递归版本
    /*public ListNode swapPairs(ListNode head) {
        // 设置一个虚拟头结点
        ListNode dummyHead = new ListNode();
        // 将虚拟头结点指向head，这样方面后面做删除操作
        dummyHead.next = head;
        ListNode cur = dummyHead;

        while (cur.next!=null && cur.next.next!=null){
            ListNode tmp = cur.next;//记录临时节点，保存两个节点之中的第一个节点
            ListNode tmp1 = cur.next.next.next;//记录临时节点，保存两个节点后面的节点

            cur.next = cur.next.next;
            cur.next.next = tmp;
            cur.next.next.next = tmp1;

            //cur移动两位，准备下一轮交换
            cur = cur.next.next;
        }
        return dummyHead.next;
    }*/

    //递归版本
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        // 获取当前节点的下一个节点
        ListNode nextNode = head.next;
        // 进行递归
        ListNode newNode = swapPairs(nextNode.next);

        // 交换节点
        nextNode.next = head;
        head.next = newNode;

        return nextNode;
    }

    private class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
