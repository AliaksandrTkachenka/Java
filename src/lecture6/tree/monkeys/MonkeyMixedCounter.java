package lecture6.tree.monkeys;

import lecture6.tree.EFruits;
import lecture6.tree.Branch;

import java.util.Map;

public class MonkeyMixedCounter extends Monkey {
    /**
     * MonkeyBananaCounter counts both bananas and coconuts
     * @param branch - a branch to count the number bananas and coconuts on it
     * @return the map with two elements. Key BANANAS,
     * value is the number of bananas on the given branch
     * and key COCONUTS, value is the number of coconuts on the given branch
     */
    @Override
    public Map<EFruits, Integer> count(Branch branch) {
        bananaNumber = super.countBananas(branch);
        super.fruitMap.put(EFruits.BANANAS, bananaNumber);
        coconutNumber = super.countCoconuts(branch);
        super.fruitMap.put(EFruits.COCONUTS, coconutNumber);
        return super.fruitMap;
    }
}
