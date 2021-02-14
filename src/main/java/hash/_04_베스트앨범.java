package hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 */
public class _04_베스트앨범 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
            new String[]{"classic", "pop", "classic", "classic", "pop"},
            new int[]{500, 600, 150, 800, 2500}
        )));
    }

    private static class Stat {
        private int genrePlayCount;
        private List<Song> songs = new ArrayList<>();

        public Stat(int genrePlayCount) {
            this.genrePlayCount = genrePlayCount;
        }

        public int getGenrePlayCount() {
            return genrePlayCount;
        }

        public void setGenrePlayCount(int genrePlayCount) {
            this.genrePlayCount = genrePlayCount;
        }

        public void addSong(Song song) {
            this.songs.add(song);
        }

        public List<Integer> getSortedSongIndexes() {
            return songs.stream()
                .sorted(getSongComparator())
                .limit(2)
                .map(Song::getIndex)
                .collect(Collectors.toList());
        }

        @Override
        public String toString() {
            return "Stat{" +
                "genrePlayCount=" + genrePlayCount +
                ", songs=" + songs +
                '}';
        }
    }

    private static class Song {
        private int index;
        private int playCount;

        public Song(int index, int playCount) {
            this.index = index;
            this.playCount = playCount;
        }

        public int getIndex() {
            return index;
        }

        public int getPlayCount() {
            return playCount;
        }

        @Override
        public String toString() {
            return "Song{" +
                "index=" + index +
                ", playCount=" + playCount +
                '}';
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Stat> stats = new HashMap<>();

        for (int i = 0; i < genres.length; ++i) {
            Stat stat;
            if (!stats.containsKey(genres[i])) {
                stat = new Stat(plays[i]);
                stats.put(genres[i], stat);
            }
            else {
                stat = stats.get(genres[i]);
                stat.setGenrePlayCount(stat.getGenrePlayCount() + plays[i]);
            }

            stat.addSong(new Song(i, plays[i]));
        }

        return stats.values()
            .stream()
            .sorted(Comparator.comparing(Stat::getGenrePlayCount).reversed())
            .map(Stat::getSortedSongIndexes)
            .flatMap(Collection::stream)
            .mapToInt(Integer::intValue)
            .toArray();
    }

    private static Comparator<Song> getSongComparator() {
        return Comparator.comparingInt(Song::getPlayCount).reversed()
            .thenComparingInt(Song::getIndex);
    }
}
