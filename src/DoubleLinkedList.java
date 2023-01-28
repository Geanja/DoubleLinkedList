public class DoubleLinkedList {
    int head;
    DoubleLinkedList prev;
    DoubleLinkedList next;

    public DoubleLinkedList(int item, DoubleLinkedList prev, DoubleLinkedList next) {
        head = item;
        this.prev = prev;
        this.next = next;
    }

    public int head() {
        return this.head;
    }

    public DoubleLinkedList prev() {
        return this.prev;
    }

    public void setPrev(DoubleLinkedList prev) {
        this.prev = prev;
    }

    public DoubleLinkedList next() {
        return this.next;
    }

    public void append(DoubleLinkedList newNode) {
        DoubleLinkedList current = this;
        newNode.next = null;
        newNode.prev = null;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public void removeNumber(int itemToRemove) {
        DoubleLinkedList current = this;
        while (current.next != null) {
            if (current.head == itemToRemove) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            current = current.next;
        }
        if (current.head == itemToRemove){
            current.prev.next = null;
        }
    }

    public DoubleLinkedList removeObject (DoubleLinkedList b){
        if (b.prev == null){
            b.next.prev = null;
            DoubleLinkedList newFirstDouble = b.next;
            b.next = null;
            return newFirstDouble;
        }
        else if (b.next == null){
            b.prev.next = null;
            b.prev = null;
            return this;
        }
        else{
            b.prev.next = b.next;
            b.next.prev = b.prev;
            b.next = null;
            b.prev = null;
            return this;
        }

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoubleLinkedList current = this;
        while (current.next != null) {
            if (current.next !=null && current.prev != null)
                sb.append("middle node [head=" + current.head + ", prev=" + current.prev + ", next=" + current.next + "]");
            if (current.prev == null)
                sb.append("First node [head = " + current.head + ", prev=" + current.prev + ", next=" + current.next + "]");
            else if (current.next == null)
                sb.append("last node [head = " + current.head + ", prev=" + current.prev + ", next=" + current.next + "]");
            current = current.next;
        }


        return sb.toString();
    }



}

