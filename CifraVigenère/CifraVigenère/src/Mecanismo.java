import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Mecanismo {
    private String chaveCifra;

    public Mecanismo(String chave) {
        this.chaveCifra = chave;
    }

    public void executarCripto(String arquivoTexto, String arquivoCripto) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arquivoTexto));
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoCripto));

            StringBuilder buffer = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                buffer.append(linha).append("\n");
            }
            reader.close();

            VigenereCipher cifra = new VigenereCipher();
            String textoCriptografado = cifra.criptografar(buffer.toString(), chaveCifra);

            writer.write(textoCriptografado);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void executarDecripto(String entradaCripto, String saidaDecripto) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(entradaCripto));
            BufferedWriter writer = new BufferedWriter(new FileWriter(saidaDecripto));

            StringBuilder buffer = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                buffer.append(linha).append("\n");
            }
            reader.close();

            VigenereCipher cifra = new VigenereCipher();
            String textoDescriptografado = cifra.descriptografar(buffer.toString(), chaveCifra);

            writer.write(textoDescriptografado);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
