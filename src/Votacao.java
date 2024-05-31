public class Votacao {
    int numeroSecao;
    int numeroCandidato;

    Votacao(){
        this(0,0);
    }

    Votacao(int numeroDaSecao, int numeroDoCandidato){
        numeroSecao = numeroDaSecao;
        numeroCandidato = numeroDoCandidato;
    }
}
