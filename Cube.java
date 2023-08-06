import java.util.Random;
public class Cube {
    // 0->5: white, yellow, blue, red, green, orange
    //         Y Y Y
    //         Y Y Y
    //         Y Y Y
    //  B B B  R R R  G G G  O O O
    //  B B B  R R R  G G G  O O O
    //  B B B  R R R  G G G  O O O
    //         W W W
    //         W W W
    //         W W W
    public int[][][] cube; // cube[face][y][x]
    public Cube() {
        cube = new int[6][3][3];
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    cube[i][j][k] = i;
                }
            }
        }
    }
    // returns face n as a string
    public String vFaces(int n){
        String s = "       ";
        for(int j = 0; j < 3; j++){
            s += cube[n][0][j] + " ";
        }
        s += "\n       ";
        for(int j = 0; j < 3; j++){
            s += cube[n][1][j] + " ";
        }
        s += "\n       ";
        for(int j = 0; j < 3; j++){
            s += cube[n][2][j] + " ";
        }
        s += "\n";
        return s;
    }
    // returns faces 2 to 5 as string

    // returns whole cube as string
    public String hFaces() {
        String s = "";
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                s += cube[i][0][j] + " ";
            }
            s += " ";
        }
        s += "\n";
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                s += cube[i][1][j] + " ";
            }
            s += " ";
        }
        s += "\n";
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                s += cube[i][2][j] + " ";
            }
            s += " ";
        }
        s += "\n";
        return s;
    }
    public void makeMove(String n){
        int x;
        String newMoves[] = n.split("");
        if (n.length() == 2){
            if (newMoves[1].equals("2")){
                x = 2;
            }
            else {
                x = 3;
            }
        }
        else {
            x = 1;
        }

        for (int y = 0; y < x; y ++) {
            int[][][] tempCube = new int[6][3][3];
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        tempCube[i][j][k] = cube[i][j][k];
                    }
                }
            }
            switch (newMoves[0]) {
                case "R":
                    // face corners
                    cube[4][2][2] = tempCube[4][0][2];
                    cube[4][2][0] = tempCube[4][2][2];
                    cube[4][0][0] = tempCube[4][2][0];
                    cube[4][0][2] = tempCube[4][0][0];
                    // face edges
                    cube[4][1][2] = tempCube[4][0][1];
                    cube[4][0][1] = tempCube[4][1][0];
                    cube[4][1][0] = tempCube[4][2][1];
                    cube[4][2][1] = tempCube[4][1][2];
                    // side corners *top right
                    cube[3][0][2] = tempCube[0][0][2];
                    cube[0][0][2] = tempCube[5][2][0];
                    cube[5][2][0] = tempCube[1][0][2];
                    cube[1][0][2] = tempCube[3][0][2];
                    // side corners *bottom right
                    cube[3][2][2] = tempCube[0][2][2];
                    cube[0][2][2] = tempCube[5][0][0];
                    cube[5][0][0] = tempCube[1][2][2];
                    cube[1][2][2] = tempCube[3][2][2];
                    // side edges
                    cube[3][1][2] = tempCube[0][1][2];
                    cube[0][1][2] = tempCube[5][1][0];
                    cube[5][1][0] = tempCube[1][1][2];
                    cube[1][1][2] = tempCube[3][1][2];
                    break;
                case "L":
                    // face corners
                    cube[2][2][2] = tempCube[2][0][2];
                    cube[2][2][0] = tempCube[2][2][2];
                    cube[2][0][0] = tempCube[2][2][0];
                    cube[2][0][2] = tempCube[2][0][0];
                    // face edges
                    cube[2][1][2] = tempCube[2][0][1];
                    cube[2][0][1] = tempCube[2][1][0];
                    cube[2][1][0] = tempCube[2][2][1];
                    cube[2][2][1] = tempCube[2][1][2];
                    // side corners *top left
                    cube[3][0][0] = tempCube[1][0][0];
                    cube[0][0][0] = tempCube[3][0][0];
                    cube[5][2][2] = tempCube[0][0][0];
                    cube[1][0][0] = tempCube[5][2][2];
                    // side corners *bottom left
                    cube[3][2][0] = tempCube[1][2][0];
                    cube[0][2][0] = tempCube[3][2][0];
                    cube[5][0][2] = tempCube[0][2][0];
                    cube[1][2][0] = tempCube[5][0][2];
                    // side edges
                    cube[3][1][0] = tempCube[1][1][0];
                    cube[0][1][0] = tempCube[3][1][0];
                    cube[5][1][2] = tempCube[0][1][0];
                    cube[1][1][0] = tempCube[5][1][2];
                    break;
                case "U":
                    // face corners
                    cube[1][2][2] = tempCube[1][0][2];
                    cube[1][2][0] = tempCube[1][2][2];
                    cube[1][0][0] = tempCube[1][2][0];
                    cube[1][0][2] = tempCube[1][0][0];
                    // face edges
                    cube[1][1][2] = tempCube[1][0][1];
                    cube[1][0][1] = tempCube[1][1][0];
                    cube[1][1][0] = tempCube[1][2][1];
                    cube[1][2][1] = tempCube[1][1][2];
                    // side corners *top left
                    cube[3][0][0] = tempCube[4][0][0];
                    cube[2][0][0] = tempCube[3][0][0];
                    cube[5][0][0] = tempCube[2][0][0];
                    cube[4][0][0] = tempCube[5][0][0];
                    // side corners *top right
                    cube[3][0][2] = tempCube[4][0][2];
                    cube[2][0][2] = tempCube[3][0][2];
                    cube[5][0][2] = tempCube[2][0][2];
                    cube[4][0][2] = tempCube[5][0][2];
                    // top edges
                    cube[3][0][1] = tempCube[4][0][1];
                    cube[2][0][1] = tempCube[3][0][1];
                    cube[5][0][1] = tempCube[2][0][1];
                    cube[4][0][1] = tempCube[5][0][1];
                    break;
                case "F":
                    // face corners
                    cube[3][2][2] = tempCube[3][0][2];
                    cube[3][2][0] = tempCube[3][2][2];
                    cube[3][0][0] = tempCube[3][2][0];
                    cube[3][0][2] = tempCube[3][0][0];
                    // face edges
                    cube[3][1][2] = tempCube[3][0][1];
                    cube[3][0][1] = tempCube[3][1][0];
                    cube[3][1][0] = tempCube[3][2][1];
                    cube[3][2][1] = tempCube[3][1][2];
                    // bottom right
                    cube[0][0][2] = tempCube[4][0][0];
                    cube[4][0][0] = tempCube[1][2][0];
                    cube[1][2][0] = tempCube[2][2][2];
                    cube[2][2][2] = tempCube[0][0][2];
                    // bottom left
                    cube[0][0][0] = tempCube[4][2][0];
                    cube[4][2][0] = tempCube[1][2][2];
                    cube[1][2][2] = tempCube[2][0][2];
                    cube[2][0][2] = tempCube[0][0][0];
                    // bottom edges
                    cube[0][0][1] = tempCube[4][1][0];
                    cube[4][1][0] = tempCube[1][2][1];
                    cube[1][2][1] = tempCube[2][1][2];
                    cube[2][1][2] = tempCube[0][0][1];
                    break;
                case "D":
                    // face corners
                    cube[0][2][2] = tempCube[0][0][2];
                    cube[0][2][0] = tempCube[0][2][2];
                    cube[0][0][0] = tempCube[0][2][0];
                    cube[0][0][2] = tempCube[0][0][0];
                    // face edges
                    cube[0][1][2] = tempCube[0][0][1];
                    cube[0][0][1] = tempCube[0][1][0];
                    cube[0][1][0] = tempCube[0][2][1];
                    cube[0][2][1] = tempCube[0][1][2];
                    // bottom left
                    cube[3][2][0] = tempCube[2][2][0];
                    cube[2][2][0] = tempCube[5][2][0];
                    cube[5][2][0] = tempCube[4][2][0];
                    cube[4][2][0] = tempCube[3][2][0];
                    // bottom right
                    cube[3][2][2] = tempCube[2][2][2];
                    cube[2][2][2] = tempCube[5][2][2];
                    cube[5][2][2] = tempCube[4][2][2];
                    cube[4][2][2] = tempCube[3][2][2];
                    // bottom edges
                    cube[3][2][1] = tempCube[2][2][1];
                    cube[2][2][1] = tempCube[5][2][1];
                    cube[5][2][1] = tempCube[4][2][1];
                    cube[4][2][1] = tempCube[3][2][1];
                    break;
                case "B":
                    // face corners
                    cube[5][2][2] = tempCube[5][0][2];
                    cube[5][2][0] = tempCube[5][2][2];
                    cube[5][0][0] = tempCube[5][2][0];
                    cube[5][0][2] = tempCube[5][0][0];
                    // face edges
                    cube[5][1][2] = tempCube[5][0][1];
                    cube[5][0][1] = tempCube[5][1][0];
                    cube[5][1][0] = tempCube[5][2][1];
                    cube[5][2][1] = tempCube[5][1][2];
                    // bottom right
                    cube[0][2][2] = tempCube[2][2][0];
                    cube[2][2][0] = tempCube[1][0][0];
                    cube[1][0][0] = tempCube[4][0][2];
                    cube[4][0][2] = tempCube[0][2][2];
                    // bottom left
                    cube[0][2][0] = tempCube[2][0][0];
                    cube[2][0][0] = tempCube[1][0][2];
                    cube[1][0][2] = tempCube[4][2][2];
                    cube[4][2][2] = tempCube[0][2][0];
                    // bottom edges
                    cube[0][2][1] = tempCube[2][1][0];
                    cube[2][1][0] = tempCube[1][0][1];
                    cube[1][0][1] = tempCube[4][1][2];
                    cube[4][1][2] = tempCube[0][2][1];
                    break;
                case "x": // moves the entire cube about the R direction
                    for (int j = 0; j < 4 ; j++) {
                        for (int k = 0; k < 4 ; k++) {
                            cube[0][j][k] = tempCube[5][j][k];
                        }
                    }

                    break;
                case "y": // moves the entire cube about the U direction
                    // loop through and change stuff
                    break;
                case "z": // moves the cube about the F direction
                    // loop through and do stuff
            }
        }
    }
    public void scramble(){
        String[] moves = {"R", "L", "F", "B", "U", "D",
                            "R2", "L2", "F2", "B2", "U2", "D2",
                            "R'", "L'", "F'", "B'", "U'", "D'"};
        for (int x = 0; x < 21; x++){
            Random randomMove = new Random();
            int moveIndex = randomMove.nextInt(moves.length);
            makeMove(moves[moveIndex]);
        }
    }
    public boolean isNotSolved(){
        int[][][] solvedCube = new int[6][3][3];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    solvedCube[i][j][k] = i;
                }
            }
        }
        for (int x = 0; x < 6;x++) {
            for (int y = 0; y < 3; y++){
                for (int z = 0; z < 3; z++) {
                    if (cube[x][y][z] != solvedCube[x][y][z]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public String returnNet() {
        String s = "";
        s += vFaces(1);
        s += hFaces();
        s += vFaces(0);
        return s;
    }
    public String toString() {
        String s = "";
        // 1             111
        // 2        11         11
        // 3    11       111       11
        // 4        11         11
        // 5    3        111        4
        // 6    3   3           4   4
        // 7    3   3   3   4   4   4
        // 8        3   3   4   4
        // 9            3   4

        // first row
        s += "             ";
        s += cube[1][0][0];
        s += cube[1][0][0];
        s += cube[1][0][0];
        s += "\n";
        // second row
        s += "        ";
        s += cube[1][1][0];
        s += cube[1][1][0];
        s += "         ";
        s += cube[1][0][1];
        s += cube[1][0][1];
        s += "\n";
        // third row
        s += "    ";
        s += cube[1][2][0];
        s += cube[1][2][0];
        s += "       ";
        s += cube[1][1][1];
        s += cube[1][1][1];
        s += cube[1][1][1];
        s += "       ";
        s += cube[1][0][2];
        s += cube[1][0][2];
        s += "\n";
        // fourth row
        s += "        ";
        s += cube[1][2][1];
        s += cube[1][2][1];
        s += "         ";
        s += cube[1][1][2];
        s += cube[1][1][2];
        s += "\n";
        // fifth row
        s += "    ";
        s += cube[3][0][0];
        s += "        ";
        s += cube[1][2][2];
        s += cube[1][2][2];
        s += cube[1][2][2];
        s += "        ";
        s += cube[4][0][2];
        s += "\n";
        // sixth row
        s += "    ";
        s += cube[3][1][0];
        s += "   ";
        s += cube[3][0][1];
        s += "           ";
        s += cube[4][0][1];
        s += "   ";
        s += cube[4][1][2];
        s += "\n";
        // seventh row
        s += "    ";
        s += cube[3][2][0];
        s += "   ";
        s += cube[3][1][1];
        s += "   ";
        s += cube[3][0][2];
        s += "   ";
        s += cube[4][0][0];
        s += "   ";
        s += cube[4][1][1];
        s += "   ";
        s += cube[4][2][2];
        s += "\n";
        // eight row
        s += "        ";
        s += cube[3][2][1];
        s += "   ";
        s += cube[3][1][2];
        s += "   ";
        s += cube[4][1][0];
        s += "   ";
        s += cube[4][2][1];
        s += "\n";
        // ninth row
        s += "            ";
        s += cube[3][2][2];
        s += "   ";
        s += cube[4][2][0];
        s += "\n";
        return s;
    }
}