package WAP;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class Frame {
  private Piece[] inners;

  public Frame() {}

  // フレームの入力
  public void inputFrame(BufferedReader br) throws IOException {
    int holesN = Integer.parseInt(br.readLine());
    inners = new Piece[holesN];
    for (int i = 0; i < holesN; ++i) {
      inners[i] = new Piece();
      inners[i].inputPiece(br);
    }
  }

  private Color randomColor() {
    Random rnd = new Random();
    return Color.rgb(rnd.nextInt(200), rnd.nextInt(200), rnd.nextInt(200));
  }

  public void showFrame(GraphicsContext gc) {
    for (int i = 0; i < inners.length; ++i) {
      inners[i].strokePolygon(gc);
    }
  }
}
