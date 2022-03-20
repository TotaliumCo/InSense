package com.example.insense.ui.main_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.Navigation;

import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.insense.R;
import com.example.insense.ui.fragments.Login.LoginViewModel;

public class MainActivity extends AppCompatActivity {
    LoginViewModel viewModel = new LoginViewModel();
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavGraph navGraph = navController.getNavInflater().inflate(R.navigation.nav_graph);
        navGraph.setStartDestination(R.id.starterFragment);
        NavController finalNavController = navController;
        viewModel.authenticationState.observe(this,
               authenticationState ->{
           if(authenticationState == LoginViewModel.AuthenticationState.AUTHENTICATED) {
               finalNavController.navigate(R.id.mainFragment);
           }else{
               finalNavController.navigate(R.id.loginFragment);
           }
       });
        navController.setGraph(navGraph);
       // NavHostFragment navhost = (NavHostFragment)getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
      //  navController =  navhost.getNavController();
      //  NavigationUI.setupActionBarWithNavController(this,  navController);
    }
    //метод для нажатия назад в верзнем левом углу
    /* @Override
    public boolean onSupportNavigateUp() {
        if(navController.navigateUp()){
            return true;
        }
        else{
            return super.onSupportNavigateUp();
        }

    }
    ///?????
    @Override
    public void onBackPressed()
    {

        super.onBackPressed();  // optional depending on your needs
    } */
}