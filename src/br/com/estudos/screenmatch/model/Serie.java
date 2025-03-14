package br.com.estudos.screenmatch.model;

public class Serie extends Titulo{
    private int temporadas;
    private int episodios;
    private boolean ativa;
    private int duracaoEpisodio;

    public Serie(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getDuracaoEpisodio() {
        return duracaoEpisodio;
    }

    public void setDuracaoEpisodio(int duracaoEpisodio) {
        this.duracaoEpisodio = duracaoEpisodio;
    }

    @Override
    public int getDuracao() {
        return temporadas * episodios * duracaoEpisodio;
    }

    @Override
    public String toString() {
        return "Serie: " + getNome() + " (" + getAnoDeLancamento() + ")";
    }
}
