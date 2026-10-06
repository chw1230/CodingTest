import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        // 장르, 장르의 노래가 불린 총 횟수
        HashMap<String, Integer> map1 = new HashMap<>();
        // 장르, 장르에 해당하는 노래
        HashMap<String, List<Song>> map2 = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            Integer play = plays[i];
            map1.put(genre, map1.getOrDefault(genre, 0) + play);

            map2.putIfAbsent(genre, new ArrayList<>());
            map2.get(genre).add(new Song(i, play));
        }

        // 장르별 총 재생 횟수를 기준으로 내림차순
        List<String> sortedGenres = new ArrayList<>(map1.keySet());
        sortedGenres.sort((g1, g2) -> map1.get(g2).compareTo(map1.get(g1)));

        List<Integer> answerList = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<Song> songs = map2.get(genre);
            Collections.sort(songs); // Song 클래스의 compareTo 기준에 따라 정렬

            // 최대 2개까지만 결과에 추가
            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                answerList.add(songs.get(i).num);
            }
        }

        // 4. List를 int[] 배열로 변환하여 반환
        return answerList.stream().mapToInt(i -> i).toArray();
    }

    class Song implements Comparable<Song> {
        Integer num;
        Integer play; // 재생횟수

        public Song(Integer num, Integer play) {
            this.num = num;
            this.play = play;
        }

        @Override
        public int compareTo(Song o) {
            if (this.play == o.play) {
                return this.num.compareTo(o.num);
            }
            return Integer.compare(o.play, this.play);
        }
    }
}