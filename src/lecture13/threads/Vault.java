package lecture13.threads;

import lecture8.ownSet.OwnSet;
import java.util.Iterator;
import java.util.Random;

public class Vault {
    private volatile OwnSet set = new OwnSet();
    private Random random;

    public Vault() {
        init();
        random = new Random();
    }

    public void putPart(Part part) {
        set.add(part);
    }

    private void init() {
        set.add(Part.BODY);
        set.add(Part.BODY);
        set.add(Part.HEAD);
        set.add(Part.HEAD);
        set.add(Part.LEFT_HAND);
        set.add(Part.LEFT_LEG);
        set.add(Part.LEFT_LEG);
        set.add(Part.RIGHT_HAND);
        set.add(Part.RIGHT_HAND);
        set.add(Part.RIGHT_HAND);
    }

    public synchronized Part givePart() {
        if(set.size() <= 0) {
            return null;
        }
        Part partToGive;
        int partIndex = 0;
        try {
            partIndex = random.nextInt(set.size());
        } catch (IllegalArgumentException e) {
            return null;
        }

        int currentIndex = 0;
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            if (currentIndex == partIndex) {
                partToGive = (Part) itr.next();
                try {
                    set.remove(partToGive);
                } catch (NullPointerException e){
                    return null;
                }
                return partToGive;
            }
            currentIndex++;
            itr.next();
        }
        return null;
    }
}
