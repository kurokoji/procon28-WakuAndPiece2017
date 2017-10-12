package WAP;

import javafx.scene.canvas.GraphicsContext;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;


public class Problem {
    private ArrayList<Piece> pieces, answerPieces;
    private ArrayList<Piece> hint;
    private Frame frame;

    public Problem() {
        pieces = new ArrayList<>();
        answerPieces = new ArrayList<>();
        hint = new ArrayList<>();
        frame = new Frame();
    }

    // 問題の入力
    public void inputProblem(BufferedReader br) throws IOException {
        int piecesN = Integer.parseInt(br.readLine());

        for (int i = 0; i < piecesN; ++i) {
            Piece piece = new Piece();
            piece.inputPiece(br);
            pieces.add(piece);
        }
        frame = new Frame();
        frame.inputFrame(br);
        br.close();
    }

    // 問題の出力
    public void outputProblem(PrintStream ps) throws IOException {
        ps.println(pieces.size());
        for (Piece piece : pieces) {
            piece.outputPiece(ps);
        }
        frame.outputFrame(ps);
        ps.flush();
        ps.close();
    }

    // ソルバから受け取った答えの入力
    public void inputAnswer(BufferedReader br) throws IOException {
        int answerPiecesN = Integer.parseInt(br.readLine());

        for (int i = 0; i < answerPiecesN; ++i) {
            Piece piece = new Piece();
            piece.inputPiece(br);
            answerPieces.add(piece);
        }
        br.close();
    }

    // ヒントの入力
    public void inputHint(BufferedReader br) throws IOException {
        int piecesN = Integer.parseInt(br.readLine());
        for (int i = 0; i < piecesN; ++i) {
            Piece piece = new Piece();
            piece.inputPiece(br);
            hint.add(piece);
        }
        br.close();
    }

    // ヒントをcanvasに描画
    public void showHint(GraphicsContext gc) throws IOException {
        for (Piece piece : hint) {
            piece.fillPolygon(gc);
            piece.strokePolygon(gc);
        }
    }

    // ソルバから受け取った答えをcanvasに描画
    public void showAnswer(GraphicsContext gc) throws IOException {
        for (Piece piece : answerPieces) {
            piece.fillPolygon(gc);
            piece.strokePolygon(gc);
        }
        frame.showFrame(gc);
    }

    // フレームの描画
    public void showFrame(GraphicsContext gc) {
        frame.showFrame(gc);
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public ArrayList<Piece> getHint() {
        return hint;
    }

    public Frame getFrame() {
        return frame;
    }
}
