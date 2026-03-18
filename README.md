# TopicosGlaucio

# Diferença entre Latencia e Throughput
// Latência é o atraso no tempo de resposta (ex: ping), medindo o tempo que um dado leva de um ponto a outro. Throughput é a taxa de transferência real, ou volume de dados entregues com sucesso por unidade
de tempo. Resumindo: latência é velocidade, throughput é capacidade. 

Principais Diferenças e Características:
Latência (Tempo/Atraso):
Mede o tempo de ida e volta (RTT) de um pacote.
Crucial para aplicações em tempo real (jogos, chamadas de vídeo, alto-frequência).
Baixa latência significa resposta rápida.
Throughput (Volume/Vazão):
Mede a quantidade de dados por segundo (ex: MB/s) ou pacotes por segundo.
Crucial para download, streaming, backups.

Relação e Trade-off:
Embora distintos, alta latência pode reduzir o throughput. Otimizar para baixa latência (ex: sem cache) pode diminuir o throughput, e aumentar o throughput (ex: muitos pacotes em lote) pode aumentar a latência. 

Analogia da Rodovia: 
Latência: Tempo que um carro leva para ir de A a B.
Throughput: Número de carros que passam pelo pedágio por minuto. 

# Lei de Moore
// A Lei de Moore é uma observação feita por Gordon Moore em 1965, cofundador da Intel, que prevê que o número de transistores em um chip dobra aproximadamente a cada dois anos, aumentando a capacidade de processamento
e reduzindo custos. Essa regra exponencial impulsionou a tecnologia por décadas, resultando em dispositivos menores, mais rápidos e eficientes.

# Bancos de dados relacional
// Um banco de dados relacional (RDBMS) organiza dados em tabelas com linhas (registros) e colunas (atributos) interligadas, utilizando chaves primárias e estrangeiras para garantir a consistência. Baseado em SQLé ideal para transações estruturadas (OLTP) que exigem alta precisão e integridade, como sistemas financeiros e de inventário.
 - Tabelas (Relações): Estruturas que armazenam dados de entidades específicas.
 - Linhas (Registros/Tuplas): Cada entrada única em uma tabela.
 - Colunas (Campos/Atributos): Características do dado armazenado.
 - Chave Primária (PK): Identificador exclusivo para cada linha em uma tabela.
 - Chave Estrangeira (FK): Campo que vincula uma tabela a outra, criando um relacionamento.
 - SQL (Structured Query Language): Linguagem padrão para interagir com bancos relacionais.
   
# Diferença entre Stack e Heap
- Stack: é automática, rápida e organizada em LIFO (último a entrar, primeiro a sair) para dados locais e pequenos.
- Heap: O Heap é maior, de acesso mais lento, usado para alocação dinâmica e exige gerenciamento manual (C/C++) ou Garbage Collector (Java/C#).

# O SISTEMA OPERACIONAL NÃO SUPORTA UMA GRANDE QUANTIDADE DE THREADS
- Embora o sistema operacional consiga gerenciar milhares de threads, cada thread consome recursos: 
  - Memória RAM: Cada thread precisa de sua própria pilha (stack) de memória (geralmente cerca de 1 MB no Windows ou 8 MB no Linux por padrão). Criar milhares de threads pode esgotar a RAM, causando lentidão extrema (swap) ou travamento.
  - Overhead de Context Switching: O sistema operacional precisa alternar rapidamente entre as threads para dar a ilusão de paralelismo. Trocar o contexto de muitas threads consome ciclos de CPU que poderiam ser usados para processar dados (custo de comutação).
  - O sistema operacional "não suporta", mas há um ponto de saturação. Criar threads demais frequentemente piora o desempenho em vez de melhorar. 

# Qual a diferença entre Thread de Plataforma (OS) e Thread Virtual (Coroutines)
 - Thread de Plataforma (OS):
   - Mapeamento: Existe uma correspondência de um-para-um (1:1) com threads do SO.
   - Custo: Alto. Criar e destruir threads de plataforma é caro, e cada uma consome uma quantidade significativa de memória (geralmente ~1MB de pilha).
   - Escalabilidade: Limitada. Criar milhares de threads pode esgotar a memória do sistema.
   - Bloqueio: Se uma thread fizer uma operação bloqueante (como leitura de banco de dados ou rede), a thread do SO fica bloqueada e não pode fazer mais nada.
   - Uso Ideal: Tarefas pesadas de processamento (CPU-bound) que exigem núcleos de processador dedicados.
  
 - Thread Virtual (Coroutines):
   - Mapeamento: Mapeamento muitos-para-um (M:N). Milhões de threads virtuais podem ser mapeadas para um número pequeno de threads de plataforma (chamadas de carrier threads).
   - Custo: Baixo. São objetos Java leves criados na heap, não no SO. A criação é muito rápida.
   - Escalabilidade: Muito alta. Permite suportar milhões de tarefas simultâneas (concorrência) na mesma aplicação.
   - Bloqueio: Quando uma thread virtual realiza uma operação I/O (bloqueante), a JVM desmonta a thread virtual da thread de plataforma, liberando-a para executar outra thread virtual. Quando o I/O termina, a thread virtual é retomada.
   - Uso Ideal: Aplicações com alta carga de I/O (I/O-bound), como servidores web, chamadas de API, consultas SQL, onde a thread passa a maior parte do tempo esperando
