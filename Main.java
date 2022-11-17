import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\Programm learning\\Neeeded Skills\\schedule4.pdf");
        File file = new File(path.toUri());
        FileInputStream fileInputStream = null;
        byte[] bFile = new byte[(int) file.length()];

        try
        {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();

            int arrayLength = 255;
            int[] arrayOfBytes = new int[arrayLength];

            for (int i = 0; i < arrayLength; i++) {
                    arrayOfBytes[i]=0;

            }

            for (int j = 0; j < 255; j++) {
                for (int i = 0; i < bFile.length; i++) {
                    if(bFile[i] == j){
                        arrayOfBytes[j]+=1;
                    }
                }
            }

            System.out.println("Counts of byte:");
            for (int i = 0; i < arrayLength; i++) {
                if(arrayOfBytes[i] !=0) {
                    System.out.println("Bytes " + i + " seems " + arrayOfBytes[i] + " times.");
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}