package lecture6.tree.monkeys;

import lecture6.tree.EFruits;
import lecture6.tree.Branch;
import java.util.Map;

public class MonkeyCoconutCounter extends Monkey {
    /**
     * MonkeyCoconutCounter counts only coconuts
     * @param branch - a branch to count the number of coconuts on it
     * @return the map with the only element where key is COCONUTS
     * and value is the number of coconuts on the given branch
     */
    @Override
    public Map<EFruits, Integer> count(Branch branch) {
        super.countCoconuts(branch);
        super.fruitMap.put(EFruits.COCONUTS, coconutNumber);
        return super.fruitMap;
    }
}