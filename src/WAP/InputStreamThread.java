package WAP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputStreamThread extends Thread {
    private BufferedReader br;
    private ArrayList<String> list;

    public InputStreamThread(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is));
        list = new ArrayList<String>();
    }

    @Override
    public void run() {
        try {
            for (String s; (s = br.readLine()) != null; ) {
                list.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getList() {
        return list;
    }
}
