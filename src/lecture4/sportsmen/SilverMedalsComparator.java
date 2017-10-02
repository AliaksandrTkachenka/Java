package lecture4.sportsmen;

import java.util.Comparator;

/**
 * Compares 2 objects of class Sportsman by amount of silver medals
 */
public class SilverMedalsComparator implements Comparator<Sportsman> {
    @Override
    public int compare(Sportsman sportsman1, Sportsman sportsman2) {
        if(sportsman1 == null) {
            return -1;
        }
        if(sportsman2 == null) {
            return 1;
        }
        return sportsman1.getSilverMedals() - sportsman2.getSilverMedals();
    }
}
