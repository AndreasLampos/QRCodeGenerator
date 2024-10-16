import com.google.zxing.*;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QRCodeGen {

    private static final List<String> history = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==============================");
            System.out.println("=== QR Code Generator & Reader ===");
            System.out.println("==============================");
            System.out.println("1. Generate QR Code");
            System.out.println("2. Read QR Code");
            System.out.println("3. Show History");
            System.out.println("4. Help");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            System.out.println("------------------------------");
            switch (choice) {
                case "1":
                    generateQRCodeFlow(scanner);
                    break;
                case "2":
                    readQRCodeFlow(scanner);
                    break;
                case "3":
                    showHistory();
                    break;
                case "4":
                    showHelp();
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
            System.out.println("------------------------------");
        }

        scanner.close();
    }

    private static void generateQRCodeFlow(Scanner scanner) {
        String url = getValidURLInput(scanner);
        System.out.print("Enter the name of the output file (without .png): ");
        String fileName = scanner.nextLine().trim();
        if (!fileName.toLowerCase().endsWith(".png")) {
            fileName += ".png";
        }

        // Check if file already exists
        if (new File(fileName).exists()) {
            System.out.print("File already exists. Do you want to overwrite it? (Y/N): ");
            String overwrite = scanner.nextLine().trim().toUpperCase();
            if (!overwrite.equals("Y")) {
                System.out.println("QR code generation canceled.");
                return;
            }
        }

        // Get customizable size input
        System.out.print("Enter the width of the QR code (default 300): ");
        String widthInput = scanner.nextLine().trim();
        int width = widthInput.isEmpty() ? 300 : Integer.parseInt(widthInput);
        System.out.print("Enter the height of the QR code (default 300): ");
        String heightInput = scanner.nextLine().trim();
        int height = heightInput.isEmpty() ? 300 : Integer.parseInt(heightInput);

        System.out.print("Do you want to save the QR code as " + fileName + "? (Y/N): ");
        String saveConfirmation = scanner.nextLine().trim().toUpperCase();

        if (saveConfirmation.equals("Y")) {
            try {
                generateQRCode(url, fileName, width, height);
                System.out.println("QR code generated and saved as " + fileName);
                history.add("Generated: " + url + " -> " + fileName); // Store in history
            } catch (WriterException | IOException e) {
                System.err.println("Error while generating QR code: " + e.getMessage());
            }
        } else {
            System.out.println("QR code generation canceled.");
        }
    }

    private static void readQRCodeFlow(Scanner scanner) {
        System.out.print("Enter the path of the QR code image file: ");
        String imagePath = scanner.nextLine().trim();
        String decodedText = readQRCode(imagePath);
        System.out.println("Decoded text from QR code: " + decodedText);
        history.add("Read: " + imagePath + " -> " + decodedText); // Store in history
    }

    private static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No history available.");
        } else {
            System.out.println("=== History ===");
            for (String record : history) {
                System.out.println(record);
            }
        }
    }

    private static void showHelp() {
        System.out.println("=== Help ===");
        System.out.println("1. Generate QR Code: Input a URL and choose a filename to create a QR code.");
        System.out.println("2. Read QR Code: Input the path of an image file containing a QR code to decode it.");
        System.out.println("3. Show History: View the history of generated and read QR codes.");
        System.out.println("4. Exit: Close the application.");
    }

    public static void generateQRCode(String text, String filePath, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    public static String getValidURLInput(Scanner scanner) {
        String url;
        while (true) {
            System.out.print("Enter the URL or text you want to encode in the QR code: ");
            url = scanner.nextLine().trim();
            if (!url.isEmpty() && isValidURL(url)) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid URL.");
            }
        }
        return url;
    }

    public static boolean isValidURL(String url) {
        try {
            new URL(url);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    public static String readQRCode(String filePath) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(filePath));
            MultiFormatReader multiFormatReader = new MultiFormatReader();
            Result result = multiFormatReader.decode(new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage))));
            return result.getText();
        } catch (NotFoundException e) {
            return "QR Code not found.";
        } catch (IOException e) {
            return "Error reading the image file: " + e.getMessage();
        }
    }
}
