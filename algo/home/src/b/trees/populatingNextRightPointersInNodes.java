package b.trees;

import java.util.LinkedList;
import java.util.Queue;

public class populatingNextRightPointersInNodes {

        class Node {
            Long val;
            Node left;
            Node right;
            Node next;

            Node(Long x) {
                this.val = x;
            }
        }


        // APPROACH 1: Level Order Traversal
        // 2 types of traversals on a tree or graph
        // Depth First Search - One branch at a time
        // Breadth First Search - we explore a level before moving onto the next
        // For DFS - we have preorder, inorder and post order traversals
        // BFS is based on the level of the node (i.e. the distance from root node)

        // This problem is a BFS kind of problem. BFS gives us access to what we are looking for

        // APPROACH 1: ALGORITHM
        // STEP 1: We need to initialise a Queue (FIFO) - First In, First Out Data structure

        // there are multiple ways to implement level order traversal (e.g. use a Queue)
        // We can use a nested loop structure. This helps us to avoid a null pointer.
        // At every step, we record the size of the queue, this will be equal to size of the nodes on a particular level
        // this is because we need to process this exact number of elements and nothing more. i.e. if we process
        // all the nodes with this size, the queue will contain all the nodes on the next level

        //         while (!Q.empty())
        //            {
        //                size = Q.size()
        //                for i in range 0..size
        //                {
        //                    node = Q.pop()
        //                    Q.push(node.left)
        //                    Q.push(node.right)
        //                }
        //            }

        // STEP 2: We add the root in the queue, since there is just one node on level zero, there are no
        // connections, we move to the while loop

        // STEP 3: In the while loop, we go through each level one after another. The inner for loop goes through all the
        // nodes on that particular level. Because we have access to all the nodes on the same level, it's easy to set the
        // next pointers

        // STEP 4: When we pop a node inside the for-loop, we add the children at the back of the queue. The element at the head/front
        // of the queue is the next element in order on the current level. We can establish new pointers this way.


        public Node connect(Node root) {


            if (root == null) {
                return null;
            }

            // Initialise queue with root of the tree
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            // loop to iterate over the levels
            while (queue.size() > 0) {

                // note the size of the queue
                int size = queue.size();

                // we go through all the nodes on the current level
                for(int i = 0; i < size; i++){

                    // we pop a node from the front of the queue
                    // the first poll removes the node on level 1
                    // we get a reference to the node in front of the queue
                    Node node = queue.poll();

                    // the queue will contain nodes from 2 levels at most at any point in time.
                    // This check is important because we do not want to add next pointers outside the end of the current level
                    if (i < size - 1) {

                        // because we have removed the first node in the front of the queue
                        // the next node in the front of the queue can be retrieved with queue.peek()
                        node.next = queue.peek();
                    }

                    // add the children to the back of the queue
                    // if there are children
                    if (node.left != null) {
                        queue.add(node.left);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    }

                }



            }

            // we return the modified root
            return root;


            // Time complexity: O(N) We process each node exactly once. both popping and adding next pointers

            // Space complexity: O(N) It is a perfect binary tree. It is O (N)
            // last level contains N/2 nodes. space complexity for BFS is the space occupied by the queue.
            // This depends on the number of nodes on a particular level
        }

}
