package sorter.project.utils;

public final class Validation {
    private Validation() {
        throw new UnsupportedOperationException();
    }

    public static boolean generalValidation(String line) {
        if (line == null || line.trim().isEmpty()) {
            return false;
        }
        String[] value = line.split(" ");
        return value.length <= 3;
    }

    public static boolean animalValidation(String line) {
        String[] value = line.split(" ");
        if (Character.isUpperCase(value[0].charAt(0)) && value.length == 1) {
            return true;
        }
        return (value.length >= 2) && (value[1].equals("true") || value[1].equals("false")) && Character.isUpperCase(value[0].charAt(0));

    }

    public static boolean manValidation(String line) {
        String[] value = line.split(" ");
        if (!Character.isUpperCase(value[0].charAt(0))) {
            return false;
        }
        if (value.length >= 2) {
            String ageStr = value[1].trim();
            int age;
            try {
                age = Integer.parseInt(ageStr);
                if (age < 0 || age > 120) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
            if (value.length == 3) {
                String gender = value[2].trim();
                return gender.equals("man") || gender.equals("woman");
            }

        }
        return true;

    }

    public static boolean barrelValidation(String line) {
        String[] value = line.split(" ");
        boolean n = false;
        int indexOfPoint = value[0].indexOf('.');
        try {
            String volumeStr = value[0].trim();
            float volume = Float.parseFloat(volumeStr);
            if (volume < 0) {
                return false;
            }

            for (int i = 0; i < value[0].length(); i++) {
                if (i == indexOfPoint) continue;
                if (Character.isDigit(value[0].charAt(i))) {
                    n = true;
                } else {
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return n;
    }
}