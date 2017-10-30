package lecture13.threads;

import lecture8.ownSet.OwnSet;

public class RobotBuilder implements Runnable {
    private OwnSet<Part> set = new OwnSet<>();
    private volatile Vault vault;

    public RobotBuilder(Vault vault) {
        this.vault = vault;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                break;
            }
            Part part = vault.givePart();
            if(part != null) {
                set.add(part);
            }
        }
        System.out.println(countRobots());
    }

    public int countRobots() {
        if(set.size() > RobotFactoryService.BODY_PARTS) {
            return 0;
        }
        int minParts = Integer.MAX_VALUE;
        for (Part part : set) {
            if(minParts > set.getAmount(part)) {
                minParts = set.getAmount(part);
            }
        }
        return minParts;
    }
}
