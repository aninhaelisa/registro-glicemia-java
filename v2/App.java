package v2;

import java.util.Locale;
import java.util.Scanner;

import v2.entities.GerenciadorArquivos;
import v2.entities.Medicao;

public class App {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Medicao medicao = new Medicao();
        GerenciadorArquivos gerenciadorArquivos = new GerenciadorArquivos();

        int op = -1;

        try {

            while (op != 0) {
                System.out.println("------------------------- Controle de glicemia ------------------------------");
                System.out.println("1 - Adicionar medição   |   2 - Listar medições  |   3 - Média             ");
                System.out.println("4 - Hora/Data ranking   |   5 - Buscar           |   6 - Remover medição   ");
                System.out.println("0 - Sair                |");
                System.out.print("> ");
                op = sc.nextInt();

                sc.nextLine();

                switch (op) {
                    case 1:
                        System.out.println("Adicionando medição...");
                        System.out.print("Hora (hh:mm): ");
                        String hora = sc.nextLine();
                        System.out.print("Data (dd/mm/aaaa): ");
                        String data = sc.nextLine();
                        System.out.print("Glicemia: ");
                        double glicemia = sc.nextDouble();
                        sc.nextLine();
                        try {
                            System.out.println("Adcionar observação? (s/n): ");
                            String obs = sc.nextLine();
                            if (obs.equalsIgnoreCase("s")) {
                                System.out.print("Observação: ");
                                String observacao = sc.nextLine();
                                medicao.setObservacao(observacao);
                                System.out.println("Observação adicionada com sucesso!");
                            } else if (obs.equalsIgnoreCase("n")) {
                                medicao.setObservacao("Sem observação");
                            } else {
                                System.out.println("Opção inválida. Observação não adicionada.");
                                medicao.setObservacao("Sem observação");
                            }
                        } catch (Exception e) {
                            System.out.println("Erro ao adicionar observação: " + e.getMessage());
                        }

                        medicao.covertendoHoraData(data, hora);
                        medicao.setGlicemia(glicemia);
                        System.out.println(medicao.meuToString(medicao.getData(), medicao.getHora()));

                        String[] linhaCSV = { String.valueOf(glicemia), data, hora, medicao.getObservacao() };
                        String linhaTXT = medicao.meuToString(medicao.getData(), medicao.getHora());
                        
                        gerenciadorArquivos.escrevendoArquivoTXT(linhaTXT);
                        gerenciadorArquivos.escrevendoArquivoCSV(linhaCSV);
                        break;

                    case 2:
                        System.out.println("Lendo arquivos...");
                        System.out.println("Quer ler arquivo TXT ou CSV? (txt/csv): ");
                        String tipoArquivo = sc.nextLine();
                        if (tipoArquivo.equalsIgnoreCase("txt")) {
                            gerenciadorArquivos.lendoArquivoTXT();
                        } else if (tipoArquivo.equalsIgnoreCase("csv")) {
                            gerenciadorArquivos.lendoArquivoCSV();
                            
                        } else {
                            System.out.println("Opção inválida. Voltando ao menu.");
                        }
                    
                        break;
                    
                    case 3:
                        System.out.print("Média glicêmica: ");
                        medicao.media();

                        break;
                    case 0:
                        System.out.println("Saindo...");
                        for (int i = 0; i < 10; i++) {
                            System.out.print("||");
                            Thread.sleep(700);
                        }
                        System.out.println("Programa encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida");
                        break;
                }

            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        sc.close();
    }
}