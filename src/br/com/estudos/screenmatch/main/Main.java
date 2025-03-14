package br.com.estudos.screenmatch.main;

import br.com.estudos.screenmatch.calculos.Calculadora;
import br.com.estudos.screenmatch.calculos.Recomendacao;
import br.com.estudos.screenmatch.model.Episodio;
import br.com.estudos.screenmatch.model.Filme;
import br.com.estudos.screenmatch.model.Serie;
import br.com.estudos.screenmatch.model.Titulo;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        Filme filme = new Filme("Teste Filme", 2025);
        filme.setDuracao(120);

        filme.exibirFichaTecnica();

        filme.avaliarFilme(8);
        filme.avaliarFilme(10);
        filme.avaliarFilme(6);

        Filme filme1 = new Filme("Outro filme", 2025);
        filme1.setDuracao(80);

        calculadora.adicionar(filme);
        calculadora.adicionar(filme1);
        System.out.println("Tempo total para assistir aos filmes: " + calculadora.getTempoTotal());

        System.out.println("\nTotal de avaliações: " + filme.getTotalDeAvaliacoes());
        System.out.println("Avaliação do filme: " + filme.calcularMediaAvalicoes());

        Serie serie = new Serie("Serie Teste", 2025);
        serie.setTemporadas(5);
        serie.setEpisodios(12);
        serie.setDuracaoEpisodio(40);
        serie.exibirFichaTecnica();
        calculadora.adicionar(serie);
        System.out.println("Duração total da série: " + serie.getDuracao());
        System.out.println("Tempo total para assistir aos titulos: " + calculadora.getTempoTotal());

        Recomendacao recomendacao = new Recomendacao();
        recomendacao.filtrarClassificacao(filme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNome("Primerio Episodio");
        episodio.setSerie(serie);
        episodio.setTotalVisualizacoes(600);
        recomendacao.filtrarClassificacao(episodio);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filme);
        listaDeFilmes.add(filme1);
        System.out.println(listaDeFilmes);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filme);
        lista.add(filme1);
        lista.add(serie);

        Collections.sort(lista);
        System.out.println(lista);
    }
}
