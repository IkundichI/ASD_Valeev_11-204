public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(10);
        tree.add(10101);
        System.out.println(tree.find(10));

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

    }
}