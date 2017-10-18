package lecture6.tree;

import java.util.ArrayList;
import java.util.List;

public class Branch {

    private int branchNumber;
    private int nesting;
    private int maxFruitNumber;
    private int maxBranchNumber;

    private int bananas;
    private int coconuts;

    private Randomizer randomizerFruits;
    private Randomizer randomizerBranches;

    private EFruits eFruits;

    private List<Branch> branches = new ArrayList<>();

    public Branch(int maxFruitNumber, int maxBranchNumber, int nesting, EFruits eFruits) {
        this.eFruits = eFruits;
        this.maxFruitNumber = maxFruitNumber;
        this.maxBranchNumber = maxBranchNumber;
        this.nesting = nesting;
        randomizerFruits = new Randomizer(maxFruitNumber);
        randomizerBranches = new Randomizer(maxBranchNumber);
    }

    /**
     * Creates a tree (branch) with the parameners set in counstructor
     * @return basic branch of the tree
     */
    public Branch create() {
        branchNumber = randomizerBranches.newRandomInt();
        if (nesting > 0) {
            nesting--;
            for (int i = 0; i < branchNumber; i++) {
                Branch newBranch = new Branch(maxFruitNumber, maxBranchNumber, nesting, eFruits);
                branches.add(newBranch.create());
            }
        }
        createFruits();
        return this;
    }

    private void createFruits() {
        switch (eFruits) {
            case BANANAS: {
                bananas = randomizerFruits.newRandomInt();
                break;
            }
            case COCONUTS: {
                coconuts = randomizerFruits.newRandomInt();
                break;
            }
            case MIXED: {
                bananas = randomizerFruits.newRandomInt();
                coconuts = randomizerFruits.newRandomInt();
                break;
            }
        }
    }

    public int getBananas() {
        return bananas;
    }

    public int getCoconuts() {
        return coconuts;
    }

    public List<Branch> getBranches() {
        return branches;
    }
}