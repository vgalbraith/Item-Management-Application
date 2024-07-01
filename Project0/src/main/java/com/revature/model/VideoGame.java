package com.revature.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="Video_games")
public class VideoGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="game_id")
    private Integer game_id;

    @Column(name="title")
    private String title;

    @Column(name="platform")
    private String platform;

    @Column(name="owned_by")
    private Integer owned_by;

    public VideoGame() {
    }

    public VideoGame(Integer game_id, String title, String platform, Integer owned_by) {
        this.game_id = game_id;
        this.title = title;
        this.platform = platform;
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
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
        return Objects.equals(game_id, videoGame.game_id) && Objects.equals(title, videoGame.title) && Objects.equals(platform, videoGame.platform) && Objects.equals(owned_by, videoGame.owned_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game_id, title, platform, owned_by);
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "game_id=" + game_id +
                ", title='" + title + '\'' +
                ", platform='" + platform + '\'' +
                ", owned_by=" + owned_by +
                '}';
    }
}