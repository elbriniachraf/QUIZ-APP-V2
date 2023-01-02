package achraf.elbrini.controle.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;


import achraf.elbrini.controle.viewmodel.SplashViewModel;

public class SplashActivity extends AppCompatActivity {
    private SplashViewModel splashViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialsplashmodel();
        goToMainActivity();
    }


    public void initialsplashmodel(){
        splashViewModel=new ViewModelProvider(this).get(SplashViewModel.class);
    }
    private void goToMainActivity(){
        Intent intent = new Intent(SplashActivity.this, OnboardingActivity.class);
        startActivity(intent);
        finish();
    }
}