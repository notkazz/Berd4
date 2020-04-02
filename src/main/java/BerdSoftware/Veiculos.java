package BerdSoftware;

/*
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
*/

public class Veiculos {
    private String placa,categoria,marca,cor;

    public Veiculos(String placa, String marca, String cor, String categoria){
        this.placa = placa;
        this.marca = marca;
        this.cor = cor;
        this.categoria = categoria;
    }
    
    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }
    
    public String getCor() {
        return cor;
    }

    public String getCategoria() {
        return categoria;
    }
}
