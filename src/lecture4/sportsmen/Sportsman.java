package lecture4.sportsmen;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */
public class Sportsman {

    private String name;
    private int goldMedals;
    private int silverMedals;

    public Sportsman() {
    }

    /**
     *
     * @param name sportsman's name
     * @param goldMedals amount of sportsman's gold medals
     * @param silverMedals mount of silver medals
     */
    public Sportsman(String name, int goldMedals, int silverMedals) {
        this.name = name;
        this.goldMedals = goldMedals;
        this.silverMedals = silverMedals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoldMedals() {
        return goldMedals;
    }

    public void setGoldMedals(int goldMedals) {
        this.goldMedals = goldMedals;
    }

    public int getSilverMedals() {
        return silverMedals;
    }

    public void setSilverMedals(int silverMedals) {
        this.silverMedals = silverMedals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sportsman sportsman = (Sportsman) o;

        if (goldMedals != sportsman.goldMedals) return false;
        if (silverMedals != sportsman.silverMedals) return false;
        return name != null ? name.equals(sportsman.name) : sportsman.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + goldMedals;
        result = 31 * result + silverMedals;
        return result;
    }

    @Override
    public String toString() {
        return this.name + "\t" + this.goldMedals + "\t" + this.silverMedals;
    }
}
