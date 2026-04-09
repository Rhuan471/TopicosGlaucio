# TopicosGlaucio

# Diferença entre Latencia e Throughput
// Latência é o atraso no tempo de resposta (ex: ping), medindo o tempo que um dado leva de um ponto a outro. Throughput é a taxa de transferência real, ou volume de dados entregues com sucesso por unidade
de tempo. Resumindo: latência é velocidade, throughput é capacidade. 

# Curiosidade
- Processo: um programa em execução
- Thread: um fluxo de execução dentro do processo
- Stack: área de memoria da thread (variaveis locais e pilhas de chamada de funções)
- Na arquitetura de computadores, speedup é um número que mede o desempenho relativo de dois sistemas que processam o mesmo problema. 

Principais Diferenças e Características:
 Latência (Tempo/Atraso)
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
 - Tabelas (Relações): Representam atributos (estruturas) que armazenam dados de entidades específicas.
 - Linhas (Registros/Tuplas): Cada entrada única em uma tabela.
 - Colunas (Campos/Atributos): Características do dado armazenado.
 - Chave Primária (PK): Identificador exclusivo para cada linha em uma tabela.
 - Chave Estrangeira (FK): Campo que vincula uma tabela a outra, criando um relacionamento.
 - SQL (Structured Query Language): Linguagem padrão para interagir com bancos relacionais.

 Thread: um fluxo de execução dentro do processo.
 - O que é o Processo/thread deamon: que não tem fim.
 - Prioridade na thread: valor informado ao escalonador para ele levar em conta.
 - Starvation: Thread que não consegue tempo de CPU.

# O que é Condição de corrida:
- O resultado final torna-se dependente da temporização imprevisível ("corrida") dos eventos, gerando comportamentos não determinísticos, corrupção de dados ou falhas de segurança

# o que é Stack
- A stack de thread (pilha de thread) é uma área de memória dedicada e privada usada por uma única thread de execução em um programa. Ela armazena dados temporários, como variáveis locais e o histórico de chamadas de funções (call stack).

- Diferença de Stack entre Threads (Multi-threading).  
Se um processo tem duas threads (Thread A e Thread B), cada uma possui sua própria stack física na memória, permitindo que executem funções diferentes simultaneamente sem interferência. 

Thread A: Executa funcao_calculo().
Thread B: Executa funcao_interface().
Resultado: Os dados locais de funcao_calculo não misturam com os da funcao_interface, pois cada uma está na sua própria stack. 

# O que é Heap
- É uma área de memória compartilhada, dinâmica e de grande capacidade, utilizada para armazenar objetos, instâncias de classes e variáveis de tamanho desconhecido em tempo de compilação.

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

# Diferença entre Paralelismo e Concorrência
- Concorrência é a estruturação e gerenciamento de múltiplas tarefas que progridem em períodos sobrepostos (alternando entre elas), frequentemente em um único núcleo. 
- Paralelismo é a execução física e simultânea de múltiplas tarefas ao mesmo tempo, exigindo múltiplos núcleos de CPU. A concorrência lida com várias coisas, o paralelismo faz várias coisas. 

# Mutex e semáforo:
- Mutex é um mecanismo de bloqueio para exclusão mútua, permitindo apenas uma thread por vez em um recurso.
- Semáforo tanto pode ser Mutex, por ele ser um mecanismo de sinalização que permite acesso controlado a múltiplas instâncias de um recurso (contagem).   

# Escalonador Cooperativo e Preemptivo (time slice)
- A principal diferença é o controle: no escalonamento preemptivo, o sistema operacional interrompe processos à força para dar vez a outros, garantindo responsividade. No cooperativo, o processo mantém a CPU até terminar ou ceder voluntariamente o controle, sendo ideal para sistemas embarcados simples, mas arriscado para multitarefa.

# A Memorization (memoização)
 - "do inglês memoization" é uma técnica de otimização usada em programação para acelerar o desempenho de aplicações, armazenando os resultados de chamadas de funções dispendiosas (pesadas) em um cache. 

Quando a função é chamada novamente com as mesmas entradas, o programa retorna o resultado armazenado em vez de recalculá-lo. 

Como funciona?
Chamada da Função: A função recebe um argumento.
Verificação do Cache: O programa verifica se o resultado para essa entrada já foi calculado e salvo em uma estrutura de dados (como um dicionário ou objeto).
Retorno Cacheado: Se o resultado estiver no cache, ele é retornado instantaneamente.
Novo Cálculo: Se não estiver, a função calcula o valor, armazena no cache e depois retorna. 

