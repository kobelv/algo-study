package com.kobe.tree;

import java.util.*;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 */
public class LeetCode236_LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        TreeNode tmp9 = new TreeNode(9);
        root.left = tmp9;

        TreeNode tmp = new TreeNode(20);
        root.right = tmp;

        tmp = new TreeNode(15);
        root.right.left = tmp;

        TreeNode tmp7 = new TreeNode(7);
        root.right.right = tmp7;

        LeetCode236_LowestCommonAncestor l = new LeetCode236_LowestCommonAncestor();
        System.out.println(l.lowestCommonAncestor(root, tmp9, tmp7).data);
    }

    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        return find(p, q);
    }

    private void dfs(TreeNode node){
        if (node.left != null){
            map.put(node.left.data, node);
            dfs(node.left);
        }
        if (node.right != null){
            map.put(node.right.data, node);
            dfs(node.right);
        }
    }

    private TreeNode find(TreeNode p, TreeNode q){
        while (p != null){
            set.add(p.data);
            p = map.get(p.data);
        }
        while (q != null){
            if (set.contains(q.data)){
                return q;
            }
            q = map.get(q.data);
        }

        return null;
    }
}
