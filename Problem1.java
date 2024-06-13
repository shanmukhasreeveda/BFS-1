// Time complexity for BFS:  O(n)
// Space complexity for BFS: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Logic: Use a queue to perform a breadth-first search, starting with the root node.
//For each level, process all nodes by dequeuing them, recording their values, and enqueueing their children.
//Append the list of values for each level to the result list and continue until the queue is empty.

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i =0; i< size; i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            result.add(temp);
        }

        return result;
    }
}

// Time complexity for DFS:  O(n)
// Space complexity for DFS: O(h) where h = height
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Logic: Initialize an empty result list and start a DFS from the root at level 0.
//In each DFS call, if the current level equals the result list size, add a new list for that level.
//Add the current node's value to its corresponding level list and recursively process its left and right children with an incremented level.

class Solution {
    List<List<Integer>> result ;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level){
        if(root == null){
            return ;
        }
        if( level == result.size()){
            List<Integer> temp = new ArrayList<>();
            result.add(temp);
        }

        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}
