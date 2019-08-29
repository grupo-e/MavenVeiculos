public class Passageiro{
    private String cpf;
    private String nome;
    private String nroCartao;
    private double pontuacaoMedia;
    private List<Double> pontuacaols; 
    public FormaPagamento forPag;

    public enum FormaPagamento{
        DINHEIRO,CARTAO,TODAS;
    }

    public Passageiro (String nome, String cpf, String nroCartao) {

        this.nome = nome;
        this.cpf = cpf;
        this.nroCartao = nroCartao;
        pontuacao = new LinkedList<>();

    }

    public String getNome(){
        return nome;
    }

    public FormaPagamento getFormaPagamento(){
        return forPag;
    }

    public String getNroCartao(){
        return nroCartao;
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