package stack;

import java.util.ArrayList;

public class Stack<Type> {
  private Node<Type> head;
  private int length;

  public Stack() {
    this.head = null;
    this.length = 0;
  }

  public void push(Type info) {
    Node<Type> temp = new Node<>(info);

    if (this.head == null) {
      this.head = temp;
    } else {
      temp.setPrevious(this.head);
      this.head = temp;
    }

    this.length++;
  }

  public Type remove() throws Exception {
    Type removedInfo = null;

    if (this.length == 0) {
      throw new Exception("The stack is already empty.");
    } else {
      removedInfo = this.head.getInfo();

      this.head = this.head.getPrevious();
      this.length--;
    }
    return removedInfo;
  }

  public ArrayList<Type> recursiveRemove() {
    return recursiveRemove(this.head);
  }

  private ArrayList<Type> recursiveRemove(Node<Type> temp) {
    ArrayList<Type> items = new ArrayList<>();

    if (temp != null) {
      items.add(temp.getInfo());

      items.addAll(recursiveRemove(temp.getPrevious()));
    }

    return items;
  }

  public int length() {
    return this.length;
  }

  public Type getFirst() {
    return this.head.getInfo();
  }

  public boolean isEmpty() {
    return this.length == 0 ? true : false;
  }
}
