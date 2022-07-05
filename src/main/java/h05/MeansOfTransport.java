package h05;

abstract public class MeansOfTransport {
    final private char[] VOCALS = new char[]{'A', 'E', 'I', 'O', 'U'};

    protected TransportType transportType;

    TransportType getTransportType(){
        return transportType;
    }

    abstract public int letMeMove(int distance);

    @Override
    public String toString() {
        String transportTypeString = transportType == null ? "undefined" : transportType.toNoun();
        String indefiniteArticle = firstCharIsVocal(transportTypeString) ? "an" : "a";
        return "I am " + indefiniteArticle + " " + transportTypeString + ".";
    }

    private boolean firstCharIsVocal(String s){
        if(s.length() < 1){
            return false;
        }
        for(char vocal : VOCALS) {
            if(s.charAt(0) == vocal ||s.charAt(0) == vocal + 32){
                return true;
            }
        }
        return false;
    }
}
