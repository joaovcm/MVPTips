package br.com.jvcm.mvptips;

import org.junit.Test;

import br.com.jvcm.mvptips.contract.WordContract;
import br.com.jvcm.mvptips.presenter.WordPresenter;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private WordContract.Presenter mPresenter;
    private int quantityCharacters;
    private int quantityVowen;

    private WordContract.View mView = new WordContract.View() {
        @Override
        public void showCountCharacters(String quantity) {
            quantityCharacters = Integer.parseInt(quantity);
        }

        @Override
        public void showCountVowen(String quantity) {
            quantityVowen = Integer.parseInt(quantity);
        }

    };

    @Test
    public void testWordAnalyse(){
        mPresenter = new WordPresenter(mView);
        mPresenter.doAnalyseWord("Jean");
        assertTrue(quantityCharacters == 4);
        assertTrue(quantityVowen == 2);
    }
}