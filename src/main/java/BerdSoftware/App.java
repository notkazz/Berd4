package BerdSoftware;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

/*
Exemplo simples de uso da API Apache Commons CVS
Extrair o arquivo commons-csv-1.7.jar para o diretorio do projeto
Para compilar no Windows: javac -cp .;.\commons-csv-1.7.jar App.java
Para compilar no Linux: javac -cp commons-csv-1.7.jar App.java
Para executar no windows: java -cp .;.\commons-csv-1.7.jar App
Para executar no Linux: java -cp .:commons-csv-1.7.jar App
Para executar: java -cp .;.\commons-csv-1.7.jar App.java
*/
public class App {
    private static final String SAMPLE_CSV_FILE_PATH = "veiculos.dat";
    public static void main(String[] args) throws IOException {
        PersistenciaVeiculos persistVeic = new PersistenciaVeiculos();
        PersistenciaMotoristas persistMotor = new PersistenciaMotoristas();
        PersistenciaPassageiros persistPass = new PersistenciaPassageiros();
        LinkedList<Veiculos> list = persistVeic.carregaVeiculos();
        LinkedList<Motoristas> motora = persistMotor.carregaMotoristas();
        LinkedList<Passageiros> passa = persistPass.carregaPassageiros();
        list.add(new Veiculos("ABC123", "TawisMobile", "LapisLazuli", "LUX"));
        list.add(new Veiculos("BCA321", "Hiram'sSpaceBender", "Sadness", "TELEPORTATION"));
        motora.add(new Motoristas("Keppo", "Veppo", "Neppo", FormaPGTO.TODAS));
        motora.add(new Motoristas("Ceppo", "Queppo", "Peppo", FormaPGTO.DINHEIRO));
        passa.add(new Passageiros("809123345", "OGRANDESERGIO", "8912", FormaPGTO.TODAS));
        passa.add(new Passageiros("321353345", "SALIBAJorge", "4272", FormaPGTO.CARTAO));
        persistVeic.persisteVeiculos(list);
        persistMotor.persisteMotoristas(motora);
        persistPass.persistePassageiros(passa);
        for (int i= 0; i<list.size(); i++){
            Veiculos vei = list.get(i);
            System.out.println("---Veiculos---");
            System.out.println("Placa : " + vei.getPlaca());
            System.out.println("Marca : " + vei.getMarca());
            System.out.println("Cor : " + vei.getCor());
            System.out.println("Categoria : " + vei.getCategoria());
            System.out.println("---------------\n\n");
        
        }
        for (int i= 0; i<motora.size(); i++){
            Motoristas mot = motora.get(i);
            System.out.println("---Motorista---");
            System.out.println("CPF : " + mot.getCPF());
            System.out.println("Nome : " + mot.getNome());
            System.out.println("PlacaVeiculo : " + mot.getVeic());
            System.out.println("FormaPGTO : " + mot.getF());
            System.out.println("---------------\n\n");
        }
        for(Passageiros pas: passa){
            System.out.println("---Passageiros---");
            System.out.println("CPF : " + pas.getCPF());
            System.out.println("Nome : " + pas.getNome());
            System.out.println("Cartao : " + pas.getCartao());
            System.out.println("FormaPGTO : " + pas.getFormaPGTO());
            System.out.println("---------------\n\n");
        }
    }

    public static void starter() throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH)); CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);) { 
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String placa = csvRecord.get(0);
                String marca = csvRecord.get(1);
                String cor = csvRecord.get(2);
                String categoria = csvRecord.get(3);

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Placa : " + placa);
                System.out.println("Marca : " + marca);
                System.out.println("Cor : " + cor);
                System.out.println("Categoria : " + categoria);
                System.out.println("---------------\n\n");
            }
        }
    }
}
