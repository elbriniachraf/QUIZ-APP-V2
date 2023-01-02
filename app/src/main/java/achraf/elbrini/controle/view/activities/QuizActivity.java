package achraf.elbrini.controle.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mikhaellopez.circularfillableloaders.CircularFillableLoaders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import achraf.elbrini.controle.R;
import achraf.elbrini.controle.model.QuestionModel;
import achraf.elbrini.controle.model.result;
import achraf.elbrini.controle.reposotorie.QuestionRepository;
import achraf.elbrini.controle.viewmodel.QuestViewModel;

public class QuizActivity extends AppCompatActivity {





    // les widgets
    TextView tv;
    RadioButton rb1,rb2,rb3;
    RadioGroup rg;
    CardView cv;
    CircularFillableLoaders cf;


    // les donnees et classes
    QuestViewModel viewmodel;
    TimerTask timerTask;
    Timer timer;
    int score=0;
    int rightAnswer=0;
    int wronanswer=0;
    static int cpt=100;
    public static int currentquestion=0;
    String quiz;
    String answerActuel;
    ArrayList<QuestionModel> listqQuestionModels;
    ArrayList<Integer> reponse_index=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // recuperer les widgets
        tv=findViewById(R.id.question);
        rb1=findViewById(R.id.rep1);
        rb2=findViewById(R.id.rep2);
        rb3=findViewById(R.id.rep3);
        cf=findViewById(R.id.circularFillableLoaders);
        cv=findViewById(R.id.cv);
        rg=findViewById(R.id.rg);


        // get informations(quiz nb_questionq)
        Intent in=getIntent();
        quiz=in.getStringExtra("quiz");
        int nb_question=in.getIntExtra("nbquestion",0);

        // get data from viewmodel
        viewmodel = new ViewModelProvider(this).get(QuestViewModel.class);
        viewmodel.getquestions(quiz,nb_question).observe(QuizActivity.this, new Observer<ArrayList<QuestionModel>>() {
            @Override
            public void onChanged(ArrayList<QuestionModel> questions) {
                if(questions.size()>0){
                    listqQuestionModels=questions;
                    loadnewQuestion();
                }
            }
        });

        // charger nouveaux question dans chaque clic sur un radiobutton
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId!= -1){
                    RadioButton rb=findViewById(checkedId);
                    answerActuel=rb.getText().toString();
                    if(currentquestion<listqQuestionModels.size()-1){
                        if(recuperrep(checkedId)==listqQuestionModels.get(currentquestion).numreponsejuste){
                            score=score+2;
                            rightAnswer++;
                        }
                        else{
                            wronanswer++;
                        }

                        reponse_index.add(recuperrep(checkedId));
                        currentquestion++;
                        loadnewQuestion();

                    }
                    else if(currentquestion==listqQuestionModels.size()-1){
                        if(recuperrep(checkedId)==listqQuestionModels.get(currentquestion).numreponsejuste){
                            score=score+2;
                            rightAnswer++;
                        }
                        else{
                            wronanswer++;
                        }


                        submitResults();

                        QuestionRepository.score=score;
                        QuestionRepository.rightAnswer=rightAnswer;
                        QuestionRepository.wrongAnswer=wronanswer;



                    }




                }
            }
        });


        if(timer!=null){
            timer.cancel();
        }
        timer=new Timer();
    }



 // charger nouveau question
    public void loadnewQuestion(){
        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slider_up);
        cv.startAnimation(animFadeIn);
        tv.setText(String.valueOf(currentquestion)+" "+listqQuestionModels.get(currentquestion).question);
        rb1.setText(listqQuestionModels.get(currentquestion).rep1);
        rb2.setText(listqQuestionModels.get(currentquestion).rep2);
        rb3.setText(listqQuestionModels.get(currentquestion).rep3);
        setdefault();
        cpt=100;
        timer.cancel();
        timer=new Timer();
        runtimer();
    }


// UNCHECKED LES RADIOBUTTON
    public void setdefault(){
        rb1.setChecked(false);
        rb2.setChecked(false);
        rb3.setChecked(false);
    }


// recuperer la reponse checker
    public int recuperrep(int checkedid){
        switch (checkedid){
            case R.id.rep1:
                return 1;
            case R.id.rep2:
                return 2;
            case R.id.rep3:
                return 3;
        }
        return 0;
    }






    // commencer le timer dans chaque question (30s)
    public void runtimer(){
        timerTask=new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        cf.setProgress(cpt);
                        cpt=cpt-10;
                        if(cpt<=-10){
                            currentquestion++;
                            loadnewQuestion();
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask,500,3000);
    }


    public void submitResults() {
        QuestionRepository.quiz=quiz;
        QuestionRepository.score=score;
        QuestionRepository.rightAnswer=rightAnswer;
        QuestionRepository.wrongAnswer=wronanswer;
        QuestionRepository.reponsesIndex=reponse_index;
        QuestionRepository.listquestion=listqQuestionModels;
        Intent intent=new Intent(QuizActivity.this,ResultActivity.class);
        startActivity(intent);
        finish();
    }


}