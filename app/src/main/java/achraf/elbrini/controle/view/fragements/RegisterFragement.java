package achraf.elbrini.controle.view.fragements;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseUser;

import achraf.elbrini.controle.R;
import achraf.elbrini.controle.model.User;
import achraf.elbrini.controle.view.activities.MainActivity;
import achraf.elbrini.controle.viewmodel.AuthViewModel;

public class RegisterFragement extends Fragment {
    ImageView im;
    EditText email,pass,repass;
    Button signup;
    public AuthViewModel viewmodel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=(View) inflater.inflate(R.layout.fragement_register,container,false);
        im=view.findViewById(R.id.go_tologin);
        email=view.findViewById(R.id.emailsi);
        pass=view.findViewById(R.id.passsi);
        repass=view.findViewById(R.id.repassi);
        signup=view.findViewById(R.id.signup);

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView,LoginFragement.class,null)
                        .commit();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailTxt=email.getText().toString();
                String passTxt=pass.getText().toString();
                String repassTxt=repass.getText().toString();
                if (!emailTxt.isEmpty() && !passTxt.isEmpty()){
                    viewmodel.signUp(emailTxt , passTxt,repassTxt).observe(getViewLifecycleOwner(), new Observer<User>() {
                        @Override
                        public void onChanged(User user) {
                            if(user.email !=null){
                                Intent intent=new Intent(getContext(),MainActivity.class);
                                startActivity(intent);
                            }

                        }
                    });
                    Toast.makeText(getContext(), "register Successfully", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getContext(), "Please Enter Email and Pass", Toast.LENGTH_SHORT).show();
                }


            }
        });

        return  view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewmodel = new ViewModelProvider(this , ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication())).get(AuthViewModel.class);

    }
}
