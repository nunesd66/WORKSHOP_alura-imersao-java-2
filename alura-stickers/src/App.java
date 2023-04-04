import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // TODO: pegar a API da marvel para consumir

        // fazer uma conexao HTTP e buscar as fotos da nasa ou de filmes
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        // String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2023-01-29&end_date=2023-03-29";
        
        var http = new ClinteHttp();
        String json = http.buscaDados(url);

        // manipular e exibir os dados
        List<Conteudo> conteudos = extrator.extrairConteudos(json);
        GeradoraDeFigurinhas gerador = new GeradoraDeFigurinhas();

        for (Conteudo conteudo : conteudos) {
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            gerador.criarFigurinha(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo() + "\n");
        }

        // TODO: formatar o system.out formatado;
        // TODO: centralizar texto; usar cores; fonte "dos memes"; colocar auto-imagem; etc;
    }
}
