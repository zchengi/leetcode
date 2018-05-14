package _347_Top_K_Frequent_Elements;

import java.util.*;

/**
 * LeetCode 347. Top K Frequent Elements
 *
 * @author cheng
 *         2018/5/14 17:05
 */
public class Solution1 {

    private class Array<E> {

        private E[] data;

        private int size;

        /**
         * 构造函数，传入数组的容量 capacity 构造 Array
         *
         * @param capacity
         */
        public Array(int capacity) {

            if (capacity <= 0) {
                throw new IllegalArgumentException("Initialization failed. Require capacity > 0.");
            }

            size = 0;
            data = (E[]) new Object[capacity];
        }

        /**
         * 无参数的构造函数，默认数组的容量 capacity = 10
         */
        public Array() {
            this(10);
        }

        /**
         * 构造函数，传入一个静态数组，生成一个 Array 类的对象
         *
         * @param array
         */
        public Array(E[] array) {

            size = array.length;
            data = (E[]) new Object[array.length];
            System.arraycopy(array, 0, data, 0, array.length);
        }

        /**
         * 获取数组中的元素个数
         *
         * @return
         */
        public int getSize() {
            return size;
        }

        /**
         * 获取数组的容量
         *
         * @return
         */
        public int getCapacity() {
            return data.length;
        }

        /**
         * 返回数组是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 向所有元素后添加一个新元素
         *
         * @param e
         */
        public void addLast(E e) {
            add(size, e);
        }

        /**
         * 向所有元素前添加一个新元素
         *
         * @param e
         */
        public void addFirst(E e) {
            add(0, e);
        }

        /**
         * 在第 index 个位置插入一个新元素 e
         *
         * @param index
         * @param e
         */
        public void add(int index, E e) {

            if (index < 0 || index > size) {
                throw new IllegalArgumentException("AddLast failed. Require index >= 0 and index <= size.");
            }
            if (size == data.length) {
                resize(2 * data.length);
            }

        /*for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }*/
            System.arraycopy(data, index, data, index + 1, size - index);

            data[index] = e;
            size++;
        }

