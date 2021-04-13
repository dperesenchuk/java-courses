package task2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main2 {
    static final Scanner scanner = new Scanner(System.in);
    static Pudge pudge;
    static ResourceBundle bundle;

    public static void main(String[] args) {
        String localeValue = args.length > 0 ? args[0] : null;
        if (!localeValue.equals("en_EN") && !localeValue.equals("ru_RU")) {
            System.out.println("Invalid params");
            return;
        }

        Locale locale = new Locale(localeValue);
        bundle = ResourceBundle.getBundle("MessageBundle", locale);

        do {
            printMenu();
            try {
                handleMenuInput(Integer.parseInt(scanner.nextLine()));
            } catch (NumberFormatException e) {
                invalidMenuSelected();
            }
        } while (true);
    }

    private static void handleMenuInput(int selectedItem) {
        switch (selectedItem) {
            case 1:
                pudge = createPudge();
                break;
            case 2:
                savePudge();
                break;
            case 3:
                loadPudge();
                break;
            case 4:
                if (pudge == null) {
                    System.out.println(bundle.getString("noPudge"));
                } else {
                    System.out.println(pudge);
                }
                break;
            case 0:
                scanner.close();
                System.exit(0);
            default:
                invalidMenuSelected();
        }
    }

    private static void printMenu() {
        System.out.println(bundle.getString("menu"));
        System.out.println("=================");
        System.out.println("1 - " +  bundle.getString("create"));
        System.out.println("2 - " + bundle.getString("save"));
        System.out.println("3 - " + bundle.getString("load"));
        System.out.println("4 - " + bundle.getString("print"));
        System.out.println("-----------------");
        System.out.println("0 - " + bundle.getString("exit"));
    }

    private static void invalidMenuSelected() {
        System.out.println(bundle.getString("wrongChoice"));
    }

    private static void invalidValue() {
        System.out.println(bundle.getString("invalidValue"));
    }

    private static Pudge createPudge() {
        System.out.println("===" + bundle.getString("create") + "===");

        int[] pudgeArgs = new int[3];
        String[] text = {bundle.getString("setIntelligence"), bundle.getString("setAgility"), bundle.getString("setStrength")};

        for (int i = 0; i < text.length; i++) {
            do {
                try {
                    System.out.println(text[i]);
                    pudgeArgs[i] = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    invalidValue();
                }
            } while (true);
        }

        System.out.println(bundle.getString("setUltimate"));
        String ultimate = scanner.nextLine();

        return new Pudge(pudgeArgs[0], pudgeArgs[1], pudgeArgs[2], ultimate);
    }

    private static void savePudge() {
        System.out.println("===" + bundle.getString("saveStarted") + "===");

        if (pudge == null) {
            System.out.println(bundle.getString("noPudge"));
            return;
        }

        try (FileOutputStream fos = new FileOutputStream("pudge.bin"); ObjectOutputStream outputStream = new ObjectOutputStream(fos)){
            outputStream.writeObject(pudge);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("===" + bundle.getString("saveFinished") + "===");
    }

    private static void loadPudge() {
        System.out.println("===" + bundle.getString("loadStarted") + "===");

        try (FileInputStream fis = new FileInputStream("pudge.bin"); ObjectInputStream inputStream = new ObjectInputStream(fis)){
            pudge = (Pudge) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("===" + bundle.getString("loadFinished") + "===");
    }
}
