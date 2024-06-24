import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        List<String> A = readFile("A");
        List<String> B = readFile("B");
        writeFile(A, B);
        List<String> dadosC = readFile("C");
        List<Pessoa> pessoas = new ArrayList<>();

        for (int i = 0; i < dadosC.size(); i++) {
            String[] C = dadosC.get(i).split(";");
            Pessoa pessoa = new Pessoa(C[0], C[1], C[2], C[3]);
            pessoas.add(pessoa);
        }
    }

    public static List<String> readFile(String name) throws FileNotFoundException {

        File file = new File("C:\\_ws\\SimuladoJv\\" + name + ".txt");
        Scanner lerFile = new Scanner(file);
        List<String> dados = new ArrayList<>();
        while (lerFile.hasNext()) {
            String aquivo = lerFile.nextLine();
            dados.add(aquivo);
        }

        lerFile.close();
        return dados;
    }

    public static void writeFile(List<String> dadosA, List<String> dadosB) throws IOException {

        FileWriter arquivoC = new FileWriter("C:\\_ws\\SimuladoJv\\C.txt");

        for (int i = 0; i < dadosA.size(); i++) {
            for (int j = 0; j < dadosB.size(); j++) {

                String[] pA = dadosA.get(i).split(";");
                String[] pB = dadosB.get(j).split(";");

                if (pA[0].equals(pB[2]))
                    arquivoC.write(dadosA.get(i) + ";" + dadosB.get(j));
            }
        }
        arquivoC.close();
    }
}