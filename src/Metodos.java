import javax.swing.*;
import java.util.Random;
import java.io.*;

public class Metodos {

    Random random = new Random();
    int qtdEleitores[] = new int[10];
    int[] qtdCandidatos = new int[300];
    public Votacao[] FCADASTRAVOTACAO(Votacao[] votacao){
        for (int i = 0; i < 200; i++){
            votacao[i].numeroSecao = random.nextInt(10);
            votacao[i].numeroCandidato = random.nextInt(300);
        }
        return votacao;
    }

    public Votacao[] FCLASSIFICASECAO(Votacao[] votacao){
        for (int i = 0; i < 199; i++){
            for (int j = (i+1); j < 200; j++){
                if (votacao[i].numeroSecao > votacao[j].numeroSecao){
                    int aux = votacao[i].numeroSecao;
                    votacao[i].numeroSecao = votacao[j].numeroSecao;
                    votacao[j].numeroSecao = aux;
                }
            }
        }
        return votacao;
    }

    public Votacao[] FGRAVAVOTACAO(Votacao[] votacao) throws IOException{

        String fileName = "Votação2021.txt";
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));

        for (int i = 0; i < 200; i++){
            gravar.write(Integer.toString(votacao[i].numeroSecao));
            gravar.newLine();
            gravar.write(Integer.toString(votacao[i].numeroCandidato));
            gravar.newLine();
        }

        JOptionPane.showMessageDialog(null, "ARQUIVO GERADO");
        gravar.close();

        return votacao;
    }

    public void PQTDELEITORESPORSECAO(Votacao[] votacao){
        for (int i = 0; i < 200; i++){
            qtdEleitores[votacao[i].numeroSecao]++;
        }
        for (int i = 0; i < 10; i++){
            System.out.println("A quantidade de eleitores na Seção" +(i+1)+ "é: " + qtdEleitores[i]);
        }
    }
    public void NUMSECAOCOMMAIOREMENORELEITORES(Votacao[] votacao) {
        int menor = 9999, maior = 0, menorI = 0, maiorI = 0;
        for (int i = 0; i < 10; i++) {
            if (qtdEleitores[i] > maior){
                maior = qtdEleitores[i];
                maiorI = i;
            }
            if (qtdEleitores[i] < menor){
                menor = qtdEleitores[i];
                menorI = i;
            }
        }
        System.out.println("A seção com maior número de eleitores foi: " + maior + "\nA seção com menor número de eleitores foi: " + menor);
    }
    public void VOTOSPORCANDIDATOS (Votacao[] votacao){
        for(int i = 0; i < 200; i++){
            qtdCandidatos[votacao[i].numeroCandidato]++;
        }

        for(int i = 0; i < 300; i++){
            System.out.println("A quantidade de votos do candidato de número " +(i + 1)+ " é: " +qtdCandidatos[i]);
        }
    }

    public void DEZCANDIDATOSMAISVOTADOS (){
        int[][] mat = new int[2][300];

        for(int i = 0; i < 300; i++){
            mat[0][i] = i+1;
            mat[1][i] = qtdCandidatos[i];
        }

        for(int i = 0; i < 299; i++){
            for(int j = (i+1); j < 300; j++) {
                if (mat[1][i] < mat[1][j]) {
                    int aux = mat[1][i];
                    mat[1][i] = mat[1][j];
                    mat[1][j] = aux;

                    aux = mat[0][i];
                    mat[0][i] = mat[0][j];
                    mat[0][j] = aux;
                }
            }
        }

        for(int j = 0; j < 10; j++){
            System.out.println((j+1)+ "- Candidato de número " +mat[0][j]+ " com " +mat[1][j]+ " votos.");
        }


    }
}

