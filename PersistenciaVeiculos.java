import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class PersistenciaVeiculos {
    private static final String SAMPLE_CSV_FILE_PATH = "veiculos.dat";

    public LinkedList<Veiculos> carregaVeiculos() throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH)); CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);) { 
            LinkedList<Veiculos> listVeiculos = new LinkedList<Veiculos>(); 
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String placa = csvRecord.get(0);
                String marca = csvRecord.get(1);
                String cor = csvRecord.get(2);
                String categoria = csvRecord.get(3);

                listVeiculos.add(new Veiculos(placa, marca, cor, categoria));
            }
            return listVeiculos;
        }
    }

    public void persisteVeiculos(LinkedList<Veiculos> list) throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH)); CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);){
            
        }
    } 
}
  
