package stack;

public class Node<Type> {
    private Type info;
    private Node<Type> previous;

    public Node(Type info) {
        this.info = info;
        this.previous = null;
    }

    public Type getInfo() {
        return info;
    }

    public void setInfo(Type info) {
        this.info = info;
    }

    public Node<Type> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<Type> previous) {
        this.previous = previous;
    }
}