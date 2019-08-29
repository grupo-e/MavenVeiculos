public class Motorista{
    private String cpf;
    private String nome;
    private Veiculo veiculo;
    private FormaPagamento forPag;
    private List<Double> pontuacaols;
    public enum FormaPagamento{
        DINHEIRO,CARTAO,TODAS;
    }
    public int pontuacaoMedia;

    public Motorista (String nome, String cpf, Veiculo veiculo) {

        this.nome = nome;
        this.cpf = cpf;
        this.veiculo = veiculo;
        pontuacaols = new LinkedList<>();

    }
    
    public String getCPF(){
        return cpf;
    }

    public String getNome(){
        return nome;
    }

    public Veiculo getVeiculo(){
        return veiculo;
    }

    public FormaPagamento getFormaPagamento(){
        return forPag;
    }

   public double getPontuacaoMedia(){

        double total = 0.0;

        for (double v : pontuacaols) {

            total+=v;

        }
        pontuacaoMedia = total/pontuacaols.size();
        return pontuacaoMedia;
    }

    public void infoPontuacao(int pontuacao){

        pontuacaols.add(pontuacao);

    }
}