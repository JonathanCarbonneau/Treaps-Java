/*
Jonathan Carbonneau
I pledge my honor that I have abided by the Stevens Honor System.
 */
import java.util.Random;

public class Treap < E extends Comparable < E >> {
  private Random priorityGenerator;
  private Node < E > root;

  // A Treap Node
  private static class Node < E > {
    public E data;
    public int priority;
    public Node < E > left;
    public Node < E > right;
    //Node constructor
    Node(E data, int priority){
      if (data == null) throw new IllegalArgumentException("Data is null");
      this.data = data;
      this.priority = priority;
      this.left = this.right = null;
    }
    //toString
    public String toString() {
      return "(" + "key=" + this.data + ", " + "priority =" + this.priority + ")";
    }
    //rotateLeft
    public Node < E > rotateLeft() {
      Node < E > childRight = this.right;
      Node < E > childRightLeft = this.right.left;
      childRight.left = this;
      this.right = childRightLeft;
      return childRight;
    }
    //rotateRight
    public Node < E > rotateRight() {
      Node < E > childLeft = this.left;
      Node < E > childLeftRight = this.left.right;
      childLeft.right = this;
      this.left = childLeftRight;
      return childLeft;
    }

  }
  //Treap constructor
  public Treap() {
    this.priorityGenerator = new Random();
    this.root = null;
  }
  //Treap constructor with seed
  public Treap(long seed) {
    this.priorityGenerator = new Random(seed);
    this.root = null;
  }
  //add without priority
  public Boolean add(E key) {
    return add(key, priorityGenerator.nextInt());
  }
  //add with priority
  public Boolean add(E key, int priority) {
    if (find(key)) {
      return false;
    } else if (this.root == null) {
      this.root = new Node < E > (key, priority);
    } else {
      this.root = addHelper(this.root, key, priority);
    }
    return true;
  }
  //addHelper inserts nodes into a tree should not be called by anything but add.
  private Node < E > addHelper(Node < E > node, final E key, final int priority) {
    if (node == null) {
      return new Node < E > (key, priority);
    }
    if (key.compareTo(node.data) < 0) {
      node.left = addHelper(node.left, key, priority);
      if (node.left != null && node.left.priority > node.priority) {
        node = node.rotateRight();
      }
    } else {
      node.right = addHelper(node.right, key, priority);
      if (node.right != null && node.right.priority > node.priority) {
        node = node.rotateLeft();
      }
    }
    return node;
  }
  //find key only
  public boolean find(E key) {
    return find(root, key);
  }
  //find root node 
  public boolean find(Node < E > root, E key) {
    if (root == null) {
      return false;
    } else if (root.data.equals(key)) {
      return true;
    } else if (key.compareTo(root.data) < 0) {
      return find(root.left, key);
    }
    return find(root.right, key);
  }
  //delete
  boolean delete(E key) {
    if (!find(key)) return false;
    this.root = deleteHelper(root, key);
    return true;
  }
  //delete helper
  private Node < E > deleteHelper(Node < E > node, E key) {
    if (node == null) {
      return null;
    } else if (key.compareTo(node.data) < 0) {
      node.left = deleteHelper(node.left, key);
    } else if (key.compareTo(node.data) > 0) {
      node.right = deleteHelper(node.right, key);
    } else if (node.left == null) {
      Node < E > tmpNode = node.right;
      node = null;
      node = tmpNode;
    } else if (node.right == null) {
      Node < E > tmpNode = node.left;
      node = null;
      node = tmpNode;
    } else if (node.left.priority < node.right.priority) {
      node = node.rotateLeft();
      node.left = deleteHelper(node.left, key);
    } else {
      node = node.rotateRight();
      node.right = deleteHelper(node.right, key);
    }
    return node;
  }
  //ToString
  public String toString() {
    return toString(root, 0);
  }
  //ToString with node
  private String toString(Node < E > current, int level) {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < level; i++) {
      s.append(" ");
    }
    if (current == null) {
      s.append("null\n");
    } else {
      s.append(current.toString() + "\n");
      s.append(toString(current.left, level + 1));
      s.append(toString(current.right, level + 1));
    }
    return s.toString();
  }

  public static void main(String[] args) {

    // construct a treap
//    Treap < Integer > testTree = new Treap < Integer > ();
//
//    testTree.add(4, 19);
//    testTree.add(2, 31);
//    testTree.add(6, 70);
//    testTree.add(1, 84);
//    testTree.add(3, 12);
//    testTree.add(5, 83);
//    testTree.add(7, 26);
//    testTree.delete(6);
//    System.out.println(testTree.find(5));
//    System.out.println(testTree.toString());

  }
}