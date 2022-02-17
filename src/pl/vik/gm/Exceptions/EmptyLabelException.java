package pl.vik.gm.exceptions;

public class EmptyLabelException extends GMExceptions {
    @Override
    public String toString() {
        return "Save file name can not be empty!";
    }
}
