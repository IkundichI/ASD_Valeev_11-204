import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(10);
        tree.add(5);
        tree.add(12);
        tree.add(234);
        tree.add(2);
        tree.add(6);
        tree.levelOrderTraversal();


    }
    public static class Node {
        int value;
        Node left, right;
        public Node (int value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }

    public static class Tree {
        Node root;
        public Tree() {
            this.root = null;
        }

        public Tree(int value) {
            Node node = new Node(value);
            this.root = node;
        }
        public void add (int value) {
            root = addRec(root, value);
        }

        private Node addRec (Node root, int value) {
            if (root == null) {
                Node newNode = new Node(value);
                return newNode;
            }
            if (root.value > value) {
               root.left = addRec(root.left, value);
            }
            if (root.value < value) {
                root.right = addRec(root.right, value);
            }
            return root;
        }
        public boolean find(int value) {
            return contains(root, value);
        }
        private boolean contains(Node node, int value) {
            if (node == null) {
                return false;
            }
            if (node.value == value) {
                return true;
            } else if (value > node.value) {
                return contains(node.left, value);
            } else if (value < node.value) {
                return contains(node.right, value);
            }
            return false;
        }

        public void levelOrderTraversal() {
            if (root == null) {
                return;
            }
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                System.out.print(node.value + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

    }
}