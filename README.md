# Projeto: Jogo de Tabuada no Terminal (CLI)

# 🎯 Objetivo
Esse projeto foi criado para atender uma necessidade que eu, e muitas outras pessoas, temos (ou tinhamos): decorar e treinar a tabuada.
Com o tempo, é comum esquecermos da tabuada. Por isso, decidi criar um jogo simples em linha de comando (CLI) para praticar operações de multiplicação de forma rápida, prática e personalizada.

# 🕹️ Como funciona

Basicamente, ele é um jogo em CLI (Command Line Interface), ou seja, é um jogo em linha de comando no seu terminal.
Funciona basicamente o seguinte: você digita a opção para jogar e operações aleatórias vão aparecendo na sua tela para você resolver.
Se você acertar, a sua pontuação aumenta em um ponto.
E se você errar, você aparecerá uma mensagem dizendo que você errou.
Entretanto, o jogo é altamente configurável e, logo no menu você terá opções para acessar as configurações.
Por exemplo, você tem a opção para ativar o modo de "responder até acertar", que como o próprio nome ja diz, se você errar você tentará quantas vezes preciso para acertar.
Além disso, você pode colocar predefinições em sua tabuada. Essas predefinições são quais números aparecerão para você realizar os seus cálculos.
Eu coloquei opções que possuem apenas os números mais difícies, porque talvez não faça sentido voce querer realizar operações como 1 * 10 ou 5 * 2, por exemplo.
Mas também coloquei a opção de você personalizar os números que você deseja que apareça.
Você pode brincar e testar as possibilidades e, em caso de algum bug inesperado pode entrar em contato comigo ou fazer uma Pull Request

# Como rodar o projeto? (Para Windows)
O projeto foi feito em Java, portanto, é necessário que você tenha o Java instalado em sua máquina. Basta pesquisar <a href="https://www.java.com/pt-BR/download/?locale=pt_BR" target="_blank">"Java Download"</a> no Google.
Agora para baixar o projeto, clique no botão azul "<> Code" do Github e clique em Download ZIP
Mande o arquivo para a sua área de trabalho, ou para o local que preferir
Extraia o arquivo na sua área de trabalho.
Agora no menu de pesquisa, digite PowerShell e abra.
Aparecerá "PS C:\Users\*nome do seu usuário*
Agora você digitará o seguinte comando: "cd Desktop" (sem as aspas) (caso tenha extraído na sua pasta de Downloads, por exemplo, dê um cd Donwloads)
Depois digite: "cd multiplication" (sem as aspas) e aperte a tecla TAB do seu teclado.
Você perceberá que ele completará automaticamente o comando e ficará assim: PS C:\Users\*nome do seu usuário*\multiplication-table-game-main>
Agora digite o comando "ls" (sem as aspas) e veja se aparecerá novamente o nome "multiplication-table-game-main", caso sim, digite "cd multiplication" (sem as aspas) e aperte a tecla TAB do seu teclado.
Provavelmente agora estará PS C:\Users\*nome do seu usuário*\multiplication-table-game-main\multiplication-table-game-main> 
Agora digite o seguinte comando (sem as aspas) "java -jar multiplication" e de aperte a tecla TAB para completar
Pronto, o jogo será inicializado e você pode seguir as opções de acordo com os números indicados
Se você digitou para jogar e agora quer parar, ou seja, voltar para o menu, digite qualquer tecla ex: "a"
Para sair do jogo completamente, vá para o menu e siga as instruções

# Como rodar o projeto (Para Linux)
É necessário que você já tenha o Java instalado, mas se você é um usuário Linux você provavelmente já deve saber como mexer no terminal.
De "cd" no diretório que você extraiu o arquivo e dê um "java -jar multiplication" com um TAB no final para completar
