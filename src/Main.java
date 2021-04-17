import java.io.*;

public class Main {

    private static int disks = 0;
    private static String baseConfiguration = "0 0 0";
    private static final String OUTPUT_PATH = "src/output/output.txt";

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOS = new FileOutputStream(OUTPUT_PATH);
        PrintStream printer = new PrintStream(fileOS);

        readInput();
    }

    public static void readInput() throws IOException {
        BufferedReader jIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter jOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(jIn.readLine());
        StringBuilder input = new StringBuilder();

        for (int i = 0; i < cases; i++) {
            input.append(jIn.readLine()).append(" ");
        }

        jOut.write(input.toString());

        jIn.close();
        jOut.close();
    }
}
