import controllers.GameController;

import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);

    System.out.println("Deseja jogar com quantos discos?");

    String userInput = input.nextLine();

    int disks;

    while (true) {
      try {
        disks = Integer.parseInt(userInput);
        break;
      } catch (Exception e) {
        System.out.println("Digite um valor inteiro válido!");
      }
    }

    GameController game = new GameController();

    game.gameInit(disks);

    System.out.println("----- VALENDO! ----- \n");

    game.showTowers();

    while (true) {
      String towerFrom;
      String towerTo;

      System.out.println("Deseja mover de que torre?");
      towerFrom = input.nextLine();

      System.out.println("Deseja mover para qual torre?");
      towerTo = input.nextLine();

      if (towerFrom.length() > 1 || towerTo.length() > 1) {
        System.out.println("Digite apenas torres válidas!");
        continue;
      }

      boolean movePossible;

      movePossible = game.moveDisk(towerFrom.toUpperCase(), towerTo.toUpperCase());

      if (!movePossible) {
        System.out.println("Movimento inválido! Tente novamente.");
      }

      game.showTowers();

      if (game.checkWin()) {
        System.out.println("Você finalizou o jogo!!!");
        System.out.println("MOVIMENTOS FEITOS: " + game.getAttemps());
        break;
      }
    }

    input.close();
  }
}
