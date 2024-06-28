package com.revature.entity;

import jakarta.persistence.*;

@Entity
public class VideoGame {
    @Column (name="game_id")
    @Id @GeneratedValue
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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VideoGame other = (VideoGame) obj;
        if (game_id == null) {
            if (other.game_id != null)
                return false;
        } else if (!game_id.equals(other.game_id))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (owned_by == null) {
            if (other.owned_by != null)
                return false;
        } else if (!owned_by.equals(other.owned_by))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "game_id=" + game_id +
                ", title=" + title + '\'' +
                ", owned_by=" + owned_by +
                '}';
    }
}