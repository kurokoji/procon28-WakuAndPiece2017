package WAP;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.lang.model.type.IntersectionType;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Problem {
  private Piece[] pieces;
  private Frame frame;

  public Problem() { }

  public void inputProblem(BufferedReader br) throws IOException {
    int piecesN = Integer.parseInt(br.readLine());
    pieces = new Piece[piecesN];
    for (int i = 0; i < piecesN; ++i) {
      pieces[i] = new Piece();
      pieces[i].inputPiece(br);
    }
    frame = new Frame();
    frame.inputFrame(br);
  }

  public void showProblem(GraphicsContext gc) {
    frame.showFrame(gc);
  }

  public Piece[] getPieces() {
    return pieces;
  }

  public Frame getFrame() {
    return frame;
  }
}
