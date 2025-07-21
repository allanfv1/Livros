
package service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Livro;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LivroService {
    private static final String API_URL = "https://www.googleapis.com/books/v1/volumes?q=intitle:";

    public List<Livro> buscarLivros(String titulo) {
        List<Livro> livros = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(API_URL + titulo.replace(" ", "+"))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.body() != null) {
                String jsonData = response.body().string();
                JsonObject jsonObject = JsonParser.parseString(jsonData).getAsJsonObject();
                JsonArray items = jsonObject.getAsJsonArray("items");

                if (items != null) {
                    for (int i = 0; i < items.size(); i++) {
                        JsonObject volumeInfo = items.get(i).getAsJsonObject()
                                                     .getAsJsonObject("volumeInfo");

                        Livro livro = new Livro();
                        livro.setTitulo(volumeInfo.get("title").getAsString());

                        if (volumeInfo.has("industryIdentifiers")) {
                            JsonArray identifiers = volumeInfo.getAsJsonArray("industryIdentifiers");
                            livro.setIsbn(identifiers.get(0).getAsJsonObject().get("identifier").getAsString());
                        } else {
                            livro.setIsbn("N/A");
                        }

                        livros.add(livro);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return livros;
    }
}
