package lecture8.ownSet;

import javax.jws.Oneway;
import java.util.*;
import java.util.function.Consumer;

/**
 * Class OwnSet realizes the possibility to store several identical values and get their number
 * @param <E>
 */

public class OwnSet<E>
        extends HashSet<E> {

    private transient HashMap<E,Integer> ownMap;

    public OwnSet() {
        ownMap = new HashMap<>();
    }

    /**
     * Gets the number of elements by the given key or 0 if element is not in this set
     * @param e element to be checked
     * @return number of found elements
     */
    public int getAmount(E e) {
        if(ownMap.containsKey(e)) {
            return ownMap.get(e);
        } else {
            return 0;
        }
    }

    /**
     * Adds the specified element to this set if this element is not in this set
     * or increases it's number
     * @param e element to be added to this set
     * @return
     */
    @Override
    public boolean add(E e) {
        Integer value = 0;
        if(ownMap.containsKey(e)) {
            value = ownMap.get(e);
         }
        return ownMap.put(e, ++value)== null;
    }

    /**
     * Removes one given element
     * @param o element to be removed
     * @return true if element o was removed and false otherwise
     */
    @Override
    public boolean remove(Object o) {
        if(ownMap.containsKey(o)) {
            if(ownMap.get(o) == 1) {
                ownMap.remove(o);
            } else{
                ownMap.put((E) o, ownMap.get(o) - 1);
            }
            return true;
        }
        return false;
    }

    /**
     * Removes all elements o from set
     * @param o elements to be removed
     * @return true if elements o were removed and false otherwise
     */
    public boolean removeAll(Object o) {
        if(ownMap.containsKey(o)) {
            ownMap.remove(o);
            return true;
        }
        return false;
    }

    /**
     * Checks if o is in a set at least in one exemplar
     * @param o element to be checked
     * @return true if set contains element and false otherwise
     */
    @Override
    public boolean contains(Object o) {
        return ownMap.containsKey(o);
    }

    @Override
    public Iterator<E> iterator() {
        return ownMap.keySet().iterator();
    }

    /**
     * Checks if set is empty
     * @return true if set is empty and false otherwise
     */
    @Override
    public boolean isEmpty() {
        return ownMap.isEmpty();
    }

    /**
     * Gets the number of unique elements
     * @return the number of unique elements
     */
    @Override
    public int size() {
        return ownMap.size();
    }

    /**
     * Gets a total number of elements.
     * If element is not unique counts the number of this elements
     * @return a total number of elements
     */
    public int sizeTotal() {
        int size = 0;
        for (Map.Entry<E, Integer> entry : ownMap.entrySet()) {
            size += entry.getValue();
        }
        return size;
    }

    /**
     * Removes all elements from set
     */
    @Override
    public void clear() {
        ownMap.clear();
    }

    /**
     * Checks if given object equals set i.e. all elements and their number are the same.
     * The order is arbitrary
     * @param o given object to be checked
     * @return true if given object equals set and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if(o.getClass() != this.getClass()) {
            return false;
        }
        if(!(((OwnSet<E>)o).size() == ownMap.size())) {
            return false;
        }
        for (Map.Entry<E, Integer> entry : ownMap.entrySet()) {
            if(!(((OwnSet<E>)o).contains(entry.getKey())
                    && ((OwnSet<E>)o).getAmount(entry.getKey()) == entry.getValue() )) {
                return false;
            }
        }
        return true;
    }

    /**
     * Clones set
     * @return new reference to the set
     */
    @Override
    public OwnSet<E> clone() {
        OwnSet<E> newSet = this;
        return newSet;
    }
}