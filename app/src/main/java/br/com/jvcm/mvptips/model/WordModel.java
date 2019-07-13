package br.com.jvcm.mvptips.model;

public class WordModel {
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean isValidWord(){
        return word !=null;
    }

    public int getQuantityVowen(){
        String[] vowes = {"A", "E", "I", "O", "U"};

        int quantity = 0;
        for (String word: word.split("")) {

            for(String vow: vowes){
                if(word.equalsIgnoreCase(vow)){
                    quantity++;
                }
            }
        }
        return quantity;
    }

    public String getFormattedQuantatyVowen(){
        return String.valueOf(getQuantityVowen());
    }

    public String getFormattedQuantatyCharacter(){
        return String.valueOf(word.length());


    }
}
