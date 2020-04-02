import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class PersistenciaMotoristas {
    private static final String SAMPLE_CSV_FILE_PATH = "motoristas.dat";

    public LinkedList<Motoristas> carregaMotoristas() throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH)); CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);) { 
            LinkedList<Motoristas> listMotorista = new LinkedList<Motoristas>(); 
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String CPF = csvRecord.get(0);
                String Nome = csvRecord.get(1);
                String veic = csvRecord.get(2);
                FormaPGTO FormaPgto;
                switch(csvRecord.get(3)){
                    case "TODAS": 
                        FormaPgto = FormaPGTO.TODAS;
                        break;
                    case "CARTAO":
                        FormaPgto = FormaPGTO.CARTAO;
                        break;
                    default: 
                        FormaPgto = FormaPGTO.DINHEIRO;
                        break;             
                }
                listMotorista.add(new Motoristas(CPF, Nome, veic, FormaPgto));
            }
            return listMotorista;
        }
    }

    public void persisteMotoristas(LinkedList<Motoristas> list) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH)); CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("cpf", "nome", "veiculo", "formaPGTO"));){
            LinkedList<Motoristas> listOriginal= carregaMotoristas(); 
            if(list.size()>listOriginal.size()){
                for(int i= 1; i<list.size(); i++){
                    Motoristas helper= list.get(i);
                    csvPrinter.printRecord(helper.getCPF(), helper.getNome(), helper.getVeic(), helper.getF());
                }
                csvPrinter.flush();
            }
} 
}
}