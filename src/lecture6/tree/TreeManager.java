package lecture6.tree;

public class TreeManager {

    private static final int DEFAULT_NESTING = 2;
    private static final int DEFAULT_MAX_FRUITS = 3;
    private static final int DEFAULT_MAX_BRANCHES = 3;

    public TreeManager() {
    }

    /**
     * creates a branch of the given type
     * @param eFruits - the type of the fruit to create a certain tree (branch)
     * @return
     */
    public Branch createBranch(EFruits eFruits) {
        Branch branch = new Branch(DEFAULT_MAX_FRUITS, DEFAULT_MAX_BRANCHES, DEFAULT_NESTING, eFruits);
        branch.create();
        return branch;
    }
}
