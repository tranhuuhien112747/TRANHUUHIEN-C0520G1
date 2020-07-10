package dsa_array_list_page.exercise;

import dsa_array_list_page.practice.MyLinkedList;

import java.util.Arrays;

/**
 * Triển khai các phương thức cài đặc của ArrayList trong thư viện Java.util.ArrayList
 *
 * @param <E>
 */
public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity:" + capacity);
        }
    }

    /**
     * Thêm phần tử vào vị trí chỉ định.-------------------------------------------
     **/

    public void add(int index, E element) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index" + index);
        } else if (elements.length == size) {
            ensureCapacity(10);
        }
        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    /**
     * Thêm phần tử vào cuối mảng.---------------------------------------------------
     **/

    public boolean add(E element) {
        if (elements.length == size) {
            ensureCapacity(10);
        }
        elements[size] = element;
        size++;
        return true;
    }

    /**
     * Truy xuất phần tử thứ i-------------------------------------------------------
     **/

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Index: " + index + ", Size " + index);
        } else {
            return (E) elements[index];
        }
    }

    /**
     * Xóa phần tử thứ index trong mảng----------------------------------
     */
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Index: " + index + ", Size " + index);
        }
        E element = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return element;
    }

    /**
     * lấy độ dài của mảng----------------------------------
     */
    public int size() {
        return this.size;
    }

    /**
     * Tìm kiếm phần tử trả vè vị trí đầu tiên nếu có trong mảng.---------------------
     **/

    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return index;
    }

    /**
     * kiểm tra sự tồn tại của phần tử trong mảng.--------------------------------
     **/

    public boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }

    /**
     * Xóa tấc cả các phần tử trong mảng.-------------------------------------------
     **/

    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    /**
     * Thêm kích thước size cho mảng theo tham số tryền vào-------------------------
     **/

   public void ensureCapacity(int mincapacity) {
        if (mincapacity >= 0) {
            int newSize = elements.length + mincapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("mincapacity" + mincapacity);
        }
    }

    /**
     * Sao chép một mảng mới giống mảng cũ----------------------------------------
     */
    public MyList<E> clone() {
        MyList<E> myList = new MyList<>();
        myList.elements = Arrays.copyOf(this.elements, this.size);
        myList.size = this.size;
        return myList;
    }
}
