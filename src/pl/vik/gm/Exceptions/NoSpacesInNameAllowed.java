package pl.vik.gm.exceptions;

public class NoSpacesInNameAllowed extends GMExceptions {
    @Override
    public String toString() {
        return "No spaces allowed in file name!";
    }
}
