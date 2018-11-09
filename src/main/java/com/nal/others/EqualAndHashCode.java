package com.nal.others;

/**
 * Created by Nishant on 03-11-2018.
 */
public class EqualAndHashCode {

    private String xyz = "abc";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EqualAndHashCode)) return false;

        EqualAndHashCode sample = (EqualAndHashCode) o;

        return !(xyz != null ? !xyz.equals(sample.xyz) : sample.xyz != null);

    }

    @Override
    public int hashCode() {
        return xyz != null ? xyz.hashCode() : 0;
    }
}
