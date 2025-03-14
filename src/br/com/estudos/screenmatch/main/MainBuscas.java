package br.com.estudos.screenmatch.main;

import br.com.estudos.screenmatch.exception.ConversaoDeAnoException;
import br.com.estudos.screenmatch.model.Titulo;
import br.com.estudos.screenmatch.model.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainBuscas {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        String busca = "";

        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite o filme que deseja consultar: ");
            busca = scanner.nextLine();

            String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=20089c9e";

            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println(response.body());

                TituloOMDB tituloOmdb = gson.fromJson(response.body(), TituloOMDB.class);
                System.out.println(tituloOmdb);

                Titulo titulo = new Titulo(tituloOmdb);
                System.out.println("Titulo convertido");
                System.out.println(titulo);

                titulos.add(titulo);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (ConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }

        FileWriter fw = new FileWriter("titulos.json");
        fw.write(gson.toJson(titulos));
        fw.close();



    }
}
