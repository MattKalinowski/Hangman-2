package Hangman.model;

import java.util.Random;

public class Repository {
    
    String word = null;
    
    String[] cities = {   "C a i r o", 
                          "A s p e n", 
                          "B e i j i n g"};
    
    String[] movies = {   "D j a n g o", 
                          "M a t r i x", 
                          "S c a r f a c e"};
    
    String[] animals = {  "e l e p h a n t", 
                          "a p e", 
                          "r a c c o o n"};
    
    String[] music = {    "B e e t h o v e n", 
                          "B l a c k   S a b b a t h", 
                          "Q u e e n"};
    
    String[] food = {     "w a t e r m e l l o n", 
                          "b a n a n a", 
                          "c h e e s e b u r g e r"};
    
    String[] hardWords = { 
                           "n i c o l e  is  a  b a d  m a d a f a k a"};
    
    
    public void setTopic(String topic) {
        switch (topic) {
            case "Cities":
                word = cities[new Random().nextInt(cities.length)];
                break;
            case "Movies":
                word = movies[new Random().nextInt(movies.length)];
                break;
            case "Animals":
                word = animals[new Random().nextInt(animals.length)];
                break;
            case "Music":
                word = music[new Random().nextInt(music.length)];
                break;
            case "Food":
                word = food[new Random().nextInt(food.length)];
                break;
            case "Hard words":
                word = hardWords[new Random().nextInt(hardWords.length)];
                break;
            default:
                System.out.println("Error - incorrect value.");
                break;
        }
    }
    
    public String randomWord() { 
        return word;
    }
}
