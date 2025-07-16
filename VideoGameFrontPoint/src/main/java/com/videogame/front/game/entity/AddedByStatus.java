package com.videogame.front.game.entity;

public class AddedByStatus {
    private int yet;
    private int owned;
    private int beaten;
    private int toplay;
    private int dropped;
    private int playing;

    public AddedByStatus() {}

    // Getters y Setters
    public int getYet() { return yet; }
    public void setYet(int yet) { this.yet = yet; }
    public int getOwned() { return owned; }
    public void setOwned(int owned) { this.owned = owned; }
    public int getBeaten() { return beaten; }
    public void setBeaten(int beaten) { this.beaten = beaten; }
    public int getToplay() { return toplay; }
    public void setToplay(int toplay) { this.toplay = toplay; }
    public int getDropped() { return dropped; }
    public void setDropped(int dropped) { this.dropped = dropped; }
    public int getPlaying() { return playing; }
    public void setPlaying(int playing) { this.playing = playing; }

    @Override
    public String toString() {
        return "AddedByStatus{" +
               "yet=" + yet +
               ", owned=" + owned +
               ", beaten=" + beaten +
               ", toplay=" + toplay +
               ", dropped=" + dropped +
               ", playing=" + playing +
               '}';
    }
}