        /**
         * 修改 index 索引位置的元素
         *
         * @param index
         * @param e
         */
        public void set(int index, E e) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("Set failed. Index is illegal.");
            }
            data[index] = e;
        }

        /**
         * 获取 index 索引位置的元素
         *
         * @param index
         * @return
         */
        public E get(int index) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("Get failed. Index is illegal.");
            }
            return data[index];
        }

        /**
         * 获取数组第一个元素
         *
         * @return
         */
        public E getFirst() {
            return get(0);
        }

        /**
         * 获取数组最后一个元素
         *
         * @return
         */
        public E getLast() {
            return get(size - 1);
        }

        /**
         * 查找数组中是否有元素 e
         *
         * @return
         */
        public boolean contains(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 查找数组中元素 e 所在的索引(第一次找到的元素)，如果不存在元素 e，则返回 -1
         *
         * @param e
         * @return
         */
        public int find(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    return i;
                }
            }
            return -1;
        }

        /**
         * 查找数组中元素 e 所在的所有索引
         *
         * @param e
         * @return
         */
        public List<Integer> findAll(E e) {

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    res.add(i);
                }
            }

            return res;
        }

        /**
         * 从数组中删除 index 位置的元素，返回删除的元素
         *
         * @param index
         * @return
         */
        public E remove(int index) {

            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("Remove failed. Index is illegal.");
            }

            E res = data[index];

        /*for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }*/
            System.arraycopy(data, index + 1, data, index, size - (index + 1));

            size--;
            // loitering objects(内存回收) != memory leak
            data[size] = null;

            if (size == data.length / 4 && size > 0) {
                resize(data.length / 2);
            }

            return res;
        }

        /**
         * 从数组中删除第一个元素，返回删除的元素
         *
         * @return
         */
        public E removeFirst() {
            return remove(0);
        }

        /**
         * 从数组中删除最后一个元素，返回删除的元素
         *
         * @return
         */
        public E removeLast() {
            return remove(size - 1);
        }

        /**
         * 从数组中删除元素(只删除找到的第一个元素) e
         *
         * @param e
         * @return
         */
        public boolean removeElement(E e) {

            int index = find(e);
            if (index != -1) {
                remove(index);
                return true;
            }

            return false;
        }

        /**
         * 从数组中删除所有元素 e
         *
         * @param e
         * @return
         */
        public boolean removeAllElement(E e) {

            boolean flag = false;
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    // 因为删除一个元素后，该元素之后的所有元素向前移动一位，所以 i--，再从当前元素查找
                    remove(i--);
                    flag = true;
                }
            }

            return flag;
        }

        /**
         * 将数组空间的容量变成 newCapacity 大小
         *
         * @param newCapacity
         */
        private void resize(int newCapacity) {

            E[] newData = (E[]) new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }

        public void swap(int i, int j) {

            if (i < 0 || i >= size) {
                throw new IllegalArgumentException("Index is illegal.");
            }

            E t = data[i];
            data[i] = data[j];
            data[j] = t;
        }

        @Override
        public String toString() {

            StringBuilder res = new StringBuilder();
            res.append(String.format("Array : size = %d , capacity = %d\n", size, data.length));
            res.append('[');
            for (int i = 0; i < size; i++) {
                res.append(data[i]);
                if (i != size - 1) {
                    res.append(", ");
                }
            }
            res.append("]");

            return res.toString();
        }
    }

    private class MaxHeap<E extends Comparable<E>> {

        private Array<E> data;

        public MaxHeap() {
            data = new Array<>();
        }

        public MaxHeap(int capacity) {
            data = new Array<>(capacity);
        }

        public MaxHeap(E[] arr) {
            data = new Array<>(arr);
            for (int i = parent(arr.length - 1); i >= 0; i--) {
                siftDown(i);
            }
        }

        /**
         * 向堆中添加元素
         *
         * @param e
         */
        public void add(E e) {
            data.addLast(e);
            siftUp(data.getSize() - 1);
        }

        private void siftUp(int k) {
            while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
                data.swap(k, parent(k));
                k = parent(k);
            }
        }

        /**
         * 查看堆中最大元素
         *
         * @return
         */
        public E findMax() {

            if (data.getSize() == 0) {
                throw new NoSuchElementException("Cannot findMax when heap is empty.");
            }
            return data.get(0);
        }

        /**
         * 取出堆中最大元素
         */
        public E extractMax() {

            E ret = findMax();

            data.swap(0, data.getSize() - 1);
            data.removeLast();

            siftDown(0);

            return ret;
        }

        private void siftDown(int k) {

            while (leftChild(k) < data.getSize()) {

                int j = leftChild(k);
                if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                    j++;
                }

                if (data.get(k).compareTo(data.get(j)) >= 0) {
                    break;
                }

                data.swap(k, j);
                k = j;
            }
        }

        /**
         * 取出堆中的最大元素，并且替换成元素 e
         *
         * @param e
         * @return
         */
        public E replace(E e) {

            E ret = findMax();
            data.set(0, e);

            siftDown(0);
            return ret;
        }

        /**
         * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
         *
         * @param index
         * @return
         */
        private int parent(int index) {
            if (index == 0) {
                throw new IllegalArgumentException("Index-0 doesn't have parent.");
            }
            return (index - 1) / 2;
        }

        /**
         * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
         *
         * @param index
         * @return
         */
        private int leftChild(int index) {
            return index * 2 + 1;
        }

        /**
         * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
         *
         * @param index
         * @return
         */
        private int rightChild(int index) {
            return index * 2 + 2;
        }

        /**
         * 返回堆中的元素个数
         *
         * @return
         */
        public int size() {
            return data.getSize();
        }

        /**
         * 返回一个布尔值，表示堆中是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return data.isEmpty();
        }
    }

    private interface Queue<E> {

        void enqueue(E e);

        E dequeue();

        E getFront();

        int getSize();

        boolean isEmpty();
    }

    private class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

        private MaxHeap<E> maxHeap;

        public PriorityQueue() {
            maxHeap = new MaxHeap<>();
        }

        @Override
        public void enqueue(E e) {
            maxHeap.add(e);
        }

        @Override
        public E dequeue() {
            return maxHeap.extractMax();
        }

        @Override
        public E getFront() {
            return maxHeap.findMax();
        }

        @Override
        public int getSize() {
            return maxHeap.size();
        }

        @Override
        public boolean isEmpty() {
            return maxHeap.isEmpty();
        }
    }

    private class Freq implements Comparable<Freq> {

        private int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq that) {
            if (this.freq < that.freq) {
                return 1;
            } else if (this.freq > that.freq) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (pq.getSize() < k) {
                pq.enqueue(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.getFront().freq) {
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.dequeue().e);
        }
        return res;
    }

    private static void printList(List<Integer> nums) {
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new Solution1()).topKFrequent(nums, k));
    }
}
