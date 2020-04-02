package BerdSoftware;

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
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH)); CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("placa", "marca", "cor", "categoria"));){
            LinkedList<Veiculos> listOriginal= carregaVeiculos();
            if(list.size()>listOriginal.size()){
                for(int i= 1; i<list.size(); i++){
                    Veiculos helper= list.get(i);
                    csvPrinter.printRecord(helper.getPlaca(), helper.getMarca(), helper.getCor(), helper.getCategoria());
                }
                csvPrinter.flush();
            }
        }
    } 
}
  
