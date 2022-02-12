package pl.vik.gm.save_load;

public class NoSpacesInNameAllowed extends GMExceptions {
    @Override
    public String toString() {
        return "No spaces allowed in file name!";
    }
}
