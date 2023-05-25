package controllers;

import java.util.ArrayList;

import stack.*;

public class GameController {
  private Stack<Integer> towerA;
  private Stack<Integer> towerB;
  private Stack<Integer> towerC;
  private int totalDisks;
  private int attemps;

  public GameController() {
    this.towerA = new Stack<>();
    this.towerB = new Stack<>();
    this.towerC = new Stack<>();
  }

  public int getAttemps() {
    return attemps;
  }

  public void gameInit(int disks) {
    for (int i = disks; i > 0; i--) {
      towerA.push(i);
    }

    this.totalDisks = disks;
    this.attemps = 0;
  }

  public boolean moveDisk(String from, String to) throws Exception {
    boolean possible = false;

    if (from.equals("A") && to.equals("B")) {
      possible = moveDisk(towerA, towerB);
    } else if (from.equals("A") && to.equals("C")) {
      possible = moveDisk(towerA, towerC);
    } else if (from.equals("B") && to.equals("A")) {
      possible = moveDisk(towerB, towerA);
    } else if (from.equals("B") && to.equals("C")) {
      possible = moveDisk(towerB, towerC);
    } else if (from.equals("C") && to.equals("A")) {
      possible = moveDisk(towerC, towerA);
    } else if (from.equals("C") && to.equals("B")) {
      possible = moveDisk(towerC, towerB);
    }

    return possible;
  }

  public boolean checkWin() {
    return towerC.length() == this.totalDisks;
  }

  public void showTowers() {
    ArrayList<Integer> allDisksTowerA = towerA.recursiveRemove();
    ArrayList<Integer> allDisksTowerB = towerB.recursiveRemove();
    ArrayList<Integer> allDisksTowerC = towerC.recursiveRemove();

    while (this.totalDisks > allDisksTowerA.size()) {
      allDisksTowerA.add(0, 0);
    }

    while (this.totalDisks > allDisksTowerB.size()) {
      allDisksTowerB.add(0, 0);
    }

    while (this.totalDisks > allDisksTowerC.size()) {
      allDisksTowerC.add(0, 0);
    }

    for (int i = 0; i < this.totalDisks; i++) {
      int diskFromA = (allDisksTowerA.isEmpty() == true) ? 0 : allDisksTowerA.remove(0);
      int diskFromB = (allDisksTowerB.isEmpty() == true) ? 0 : allDisksTowerB.remove(0);
      int diskFromC = (allDisksTowerC.isEmpty() == true) ? 0 : allDisksTowerC.remove(0);

      System.out.println(" " + (diskFromA == 0 ? " " : diskFromA) + " " +
          (diskFromB == 0 ? " " : diskFromB) + " "
          + (diskFromC == 0 ? " "
              : diskFromC));
    }

    System.out.println("-------");
    System.out.println(" A B C");
  }

  private boolean moveDisk(Stack<Integer> towerFrom, Stack<Integer> towerTo) throws Exception {
    if (towerFrom.isEmpty()) {
      return false;

    } else {
      if (towerTo.isEmpty()) {
        int removedDisk = towerFrom.remove();

        towerTo.push(removedDisk);

        this.attemps += 1;

        return true;

      } else {
        if (towerFrom.getFirst() < towerTo.getFirst()) {
          int removedDisk = towerFrom.remove();

          towerTo.push(removedDisk);

          this.attemps += 1;

          return true;

        } else {
          return false;
        }
      }
    }
  }
}
