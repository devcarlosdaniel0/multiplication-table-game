# 📚 Projeto: Jogo de Tabuada no Terminal (CLI)

## 🎯 Objetivo

Esse projeto foi criado para resolver um problema comum: **esquecer a tabuada** com o tempo.  
Por isso, desenvolvi um jogo simples em **linha de comando (CLI)** para praticar **multiplicação** de forma rápida, prática e personalizada.

## 🕹️ Como funciona

Este é um jogo interativo que roda diretamente no **terminal**. Você interage com o menu para configurar e iniciar as partidas.

- A cada rodada, uma operação aleatória de multiplicação aparece na tela.
- Se acertar, ganha um ponto.
- Se errar, recebe uma mensagem de erro — mas pode continuar tentando!

### ⚙️ Configurações disponíveis:

- **Modo "Responder até acertar"**: você só avança quando acertar a resposta.
- **Predefinições de dificuldade**: escolha multiplicações com números mais difíceis.
- **Modo personalizado**: selecione quais números deseja praticar.

Você pode testar diferentes modos e, se encontrar algum problema, sinta-se à vontade para abrir uma **issue** ou enviar uma **Pull Request**.

---

## 💻 Como rodar o projeto

### 🔵 Windows

1. Verifique se o Java está instalado. Caso não tenha:
   👉 [Baixe aqui o Java](https://www.java.com/pt-BR/download/?locale=pt_BR)

2. [📦 Clique aqui para baixar o projeto (ZIP)](https://github.com/devcarlosdaniel0/multiplication-table-game/archive/refs/heads/main.zip)  
   ou vá até o repositório e clique em **"Code" → "Download ZIP"**.

3. Salve o projeto na pasta de sua preferência, por exemplo Downloads.

4. Vá até a pasta onde o arquivo foi baixado, clique com botão direito e extraia com o [WinRAR](https://www.win-rar.com/predownload.html?&L=9).

5. Abra o menu de pesquisa e digite **PowerShell**, abrindo-o em seguida.
   
6. Navegue até a pasta extraída digitando o seguinte comando:
   ```bash
   cd \Downloads\multiplication-table-game-main
   ```

obs: Ao abrir o **PowerShell**, você encontrará em seu terminal: PS C:\Users\{nome do seu usuário} e, caso a sua pasta de Downloads esteja localizada em outro disco local, por por exemplo disco local D, digite os seguintes comandos: 
   ```bash
   D:
   cd \Users\{nome do seu usuário}\Downloads\multiplication-table-game-main
   ```

6. Execute o jogo digitando o comando:
   ```bash
   java -jar multiplication-table-game.jar
   ```

8. Pronto! Agora é só seguir as instruções do menu para jogar ou configurar.

### 🐧 Linux

1. Abra o terminal e digite o comando:
   ```bash
   git clone https://github.com/devcarlosdaniel0/multiplication-table-game.git
   ```

2. Digite o comando:
   ```bash
   cd multiplication-table-game/
   ```

3. Abra o jogo com o comando:
   ```bash
   java -jar multiplication-table-game.jar 
   ```
