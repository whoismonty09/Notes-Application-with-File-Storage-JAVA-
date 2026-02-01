
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Note {
    String content;

    Note(String content) {
        this.content = content;
    }

    void displayNote(int index) {
        System.out.println(index + ". " + content);
    }
}

public class Main {

    static ArrayList<Note> notes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n Notes Application developed by Monty");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Save Notes to File");
            System.out.println("4. Load Notes from File");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNote();
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    saveNotesToFile();
                    break;
                case 4:
                    loadNotesFromFile();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    static void addNote() {
        System.out.print("Enter your note: ");
        String content = scanner.nextLine();
        notes.add(new Note(content));
        System.out.println("✅ Note added successfully!");
    }

    static void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
        } else {
            for (int i = 0; i < notes.size(); i++) {
                notes.get(i).displayNote(i + 1);
            }
        }
    }
;
        }
    }

    static void loadNotesFromFile() {
        try {
            File file = new File(FILE_NAME);
            Scanner fileScanner = new Scanner(file);
            notes.clear();

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                notes.add(new Note(line));
            }

            fileScanner.close();
            System.out.println("📂 Notes loaded from file successfully!");
        } catch (IOException e) {
            System.out.println("No file found to load notes.");
        }
    }
}
