package javacollection_tree_and_map.exercise.setting_bst;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>> {
    TreeNode<E> root;
    private int size;

    public int getSize() {
        return size;
    }

    TreeNode<E> crearNewNode(E e) {
        return new TreeNode<>(e);
    }

    public void insert(E e) {
        if (this.root == null) {
            root = crearNewNode(e);
        } else {
            TreeNode<E> rootTemp = root;
            TreeNode<E> parent = null;
            while (rootTemp != null) {
                if (e.compareTo((E) rootTemp.element) > 0) {
                    parent = rootTemp;
                    rootTemp = rootTemp.right;
                } else if (e.compareTo((E) rootTemp.element) < 0) {
                    parent = rootTemp;
                    rootTemp = rootTemp.left;
                } else {
                    return;
                }

            }
            if (e.compareTo((E) parent.element) > 0) {
                parent.right = crearNewNode(e);
            } else {
                //nguoc lai
                parent.left = crearNewNode(e);
            }

        }
        size++;
    }


    //left--->root--->right
    public void inOrder(TreeNode<E> root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print("->" + root.element);
            inOrder(root.right);
        }
    }

    /**
     * [Optional] [Bài tập] Cài đặt thao tác duyệt theo thứ tự postorder trong Binary Search Tree.
     */
    // left--->right--->root
    public void postOrder(TreeNode<E> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print("->" + root.element);
        }
    }

    /**
     * [Optional] [Bài tập] Cài đặt thao tác duyệt theo thứ tự preorder trong Binary Search Tree.
     */
    // root--->left--->right
    public void preOder(TreeNode<E> root) {
        if (root != null) {
            System.out.print("->" + root.element);
            preOder(root.left);
            preOder(root.right);
        }
    }

    //by lever 1-->2-->3......
    public void breathfirst(TreeNode<E> root) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                System.out.print("->" + current.element);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
    }

    /**
     * [Optional] [Bài tập] Cài đặt thao tác tìm kiếm trong Binary Search Tree.
     */
    public boolean searchBST(E data) {
        boolean hasNode = false;
        TreeNode<E> current = root;
        while (current != null) {
            if (data.compareTo(current.element) == 0) {
                hasNode = true;
                break;
            } else if (data.compareTo(current.element) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return hasNode;
    }

    /**
     * [Optional] [Bài tập] Cài đặt thao tác xoá trong Binary Search Tree.
     */
    public void deleteBST(E number) {
        

    }
}
