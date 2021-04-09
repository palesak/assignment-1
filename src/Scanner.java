import java.nio.file.*;
public class Scanner
{
    public static String readFileAsString(String fileName) throws Exception
    {
        String data;
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) throws Exception
    {
        String data = readFileAsString("../data/lastnames.txt");
        System.out.println(data);
    }
}


