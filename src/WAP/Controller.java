package WAP;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.canvas.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import java.io.*;

public class Controller {
  @FXML private Canvas myCanvas;
  @FXML private Button problemReadButton, hintReadButton, solveButton, canvasClearButton;
  @FXML private Label piecesLabel;
  @FXML private TextArea consoleArea;
  private Problem problem;
  // private final String readQRCurrentPath = "cppReadQR/build/readqr";
  // private final String solverCurrentPath = "kurosolver/build/solver";
  private final String readQRAbsolutePath = "/Users/kurokoji/Dropbox/kurokoji/procon28dev/cppReadQR/build/readqr";
  private final String solverAbsolutePath = "/Users/kurokoji/Dropbox/kurokoji/procon28dev/kurosolver/build/solver";

  public Controller() {
    problem = new Problem();
  }

  private void canvasClear() {
    myCanvas.getGraphicsContext2D().clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
  }

  // readQRを起動し形状情報を読み込み，フレームを表示する
  // problemReadButtonが押されたらイベント発生
  @FXML
  public void onProblemReadClicked() throws IOException, InterruptedException {
    // final String readQRAbsolutePath = new File(readQRCurrentPath).getAbsolutePath();
    ProcessBuilder pb = new ProcessBuilder(readQRAbsolutePath, "0", "0");
    Process process = pb.start();

    process.waitFor();
    InputStream is = process.getInputStream();
    InputStream eis = process.getErrorStream();
    process.waitFor();

    BufferedReader bf = new BufferedReader(new InputStreamReader(eis));
    for (String s; (s = bf.readLine()) != null; ) {
      String t = consoleArea.getText();
      consoleArea.setText(t + '\n' + s);
    }

    problem.inputProblem(new BufferedReader(new InputStreamReader(is)));
    problem.showFrame(myCanvas.getGraphicsContext2D());
    piecesLabel.setText("Pieces: " + problem.getPieces().size());
  }

  // readQRを起動し配置情報(ヒント)を読み込み，ピースを表示する
  // hintReadButtonが押されたらイベント発生
  @FXML
  public void onHintReadClicked() throws IOException, InterruptedException {
    //final String readQRAbsolutePath = new File(readQRCurrentPath).getAbsolutePath();
    ProcessBuilder pb = new ProcessBuilder(readQRAbsolutePath, "1", "0");
    Process process = pb.start();

    process.waitFor();
    InputStream is = process.getInputStream();
    InputStream eis = process.getErrorStream();
    process.waitFor();

    BufferedReader br = new BufferedReader(new InputStreamReader(eis));
    for (String s; (s = br.readLine()) != null; ) {
      String t = consoleArea.getText();
      consoleArea.setText(t + '\n' + s);
    }

    problem.inputHint(new BufferedReader(new InputStreamReader(is)));
    problem.showHint(myCanvas.getGraphicsContext2D());
  }

  // ソルバに事前に受け取った問題情報をフォーマットに沿って流し込む
  // ソルバからの答えを受け取り，canvasに描画する
  // solveButtonが押されたらイベント発生
  @FXML
  public void onSolveClicked() throws IOException, InterruptedException {
    // final String solverAbsolutePath = new File(solverCurrentPath).getAbsolutePath();
    ProcessBuilder pb = new ProcessBuilder(solverAbsolutePath, "90");
    Process process = pb.start();

    OutputStream os = process.getOutputStream();
    PrintStream ps = new PrintStream(os);

    problem.outputProblem(ps);
    InputStream is = process.getInputStream();
    InputStream eis = process.getErrorStream();

    BufferedReader br = new BufferedReader(new InputStreamReader(eis));

    for (String s; (s = br.readLine()) != null; ) {
      String t = consoleArea.getText();
      consoleArea.setText(t + '\n' + s);
    }
    process.waitFor();

    problem.inputAnswer(new BufferedReader(new InputStreamReader(is)));
    canvasClear();
    problem.showAnswer(myCanvas.getGraphicsContext2D());
  }

  @FXML
  public void onCanvasClearClicked() {
    canvasClear();
  }
}
