package _303_Range_Sum_Query_Immutable;

import java.util.NoSuchElementException;

/**
 * LeetCode 303. Range Sum Query - Immutable
 *
 * @author cheng
 *         2018/5/15 13:36
 */
public class NumArray1 {

    private class SegmentTree<E> {

        private E[] tree;

        private E[] data;

        private Merger<E> merger;

        public SegmentTree(E[] arr, Merger<E> merger) {

            if (arr.length < 0) {
                throw new IllegalArgumentException("Arr cannot be empty.");
            }

            this.merger = merger;

            data = (E[]) new Object[arr.length];
            System.arraycopy(arr, 0, data, 0, arr.length);

            tree = (E[]) new Object[4 * arr.length];
            buildSegmentTree(0, 0, arr.length - 1);
        }

        /**
         * 在 treeIndex 的位置创建表示区间 [l...r] 的线段树
         *
         * @param treeIndex
         * @param l
         * @param r
         */
        private void buildSegmentTree(int treeIndex, int l, int r) {

            if (l == r) {
                tree[treeIndex] = data[l];
                return;
            }

            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            int mid = (r - l) / 2 + l;

            buildSegmentTree(leftTreeIndex, l, mid);
            buildSegmentTree(rightTreeIndex, mid + 1, r);

            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }

        public E get(int index) {

            if (index < 0 || index >= data.length) {
                throw new IllegalArgumentException("Index is illegal.");
            }

            return data[index];
        }

        /**
         * 返回去区间 [queryL, queryR] 的值
         *
         * @param queryL
         * @param queryR
         * @return
         */
        public E query(int queryL, int queryR) {

            if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
                throw new IllegalArgumentException("Index is Illegal.");
            }

            return query(0, 0, data.length - 1, queryL, queryR);
        }

        /**
         * 在以 treeID 为根的线段树中 [l...r] 的范围内，搜索区间 [queryL, queryR] 的值
         *
         * @param treeIndex
         * @param l
         * @param r
         * @param queryL
         * @param queryR
         * @return
         */
        private E query(int treeIndex, int l, int r, int queryL, int queryR) {

            if (l == queryL && r == queryR) {
                return tree[treeIndex];
            }

            int mid = l + (r - l) / 2;
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            if (queryL >= mid + 1) {
                return query(rightTreeIndex, mid + 1, r, queryL, queryR);
            } else if (queryR <= mid) {
                return query(leftTreeIndex, l, mid, queryL, queryR);
            } else {
                E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
                E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
                return merger.merge(leftResult, rightResult);
            }
        }

        public int getSize() {
            return data.length;
        }

        /**
         * 返回左孩子节点的索引
         *
         * @param index
         * @return
         */
        private int leftChild(int index) {
            return 2 * index + 1;
        }

        /**
         * 返回右孩子节点的索引
         *
         * @param index
         * @return
         */
        private int rightChild(int index) {
            return 2 * index + 2;
        }

        @Override
        public String toString() {

            StringBuilder res = new StringBuilder();
            res.append('[');
            for (int i = 0; i < tree.length; i++) {
                if (tree[i] != null) {
                    res.append(tree[i]);
                } else {
                    res.append("null");
                }

                if (i != tree.length - 1) {
                    res.append(", ");
                }
            }
            res.append(']');

            return res.toString();
        }
    }

    private interface Merger<E> {

        E merge(E a, E b);
    }

    private SegmentTree<Integer> segmentTree;

    public NumArray1(int[] nums) {

        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public int sumRange(int i, int j) {

        if (segmentTree == null) {
            throw new NoSuchElementException("Segment Tree is null.");
        }

        return segmentTree.query(i, j);
    }

    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray1 numArray1 = new NumArray1(nums);

        System.out.println(numArray1.sumRange(0, 2));
        System.out.println(numArray1.sumRange(2, 5));
        System.out.println(numArray1.sumRange(0, 5));
    }
}
