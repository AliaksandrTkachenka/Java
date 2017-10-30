package lecture13.threads;

import java.util.Random;

public class RobotFactoryService {
    public static final int PARTS_TO_PRODUCE = 100;
    public static final int BODY_PARTS = 6;
    private Random random = new Random();

    public Part getRandomPart() {
        int switcher = random.nextInt(BODY_PARTS);
        switch (switcher) {
            case 0: return Part.BODY;
            case 1: return Part.HEAD;
            case 2: return Part.LEFT_HAND;
            case 3: return Part.RIGHT_HAND;
            case 4: return Part.LEFT_LEG;
            case 5: return Part.RIGHT_LEG;
        }
        return null;

    }
}
