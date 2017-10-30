package lecture13.threads;

import lecture8.ownSet.*;

public class ExtendedOwnSet extends OwnSet{
    private boolean isAccessible;

    public ExtendedOwnSet() {
        super();
        this.isAccessible = true;
    }

    public void setAccessible() {
        this.isAccessible = true;
    }

    public void setUnaccessible() {
        this.isAccessible = false;
    }

    @Override
    public boolean add(Object o) {
        if(isAccessible == true) {
            return super.add(o);
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if(isAccessible == true) {
            return super.remove(o);
        }
        return false;
    }
}
