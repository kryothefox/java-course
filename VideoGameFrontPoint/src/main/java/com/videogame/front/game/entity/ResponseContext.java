package com.videogame.front.game.entity;

import java.util.List;
import java.util.Objects;

public class ResponseContext {

    private int count;
    private String next;
    private String previous;
    private List<Game> results;

    public ResponseContext() {
    }

    public ResponseContext(int count,
            String next,
            String previous,
            List<Game> results) {
        this.count =
                count;
        this.next =
                next;
        this.previous =
                previous;
        this.results =
                results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count =
                count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next =
                next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous =
                previous;
    }

    public List<Game> getResults() {
        return results;
    }

    public void setResults(List<Game> results) {
        this.results =
                results;
    }

    @Override
    public String toString() {
        return "ResponseContext{" +
                "count=" +
                count +
                ", next=" +
                next +
                ", previous=" +
                previous +
                ", results=" +
                results +
                '}';
    }

    @Override
    public int hashCode() {
        int hash =
                7;
        hash =
                37 *
                hash +
                this.count;
        hash =
                37 *
                hash +
                Objects.hashCode(this.next);
        hash =
                37 *
                hash +
                Objects.hashCode(this.previous);
        hash =
                37 *
                hash +
                Objects.hashCode(this.results);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this ==
                obj) {
            return true;
        }
        if (obj ==
                null) {
            return false;
        }
        if (getClass() !=
                obj.getClass()) {
            return false;
        }
        final ResponseContext other =
                (ResponseContext) obj;
        if (this.count !=
                other.count) {
            return false;
        }
        if (!Objects.equals(this.next,
                other.next)) {
            return false;
        }
        if (!Objects.equals(this.previous,
                other.previous)) {
            return false;
        }
        return Objects.equals(this.results,
                other.results);
    }

}
