package lecture8.ownSet;

import java.util.*;

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
}