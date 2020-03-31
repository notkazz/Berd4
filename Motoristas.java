import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Motoristas {
    private String CPF,Nome,veic,formapgmt;

    public Motoristas(String CPF, String Nome, Veiculos veic, forma pgmt){
        this.CPF = CPF;
        this.veic = veic;
        //this.formPgmt = Formpgmt;
        this.Nome = Nome;
    }
    
    public String getCPF() {
        return CPF;
    }

    public String getveic() {
        return veic;
    }
    
   /* public String getFormPgmt() {
        return cor;
    }
    */

    public String getNome() {
        return Nome;
    }
}
