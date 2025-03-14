package br.com.estudos.screenmatch.calculos;

public class Recomendacao {

    public void filtrarClassificacao(Classificacao classificacao) {
        if (classificacao.getClassificacao() > 4) {
            System.out.println("Está entre os preferidos!");
        } else if (classificacao.getClassificacao() >= 2) {
            System.out.println("Muito bem avaliado!");
        } else {
            System.out.println("Adicione a sua lista para depois!");
        }
    }
}
