package string.medium.longest_absolute_file_path;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 388. 文件的最长绝对路径
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 388. 文件的最长绝对路径
 * @since 2022/4/20
 */
public class Solutions {
    public int lengthLongestPath(String input) {
        input += "\n";
        int len = input.length();
        StringBuilder sb = new StringBuilder();
        int htCount = 0;
        FileNode root = new FileNode(), p = root, cur = p;
        boolean isFile = false;
        // 1. \n:       same level with p
        // 2. \n(\t)*i:     (i + 1) level
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if (c == 9) {
                // counts of \t, to get level
                htCount++;

            } else if (c == 10) {
                // find direct parent
                while (p.level > htCount) {
                    p = p.p;
                }
                // current FileNode
                cur = new FileNode(p, sb.length(), htCount + 1, isFile);
                // adding to children list
                p.children.add(cur);
                sb.delete(0, sb.length());
                if (!isFile) {
                    p = cur;
                }
                // reset
                htCount = 0;
                isFile = false;
            } else {
                sb.append(c);
                if (c == '.') {
                    isFile = true;
                }
            }
        }
        dfs(root, 0);
        dfs(root);
        System.out.println(ans);
//        int len=0;
//        for (StringBuilder )
        int max = 0;
        for (Integer i : ans) {
            max = Math.max(max, i);
        }
        return max;
    }

    List<Integer> ans = new LinkedList<>();

    void dfs(FileNode node, int len) {
        for (FileNode n : node.children) {
            if (n.children.size() == 0 && !n.isFile) {
                continue;
            }
            if (n.children.size() == 0) {
                ans.add(len + n.filePathLen);
            }
            dfs(n, len+n.filePathLen + 1);
        }
    }

    void dfs(FileNode node) {
        if (null != node) {
            for (int i = 0; i < node.level; i++) {
                System.out.print("\t");
            }
            System.out.println(node.toString() + ", children: " + node.children.size());
            for (int i = 0; i < node.children.size(); i++) {
                dfs(node.children.get(i));
            }
        }
    }

    static class FileNode {
        FileNode p;
        boolean isFile;
        int filePathLen;
        int level;
        List<FileNode> children = new LinkedList<>();

        @Override
        public String toString() {
            return "[filePathLen = " + filePathLen + ", level = " + level + ", isFile = " + isFile + "]";
        }

        public FileNode() {
        }


        public FileNode(FileNode p, int filePathLen, int level, boolean isFile) {
            this.p = p;
            this.filePathLen = filePathLen;
            this.level = level;
            this.isFile = isFile;
        }

    }

    public static void main(String[] args) {
//        System.out.println(new Solutions().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        System.out.println(new Solutions().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
//        System.out.println(new Solutions().lengthLongestPath("a\n\taaaaaaaaaaaaaaaa\n\t\ta.txt\n\tb\n\t\tc\n\t\t\tb\n\t\t\t\td.txt"));
    }
}
