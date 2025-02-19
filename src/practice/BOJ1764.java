package src.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ1764 {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> setN = new TreeSet<>();
        Set<String> setM = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            setN.add(str);
        }
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            setM.add(str);
        }

        setN.retainAll(setM);
        System.out.println(setN.size());
        for (String s : setN) {
            System.out.println(s);
        }


    }
}
