import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadaFile {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\vcher\\IdeaProjects\\Week3\\Searching\\StringBB\\src\\readingafile.txt";
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
