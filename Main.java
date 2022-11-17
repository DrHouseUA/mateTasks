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
            int arrayValues = 2;

            int[][] arrayOfBytes = new int[arrayLength][arrayValues];
            for (int i = 0; i < arrayLength; i++) {
                for (int j = 0; j < arrayValues; j++) {
                    arrayOfBytes[i][j]=0;
                }
            }



            for (int j = 0; j < 255; j++) {
                int countOfByte = 0;
                for (int i = 0; i < bFile.length; i++)
                {
                    if(bFile[i] == j){
                        countOfByte++;
                        arrayOfBytes[j][0]=j;
                        arrayOfBytes[j][1]=countOfByte;
                    }
                }
            }

            System.out.println("Counts of byte:");
            for (int i = 0; i < arrayLength; i++) {
                if(arrayOfBytes[i][0] !=0) {
                    for (int j = 0; j < 1; j++) {
                        System.out.println("Bytes " + arrayOfBytes[i][0] + " seems " + arrayOfBytes[i][1] + " times.");
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}