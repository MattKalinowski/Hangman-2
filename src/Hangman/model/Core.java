package Hangman.model;

public class Core {
    
    private String word;
    private char[] letters;
    private char[] encrypt;
    public int counter;
    public int missCounter;
    private boolean missed;
    public String topic;
    Repository rep = new Repository();
    
    public Core() {
        
    }
    
    public void setTopic(String topic) {
        this.topic = topic;
        rep.setTopic(topic);
    }
    
    public void setWord() {
        word = rep.randomWord();
    }
    public String getWord() {
        return word;
    }
    public void setLetters() {
        letters = getWord().toCharArray();
    }
    public char[] getLetters() {
        return letters;
    }
    public void setEncrypt() { 
        encrypt = getWord().toCharArray();
        for(int i = 0; i < letters.length; i++) {
            if(letters[i] == encrypt[i] && letters[i] != ' ') {
                encrypt[i] = '_';
            } else if(letters[i] == encrypt[i] && letters[i] == ' ') {
                counter++;
            }
        }
    }
    public char[] getEncrypt() {
        return encrypt;
    }
    public void checkLetters(char c) {    
        
        missed = true;
        for(int i=0; i<letters.length; i++) {
            if (c == Character.toUpperCase(letters[i])) { 
                encrypt[i] = c;
                counter++; 
                missed = false;
            } 
        }   
            if(missed) {
                missCounter++;
        }
    }
    public int getLettersLength() {
        return letters.length;
    }
}
