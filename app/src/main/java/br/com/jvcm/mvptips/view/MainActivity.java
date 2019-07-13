package br.com.jvcm.mvptips.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.jvcm.mvptips.R;
import br.com.jvcm.mvptips.contract.WordContract;
import br.com.jvcm.mvptips.presenter.WordPresenter;
import br.com.jvcm.mvptips.provider.WordDataProvider;

//is-a WordContract.View
public class MainActivity extends AppCompatActivity implements WordContract.View {

    //step 1 - view ever has-a instance of presenter (business condition)
    private WordContract.Presenter mPresenter;
    private EditText word;
    private Button analyze;
    private TextView quantityVowen;
    private TextView quantityCharacter;
    private WordDataProvider mProvider = new WordDataProvider();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //step 2 - initialize presenter
        mPresenter = new WordPresenter(this, mProvider);
        word = findViewById(R.id.edt_word);
        analyze = findViewById(R.id.btn_analyze);
        quantityCharacter = findViewById(R.id.tv_character);
        quantityVowen = findViewById(R.id.tv_vowen);
        analyze.setOnClickListener(this::onClickAnalyze);

    }

    private void onClickAnalyze(View view){
        mPresenter.doAnalyseWord(word.getText().toString());
    }

    private void onClickDetails(View view){
        //start activity detail

    }


    @Override
    public void showCountCharacters(String quantity) {
        quantityCharacter.setText(quantity);

    }

    @Override
    public void showCountVowen(String quantity) {
        quantityVowen.setText(quantity);

    }
}
