package pl.vik.gm.Exceptions;

public class Validators {
    public static String getFileNameFromKeyboard(String name) throws EmptyLabelException, NoSpacesInNameAllowed {
        if (name.equals("")) {
            throw new EmptyLabelException();
        }

        if (name.length() > 0) {
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) == ' ') {
                    throw new NoSpacesInNameAllowed();
                }
            }
        }

        return name;
    }

    public static boolean haveEnergyToMakeThatMove(Integer energyCost, Integer energy) throws NoEnergyException{
        if (energyCost > energy) {
            throw new NoEnergyException();
        }

        return true;
    }
}
