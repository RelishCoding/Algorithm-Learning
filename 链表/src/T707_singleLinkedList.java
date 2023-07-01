public class T707_singleLinkedList {
    //虚拟头结点
    private Node dummyHead;
    //链表元素的个数
    private int size;

    //结点类
    private class Node{
        private int val;
        private Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(Node next) {
            this.next = next;
        }
    }

    //初始化链表
    public T707_singleLinkedList() {
        this.dummyHead=new Node(null);
        this.size=0;
    }

    //获取第index个节点数值，注意index是从0开始的，第0个节点就是头结点
    public int get(int index) {
        //如果index是非法数值直接返回-1
        if (index<0 || index>size-1){
            return -1;
        }

        Node cur = dummyHead.next;
        while(index>0){
            cur=cur.next;
            index--;
        }
        return cur.val;
    }

    //在链表最前面插入一个节点，插入完成后，新插入的节点为链表的新的头结点
    //在链表最前面插入一个节点，等价于在第0个元素前添加
    public void addAtHead(int val) {
        //addAtIndex(0,val);
        Node newNode = new Node(val, dummyHead.next);
        dummyHead.next=newNode;
        size++;
    }

    //在链表最后面添加一个节点
    //在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加
    public void addAtTail(int val) {
        //addAtIndex(size,val);
        Node cur = dummyHead;
        while (cur.next!=null){
            cur=cur.next;
        }
        Node newNode = new Node(val, null);
        cur.next=newNode;
        size++;
    }

    // 在第index个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果index等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果index大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if (index>size || index<0){
            return;
        }

        Node cur = dummyHead;
        while (index>0){
            cur = cur.next;
            index--;
        }
        Node newNode = new Node(val, cur.next);
        cur.next=newNode;
        size++;
    }

    // 删除第index个节点，如果index大于等于链表的长度，直接return
    // 注意index是从0开始的
    public void deleteAtIndex(int index) {
        if (index>size-1 || index<0){
            return;
        }

        Node cur = dummyHead;
        while (index>0){
            cur=cur.next;
            index--;
        }
        cur.next=cur.next.next;
        size--;
    }
}
