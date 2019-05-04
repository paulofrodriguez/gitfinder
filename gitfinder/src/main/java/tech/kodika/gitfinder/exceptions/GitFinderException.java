package tech.kodika.gitfinder.exceptions;

public class GitFinderException extends Exception {

    public GitFinderException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public GitFinderException() {
        super();
    }

    public GitFinderException(String s) {
        super(s);
    }

    public GitFinderException(Throwable throwable) {
        super(throwable);
    }

    protected GitFinderException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
