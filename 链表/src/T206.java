import java.util.List;
import java.util.Stack;

public class T206 {
    //方法一：双指针法
    /*public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode tmp;//保存cur的下一个节点
        while (cur!=null){
            //保存一下 cur的下一个节点，因为接下来要改变cur->next
            tmp = cur.next;
            cur.next = pre;//翻转操作
            //更新pre和cur指针
            pre = cur;
            cur = tmp;
        }
        return pre;
    }*/

    //方法二：递归法,从前向后递归
    /*public ListNode reverseList(ListNode head) {
        //和双指针法初始化是一样的逻辑
        //ListNode cur = head;
        //ListNode pre = NULL;
        return reverse(head,null);
    }
    private ListNode reverse(ListNode cur,ListNode pre){
        if (cur==null){
            return pre;
        }
        ListNode tmp = cur.next;
        cur.next = pre;
        //可以和双指针法的代码进行对比，如下递归的写法，其实就是做了这两步
        //pre = cur;
        //cur = temp;
        return reverse(tmp,cur);
    }*/

    //方法三：递归法，从后向前递归
    /*public ListNode reverseList(ListNode head) {
        // 边缘条件判断
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        //递归调用，翻转第二个节点开始往后的链表
        ListNode newHead = reverseList(head.next);
        // 翻转头节点与第二个节点的指向
        head.next.next = head;
        //此时的head节点为尾节点，next需要指向null
        head.next = null;
        return newHead;
    }*/

    //方法四：迭代方法：增加虚头结点，使用头插法实现链表翻转（不需要栈）
    /*public ListNode reverseList(ListNode head) {
        // 创建虚拟头结点
        ListNode dummyHead = new ListNode();
        dummyHead.next = null;
        // 遍历所有节点
        ListNode cur = head;
        ListNode tmp;
        while (cur!=null){
            //头插法
            tmp = cur.next;
            cur.next = dummyHead.next;
            dummyHead.next = cur;
            cur = tmp;
        }
        return dummyHead.next;
    }*/

    //方法五：使用栈解决反转链表的问题
    public ListNode reverseList(ListNode head) {
        // 如果链表为空，则返回空
        if (head==null){
            return null;
        }
        // 如果链表中只有只有一个元素，则直接返回
        if (head.next==null){
            return head;
        }
        // 创建栈,每一个结点都入栈
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }

        //创建一个虚拟头结点
        ListNode dummyHead = new ListNode();
        cur = dummyHead;
        while (!stack.isEmpty()){
            ListNode node = stack.pop();
            cur.next = node;
            cur = cur.next;
        }
        //最后一个元素的next要赋值为空
        cur.next = null;
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
