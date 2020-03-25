package webscraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/**
 * @author Lucas Carvalho Alves Nogueira
 * Web Scraper amazon.com.br
 */
public class WebScraper {

    public static void main(String[] args) throws IOException {
        String titulo, preco, autor, avaliacao, estoque, vendedor;
        
        try {
            Document d = Jsoup.connect("https://www.amazon.com.br/%C3%BAltimo-desejo-Witcher-bruxo-Geralt/dp/854690281X").get();
            
            System.out.println("---- Web Scraper ----");
            
            titulo = d.select("span[class=a-size-large]").text();
            System.out.println("Título: " + titulo);

            preco = d.select("span[class=a-size-medium a-color-price inlineBlock-display offer-price a-text-normal price3P]").text();
            System.out.println("Preço: " + preco);
            
            autor = d.select("#bylineInfo > span > a").text();
            System.out.println("Autor: " + autor);
            
            avaliacao = d.select("#acrPopover > span.a-declarative > a > i.a-icon.a-icon-star.a-star-5 > span").text();
            System.out.println("Avaliação: " + avaliacao);
            
            estoque = d.select("#availability > span").text();
            System.out.println("Estoque: " + estoque);
            
            vendedor = d.select("#merchant-info").text();
            System.out.println("Vendedor: " + vendedor);
          
            
        } catch (IOException e) {
            e.getMessage();
        }

    }
}
