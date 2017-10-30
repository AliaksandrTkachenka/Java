package lecture13.threads;

import java.util.Random;

public class RobotFactory implements Runnable {
    private Random random = new Random();
    private volatile Vault vault;
    private RobotFactoryService service;

    public RobotFactory(Vault vault) {
        this.vault = vault;
        service = new RobotFactoryService();
    }

    @Override
    public void run() {
        for(int i = 0; i < RobotFactoryService.PARTS_TO_PRODUCE; i++) {
            vault.putPart(service.getRandomPart());
            try {
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
