package com.example.insense.ui.main_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.Navigation;

import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.example.insense.R;
import com.example.insense.ui.fragments.Login.LoginViewModel;

public class MainActivity extends AppCompatActivity {
    LoginViewModel viewModel = new LoginViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
       NavGraph navGraph = navController.getNavInflater().inflate(R.navigation.nav_graph);
       navGraph.setStartDestination(R.id.starterFragment);
       viewModel.authenticationState.observe(this,
               authenticationState ->{
           if(authenticationState == LoginViewModel.AuthenticationState.AUTHENTICATED) {
               navController.navigate(R.id.mainFragment);
           }else{
               navController.navigate(R.id.loginFragment);
           }
       });
       navController.setGraph(navGraph);
    }
}