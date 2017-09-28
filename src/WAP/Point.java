package WAP;

import java.io.*;

public class Point {
  final double MAG = 5.0;
  private double x, y;
  public Point() {}
  public Point(Double _x, Double _y) {
    x = _x;
    y = _y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public void input(BufferedReader br) throws IOException {
    String[] s = br.readLine().split(" ");
    x = Double.parseDouble(s[0]) * MAG;
    y = Double.parseDouble(s[1]) * MAG;
  }
}
