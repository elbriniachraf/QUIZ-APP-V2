package achraf.elbrini.controle.view.fragements;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import achraf.elbrini.controle.R;
import achraf.elbrini.controle.reposotorie.QuestionRepository;
import achraf.elbrini.controle.view.activities.ResultActivity;

public class ReviewFragement extends Fragment {
    TextView tv;
    RadioButton rb1,rb2,rb3;
    RadioGroup rg;
    ViewGroup root;
    Button submit;
    int currentindex=0;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root=(ViewGroup) inflater.inflate(R.layout.fragement_review,container,false);
        tv=root.findViewById(R.id.question_rev);
        rb1=root.findViewById(R.id.rep1_rev);
        rb2=root.findViewById(R.id.rep2_rev);
        rb3=root.findViewById(R.id.rep3_rev);
        submit=root.findViewById(R.id.submit_rev);
        rg=root.findViewById(R.id.rg_rev);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentindex<QuestionRepository.listquestion.size()-2){
                    currentindex++;
                    loadquestion();
                    setreponseofuser();
                    verifyanswer();
                }
                else{
                    Intent intent=new Intent(root.getContext(), ResultActivity.class);
                    root.getContext().startActivity(intent);
                }

            }
        });
        loadquestion();
        setreponseofuser();
        verifyanswer();



        return  root;
    }


    private void setreponseofuser(){
        int index=QuestionRepository.reponsesIndex.get(currentindex);
        switch(index){
            case 1:{
                rb1.setChecked(true);
                break;
            }
            case 2:{
                rb2.setChecked(true);
                break;
            }
            case 3:{
                rb3.setChecked(true);
                break;
            }
        }
    }


    private int getreponseofuser(){
        int index=QuestionRepository.reponsesIndex.get(currentindex);
        switch(index){
            case 1:{
                return 1;
            }
            case 2:{
                return 2;
            }
            case 3:{
                return 3;
            }
        }
        return -1;
    }


    private void loadquestion(){
        tv.setText(QuestionRepository.listquestion.get(currentindex).question);
        rb1.setText(QuestionRepository.listquestion.get(currentindex).rep1);
        rb2.setText(QuestionRepository.listquestion.get(currentindex).rep2);
        rb3.setText(QuestionRepository.listquestion.get(currentindex).rep3);
    }





    private void verifyanswer(){
        setdefaultbackground();
        int rb_cheked=getreponseofuser();
        int answer_correct=QuestionRepository.listquestion.get(currentindex).numreponsejuste;
        switch(rb_cheked){
            case 1:{
                if(answer_correct==1){
                    rb1.setBackgroundResource(R.drawable.radio_button_right);
                }
                else{
                    rb1.setBackgroundResource(R.drawable.radio_button_wrong);
                    setrightannswer();
                }
                break;
            }
            case 2:{
                if(answer_correct==2){
                    rb2.setBackgroundResource(R.drawable.radio_button_right);
                }
                else{
                    rb2.setBackgroundResource(R.drawable.radio_button_wrong);
                    setrightannswer();
                }
                break;
            }
            case 3:{
                if(answer_correct==3){
                    rb3.setBackgroundResource(R.drawable.radio_button_right);
                }
                else{
                    rb3.setBackgroundResource(R.drawable.radio_button_wrong);
                    setrightannswer();
                }
                break;
            }

        }






    }

    private void setdefaultbackground(){
        rb1.setBackgroundResource(R.drawable.custom_radiobutton);
        rb2.setBackgroundResource(R.drawable.custom_radiobutton);
        rb3.setBackgroundResource(R.drawable.custom_radiobutton);
    }


    private void setrightannswer(){
        switch(QuestionRepository.listquestion.get(currentindex).numreponsejuste){
            case 1:{
                rb1.setBackgroundResource(R.drawable.radio_button_right);
                break;
            }

            case 2:{
                rb2.setBackgroundResource(R.drawable.radio_button_right);
                break;
            }
            case 3:{
                rb3.setBackgroundResource(R.drawable.radio_button_right);
                break;
            }

        }
    }









}
