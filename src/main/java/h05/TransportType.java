package h05;

public enum TransportType {
    BIKE, CAR, VESSEL, PLANE;

    public String toNoun(){
        char[] name = this.name().toCharArray();
        for(int i = 0; i < name.length; i++){
            name[i] = i == 0 ? toUpper(name[i]) : toLower(name[i]);
        }
        return new String(name);
    }

    private char toUpper(char c){
        if(c >= 'a' && c <= 'z'){
            return (char)(c - 32);
        }
        return c;
    }

    private char toLower(char c){
        if(c >= 'A' && c <= 'Z'){
            return (char)(c + 32);
        }
        return c;
    }
}
