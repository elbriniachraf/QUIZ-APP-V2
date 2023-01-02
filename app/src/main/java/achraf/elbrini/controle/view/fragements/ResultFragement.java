package achraf.elbrini.controle.view.fragements;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.HashMap;

import achraf.elbrini.controle.R;
import achraf.elbrini.controle.model.QuizModel;
import achraf.elbrini.controle.model.result;
import achraf.elbrini.controle.reposotorie.QuestionRepository;
import achraf.elbrini.controle.view.activities.MainActivity;
import achraf.elbrini.controle.view.activities.QuizActivity;
import achraf.elbrini.controle.view.adapters.QuizListAdapter;
import achraf.elbrini.controle.viewmodel.QuestViewModel;
import achraf.elbrini.controle.viewmodel.QuizViewModel;

public class ResultFragement extends Fragment {
    QuestViewModel viewmodel;
    TextView tv1,tv2,tv3;
    LottieAnimationView lv;
    CardView bt1,bt2;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root=(ViewGroup) inflater.inflate(R.layout.fragement_result,container,false);
        tv1=root.findViewById(R.id.score);
        tv2=root.findViewById(R.id.rightanswer);
        tv3=root.findViewById(R.id.wronanswer);
        lv=root.findViewById(R.id.desision);
        bt1=root.findViewById(R.id.recommencer);
        bt2=root.findViewById(R.id.quitter);


        int totalquestion=QuestionRepository.rightAnswer+QuestionRepository.wrongAnswer;
        tv1.setText(QuestionRepository.score+"/");
        tv2.setText(QuestionRepository.rightAnswer+"");
        tv3.setText(QuestionRepository.wrongAnswer+"");


        if(QuestionRepository.score>totalquestion){
            lv.setAnimation(R.raw.success);
        }
        else{
            lv.setAnimation(R.raw.faillure);
        }

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
                System.exit(0);
            }
        });
        
        
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(root.getContext(),MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });


        return  root;

    }
}
