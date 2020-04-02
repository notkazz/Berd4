package BerdSoftware;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Passageiros {
    private String CPF,Nome,cartao;
    private FormaPGTO FormaPGTO;


    public Passageiros(String CPF, String Nome, String cartao, FormaPGTO FormaPGTO){
        this.CPF = CPF;
        this.cartao = cartao;
        this.FormaPGTO = FormaPGTO;
        this.Nome = Nome;
    }
    
    public String getCPF() {
        return CPF;
    }

    public String getCartao() {
        return cartao;
    }
    
   public FormaPGTO getFormaPGTO() {
        return FormaPGTO;
    }

    public String getNome() {
        return Nome;
    }
}
