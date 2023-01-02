package achraf.elbrini.controle.reposotorie;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import achraf.elbrini.controle.model.DBUser;
import achraf.elbrini.controle.model.User;
import achraf.elbrini.controle.view.activities.MainActivity;

public class AuthReposotory {
    private Application application;
    DBUser dbUser;
    private MutableLiveData<User> usermutablelivedata;

    //constructor
    public AuthReposotory(Application application) {
        this.application = application;
        dbUser=new DBUser(application.getApplicationContext());
        usermutablelivedata=new MutableLiveData<>();
    }



    // registration user and add to user table
    public MutableLiveData<User> signup(String user, String pass,String repass){
        if(user.equals("")||pass.equals("")||repass.equals(""))
            Toast.makeText(application.getApplicationContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
        else{
            if(pass.equals(repass)){
                Boolean checkuser = dbUser.checkusername(user);
                if(checkuser==false){
                    Boolean insert = dbUser.insertData(user, pass);
                    if(insert==true){
                        Toast.makeText(application.getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(application.getApplicationContext(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        application.getBaseContext().startActivity(intent);
                        usermutablelivedata.postValue(new User(user,pass));
                        return usermutablelivedata;
                    }else{
                        Toast.makeText(application.getApplicationContext(), "Registration failed", Toast.LENGTH_SHORT).show();
                        usermutablelivedata.postValue(new User(null,null));
                        return usermutablelivedata;
                    }
                }
                else{
                    Toast.makeText(application.getApplicationContext(), "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(application.getApplicationContext(), "Passwords not matching", Toast.LENGTH_SHORT).show();
            }

        }
        usermutablelivedata.postValue(new User(null,null));
        return usermutablelivedata;
    }


    // se connecter
    public MutableLiveData<User> signIn(String user, String pass){
        if(user.equals("")||pass.equals(""))
            Toast.makeText(application.getApplicationContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
        else{
            Boolean checkuserpass = dbUser.checkusernamepassword(user, pass);
            if(checkuserpass==true){
                Toast.makeText(application.getApplicationContext(), "Sign in successfull", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(application.getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                application.getBaseContext().startActivity(intent);
                usermutablelivedata.postValue(new User(user,pass));
                return usermutablelivedata;


            }else{
                Toast.makeText(application.getBaseContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        }

        usermutablelivedata.postValue(new User(null,null));
        return usermutablelivedata;
    }



}
