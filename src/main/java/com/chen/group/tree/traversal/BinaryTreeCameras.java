package com.chen.group.tree.traversal;

import com.chen.model.TreeNode;

public class BinaryTreeCameras {
    int res = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = traversal(root);
        if (result == 0) {
            res++;
        }
        return res;
    }

    private int traversal(TreeNode root) {
        if (root == null)
            return 2;
        int left = traversal(root.left), right = traversal(root.right);
        // 如果左右子节点有一个是NO_CAMERA，表示的是子节点既没相机，也没相机覆盖它，
        // 所以当前节点需要有一个相机
        if (left == 0 || right == 0) {
            // 在当前节点放一个相机，统计相机的个数
            res++;
            return 1;
        }
        // 如果左右子节点只要有一个有相机，那么当前节点就不需要相机了，否则返回一个没有相机的标记
        return left == 1 || right == 1 ? 2 : 0;

    }
}
