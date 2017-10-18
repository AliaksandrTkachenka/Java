package lecture6.tree;

import lecture6.tree.monkeys.Monkey;

public class Main {
    public static void main(String[] args) {
        TreeManager treeManager = new TreeManager();
        Branch branchMixed = treeManager.createBranch(EFruits.MIXED);
        MonkeyManager monkeyManager = new MonkeyManager();
        Monkey monkeyCoconutCounter = monkeyManager.createMonkey(EFruits.COCONUTS);
        Monkey monkeyBananaCounter = monkeyManager.createMonkey(EFruits.BANANAS);
        Monkey monkeyMixedCounter = monkeyManager.createMonkey(EFruits.MIXED);
        System.out.println(monkeyManager.count(branchMixed, monkeyBananaCounter));
        System.out.println(monkeyManager.count(branchMixed, monkeyCoconutCounter));
        System.out.println(monkeyManager.count(branchMixed, monkeyMixedCounter));
    }
}
