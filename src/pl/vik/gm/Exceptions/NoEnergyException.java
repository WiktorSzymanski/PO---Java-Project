package pl.vik.gm.exceptions;

public class NoEnergyException extends GMExceptions {
    @Override
    public String toString() {
        return "Not enough energy to perform this action";
    }
}
