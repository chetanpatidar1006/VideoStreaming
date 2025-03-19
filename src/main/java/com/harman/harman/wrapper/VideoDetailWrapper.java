package com.harman.harman.wrapper;

public class VideoDetailWrapper {

        private String title;
        private String director;
        private String cast;
        private String genre;
        private int runningTime;

        public VideoDetailWrapper(String title, String director, String cast, String genre, int runningTime) {
            this.title = title;
            this.director = director;
            this.cast = cast;
            this.genre = genre;
            this.runningTime = runningTime;
        }

        // Getters and Setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getCast() {
            return cast;
        }

        public void setCast(String cast) {
            this.cast = cast;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public int getRunningTime() {
            return runningTime;
        }

        public void setRunningTime(int runningTime) {
            this.runningTime = runningTime;
        }

    @Override
    public String toString() {
        return "VideoDetailWrapper{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", cast='" + cast + '\'' +
                ", genre='" + genre + '\'' +
                ", runningTime=" + runningTime +
                '}';
    }
}
