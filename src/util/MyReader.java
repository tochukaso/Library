package util;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 競技プログラミングコンテスト用
 * 標準入力を扱うクラス
 *
 */
public class MyReader implements Closeable {

    private BufferedReader br = null;
    public MyReader(InputStream in ) {
        this.br = new BufferedReader(new InputStreamReader(in));
    }
    private int brPos = 0;
    private int[] brBuf = null;

    private String delimiter = " ";
    public void close() {
        try {
            this.br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public final int readInt()  {
        if (brBuf == null || brBuf.length == brPos) {
            brBuf = readIntArray();
            brPos = 0;
            return readInt();
        }
        return brBuf[brPos++];
    }

    private String readLine() {
        try {
            return br.readLine();
        } catch(IOException ioe) {
            ioe.printStackTrace();
            throw new RuntimeException(ioe);
        }
    }

    public final int readNextInt()  {
        return Integer.parseInt(readLine());
    }

    public final long readNextLong()  {
        return Long.parseLong(readLine());
    }

    public final int[] readIntArray()  {
        String[] s = readStrArray();
        int cnt = s.length;
        int[] out = new int[cnt];
        for (int i = 0; i < cnt; i++) out[i] = Integer.parseInt(s[i]);
        return out;
    }

    public final int[] readIntColumnArray(int N)  {
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = readInt();
        } 
        return res;
    }
    
    public final int[][] readIntMatrix(int N) {
        int[][] res = new int[N][];
        for (int i = 0; i < N; i++) {
            res[i] = readIntArray();
        }
            
        return res;
    }
    
    public final char[][] readCharMatrix(int N) {
        char[][] res = new char[N][];
        for (int i = 0; i < N; i++) {
            res[i] = readCharArray();
        }
        
        return res;
    }

    public final char[] readCharArray()  {
        String[] s = readStrArray();
        int cnt = s.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) sb.append(s[i]);
        return sb.toString().toCharArray();
    }
    public final long[] readLongArray()  {
        String[] s = readStrArray();
        int cnt = s.length;
        long[] out = new long[cnt];
        for (int i = 0; i < cnt; i++) out[i] = Long.parseLong(s[i]);
        return out;
    }
    
    public final String readString() {
        return readLine();
    }

    public final String[] readStrArray()  {
      List<String> res = new ArrayList<String>();
      StringTokenizer st = new StringTokenizer(readLine(), delimiter);
      while (st.hasMoreTokens()) {
          res.add(st.nextToken());
      }
      return res.toArray(new String[0]);
    }

    public void setDelimiter(String delim) {
        this.delimiter = delim;
    }
    
    public String getDelimiter() {
        return this.delimiter;
    }

}
