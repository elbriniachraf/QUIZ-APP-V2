package achraf.elbrini.controle.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.HashMap;

import achraf.elbrini.controle.model.QuestionModel;
import achraf.elbrini.controle.model.QuizModel;

import achraf.elbrini.controle.reposotorie.QuizListReposotory;

public class QuizViewModel extends AndroidViewModel{
    private MutableLiveData<ArrayList<QuizModel>> quizMutableLiveData;

    private QuizListReposotory repository;

    public QuizViewModel(@NonNull Application application) {
        super(application);
        repository=new QuizListReposotory();
        quizMutableLiveData = new MutableLiveData<>();
    }


    // get all quiz
    public MutableLiveData<ArrayList<QuizModel>> getdata(){
        MutableLiveData<ArrayList<QuizModel>> mld=new MutableLiveData<>();
        mld=repository.loaddata();
        return mld;
    }



}
