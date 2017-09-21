package lecture1;

/**
 * @author AliaksandrTkachenka
 * class Robot describes robot's coordinates and it's moves
 */

public class Robot {

    /**
     * robot's current coordinates
     */
    private int coordX;
    private int coordY;

    public int getCoordX() {
        return coordX;
    }
    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }
    public int getCoordY() {
        return coordY;
    }
    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    /**
     * @param offsetX
     * @param offsetY
     * adds offsets along the X and Y axes
     */

    public void move(int offsetX, int offsetY) {
        this.coordX += offsetX;
        this.coordY += offsetY;
    }


}