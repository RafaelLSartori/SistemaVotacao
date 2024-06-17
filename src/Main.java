import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Metodos m = new Metodos();

        Votacao votacao[] = new Votacao[200];

        for (int i = 0; i < 200; i++){
            votacao[i] = new Votacao();
        }

        int opc = 0;
        int opc4 = 0;

        while (opc != 9){
            opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar voto \n 2 - Cassificar os registros \n 3 - Gravar dados \n 4 - Mostrar indicadores \n 5 - Ler dados salvos \n 9 - FIM"  ));
            switch (opc){
                case 1: votacao = m.FCADASTRAVOTACAO(votacao);
                    break;
                case 2: votacao = m.FCLASSIFICASECAO(votacao);
                    break;
                case 3: votacao = m.FGRAVAVOTACAO(votacao);
                    break;
                case 4: while (opc4 != 9){
                    opc4 = Integer.parseInt(JOptionPane.showInputDialog("1 - Qtd eleitores p/ seção \n 2 - Nº seção com M M \n 3 - Qtd de votos p/ can \n 4 - 10 mais votados \n 9 - FIM"));
                    switch (opc4){
                        case 1: m.PQTDELEITORESPORSECAO(votacao);
                            break;
                        case 2: m.NUMSECAOCOMMAIOREMENORELEITORES(votacao);
                            break;
                        case 3: m.VOTOSPORCANDIDATOS(votacao);
                            break;
                        case 4: m.DEZCANDIDATOSMAISVOTADOS();
                            break;
                        case 9: JOptionPane.showMessageDialog(null,"FIM");
                            break;
                        default: JOptionPane.showMessageDialog(null,"INVÁLIDO");
                    }
                }
                case 5: m.FLERVOTACAO();
                    break;
                case 9: JOptionPane.showMessageDialog(null,"FIM");
                    break;
                default: JOptionPane.showMessageDialog(null,"INVÁLIDO");
            }
        }
    }
}