package com.seniorsteps.mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.seniorsteps.mvvm.API.Responses.User;
import com.seniorsteps.mvvm.Base.MyBaseActivity;

public class Login extends MyBaseActivity {

    EditText username,password;
    Button login;
    LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intitView();
        viewModel = ViewModelProviders.of(this)
                .get(LoginViewModel.class);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameString = username.getText().toString();
                String passwordString = password.getText().toString();
                viewModel.login(usernameString,passwordString);
            }
        });


        viewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
               if(user!=null){
                   //navigate to home activity
               }
            }
        });
        viewModel.getMessage()
                .observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                       ShowMessage("",s);
                    }
                });

    }

    private void intitView() {
        username =findViewById(R.id.user_name);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
    }
}
