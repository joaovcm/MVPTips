package br.com.jvcm.mvptips.presenter;

import br.com.jvcm.mvptips.contract.WordContract;
import br.com.jvcm.mvptips.model.WordModel;
import br.com.jvcm.mvptips.provider.WordDataProvider;

public class WordPresenter implements WordContract.Presenter {
    //step 1 - ever has-a instance of view (business condition)
    private WordContract.View mView;
    private WordDataProvider mProvider;

    //step 2 - declare constructor
    public WordPresenter(WordContract.View view, WordDataProvider dataProvider) {
        //step 3 - conection of objects
        mView = view;
        mProvider = dataProvider;
    }

    @Override
    public void doAnalyseWord(String word) {
        WordModel model = new WordModel();
        model.setWord(word);
        mProvider.setModel(model);

        if (model.isValidWord()) {
            mView.showCountCharacters(model.getFormattedQuantatyCharacter());
        }

        mView.showCountVowen(model.getFormattedQuantatyVowen());
    }
}
