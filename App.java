import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class App {

    static Scanner sc = new Scanner(System.in);
    static final String ARQUIVO = "glicemia.txt";
    static DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    static DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n==============================");
            System.out.println("   CONTROLE DE GLICEMIA");
            System.out.println("==============================");
            System.out.println("1 - Adicionar medição");
            System.out.println("2 - Ver todas as medições");
            System.out.println("3 - Ver maior glicemia");
            System.out.println("4 - Ver menor glicemia");
            System.out.println("5 - Ver dia com maior média");
            System.out.println("6 - Ver dia com menor média");
            System.out.println("7 - Ver hora com maior média");
            System.out.println("8 - Ver hora com menor média");
            System.out.println("9 - Buscar medições por dia");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    adicionarMedicao();
                    break;
                case 2:
                    listarMedicoes();
                    break;
                case 3:
                    mostrarMaior();
                    break;
                case 4:
                    mostrarMenor();
                    break;
                case 5:
                    diaMaiorMedia();
                    break;
                case 6:
                    diaMenorMedia();
                    break;
                case 7:
                    horaMaiorMedia();
                    break;
                case 8:
                    horaMenorMedia();
                    break;
                case 9:
                    buscarPorDia();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }

    // =========================
    // CLASSE MEDICAO
    // =========================
    static class Medicao {
        int glicemia;
        LocalDateTime dataHora;

        public Medicao(int glicemia, LocalDateTime dataHora) {
            this.glicemia = glicemia;
            this.dataHora = dataHora;
        }

        @Override
        public String toString() {
            return "Glicemia: " + glicemia + " mg/dL | Data/Hora: " + dataHora.format(formatoDataHora);
        }

        public String paraArquivo() {
            return glicemia + ";" + dataHora.toString();
        }

        public static Medicao deArquivo(String linha) {
            String[] partes = linha.split(";");
            int glicemia = Integer.parseInt(partes[0]);
            LocalDateTime dataHora = LocalDateTime.parse(partes[1]);
            return new Medicao(glicemia, dataHora);
        }
    }

    // =========================
    // ADICIONAR MEDIÇÃO
    // =========================
    public static void adicionarMedicao() {
        System.out.print("Digite o valor da glicemia (mg/dL): ");
        int glicemia = sc.nextInt();
        sc.nextLine();

        System.out.print("Deseja usar data e hora atuais? (s/n): ");
        String resp = sc.nextLine();

        LocalDateTime dataHora;

        if (resp.equalsIgnoreCase("s")) {
            dataHora = LocalDateTime.now();
        } else {
            System.out.print("Digite a data (dd/MM/yyyy): ");
            String dataTexto = sc.nextLine();
            System.out.print("Digite a hora (HH:mm): ");
            String horaTexto = sc.nextLine();

            LocalDate data = LocalDate.parse(dataTexto, formatoData);
            LocalTime hora = LocalTime.parse(horaTexto, formatoHora);
            dataHora = LocalDateTime.of(data, hora);
        }

        Medicao medicao = new Medicao(glicemia, dataHora);
        salvarNoArquivo(medicao);
        System.out.println("Medição salva com sucesso!");
    }

    // =========================
    // SALVAR NO TXT
    // =========================
    public static void salvarNoArquivo(Medicao medicao) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO, true))) {
            bw.write(medicao.paraArquivo());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo.");
        }
    }

    // =========================
    // LER TODAS AS MEDIÇÕES
    // =========================
    public static ArrayList<Medicao> lerMedicoes() {
        ArrayList<Medicao> lista = new ArrayList<>();

        File arquivo = new File(ARQUIVO);
        if (!arquivo.exists()) {
            return lista;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                lista.add(Medicao.deArquivo(linha));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
        }

        return lista;
    }

    // =========================
    // LISTAR TODAS
    // =========================
    public static void listarMedicoes() {
        ArrayList<Medicao> lista = lerMedicoes();

        if (lista.isEmpty()) {
            System.out.println("Nenhuma medição encontrada.");
            return;
        }

        System.out.println("\n--- TODAS AS MEDIÇÕES ---");
        for (Medicao m : lista) {
            System.out.println(m);
        }
    }

    // =========================
    // MAIOR
    // =========================
    public static void mostrarMaior() {
        ArrayList<Medicao> lista = lerMedicoes();

        if (lista.isEmpty()) {
            System.out.println("Nenhuma medição encontrada.");
            return;
        }

        Medicao maior = lista.get(0);

        for (Medicao m : lista) {
            if (m.glicemia > maior.glicemia) {
                maior = m;
            }
        }

        System.out.println("\n--- MAIOR GLICEMIA ---");
        System.out.println(maior);
    }

    // =========================
    // MENOR
    // =========================
    public static void mostrarMenor() {
        ArrayList<Medicao> lista = lerMedicoes();

        if (lista.isEmpty()) {
            System.out.println("Nenhuma medição encontrada.");
            return;
        }

        Medicao menor = lista.get(0);

        for (Medicao m : lista) {
            if (m.glicemia < menor.glicemia) {
                menor = m;
            }
        }

        System.out.println("\n--- MENOR GLICEMIA ---");
        System.out.println(menor);
    }

    // =========================
    // DIA COM MAIOR MÉDIA
    // =========================
    public static void diaMaiorMedia() {
        ArrayList<Medicao> lista = lerMedicoes();

        if (lista.isEmpty()) {
            System.out.println("Nenhuma medição encontrada.");
            return;
        }

        HashMap<LocalDate, ArrayList<Integer>> mapa = new HashMap<>();

        for (Medicao m : lista) {
            LocalDate dia = m.dataHora.toLocalDate();
            mapa.putIfAbsent(dia, new ArrayList<>());
            mapa.get(dia).add(m.glicemia);
        }

        LocalDate melhorDia = null;
        double maiorMedia = -1;

        for (LocalDate dia : mapa.keySet()) {
            ArrayList<Integer> valores = mapa.get(dia);
            double soma = 0;

            for (int v : valores) {
                soma += v;
            }

            double media = soma / valores.size();

            if (media > maiorMedia) {
                maiorMedia = media;
                melhorDia = dia;
            }
        }

        System.out.println("\n--- DIA COM MAIOR MÉDIA ---");
        System.out.println("Dia: " + melhorDia.format(formatoData));
        System.out.printf("Média: %.2f mg/dL%n", maiorMedia);
    }

    // =========================
    // DIA COM MENOR MÉDIA
    // =========================
    public static void diaMenorMedia() {
        ArrayList<Medicao> lista = lerMedicoes();

        if (lista.isEmpty()) {
            System.out.println("Nenhuma medição encontrada.");
            return;
        }

        HashMap<LocalDate, ArrayList<Integer>> mapa = new HashMap<>();

        for (Medicao m : lista) {
            LocalDate dia = m.dataHora.toLocalDate();
            mapa.putIfAbsent(dia, new ArrayList<>());
            mapa.get(dia).add(m.glicemia);
        }

        LocalDate piorDia = null;
        double menorMedia = Double.MAX_VALUE;

        for (LocalDate dia : mapa.keySet()) {
            ArrayList<Integer> valores = mapa.get(dia);
            double soma = 0;

            for (int v : valores) {
                soma += v;
            }

            double media = soma / valores.size();

            if (media < menorMedia) {
                menorMedia = media;
                piorDia = dia;
            }
        }

        System.out.println("\n--- DIA COM MENOR MÉDIA ---");
        System.out.println("Dia: " + piorDia.format(formatoData));
        System.out.printf("Média: %.2f mg/dL%n", menorMedia);
    }

    // =========================
    // HORA COM MAIOR MÉDIA
    // =========================
    public static void horaMaiorMedia() {
        ArrayList<Medicao> lista = lerMedicoes();

        if (lista.isEmpty()) {
            System.out.println("Nenhuma medição encontrada.");
            return;
        }

        HashMap<Integer, ArrayList<Integer>> mapa = new HashMap<>();

        for (Medicao m : lista) {
            int hora = m.dataHora.getHour();
            mapa.putIfAbsent(hora, new ArrayList<>());
            mapa.get(hora).add(m.glicemia);
        }

        int melhorHora = -1;
        double maiorMedia = -1;

        for (int hora : mapa.keySet()) {
            ArrayList<Integer> valores = mapa.get(hora);
            double soma = 0;

            for (int v : valores) {
                soma += v;
            }

            double media = soma / valores.size();

            if (media > maiorMedia) {
                maiorMedia = media;
                melhorHora = hora;
            }
        }

        System.out.println("\n--- HORA COM MAIOR MÉDIA ---");
        System.out.printf("Hora: %02d:00%n", melhorHora);
        System.out.printf("Média: %.2f mg/dL%n", maiorMedia);
    }

    // =========================
    // HORA COM MENOR MÉDIA
    // =========================
    public static void horaMenorMedia() {
        ArrayList<Medicao> lista = lerMedicoes();

        if (lista.isEmpty()) {
            System.out.println("Nenhuma medição encontrada.");
            return;
        }

        HashMap<Integer, ArrayList<Integer>> mapa = new HashMap<>();

        for (Medicao m : lista) {
            int hora = m.dataHora.getHour();
            mapa.putIfAbsent(hora, new ArrayList<>());
            mapa.get(hora).add(m.glicemia);
        }

        int piorHora = -1;
        double menorMedia = Double.MAX_VALUE;

        for (int hora : mapa.keySet()) {
            ArrayList<Integer> valores = mapa.get(hora);
            double soma = 0;

            for (int v : valores) {
                soma += v;
            }

            double media = soma / valores.size();

            if (media < menorMedia) {
                menorMedia = media;
                piorHora = hora;
            }
        }

        System.out.println("\n--- HORA COM MENOR MÉDIA ---");
        System.out.printf("Hora: %02d:00%n", piorHora);
        System.out.printf("Média: %.2f mg/dL%n", menorMedia);
    }

    // =========================
    // BUSCAR POR DIA
    // =========================
    public static void buscarPorDia() {
        ArrayList<Medicao> lista = lerMedicoes();

        if (lista.isEmpty()) {
            System.out.println("Nenhuma medição encontrada.");
            return;
        }

        System.out.print("Digite a data que deseja buscar (dd/MM/yyyy): ");
        String dataTexto = sc.nextLine();
        LocalDate dataBusca = LocalDate.parse(dataTexto, formatoData);

        boolean encontrou = false;

        System.out.println("\n--- MEDIÇÕES DO DIA " + dataBusca.format(formatoData) + " ---");
        for (Medicao m : lista) {
            if (m.dataHora.toLocalDate().equals(dataBusca)) {
                System.out.println(m);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma medição encontrada nesse dia.");
        }
    }
}