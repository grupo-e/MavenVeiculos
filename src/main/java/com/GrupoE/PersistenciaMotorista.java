import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PersistenciaMotorista {
    
    List<Veiculo> pers;
    private static final String SAMPLE_CSV_FILE_PATH = "motoristas.dat";
    String path;

    public PersistenciaMotorista (String path){

        pers = new LinkedList<Veiculo>();
        this.path = path;
        try {
            carregaVeiculo();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void carregaVeiculo () throws IOException {
        
        try (

            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

        ) {

            for (CSVRecord csvRecord : csvParser) {

                String nome = csvRecord.get(0);
                String cpf = csvRecord.get(1);                
                Veiculo veiculo = csvRecord.get(2);

                pers.add(new Motorista(nome,cpf,veiculo));
                
            }

        }  

    }

    public Boolean persisteVeiculo(List<Veiculo> aux) {

        File dir = new File(path);
        File arq = new File(dir, "motoristas.dat");

        try {

            arq.createNewFile();

            FileWriter fileWriter = new FileWriter(arq, false);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Veiculo v : aux) {

                printWriter.println(v);

            }

            printWriter.flush();

            printWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
            return false;

        }

        return true;

    }

}