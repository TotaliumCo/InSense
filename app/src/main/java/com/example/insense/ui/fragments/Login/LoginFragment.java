package com.example.insense.ui.fragments.Login;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;


import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.example.insense.R;
import com.example.insense.databinding.FragmentLoginBinding;
import com.example.insense.ui.fragments.Binding.BindingFragment;
import com.firebase.ui.auth.AuthUI;

import static androidx.navigation.Navigation.findNavController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;
    LoginViewModel viewModel = new LoginViewModel();
    private static final int SIGN_IN_RESULT_CODE = 1001;

    public LoginFragment() {
    }

  public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }


    }

    private void observeAuthenticationState() {
        viewModel.authenticationState.observe(getViewLifecycleOwner(),

                authenticationState ->{
                    if(authenticationState == LoginViewModel.AuthenticationState.AUTHENTICATED){
                        binding.signin.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.mainFragment));
                    }else{
                        binding.signin.setOnClickListener(view123-> {
                                    List<AuthUI.IdpConfig> providers = Arrays.asList(new AuthUI.IdpConfig.GoogleBuilder().build(),
                                            new AuthUI.IdpConfig.EmailBuilder().build());
                                    startActivityForResult(
                                            AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(
                                                    providers
                                            ).build(), SIGN_IN_RESULT_CODE
                                    );
                                }
                        );
                        binding.signup.setOnClickListener(view12 -> {
                        //    Navigation.findNavController(view).navigate(R.id.registerFragment);
                        });
                    }
                });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        observeAuthenticationState();
    }
}