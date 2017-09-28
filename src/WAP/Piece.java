package WAP;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Polygon;
import javafx.scene.layout.AnchorPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.Random;

public class Piece {
  private double[] xPoints, yPoints;
  private int pointsN;
  public Piece() {}

  private Color randomColor() {
    Random rnd = new Random();
    return Color.rgb(rnd.nextInt(200), rnd.nextInt(200), rnd.nextInt(200));
  }

  // ピースの入力
  public void inputPiece(BufferedReader br) throws IOException {
    pointsN = Integer.parseInt(br.readLine());
    xPoints = new double[pointsN];
    yPoints = new double[pointsN];
    for (int i = 0; i < pointsN; ++i) {
      Point point = new Point();
      point.input(br);
      xPoints[i] = point.getX();
      yPoints[i] = point.getY();
    }
  }

  public void fillPolygon(GraphicsContext gc) {
    gc.setFill(randomColor());
    gc.fillPolygon(xPoints, yPoints, pointsN);
  }

  public void strokePolygon(GraphicsContext gc) {
    gc.setStroke(Color.BLACK);
    gc.setLineWidth(0.5);
    gc.strokePolygon(xPoints, yPoints, pointsN);
  }
}
