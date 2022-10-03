package h05;

abstract public class MeansOfTransport {
    final private char[] VOWELS = new char[]{'A', 'E', 'I', 'O', 'U'};

    protected TransportType transportType;

    /**
     *
     * @return the Transport Type of the vehicle
     */
    public TransportType getTransportType(){
        return transportType;
    }

    /**
     * Drive a predefined distance
     * @param distance to move
     * @return the used fuel/charge
     */
    abstract public int letMeMove(int distance);

    @Override
    public String toString() {
        String transportTypeString = transportType == null ? "undefined" : transportType.toNoun();
        String indefiniteArticle = firstCharIsVowel(transportTypeString) ? "an" : "a";
        return "I am " + indefiniteArticle + " " + transportTypeString + ".";
    }

    /**
     *
     * @param s Input String
     * @return true, if the first character of the Input String is a vowel
     */
    private boolean firstCharIsVowel(String s){
        if(s.length() < 1){
            return false;
        }
        for(char vowel : VOWELS) {
            if(s.charAt(0) == vowel ||s.charAt(0) == vowel + 32){
                return true;
            }
        }
        return false;
    }
}
