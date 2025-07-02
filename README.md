# 📚 Projeto: Jogo de Operações Matemáticas no Terminal (CLI)

## 🎯 Objetivo

Esse projeto foi criado inicialmente para resolver um problema comum: **esquecer a tabuada** com o tempo.  
Entretanto, eu fiz algumas alterações e você pode realizar todas as operações matemáticas: somar, subtrair e multiplicar.

## 🕹️ Como funciona

Este é um jogo interativo que roda diretamente no **terminal**. Você interage com o menu para configurar e iniciar as partidas.

- A cada rodada, uma operação aleatória aparece na tela, Exemplo: 8 * 7, 7 + 5, 9 - 5.
- Se acertar, ganha um ponto.
- Se errar, recebe uma mensagem de erro, mas pode continuar tentando.

### ⚙️ Configurações disponíveis:

- **Modo "Responder até acertar"**: você só avança quando acertar a resposta.
- **Predefinições de dificuldade**: escolha multiplicações com números mais difíceis.
- **Modo personalizado**: selecione quais números deseja praticar.

---

## 💻 Como rodar o projeto

### 🔵 Windows

1. Verifique se o Java está instalado. Caso não tenha:
   👉 [Baixe aqui o Java](https://www.java.com/pt-BR/download/?locale=pt_BR).

2. [📦 Clique aqui para baixar o projeto (ZIP)](https://github.com/devcarlosdaniel0/multiplication-table-game/archive/refs/heads/main.zip)  
   ou vá até o repositório e clique em **"Code" → "Download ZIP"**.

3. Salve o projeto na pasta de sua preferência, por exemplo, **Downloads**.

4. Vá até a pasta onde o projeto foi baixado, clique com botão direito do mouse e extraia com o [WinRAR](https://www.win-rar.com/predownload.html?&L=9).

5. Abra o menu de pesquisa e digite **PowerShell**, abrindo-o em seguida.
   
6. Vá para a pasta onde extraiu o arquivo, nesse caso, **Downloads**, digitando o seguinte comando:
   ```bash
   cd \Downloads\multiplication-table-game-main
   ```

obs: Ao abrir o **PowerShell**, você encontrará em seu terminal: PS C:\Users\*NOME DO SEU USUÁRIO* e, caso a sua pasta de **Downloads** esteja localizada em outro disco local, por exemplo, disco local D, digite os seguintes comandos: 
   ```bash
   D:
   cd \Users\$env:USERNAME\Downloads\multiplication-table-game-main
   ```

7. Execute o jogo digitando o comando:
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

4. Pronto! Agora é só seguir as instruções do menu para jogar ou configurar.
