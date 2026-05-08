// Crie 10 entradas chave-valor aleatórios e em seguida acesse o banco Redis com algum programa GUI (RedisInsight, Another Redis Desktop Manager ou Redis for VS Code) e 
// verifique se as chaves foram criadas. Depois volte ao programa e liste as chaves e seus respectivos valores.
import redis.clients.jedis.Jedis;
import java.util.Random;

public class Atividade2 {
    public static void main(String[] args) {
        // Conectando ao Redis
        Jedis jedis = new Jedis("localhost", 6379);
        
        // Criando 10 entradas chave-valor aleatórios
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            String key = "key" + i;
            String value = "value" + random.nextInt(100);
            jedis.set(key, value);
        }
        
        // Listando as chaves e seus respectivos valores
        System.out.println("Chaves e valores no Redis:");
        for (String key : jedis.keys("key*")) {
            String value = jedis.get(key);
            System.out.println(key + ": " + value);
        }
        
        // Fechando a conexão
        jedis.close();
    }
}