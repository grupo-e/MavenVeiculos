import java.util.ArrayList;
import java.util.List;

public class ControleVeiculo {

    PersistenciaVeiculos pers;

    public ControleVeiculo (){

        pers = new PersistenciaVeiculos("C:\\Users\\jayja\\Desktop");

    }

    public Veiculo getVeiculo (String placa){

        for(Veiculo v : pers.cars){
            if (v.getPlaca().equals(placa)){
                return v;
            }
        }
        return null;
    }

    public List<Veiculo> getVeiculo (Veiculo.CategoriaVeiculo categoria){

        List<Veiculo> aux = new ArrayList();
        for(Veiculo v : pers.cars){
            if(v.getCategoria() == categoria){
                aux.add(v);
            }
        }
        return aux;
    }

    public List<Veiculo> getTodosVeiculos (){

        return pers.cars;

    }



}