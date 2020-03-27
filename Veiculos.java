import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Veiculos {
    private String placa,categoria,marca,cor ;
    
    public Veiculos(String placa, String marca, String cor, String Categoria)
    {
        this.placa = placa;
        this.marca = marca;
        this.cor = cor;
        this.categoria = categoria;

    }

    public String gitTest(){
        return "Teste bem succedido";
    }
    
    public String getPlaca() {
        placa = csvRecord.get(0);
        return placa;
    }

    public String getMarca() {
        marca = csvRecord.get(1);
        return marca;
    }
    
    public String getCor() {
        cor = csvRecord.get(2);
        return cor;
    }

    public String getCategoria() {
        categoria = csvRecord.get(3);
        return categoria;
    }
}
