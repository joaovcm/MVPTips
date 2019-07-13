package br.com.jvcm.mvptips.contract;

public interface WordContract {
    interface Presenter{
        void doAnalyseWord(String word);
    }

    interface View{
        void showCountCharacters(String quantity);

        void showCountVowen(String quantity);
    }
}