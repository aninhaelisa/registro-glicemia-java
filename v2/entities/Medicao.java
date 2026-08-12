package v2.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Medicao extends GerenciadorArquivos {
    private Double glicemia;
    private LocalTime hora;
    private LocalDate data;
    private String observacao;

    public Medicao() {
    }

    public Medicao(Double glicemia, LocalTime hora, LocalDate data, String observacao, String nomeArquivo) {
        super(nomeArquivo);
        this.glicemia = glicemia;
        this.hora = hora;
        this.data = data;
        this.observacao = observacao;

    }

    public void covertendoHoraData(String data, String hora) {
        DateTimeFormatter formatterdata = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterhora = DateTimeFormatter.ofPattern("HH:mm");
        this.data = LocalDate.parse(data, formatterdata);
        this.hora = LocalTime.parse(hora, formatterhora);

        meuToString(this.data, this.hora);
    }

    public void media(){
        
        try(BufferedReader br = new BufferedReader(new FileReader(super.getNomeArquivo() + ".csv"))) {
            String line;
            double soma = 0;
            int count = 0;

            String linhaCabecalho = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length > 0) {
                    try {
                        double glicemia = Double.parseDouble(values[0]);
                        soma += glicemia;
                        count++;
                    } catch (NumberFormatException e) {
                        System.out.println("Erro ao converter glicemia para número: " + e.getMessage());
                    }
                }
            }
            if (count > 0) {
                double media = soma / count;
                System.out.printf("%.2f mg/dL\n", media);
            } else {
                System.out.println("Nenhuma medição encontrada para calcular a média.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV para calcular a média: " + e.getMessage());
        }
    }

    public String meuToString(LocalDate data, LocalTime hora) {
        return String.format("Glicemia: %.2f | Data: %s | Hora: %s | Observação: %s", glicemia, data, hora, observacao);
    }

    public Double getGlicemia() {
        return glicemia;
    }

    public void setGlicemia(double glicemia) {
        this.glicemia = glicemia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
