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

public class PersistenciaVeiculos {
    
    List<Veiculo> cars;
    private static final String SAMPLE_CSV_FILE_PATH = "veiculos.dat";
    String path;

    public PersistenciaVeiculos (String path){

        cars = new LinkedList<Veiculo>();
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

                String placa = csvRecord.get(0);
                String marca = csvRecord.get(1);
                String cor = csvRecord.get(2);
                Veiculo.CategoriaVeiculo categoria = csvRecord.get(3);

                cars.add(new Veiculo(placa, marca, cor, categoria));
                
            }

        }        


            
        

    }

    public Boolean persisteVeiculo(List<Veiculo> aux) {

        File dir = new File(path);
        File arq = new File(dir, "veiculo.dat");

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