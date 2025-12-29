# 📚 Jogo de Operações Matemáticas

Esse é um projeto Command Line Interface (CLI) <br>
Treine cálculo mental de forma rápida e prática via Terminal. <br>
O jogo gera operações aleatórias para você resolver e melhora sua agilidade com tabuada, soma e subtração.

## 🎯 Objetivo

Este projeto nasceu para resolver um problema real: **esquecer a tabuada** com o tempo.  
Todavia, atualmente ele evoluiu e virou um jogo completo para praticar soma, subtração e multiplicação com diversos números aleatórios para você se tornar **ágil em cálculo mental**. 

Perfeito para quem quer:
- estudar
- treinar o cérebro
- preparar-se para provas

## 🕹️ Como funciona

Rodadas acontecem no terminal e você responde às operações exibidas na tela.

A cada rodada, uma operação aleatória aparece na tela, exemplo:
- 8 × 7
- 7 + 5
- 9 − 5

Se acertar, ganha um ponto. <br>
Se errar, recebe um aviso de erro.

### ⚙️ Configurações disponíveis:

- **Modo "Responder até acertar"**: você só avança quando acertar a resposta.
- **Predefinições de dificuldade**: escolha multiplicações com números mais difíceis.
- **Modo personalizado**: selecione quais números deseja praticar.

---

## 💻 Como rodar o projeto

### 🔵 Windows

1. Verifique se o Java está instalado. Caso não esteja, realize a instalação por meio do site oficial:
   https://www.java.com/pt-BR/download

2. [Clique aqui para baixar o projeto](https://github.com/devcarlosdaniel0/multiplication-table-game/archive/refs/heads/main.zip) ou pelo botão Download ZIP no GitHub

3. Salve o projeto na pasta de sua preferência, por exemplo, **Downloads**.

4. Vá até a pasta onde o projeto foi salvo e extraia com o [WinRAR](https://www.win-rar.com/predownload.html?&L=9).

5. Abra o menu de pesquisa e digite **PowerShell**, abrindo-o em seguida.
   
6. Navegue com o terminal (**PowerShell**) até pasta onde extraiu o arquivo, nesse caso, **Downloads**, digitando:
   ```bash
   cd .\Downloads\multiplication-table-game-main
   ```

🔎 Se estiver em outro disco (ex: D:), use:
   ```bash
   D:
   cd \Users\$env:USERNAME\Downloads\multiplication-table-game-main
   ```

7. Execute o jogo:
   ```bash
   java -jar multiplication-table-game.jar
   ```

8. Pronto! Agora é só seguir as instruções do menu para jogar ou configurar.

### 🐧 Linux

1. Clone o repositório:
   ```bash
   git clone https://github.com/devcarlosdaniel0/multiplication-table-game.git
   ```

2. Navegue até a pasta:
   ```bash
   cd multiplication-table-game/
   ```

3. Execute o jogo:
   ```bash
   java -jar multiplication-table-game.jar 
   ```

4. Pronto! Agora é só seguir as instruções do menu para jogar ou configurar.
