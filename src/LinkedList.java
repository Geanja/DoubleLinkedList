import com.sun.jdi.connect.spi.TransportService;

public class LinkedList {
    int head;
    LinkedList tail;

    public LinkedList(int item, LinkedList list) {
        head = item;
        tail = list;
    }

    public int head() {
        return this.head;
    }

    public LinkedList tail() {
        return this.tail;
    }

    public void append(LinkedList b) {
        LinkedList nxt = this;
        b.tail = null;
        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt.tail = b;
    }

    public LinkedList remove(LinkedList b) {
        LinkedList current = this;
        LinkedList temp = null;

        if (current.head == b.head) {
            current = current.tail;
            LinkedList newFirst = new LinkedList(current.head(), null);
            while (current.tail != null) {
                newFirst.append(new LinkedList(current.tail.head(), null));
                current = current.tail;
            }
            return newFirst;
        }

        while (current.tail != null) {
            if (current.tail.head == b.head) {
                temp = current.tail;
                current.tail = current.tail.tail;
                temp.tail = null;

                return this;
            }
            current = current.tail;
        }
        return this;
    }


    @Override
    public String toString() {
        return "LinkedList [head=" + head + "]";
    }
}
