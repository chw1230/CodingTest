import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        //장르, 재생 수 카운트 값
        HashMap<String, Integer> genreMap = new HashMap<>();

        // 장르, 노래 객체 (id, play(재생수))
        HashMap<String, List<Song>> songMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            songMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }

        List<String> sortedGenres = new ArrayList<>(genreMap.keySet());
        sortedGenres.sort((g1, g2) -> genreMap.get(g2).compareTo(genreMap.get(g1))); // 총 재생 횟수를 기반으로 많은 들은 장르 내림차순 리스트 만들기

        List<Integer> answerList = new ArrayList<>();

        // 장르를 내림차순으로 하나씩 선택하면서
        for (String genre : sortedGenres) {
            List<Song> songList = songMap.get(genre); // 장르당 노래 객체 리스트 뽑기
            Collections.sort(songList); // Song의 compareTo 기준으로 정렬하기

            // 노래가 2개보다 작으면 1번 , 2개보다 크면 2개의 노래만!
            for (int i = 0; i < Math.min(songList.size(), 2); i++) {
                answerList.add(songList.get(i).id);
            }
        }

        return answerList.stream().mapToInt(i -> i).toArray(); // 리스트를 배열로 반환해서 전달하기
    }

    static class Song implements Comparable<Song> {
        int id;
        int play; // 재생 수

        public Song(int id, int play) {
            this.id = id;
            this.play = play;
        }

        @Override
        public int compareTo(Song o) {
            if (this.play == o.play) {
                return Integer.compare(this.id, o.id); // 재생 수가 같은 경우에 고유 번호 오름차순 으로 정렬
            }
            return Integer.compare(o.play, this.play); // 재생 수 내림차순으로 정렬
        }
    }
}