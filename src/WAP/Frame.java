package WAP;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Random;

public class Frame {
    private ArrayList<Piece> inners;
    private int holesN;

    public Frame() {
        inners = new ArrayList<>();
    }

    // フレーム情報の入力
    public void inputFrame(BufferedReader br) throws IOException {
        holesN = Integer.parseInt(br.readLine());

        for (int i = 0; i < holesN; ++i) {
            Piece piece = new Piece();
            piece.inputPiece(br);
            inners.add(piece);
        }
    }

    // フレーム情報の出力
    public void outputFrame(PrintStream ps) throws IOException {
        ps.println(holesN);
        for (Piece piece : inners) {
            piece.outputPiece(ps);
        }
    }

    // randomなカラーを返す
    private Color randomColor() {
        Random rnd = new Random();
        return Color.rgb(rnd.nextInt(200), rnd.nextInt(200), rnd.nextInt(200));
    }

    // フレームをcanvasに描画
    public void showFrame(GraphicsContext gc) {
        for (Piece piece : inners) {
            piece.strokePolygon(gc);
        }
    }
}
