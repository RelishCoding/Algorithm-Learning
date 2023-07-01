public class T707_twoWayLinkedList {
    //虚拟头结点
    private Node dummyHead;
    //尾结点
    private Node last;
    //链表元素的个数
    private int size;

    //结点类
    private class Node{
        private int val;
        private Node next;
        private Node pre;

        public Node(int val, Node next, Node pre) {
            this.val = val;
            this.next = next;
            this.pre = pre;
        }

        public Node(Node next, Node pre) {
            this.next = next;
            this.pre = pre;
        }
    }

    //初始化链表
    public T707_twoWayLinkedList() {
        this.dummyHead=new Node(null,null);
        this.last=dummyHead;//方便链表为空且尾插时使用
        this.size=0;
    }

    //获取第index个节点数值，注意index是从0开始的，第0个节点就是头结点
    public int get(int index) {
        //如果index是非法数值直接返回-1
        if (index<0 || index>size-1){
            return -1;
        }

        Node cur = findPreNode(index).next;
        return cur.val;
    }

    //在链表最前面插入一个节点，插入完成后，新插入的节点为链表的新的头结点
    //在链表最前面插入一个节点，等价于在第0个元素前添加
    public void addAtHead(int val) {
        //addAtIndex(0,val);
        Node newNode = new Node(val, dummyHead.next,dummyHead);
        //如果链表为空
        if (dummyHead.next==null){
            last=newNode;
        }else {
            dummyHead.next.pre=newNode;
        }
        dummyHead.next=newNode;
        size++;
    }

    //在链表最后面添加一个节点
    //在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加
    public void addAtTail(int val) {
        //addAtIndex(size,val);
        Node newNode = new Node(val, null,last);
        last.next=newNode;
        last=newNode;
        size++;
    }

    // 在第index个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果index等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果index大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if (index>size || index<0){
            return;
        }

        Node cur = findPreNode(index);

        Node newNode = new Node(val, cur.next,cur);
        //若为空链表，传入的参数index只能为0，即必定为头插
        if (dummyHead.next==null || index==size){
            last=newNode;
        }else {
            cur.next.pre=newNode;//头插和尾插时无法执行
        }
        cur.next=newNode;
        size++;
    }

    // 删除第index个节点，注意index是从0开始的
    public void deleteAtIndex(int index) {
        //如果index大于等于链表的长度，直接return
        if (index>size-1 || index<0){
            return;
        }

        Node cur = findPreNode(index);

        //如果删除的不是尾结点
        if (cur.next.next!=null){
            cur.next.next.pre=cur;
        }else {
            last=cur;
        }
        cur.next=cur.next.next;
        size--;
    }

    //添加操作和删除操作都需要找到目标结点的前一个结点，故将找前一个结点的方法抽取出来
    private Node findPreNode(int index){
        Node cur = dummyHead;
        //判断从前往后遍历和从后往前遍历哪个时间更短
        if (index-1>=size/2){
            cur=last;
            for (int i = 0; i < size-index; i++) {
                cur=cur.pre;
            }
        }else {
            while(index>0){
                cur=cur.next;
                index--;
            }
        }
        return cur;
    }
}
