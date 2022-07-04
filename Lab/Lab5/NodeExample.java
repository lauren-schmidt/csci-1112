Class NodeExample {
    Int data;
    String name;
    Boolean on;
    Node next;

    public Node(int d, String n, boolean b) {
        data = d;
        name = name;
        on = b;
    }

    public getName() {
        return this.name;
    }

    public getData() {
        return this.data;
    }

    public getStatus() {
        return this.on;
    }

    public getNext() {
        return this.next;
    }

    public setNext(Node n) {
        this.next = n;
    }
    
}
