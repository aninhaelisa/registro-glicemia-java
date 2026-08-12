package v2.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Medicao {
    private Double glicemia;
    private LocalTime hora;
    private LocalDate data;
    private String observacao;

    public Medicao() {
    }

    public Medicao(Double glicemia, LocalTime hora, LocalDate data, String observacao) {
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
