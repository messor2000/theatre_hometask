package visitor;

import java.util.*;

public class Listener implements Respect {
    private Sex sex;
    private int mustacheLength;
    private int broochNumbers;

    public Sex getSex() {
        return sex;
    }

    public int getMustacheLength() {
        return mustacheLength;
    }

    public int getBroochNumbers() {
        return broochNumbers;
    }

    @Override
    public int getRespect() {
        int respect = 0;

        switch (sex) {
            case GENTLEMAN:
                respect = getMustacheLength();
                break;
            case LADY:
                respect = getBroochNumbers();
                break;
        }
        return respect;
    }

    public static class Builder {
        private final Listener listener;

        public Builder() {
            listener = new Listener();
        }

        public Listener gentleman(int mustacheLength) {
            listener.sex = Sex.GENTLEMAN;
            listener.mustacheLength = mustacheLength;
            return listener;
        }

        public Listener lady(int broochNumbers) {
            listener.sex = Sex.LADY;
            listener.broochNumbers = broochNumbers;
            return  listener;
        }
    }

//    public Listener(Sex sex, int mustacheLength) {
//        this.sex = sex;
//        this.mustacheLength = mustacheLength;
//    }
//
//    public Listener(Sex sex, int broochNumbers) {
//        this.sex = sex;
//        this.broochNumbers = broochNumbers;
//    }

    @Override
    public String toString() {
        return "Listener{" +
                "sex is '" + sex + '\'' +
                ", mustache length=" + mustacheLength +
                ", brooch numbers=" + broochNumbers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Listener listener = (Listener) o;
        return mustacheLength == listener.mustacheLength &&
                broochNumbers == listener.broochNumbers &&
                Objects.equals(sex, listener.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sex, mustacheLength, broochNumbers);
    }
}
