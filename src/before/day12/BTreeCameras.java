package before.day12;

import util.TreeNode;

public class BTreeCameras {
	public static void main(String[] args) {
		BTreeCameras bTreeCameras=new BTreeCameras();
		TreeNode rNode=new TreeNode(0).getTestData();
		System.out.println(bTreeCameras.minCameraCover(rNode));
	}
	private int res = 0;

	public int minCameraCover(TreeNode rNode) {
		
		if (lrt(rNode)==0) {
			res++;
		}
		return res;
	}

	/**
	 * 明确状态：
	 * 
	 * 0：这个结点未被监控到
	 * 
	 * 1：这个结点被监控了
	 * 
	 * 2：这个结点安装了相机
	 * 
	 * @author Rondo
	 * @date 2020年9月22日 上午7:56:52
	 * @param root
	 * @return
	 */
	private int lrt(TreeNode root) {
		if (root == null) { // 不等于 0 就好
			return 1;
		}
		int left = lrt(root.left);
		int right = lrt(root.right);
		if (left == 0 || right == 0) { // 如果某个结点的左孩子或右孩子未被监控，则该结点未被监控，则需要给该结点安装相机
			res++;
			return 2;
		}
		if (left == 1 && right == 1) { // 如果左右孩子都已经被监控，但是未安装相机，所以该结点是未被监控的
			return 0;
		}
		return 1; // 其余情况
	}
}
