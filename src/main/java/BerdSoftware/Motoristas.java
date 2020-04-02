package BerdSoftware;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Motoristas {
    private String CPF,Nome,veic;
    private FormaPGTO FormaPGTO;


    public Motoristas(String CPF, String Nome, String veic, FormaPGTO FormaPGTO){
        this.CPF = CPF;
        this.veic = veic;
        this.FormaPGTO = FormaPGTO;
        this.Nome = Nome;
    }
    
    public String getCPF() {
        return CPF;
    }

    public String getVeic() {
        return veic;
    }
    
    public FormaPGTO getF() {
        return FormaPGTO;
    }

    public String getNome() {
        return Nome;
    }
}
