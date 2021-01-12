package com.chen.group.tree.traversal;

import com.chen.model.TreeNode;

public class SumRootOfLeafNums {
    public int sumNumbers(TreeNode root) {
            
        return sumNumbers(root,0);
    }

    public int sumNumbers(TreeNode root,int preSum) {
        if(root == null ){
            return 0;
        }
        if(root.left == null && root.right == null) {
            return preSum * 10 + root.val;
        }
        return sumNumbers(root.left,preSum * 10 + root.val) + sumNumbers(root.right,preSum * 10 + root.val);
    }
}
