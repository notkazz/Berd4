import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class PersistenciaMotoristas {
    private static final String SAMPLE_CSV_FILE_PATH = "veiculos.dat";

    public LinkedList<Motoristas> carregaMotoristas() throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH)); CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);) { 
            LinkedList<Motoristas> listMotorista = new LinkedList<Motoristas>(); 
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String CPF = csvRecord.get(0);
                String Nome = csvRecord.get(1);
                //get Veiculo;
                //get forma pagamento[];

                listMotorista.add(new Motoristas(CPF, Nome, veic, FormPgtoa));
            }
            return listMotorista;
        }
    }

    public void persisteMotoristas(LinkedList<Motoristas> list) throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH)); CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);){
            
        }
    } 
}