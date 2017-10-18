package lecture6.tree.monkeys;

import lecture6.tree.EFruits;
import lecture6.tree.Branch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Monkey {
    protected Map<EFruits, Integer> fruitMap;
    protected int bananaNumber;
    protected int coconutNumber;


    public Monkey() {
        this.fruitMap = new HashMap<>();
    }
    /**
     * Monkey counts the number of the given type of fruits on the given branch
     */
    public abstract Map<EFruits, Integer> count(Branch branch);

    protected int countBananas(Branch branch) {
        bananaNumber += branch.getBananas();
        List<Branch> branches = branch.getBranches();
        for (Branch b : branches) {
            countBananas(b);
        }
        return bananaNumber;
    }

    protected int countCoconuts(Branch branch) {
        coconutNumber += branch.getCoconuts();
        List<Branch> branches = branch.getBranches();
        for (Branch b : branches) {
            countCoconuts(b);
        }
        return coconutNumber;
    }
}
