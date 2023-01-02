package achraf.elbrini.controle.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;

import achraf.elbrini.controle.model.User;
import achraf.elbrini.controle.reposotorie.AuthReposotory;

public class AuthViewModel extends AndroidViewModel {
    private MutableLiveData<FirebaseUser> firebasemutablelivedata;
    private FirebaseUser currenUser;
    private AuthReposotory authReposotory;



    public AuthViewModel(@NonNull Application application) {
        super(application);
        authReposotory=new AuthReposotory(application);
    }



    public MutableLiveData<User> signUp(String email, String pass,String repass){

        MutableLiveData<User> mld= authReposotory.signup(email,pass,repass);
        return mld;
    }
    public MutableLiveData<User> signIn(String email,String pass){
        MutableLiveData<User> mld=authReposotory.signIn(email,pass);
        return mld;

    }


}
