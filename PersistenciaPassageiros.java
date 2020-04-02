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

public class PersistenciaPassageiros {
    private static final String SAMPLE_CSV_FILE_PATH = "Passageiros.dat";

    public LinkedList<Passageiros> carregaPassageiros() throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH)); CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);) { 
            LinkedList<Passageiros> listPassageiros = new LinkedList<Passageiros>(); 
            for (CSVRecord csvRecord : csvParser) {

                String CPF = csvRecord.get(0);
                String Nome = csvRecord.get(1);
                String cartao = csvRecord.get(2);
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
                } listPassageiros.add(new Passageiros(CPF, Nome, cartao, FormaPgto));
            }
            return listPassageiros;
        }
    }


    public void persistePassageiros(LinkedList<Passageiros> list) throws IOException {
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH)); CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("cpf", "nome", "cartao", "formaPGTO"));){
                LinkedList<Passageiros> listOriginal= carregaPassageiros(); 
                if(list.size()>listOriginal.size()){
                    for(int i= 1; i<list.size(); i++){
                        Passageiros helper= list.get(i);
                        csvPrinter.printRecord(helper.getCPF(), helper.getCartao(), helper.getNome(), helper.getFormaPGTO());
                    }
                    csvPrinter.flush();
                }
    } 
}
}