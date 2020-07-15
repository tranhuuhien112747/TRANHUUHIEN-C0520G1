package javacollection_tree_and_map.exercise.setting_bst;

public class TestBST {
    public static void main(String[] args) {
        BST treeBST=new BST();
        treeBST.insert(60);
        treeBST.insert(55);
        treeBST.insert(100);
        treeBST.insert(45);
        treeBST.insert(57);
        treeBST.insert(67);
        treeBST.insert(107);
        treeBST.insert(59);
        treeBST.insert(101);
        System.out.println("-----------------------inOrder---------------------------");
        treeBST.inOrder(treeBST.root);
        System.out.println();
        System.out.println("Size " + treeBST.getSize());
        System.out.println("------------------------postOrder--------------------------");
        treeBST.postOrder(treeBST.root);
        System.out.println();
        System.out.println("Size " + treeBST.getSize());
        System.out.println("------------------preOder------------------------------------");
        treeBST.preOder(treeBST.root);
        System.out.println();
        System.out.println("Size " + treeBST.getSize());
        System.out.println("-----------------------breath-first-----------------------");
        treeBST.breathfirst(treeBST.root);
        System.out.println();
        System.out.println("Size " + treeBST.getSize());

    }

}
