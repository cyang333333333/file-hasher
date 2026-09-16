import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.BufferedReader;
import java.io.FileReader;



public class FileHasher {
    public static void main(String[] args) {
        File dir = new File("JavaFileSystem");
        dir.mkdir();
        File file = new File("JavaFileSystem/notes.txt");
        try (FileWriter writer = new FileWriter("JavaFileSystem/notes.txt")) {
            file.createNewFile();   
            writer.write("jdsjklsadjkl");
            writer.close();
        } catch (IOException e) {
            System.out.println("cant");
        }

        File file2 = new File("JavaFileSystem/data.txt");
        try (FileWriter writer2 = new FileWriter("JavaFileSystem/data.txt")) {
            file2.createNewFile();   
            writer2.write("jdsjklsadjkl sdfsfdsa fsdlkjfasjlk");
            writer2.close();
        } catch (IOException e) {
            System.out.println("cant");
        }

        File file3 = new File("JavaFileSystem/log.txt");  
        try (FileWriter writer3 = new FileWriter("JavaFileSystem/log.txt")) { 
            file3.createNewFile(); 
            writer3.write("jdsjklsadjkl. r9r90i390093409349034904309.");
            writer3.close();
        } catch (IOException e) {
            System.out.println("cant");
        }

        String full = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("JavaFileSystem/notes.txt"))) {
            String result = reader.readLine();
            full = full + result;
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("cant");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("JavaFileSystem/data.txt"))) {
            String result = reader.readLine();
            full = full + result;
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("cant");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("JavaFileSystem/log.txt"))) {
            String result = reader.readLine();
            full = full + result;
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("cant");
        }

        File dir2 = new File("JavaFileSystem/Backup");
        dir2.mkdir();

        File file4 = new File("JavaFileSystem/Backup/backup.txt");
        try (FileWriter writer = new FileWriter("JavaFileSystem/Backup/backup.txt")) {
            file4.createNewFile();   
            writer.write(full);
        } catch (IOException e) {
            System.out.println("cant");
        }

        try {
            System.out.println(hashFile("JavaFileSystem/notes.txt"));
        } catch (Exception e) {
            System.out.println("cant");
        }
        try {
            System.out.println(hashFile("JavaFileSystem/data.txt"));
        } catch (Exception e) {
            System.out.println("cant");
        }
        try {
            System.out.println(hashFile("JavaFileSystem/log.txt"));
        } catch (Exception e) {
            System.out.println("cant");
        }
        try {
            System.out.println(hashFile("JavaFileSystem/Backup/backup.txt"));
        } catch (Exception e) {
            System.out.println("cant");
        }
        
    }

    public static String hashFile(String filePath) throws IOException {
        String str = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            str = reader.readLine();
        } catch (IOException e) {
            System.out.println("cant");
        }
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(str.getBytes());
            StringBuilder hexString = new StringBuilder();
                for (byte b : encodedHash) {
                    String hex = String.format("%02x", b);
                    if (hex.length() == 1) {
                        hexString.append('0');
                    }
                    hexString.append(hex);
                }
            return hexString.toString();
        } catch (Exception e) {
            System.out.println("cant missing file");
            return null;
        }
    }
}