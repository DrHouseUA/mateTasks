import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

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

            int arrayLength = 256;
            Integer[] arrayOfBytes = new Integer[arrayLength];
            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            
            for (int i = 0; i < arrayLength; i++) {
                arrayOfBytes[i]=0;
            }

            for (int i = 0; i < bFile.length; i++) {
                arrayOfBytes[bFile[i]+128]+=1;
            }
            for (int i = 0; i < arrayOfBytes.length; i++) {
                map.put(i, arrayOfBytes[i]);
            }
            System.out.println("Byte=Counts");
            map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}