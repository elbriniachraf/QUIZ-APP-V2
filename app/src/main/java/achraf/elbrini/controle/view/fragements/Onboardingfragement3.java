package achraf.elbrini.controle.view.fragements;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import achraf.elbrini.controle.R;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import achraf.elbrini.controle.view.activities.LoginActivity;
import achraf.elbrini.controle.view.activities.MainActivity;

public class Onboardingfragement3 extends Fragment {

    FloatingActionButton ft;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root=(ViewGroup) inflater.inflate(R.layout.fragement_on_boarding3,container,false);
        ft=root.findViewById(R.id.ft);
        ft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(root.getContext(), LoginActivity.class);
                startActivity(i);
            }
        });
        return  root;
    }
}
