package documin;

import java.util.Scanner;

public class IO {
    private Scanner input = new Scanner(System.in);
    public String input(String label) {
        return input.nextLine();
    }
}