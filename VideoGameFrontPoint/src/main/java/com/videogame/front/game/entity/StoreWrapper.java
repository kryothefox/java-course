package com.videogame.front.game.entity;

public class StoreWrapper {
    private Store store;

    public StoreWrapper() {}

    // Getters y Setters
    public Store getStore() { return store; }
    public void setStore(Store store) { this.store = store; }

    @Override
    public String toString() {
        return "StoreWrapper{" +
               "store=" + store +
               '}';
    }
}