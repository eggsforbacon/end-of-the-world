import java.io.*;

public class Main {

    private static String baseConfiguration;
    private static final String IO_PATH = "src/output/output.txt";

    public static void main(String[] args) throws IOException{
        FileOutputStream fileOS = new FileOutputStream(IO_PATH);
        PrintStream printer = new PrintStream(fileOS);
        BufferedReader jIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter jOut = new BufferedWriter(new OutputStreamWriter(System.out));
        clear();
        System.out.println("-Ingresar un numero N (numero de entradas), pulsar [ENTER], e ir aniadiendo entradas\n-hasta haber presionado [ENTER] N veces:");
        String solution = readInput(jIn, jOut);
        clear();
        printer.print(solution);
        jOut.write("-La solucion queda guardada en " + IO_PATH);

        jIn.close();
        jOut.close();
    }

    public static void solve(int disks, int[] set, int from, int to, int rest) {
        if (disks == 1) {
            set[from]--;
            set[to]++;
            baseConfiguration += set[0] + " " + set[1] + " " + set[2] + "\n";
        }
        else {
            solve(disks - 1, set, from, rest, to);
            set[from]--;
            set[to]++;
            baseConfiguration += set[0] + " " + set[1] + " " + set[2] + "\n";
            solve(disks - 1, set, rest, to, from);
        }
    }

    private static String readInput(BufferedReader jIn, BufferedWriter jOut) throws IOException {
        StringBuilder solution = new StringBuilder();
        int cases = Integer.parseInt(jIn.readLine());
        int disks;

        for(int i = 0; i < cases; i++){
            disks = Integer.parseInt(jIn.readLine());
            int[] towers= {disks,0,0};
            baseConfiguration = disks + " " + 0 + " " + 0 + "\n";
            solve(disks,towers, 0, 2, 1);
            solution.append(baseConfiguration).append("\n");
        }

        return solution.toString();
    }

    private static void clear() {
        try {
            final String OS = System.getProperty("os.name");
            if (OS.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            System.out.println("Screen could not be cleared (" + e + ")\n");
        }
    }
}