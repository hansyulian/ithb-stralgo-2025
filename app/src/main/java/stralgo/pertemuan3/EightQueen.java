package stralgo.pertemuan3;

public class EightQueen {

  boolean diagonal45Visits[];
  boolean diagonal135Visits[];
  boolean columnVisits[];
  boolean found;
  int columns[];

  public EightQueen() {
    this.diagonal45Visits = new boolean[20];
    this.diagonal135Visits = new boolean[20];
    this.columnVisits = new boolean[8];
    this.found = false;
    this.columns = new int[8];
  }

  void build8Queen(int row) {
    // terminate when solution found
    if (found) {
      return;
    }
    // terminate when solution found and mark it found
    if (row == 8) {
      found = true;
      return;
    }
    for (int currentColumn = 0; currentColumn < 8; currentColumn++) {
      if (found) {
        return;
      }
      if (columnVisits[currentColumn]) {
        continue; // column has been visited previously
      }
      int currentDiagonal45 = row + currentColumn;
      if (diagonal45Visits[currentDiagonal45]) {
        continue; // diagonal45 has been visited
      }
      int currentDiagonal135 = row - currentColumn + 10; // just add offset
      if (diagonal135Visits[currentDiagonal135]) {
        continue; // diagonal135 has been visited
      }
      // not yet visited, mark current as visited
      columnVisits[currentColumn] = true;
      diagonal45Visits[currentDiagonal45] = true;
      diagonal135Visits[currentDiagonal135] = true;
      // put current row in the snapshot
      columns[row] = currentColumn;
      // dfs to next row
      build8Queen(row + 1);
      // when backtrack, invalidate all the markings
      // not yet visited, mark current as visited
      columnVisits[currentColumn] = false;
      diagonal45Visits[currentDiagonal45] = false;
      diagonal135Visits[currentDiagonal135] = false;
    }
  }

  public void printOne() {
    build8Queen(0);
    for (int i = 0; i < this.columns.length; i++) {
      System.out.println((i + 1) + " - " + (this.columns[i] + 1));
    }
  }

  public static void main(String[] args) {
    EightQueen eightQueen = new EightQueen();
    eightQueen.printOne();
  }
}
