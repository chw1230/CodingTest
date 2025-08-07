import java.io.*;

public class Main {
    private static char[][] arr;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void div(int i, int j,int size) throws IOException {
        if (check(i, j,size)) {
            bw.write(arr[i][j]);
            return;
        } else {
            bw.write("(");
            size = size / 2;
            div(i, j, size);
            div(i, j+size, size);
            div(i+size, j, size);
            div(i+size, j+size, size);
        }
        bw.write(")");
    }

    static boolean check(int i, int j,int size) {
        int save = arr[i][j];
        for (int k = 0; k < size; k++) {
            for (int l = 0; l < size; l++) {
                if ( save != arr[i+k][j+l]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt((br.readLine()));

        arr = new char[N][N];

        for (int i = 0; i < arr.length; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        div(0, 0,N);

        bw.flush();
        bw.close();
    }
}