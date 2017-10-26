package lecture8.ownList;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class OwnList<E> extends LinkedList<E>{
    private boolean isImmutable = false;
    private int iteratorIndex;

    /**
     * makes list immutable
     * @return list
     */
    public OwnList<E> build() {
        isImmutable = true;
        return this;
    }

    /**
     * creates list with the given collection and makes list immutable
     * @param c collection to copy to the list
     */
    public OwnList(Collection c) {
        super(c);
        this.isImmutable = true;
        iteratorIndex = 0;
    }

    public OwnList() {
        super();
        iteratorIndex = 0;
    }

    /**
     * Adds Element e to the list if list is mutable
     * Able to add more then one element by sequence of invokes of this method
     * @param e Element to be added
     * @return list
     */
    public OwnList<E> addE(E e) {
        if(isImmutable == false) {
            super.add(e);
        }
        return this;
    }

    /**
     * Adds element e to the start of the list if list is mutable
     * @param e Element to be added
     */
    @Override
    public void addFirst(E e) {
        if(isImmutable == false) {
            super.addFirst(e);
        }
    }

    /**
     * Adds element e to the end of the list if list is mutable
     * @param e Element to be added
     */
    @Override
    public void addLast(E e) {
        if(isImmutable == false) {
            super.addLast(e);
        }
    }

    /**
     * Adds element e to the list if list is mutable
     * @param e Element to be added
     * @return true if element was added, 0 otherwise
     */
    @Override
    public boolean add(E e) {
        if(isImmutable == false) {
            return super.add(e);
        }
        return false;
    }

    /**
     * Adds collection c to the list if list is mutable
     * @param c Collection to be added
     * @return true if c was added, 0 otherwise
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        if(isImmutable == false) {
            return super.addAll(c);
        }
        return false;
    }

    /**
     * Adds collection c to the position index of the list
     * @param index Index to insert c
     * @param c Collection to be added
     * @return true on success, false otherwise
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if(isImmutable == false) {
            return super.addAll(index, c);
        }
        return false;
    }

    /**
     * Adds collection c to the list if list is mutable
     * Able to add more then one element by sequence of invokes of this method.
     * @param c Collection to be added
     * @return true if c was added, 0 otherwise
     */
    public OwnList<E> addAllE(Collection<? extends E> c) {
        if(isImmutable == false) {
            super.addAll(c);
        }
        return this;
    }

    /**
     * Adds collection c to the position index of the list.
     * Able to add more then one element by sequence of invokes of this method.
     * @param index Index to insert c
     * @param c Collection to be added
     * @return true on success, false otherwise
     */
    public OwnList<E> addAllE(int index, Collection<? extends E> c) {
        if(isImmutable == false) {
            super.addAll(index, c);
        }
        return this;
    }

    /**
     * Addss element to the position index to the list
     * @param index index of the list to add element
     * @param element Element to be added
     */
    @Override
    public void add(int index, E element) {
        if(isImmutable == false) {
            super.add(index, element);
        }
    }

    /**
     * Removes element of the list by index if list is mutable
     * @param index index of the element to be removed
     * @return Element
     */
    @Override
    public E remove(int index) {
        if(isImmutable == false) {
            return super.remove(index);
        }
        return null;
    }

    /**
     * Removes first element from the list if list is mutable
     * @return deleted element or null if list is immutable
     */
    @Override
    public E removeFirst() {
        if(isImmutable == false) {
            return super.removeFirst();
        }
        return null;
    }

    /**
     * Removes last element from the list if list is mutable
     * @return deleted element or null if list is immutable
     */
    @Override
    public E removeLast() {
        if(isImmutable == false) {
            return super.removeLast();
        }
        return null;
    }

    /**
     * Removes given Object from the list
     * @param o Object
     * @return true if element was deleted, false otherwise
     */
    @Override
    public boolean remove(Object o) {
        if(isImmutable == false) {
            return super.remove(o);
        }
        return false;
    }

    /**
     * Removes current element if list is mutable
     * @return deleted element
     */
    @Override
    public E remove() {
        return super.remove();
    }

    /**
     * Gets next element of the list
     * @return next element. If current element is last
     * gets first. If list is empty returns null
     */
    public E next() {
        if(iteratorIndex == this.size() - 1) {
            iteratorIndex = 0;
            return this.getFirst();
        }
        if(this.size() == 0) {
            return null;
        }
        E e = this.get(iteratorIndex);
        iteratorIndex++;
        return e;
    }

    /**
     * gets element by index and shifting index for next() method
     * @param index to get
     * @return element by it's index in the list
     */
    @Override
    public E get(int index) {
        iteratorIndex = index;
        return super.get(index);
    }

    @Override
    public String toString() {
        int currentIndex = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(E e: this) {
            stringBuilder.
                    append("\n").
                    append('[').
                    append(currentIndex++).
                    append(']').
                    append("=").
                    append(e);
        }
        return "OwnList:" +
                "isImmutable=" + isImmutable +
                stringBuilder.toString();
    }
}