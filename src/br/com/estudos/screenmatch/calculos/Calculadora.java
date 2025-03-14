package br.com.estudos.screenmatch.calculos;

import br.com.estudos.screenmatch.model.Titulo;

public class Calculadora {
    private int tempoTotal;

    public void adicionar(Titulo titulo){
        tempoTotal += titulo.getDuracao();
    }

    public int getTempoTotal() {
        return tempoTotal;
    }
}
