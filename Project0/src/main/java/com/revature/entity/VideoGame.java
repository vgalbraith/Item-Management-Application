package com.revature.entity;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table (name="video_games")
public class VideoGame {

    @Column (name="game_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer game_id;

    @Column (name="title")
    private String title;

    @Column (name="owned_by")
    private Integer owned_by;

    public VideoGame() {
    }

    public VideoGame(String title) {
        this.title = title;
    }

    public VideoGame(Integer game_id, String title, Integer owned_by) {
        this.game_id = game_id;
        this.title = title;
        this.owned_by = owned_by;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOwned_by() {
        return owned_by;
    }

    public void setOwned_by(Integer owned_by) {
        this.owned_by = owned_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoGame videoGame = (VideoGame) o;
        return Objects.equals(game_id, videoGame.game_id) && Objects.equals(title, videoGame.title) && Objects.equals(owned_by, videoGame.owned_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game_id, title, owned_by);
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "game_id=" + game_id +
                ", title='" + title + '\'' +
                ", owned_by=" + owned_by +
                '}';
    }
}