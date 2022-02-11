package pl.vik.gm.save_load;

abstract public class GMExceptions extends Exception {
}

class EmptyLabelException extends GMExceptions {
    @Override
    public String toString() {
        return "Save file name can not be empty!";
    }
}

class NoSpacesInNameAllowed extends GMExceptions {
    @Override
    public String toString() {
        return "No spaces allowed in file name!";
    }
}