package v2.entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorArquivos {
    private String nomeArquivo = "medicoes";
    private String extensaoArquivo;

    public GerenciadorArquivos() {
    }

    public GerenciadorArquivos(String nomeArquivo, String extensaoArquivo) {
        this.nomeArquivo = nomeArquivo;
        this.extensaoArquivo = extensaoArquivo;
    }

    public void escrevendoArquivoTXT(String line) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo + ".txt", true))) {
            bw.write(line);
            bw.newLine();
        } catch (Exception e) {
            System.out.println("Erro ao escrever no medicoes.txt: " + e.getMessage());
        }
    }

    public void escrevendoArquivoCSV(String[] line) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo + ".csv", true))) {
            bw.write(String.join(";", line));
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }

    


    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getExtensaoArquivo() {
        return extensaoArquivo;
    }

    public void setExtensaoArquivo(String extensaoArquivo) {
        this.extensaoArquivo = extensaoArquivo;
    }
}