Principais Características
Ideal para Funções Puras: Funciona melhor com funções que, dado o mesmo argumento, sempre retornam o mesmo resultado.
Troca Tempo por Espaço: Consome mais memória (para o cache) para ganhar velocidade de execução.
Muito usada em Recursividade: Essencial para algoritmos recursivos repetitivos, como o cálculo da sequência de Fibonacci.
Programação Dinâmica: É uma técnica fundamental na abordagem "de cima para baixo" (top-down) da programação dinâmica. 

# Memória volátil 
- é um tipo de armazenamento de computador que exige energia contínua para manter os dados, perdendo todas as informações armazenadas assim que o dispositivo é desligado ou reiniciado. É usada para acesso rápido e temporário de dados pelo processador (CPU), sendo essencial para o funcionamento de softwares ativos. 

Principais características e usos:
Velocidade: São muito mais rápidas que a memória não volátil (como HDs e SSDs).
Exemplos: A memória RAM (Random Access Memory) é o principal exemplo, incluindo também a memória cache (L1, L2, L3).
Finalidade em programação: Armazena variáveis, estruturas de dados e instruções de programas que estão em execução no momento.
Vantagem: A volatilidade protege dados sensíveis, pois os apaga ao desligar, além de oferecer alto desempenho de leitura e escrita

#Coerência de cache 
- é a garantia de que múltiplos núcleos de CPU vejam a mesma versão de dados compartilhados, evitando dados "sujos" ou obsoletos. O protocolo MESI (Modified, Exclusive, Shared, Invalid) gerencia estados de cache para sincronizar escritas, assegurando que, quando um núcleo altera um dado, outros núcleos saibam. 

# O que é o Protocolo MESI em Programação (Visão Geral)
Em sistemas multi-core, cada núcleo tem sua própria cache (lenta se compartilhada, mas rápida localmente). Se dois núcleos lerem a mesma variável da RAM e um deles a alterar, o outro precisa ser notificado. O MESI gerencia isso usando quatro estados para cada linha de cache: 

M (Modified - Modificado): O dado foi alterado na cache e é diferente da RAM. Apenas este núcleo possui a cópia atualizada.
E (Exclusive - Exclusivo): O dado foi lido, é igual à RAM e está apenas na cache deste núcleo.
S (Shared - Compartilhado): O dado é igual à RAM e pode existir em caches de outros núcleos.
I (Invalid - Inválido): O dado na cache não é mais válido (outro núcleo alterou o valor). 

Por que Importa para Programadores:
A falta de coerência pode levar a resultados imprevisíveis, bugs de concorrência e falsos compartilhamentos (false sharing), onde núcleos diferentes tentam atualizar variáveis independentes que residem na mesma linha de cache, travando o desempenho. 

Resumo Técnico:
M: Modificado (único, sujo)
E: Exclusivo (único, limpo)
S: Compartilhado (pode ter múltiplos, limpo)
I: Inválido (dado inválido)

# O AtomicInteger
 - é uma classe do Java (pacote java.util.concurrent.atomic) usada para realizar operações em um número inteiro de forma atômica e thread-safe (segura para uso em várias threads simultâneas) sem a necessidade de usar synchronized ou bloqueios explícitos. 

Principais usos e funções:
Contadores Seguros: Ideal para cenários onde várias threads precisam incrementar ou decrementar um contador ao mesmo tempo, garantindo que nenhum valor seja perdido.
Operações Atômicas: Ele transforma operações compostas (que não são atômicas por padrão, como i++) em uma única etapa indivisível, utilizando mecanismos de hardware conhecidos como CAS (Compare-And-Swap).
Performance (Lock-free): Por ser lock-free (livre de bloqueios), o AtomicInteger costuma ser mais rápido do que usar blocos synchronized, evitando que threads fiquem bloqueadas esperando a liberação de recursos.
Visibilidade de Variável: Assegura que, quando uma thread atualiza o valor, todas as outras threads vejam o valor atualizado imediatamente. 

Métodos comuns do AtomicInteger:
incrementAndGet(): Incrementa e retorna o novo valor.
getAndIncrement(): Retorna o valor atual e depois incrementa.
decrementAndGet(): Decrementa e retorna o novo valor.
addAndGet(int delta): Adiciona um valor específico e retorna o novo valor.
compareAndSet(int expect, int update): Atualiza o valor apenas se o valor atual for igual ao valor esperado (útil para implementar locks personalizados)

- [Opcional: VSCode Dapr Extension](https://www.baeldung.com/java-volatile)

