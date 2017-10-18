package lecture6.tree;

import lecture6.tree.monkeys.Monkey;
import lecture6.tree.monkeys.MonkeyBananaCounter;
import lecture6.tree.monkeys.MonkeyCoconutCounter;
import lecture6.tree.monkeys.MonkeyMixedCounter;
import java.util.Map;

public class MonkeyManager {
    /**
     * Creates a monkey of the given type by parameter eFruits
     * @param eFruits defines the type of the monkey
     * @return certain monkey with the given type or null if there's no such type of fruits
     */
    public Monkey createMonkey(EFruits eFruits) {
        switch (eFruits) {
            case BANANAS: {
                return new MonkeyBananaCounter();
            }
            case COCONUTS: {
                return new MonkeyCoconutCounter();
            }
            case MIXED: {
                return new MonkeyMixedCounter();
            }
        }
        return null;
    }

    /**
     * Counts the number of fruits that monkey can count on the given tree (branch)
     * @param branch - tree (branch) to count the number of ruits
     * @param monkey - the given monkey
     * @return map where key is the type of fruits that monkey counted
     * and value is the number of this type of fruits
     */
    public Map<EFruits, Integer> count(Branch branch, Monkey monkey) {
        return monkey.count(branch);
    }
}
