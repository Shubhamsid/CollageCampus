package blog.sidvitech.com.authentication.LogIn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;
import android.widget.TextView;

import blog.sidvitech.com.activity.MainActivity;
import blog.sidvitech.com.activity.R;

//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import blog.sidvitech.com.fragments.signup;

public class BaseActivity extends MainActivity {

    Button btnlogin;
    TextView rgstlink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnlogin=(Button)findViewById(R.id.btnlogin);
        rgstlink= (TextView) findViewById(R.id.tvforgotpassword);
        Fragment f=new Login();
//        FragmentManager fm=getSupportFragmentManager();
//        fm.beginTransaction().add(R.id.flfrholder,f).commit();

        if (savedInstanceState == null) {
            // only create fragment if activity is started for the first time
            FragmentManager mFragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

            Login fragment = new Login();

            fragmentTransaction.add(R.id.flfrholder, fragment);
            fragmentTransaction.commit();
        }

//        init();
    }

//    public void init(){
//        rgstlink.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment f=new signup();
//                FragmentManager fm=getSupportFragmentManager();
//                fm.beginTransaction().add(R.id.flfrholder,f).commit();
//            }
//        });
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == Login.RC_SIGN_IN) {
            Login fragment = (Login) getSupportFragmentManager()
                    .findFragmentById(R.id.flfrholder);
            fragment.onActivityResult(requestCode, resultCode, data);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
