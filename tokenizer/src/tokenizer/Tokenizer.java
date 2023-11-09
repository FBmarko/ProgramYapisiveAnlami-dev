package tokenizer;

/**
 *
 * @author Mehmet Turan
 */
import java.io.*;
import java.util.Scanner;

public class Tokenizer {
    public static void main(String[] args) {
        final int MAX_FILE_SIZE = 10000;
        final int MAX_WORDS = 1000;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Okunacak dosyanin adini girin (ornegin: ornek.txt): ");
        String fileName = scanner.nextLine();

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            StringBuilder fileContent = new StringBuilder();

            while (fileScanner.hasNextLine()) {
                fileContent.append(fileScanner.nextLine()).append("\n");
            }

            fileScanner.close();

            String[] CS = tokenize(fileContent.toString());

            System.out.println("Dosyanin kelime dizisi:");
            for (String token : CS) {
                System.out.println(token);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Dosya acma hatası: " + e.getMessage());
            System.exit(1);
        }
    }

    public static String[] tokenize(String input) {
        String[] CS = input.split("[ \\t\\n,()]+");
        return CS;
    }
}
