import java.io.*;

/**
 * Created by inti on 03/06/14.
 */
public class ReplaceVariable {
    public static void main(String[] args) {
        if (args != null && args.length == 3) {
            try {
                modify(new FileInputStream(args[0]), args[1], args[2]);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (args != null && args.length == 2) {
                modify(System.in, args[0], args[1]);
        }
    }

    private static void modify(InputStream input, String pattern, String replacement) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line = reader.readLine();
            while (line!=null) {
                System.out.println(line.replace(pattern,replacement));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
