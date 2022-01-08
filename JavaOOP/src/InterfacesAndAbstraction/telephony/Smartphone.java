package InterfacesAndAbstraction.telephony;

public class Smartphone implements Callable, Browsable {

    public Smartphone() {
    }

    @Override
    public String browse(String site) {
        boolean isInValid = false;
        char[] siteCharacters = site.toCharArray();
        for (char siteCharacter : siteCharacters) {
            if (Character.isDigit(siteCharacter)){
                isInValid = true;
                break;
            }
        }

        if (isInValid){
            return "Invalid URL!";
        } else {
            return String.format("Browsing: %s!", site);
        }
    }

    @Override
    public String call(String numbers) {
        boolean isInValid = false;
        char[] phoneCharacters = numbers.toCharArray();
        for (char phoneCharacter : phoneCharacters) {
            if (!Character.isDigit(phoneCharacter)){
                isInValid = true;
                break;
            }
        }

        if (isInValid){
            return "Invalid number!";
        } else {
            return "Calling... " + numbers;
        }
    }
}


