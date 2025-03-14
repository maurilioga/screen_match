package br.com.estudos.screenmatch.main;

import br.com.estudos.screenmatch.model.Filme;
import br.com.estudos.screenmatch.model.Serie;
import br.com.estudos.screenmatch.model.Titulo;

import java.util.ArrayList;

public class MainLists {

    public static void main(String[] args) {

        Filme shrek = new Filme("Shrek", 2001);
        shrek.avaliarFilme(10);

        Filme dune = new Filme("Dune", 2021);
        dune.avaliarFilme(8);

        Serie breakingBad = new Serie("Breaking Bad", 2008);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(shrek);
        lista.add(dune);
        lista.add(breakingBad);

        for (Titulo item : lista) {
            System.out.println(item.toString());

            if (item instanceof Filme filme) {
                System.out.println("Classificação do Filme: " + filme.getClassificacao());
            }
        }
    }
}
