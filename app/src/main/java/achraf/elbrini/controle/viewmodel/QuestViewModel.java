package achraf.elbrini.controle.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.HashMap;

import achraf.elbrini.controle.model.QuestionModel;
import achraf.elbrini.controle.model.result;

import achraf.elbrini.controle.reposotorie.QuestionRepository;


public class QuestViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<QuestionModel>> questionMutableLiveData;
    private QuestionRepository repository;
    private MutableLiveData<HashMap<String , Long>> resultMutableLiveData;
    private MutableLiveData<result> result_actuel;


// constructor
    public QuestViewModel(@NonNull Application application) {
        super(application);
        questionMutableLiveData = new MutableLiveData<>();
        repository = new QuestionRepository(application);
    }


    //  get all questions 15 30 40
    public MutableLiveData<ArrayList<QuestionModel>> getquestions(String quiz,int nb_questions){
        MutableLiveData<ArrayList<QuestionModel>>  mld=repository.getQuestions(quiz,nb_questions);
        return mld;
    }















}
