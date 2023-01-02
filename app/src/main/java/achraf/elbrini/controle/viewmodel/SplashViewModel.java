package achraf.elbrini.controle.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import achraf.elbrini.controle.reposotorie.SplashReposotorie;

public class SplashViewModel extends AndroidViewModel {
    private SplashReposotorie splashReposotorie;


    public SplashViewModel(@NonNull Application application) {
        super(application);
        splashReposotorie=new SplashReposotorie();
    }


}
