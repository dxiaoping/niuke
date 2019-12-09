package jianzhioffer;

/**
 * @Description 寻找节点的下一个节点
 * @auther DuanXiaoping
 * @create 2019-10-14 14:48
 */
public class GetNext {
    /**
     * 1.空节点
     * 2.右节点不为空
     * 3.节点为父节点的左节点没有右节点
     * 4.节点为父节点的右节点没有右节点
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode moveNode = null;
        if (pNode == null){
            return null;
        }
        //右节点不为空
        if(pNode.right != null){
            moveNode = pNode.right;
            while (moveNode.left != null){
                moveNode = moveNode.left;
            }
            return moveNode;
        }
        //节点为父节点的左节点，没有右节点
        if (pNode.next != null && pNode.next.left == pNode){
            return pNode.next;
        }

        //节点在父节点右边且没有右节点
        if (pNode.next != null && pNode.next.right == pNode){
            moveNode = pNode.next;
            while (moveNode.next != null && moveNode.next.right == moveNode){
                moveNode=moveNode.next;
            }

            return moveNode.next;

        }
        return moveNode;
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}