public class Veiculo {

    public enum CategoriaVeiculo {

        SIMPLES,NORMAL,LUXO;

    }
    private String placa;
    private String marca;
    private String cor;
    private CategoriaVeiculo categoria;

    @Override
    public String toString() {
        return placa+" ,"+marca+" ,"+cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public CategoriaVeiculo getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaVeiculo categoria) {
        this.categoria = categoria;
    }

    public Veiculo(String placa, String marca, String cor, CategoriaVeiculo categoria) {
        this.placa = placa;
        this.marca = marca;
        this.cor = cor;
        this.categoria = categoria;
    }
}
