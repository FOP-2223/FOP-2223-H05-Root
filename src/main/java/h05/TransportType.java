package h05;

public enum TransportType {
    BICYCLE, CAR, VESSEL, PLANE;

    public String toNoun(){
        char[] name = this.name().toCharArray();
        for(int i = 0; i < name.length; i++){
            if(isSpecialCharacter(name[i])){
                name[i] = ' ';
            }else {
                name[i] = i == 0 ? toUpper(name[i]) : toLower(name[i]);
            }
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

    private boolean isSpecialCharacter(char c){
        if( (c >= 32 & c <= 47) | (c >= 58 & c <= 64) | (c >= 91 & c <= 96) | (c >= 123 & c <= 126)){
            return true;
        }
        return false;
    }
}
