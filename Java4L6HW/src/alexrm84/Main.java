package alexrm84;

public class Main {

    public static void main(String[] args) {
//        Tree<Integer> tree = new TreeImplement<>();
//        tree.add(60);
//        tree.add(25);
//        tree.add(66);
//        tree.add(15);
//        tree.add(5);
//        tree.add(20);
//        tree.add(45);
//        tree.add(30);
//        tree.add(32);
//        tree.add(55);
//
//        tree.display();
//
//        System.out.println("Find 60: " + tree.find(60));
//        System.out.println("Find 45: " + tree.find(45));
//        System.out.println("Find 32: " + tree.find(32));
//        System.out.println("Find 666: " + tree.find(666));
//
//        tree.remove(15);
//        tree.display();

        int balancedNodes=0;

        for (int i = 0; i < 100; i++) {
            Tree<Integer> tree = new TreeImplement<>();
            for (int j = 0; j < 15; j++) {
                tree.add((int) (Math.random()*200)-100);
            }
            if (isBalanced(((TreeImplement<Integer>) tree).getRootNode())){
                balancedNodes++;
            }
        }
        System.out.println("Percentage of balanced trees: " + balancedNodes + "%");
    }

    public static boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }
}
