package eu.senla.utilities;

import java.util.Scanner;

public class ConsoleUtility {
    private static final Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }
}
