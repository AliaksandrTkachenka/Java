package lecture6.tree.monkeys;

import lecture6.tree.EFruits;
import lecture6.tree.Branch;
import java.util.Map;

public class MonkeyBananaCounter extends Monkey {
    /**
     * MonkeyBananaCounter counts only bananas
     * @param branch - a branch to count the number of bananas on it
     * @return the map with the only element where key is BANANAS
     * and value is the number of bananas on the given branch
     */
    @Override
    public Map<EFruits, Integer> count(Branch branch) {
        bananaNumber = super.countBananas(branch);
        super.fruitMap.put(EFruits.BANANAS, bananaNumber);
        return super.fruitMap;
    }

}