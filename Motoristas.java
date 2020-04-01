/*
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
*/

public class Motoristas {
    private String CPF,Nome,veic;
    private FormaPGTO formaPgto;

    public Motoristas(String CPF, String Nome, String veic, FormaPGTO formaPgto){
        this.CPF = CPF;
        this.veic = veic;
        this.formaPgto = formaPgto;
        this.Nome = Nome;
    }
    
    public String getCPF() {
        return CPF;
    }

    public String getVeic() {
        return veic;
    }
    
    public FormaPGTO getFormPgmt() {
        return formaPgto;
    }

    public String getNome() {
        return Nome;
    }
}
