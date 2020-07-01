package com.spdb.study.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.Longyx
 * @date 2020年06月16日 13:00
 */
public class BuildTreeCase {
    Map<Integer,Integer> map = new HashMap<>();
    int[] preOrder;

    public TreeNode buildTree(int[] preOrder,int[] inOrder){
        this.preOrder = preOrder;
        for (int i=0;i<preOrder.length;i++) {
            map.put(inOrder[i],i);
        }
        return recursive(0,0,inOrder.length-1);
    }

    private TreeNode recursive(int pre_root_idx, int in_left_idx, int in_right_idx) {
        if (in_left_idx < in_right_idx){
            return  null;
        }
        //从前序遍历中获取根节点
        TreeNode root = new TreeNode(preOrder[pre_root_idx]);
        //从中序遍历中获取根节点索引
        int index = map.get(preOrder[pre_root_idx]);
        root.left = recursive(pre_root_idx,in_left_idx,index-1);
        root.right = recursive(pre_root_idx+(index-1-in_left_idx+1)+1,index+1,in_right_idx);

        return root;
    }
}
