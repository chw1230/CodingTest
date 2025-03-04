package thisisCodingTest.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10814 {

    public static class Person implements Comparable<Person>{
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        /* 문제를 잘못 알고 있었음! ㅠㅜㅠㅜ
        @Override
        public int compareTo(Person o) {
            if (this.age == o.age) { // 나이 같으면
                return this.name.compareTo(o.name); // 이름 사전순 비교
            } else {
                return Integer.compare(this.age, o.age); // 나이 비교
            }
        }
         */

        @Override
        public String toString() {
            return age + " " + name;
        }

        @Override
        public int compareTo(Person o) {
            return Integer.compare(this.age, o.age);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Person[] person = new Person[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            person[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(person);
        for (Person p : person) {
            System.out.println(p.age + " " + p.name);
        }
    }
}
