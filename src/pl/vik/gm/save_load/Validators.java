package pl.vik.gm.save_load;

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
}
