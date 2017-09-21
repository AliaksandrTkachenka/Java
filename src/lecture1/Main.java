package lecture1;

/**
 * @author AliaksandrTkachenka
 * class Robot describes robot's coordinates
 */

import java.util.Scanner;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws NumberFormatException {

        Robot robot = new Robot();
        /**
         * Input robot's start coordinates
         */
        System.out.println("Input start coordinate X:");
        robot.setCoordX(input());
        System.out.println("Input start coordinate Y:");
        robot.setCoordY(input());

        /**
         * Input robot's offset and moving robot
         */

        System.out.println("Input offset X and Y:");
        robot.move(input(), input());

        System.out.println("Robot's position:\nX: " + robot.getCoordX() + "\nY: " + robot.getCoordY());

    }

    /**
     *
     * @return integer value that is derived from the console
     */
    private static int input() {

        Scanner scanner = new Scanner(System.in);

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        return 0;
    }
}