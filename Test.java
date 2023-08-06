import java.util.Scanner;

public class Test {
    public static void main (String[] args) {
        Cube c = new Cube();
        c.scramble();
        System.out.println(c.returnNet());
        System.out.println(c);
        Scanner s = new Scanner(System.in);
        while (c.isNotSolved()){
            String move = s.next();
            c.makeMove(move);
            System.out.println(c.returnNet());
            System.out.println(c);
        }
    }
}
// print in color
// add "x" and "y"
// print colors on the 3d cube
// create a GUI