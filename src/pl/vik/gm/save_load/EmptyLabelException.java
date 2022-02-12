package pl.vik.gm.save_load;

public class EmptyLabelException extends GMExceptions {
    @Override
    public String toString() {
        return "Save file name can not be empty!";
    }
}
