package ca.davidpellegrini.scorekeepersolution;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.view.View.OnClickListener;

import android.widget.RadioGroup.OnCheckedChangeListener;
import android.view.View.OnKeyListener;

public class MainActivity extends AppCompatActivity  implements OnEditorActionListener, OnClickListener,
        OnCheckedChangeListener, OnKeyListener{

    private TextView teamA,teamB;
    private Button teamAPlus,teamAMinus,teamBPlus,teamBMinus;
    private RadioGroup incrementBy;
    private String teamAScore,teamBScore;
    private RadioButton inc1, inc5, inc10;
    private String scoreAString = "";
    private String scoreBString = "";
    private int increment = 1;

    private String incOrDecStringA = "";
    private String incOrDecStringB = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamA = (TextView) findViewById(R.id.teamA_score_textview);
        teamB = (TextView) findViewById(R.id.teamB_score_textview);
        teamAPlus  = (Button) findViewById(R.id.increase_TeamA_Button3);
        teamAPlus.setOnClickListener(this);
        teamBPlus  = (Button) findViewById(R.id.increase_TeamB_Button);
        teamBPlus.setOnClickListener(this);
        teamAMinus = (Button) findViewById(R.id.decrease_TeamA_Button);
        teamAMinus.setOnClickListener(this);
        teamBMinus = (Button) findViewById(R.id.decrease_TeamB_Button);
        teamBMinus.setOnClickListener(this);
        incrementBy = (RadioGroup) findViewById(R.id.roundingRadioGroup);
        incrementBy.setOnCheckedChangeListener(this);

        inc1 = (RadioButton) findViewById(R.id.noRoundingRadioButton);
        inc5 = (RadioButton) findViewById(R.id.noRoundingRadioButton5);
        inc10 = (RadioButton) findViewById(R.id.noRoundingRadioButton10);
    }

    public void calculateAndDisplayA(){
        scoreAString = teamA.getText().toString();
       // scoreBString = teamB.getText().toString();

        int scoreA,scoreB;
        if(scoreAString.equals("")){
            scoreA = 0;
        }
        else{
            scoreA = Integer.parseInt(scoreAString);
        }
        /*if(scoreBString.equals("")){
            scoreB = 0;
        }
        else{
            scoreB = Integer.parseInt(scoreBString);
        }*/

            if (incOrDecStringA == "increment") {
                scoreA = scoreA + increment;
                teamA.setText(Integer.toString(scoreA));
            } else {
                scoreA = scoreA - increment;
                if(scoreA==0)
                    teamA.setText("0");
                else
                teamA.setText(Integer.toString(scoreA));
            }


    }

    public void calculateAndDisplayB(){
        scoreBString = teamB.getText().toString();
        int scoreB;
        if(scoreBString.equals("")){
            scoreB = 0;
        }
        else{
            scoreB = Integer.parseInt(scoreBString);
        }
        /*if(scoreBString.equals("")){
            scoreB = 0;
        }
        else{
            scoreB = Integer.parseInt(scoreBString);
        }*/

            if (incOrDecStringB == "increment") {
                scoreB = scoreB + increment;
                teamB.setText(Integer.toString(scoreB));
            } else {

                scoreB = scoreB - increment;
                if(scoreB==0)
                    teamB.setText("0");
                else
                teamB.setText(Integer.toString(scoreB));
            }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.increase_TeamA_Button3:
                incOrDecStringA = "increment";
                calculateAndDisplayA();
                break;
            case R.id.decrease_TeamA_Button:
                incOrDecStringA = "decrement";
                calculateAndDisplayA();
                break;
            case R.id.increase_TeamB_Button:
                incOrDecStringB = "increment";
                calculateAndDisplayB();
                break;
            case R.id.decrease_TeamB_Button:
                incOrDecStringB = "decrement";
                calculateAndDisplayB();
                break;
            /*default:
                Default is like the else in an if statement
                With onClick it can be dangerous because it
                    will run when something other than our
                    button is clicked
                break;
             */
        }

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Log.e("checkedId: ", Integer.toString(checkedId));
        switch (checkedId){
            case R.id.noRoundingRadioButton:
            default:
                increment = 1;
                break;
            case R.id.noRoundingRadioButton5:
                increment = 5;
                break;
            case R.id.noRoundingRadioButton10:
                increment = 10;
                break;
        }
        //calculateAndDisplayA();
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
    }
}
