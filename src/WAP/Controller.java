package WAP;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.canvas.*;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
  @FXML private Canvas myCanvas;
  @FXML private Button problemReadButton, hintReadButton, solveButton;
  @FXML private Label piecesLabel;
  private Problem problem = new Problem();

  @FXML
  public void onProblemReadClicked() throws IOException, InterruptedException {
    final String readQRCurrentPath = "cppReadQR/build/readqr";
    //final String readQRAbsolutePath = new File(readQRCurrentPath).getAbsolutePath();
    final String readQRAbsolutePath = "/Users/kurokoji/Dropbox/kurokoji/procon28dev/cppReadQR/build/readqr";
    ProcessBuilder pb = new ProcessBuilder(readQRAbsolutePath, "0", "0");
    Process process = pb.start();

    process.waitFor();
    InputStream is = process.getInputStream();
    InputStream eis = process.getErrorStream();

    process.waitFor();

    problem.inputProblem(new BufferedReader(new InputStreamReader(is)));

    problem.showProblem(myCanvas.getGraphicsContext2D());
    piecesLabel.setText("Pieces: " + problem.getPieces().length);
  }


  @FXML
  public void onHintReadClicked() {

  }

  @FXML
  public void onSolveClicked() {

  }
}
