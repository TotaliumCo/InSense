package com.example.insense.ui.authentication.authentication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.insense.R;
import com.example.insense.databinding.FragmentLoginBinding;
import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;
    private static final int SIGN_IN_RESULT_CODE = 1001;

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        binding.signin.setOnClickListener(view -> {
                    List<AuthUI.IdpConfig> providers = Arrays.asList(new AuthUI.IdpConfig.GoogleBuilder().build());
                    startActivityForResult(
                            AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(
                                    providers
                            ).build(), SIGN_IN_RESULT_CODE
                    );
                }
        );
        binding.signin2.setOnClickListener(view -> {
                    NavController navController = NavHostFragment.findNavController(LoginFragment.this);
                    navController.navigate(R.id.action_loginFragment_to_loginEmailFragment);
                    Log.i("NAV", "onCreateView: nav action_loginFragment_to_loginEmailFragment");
                }
        );
        return binding.getRoot();
    }
}