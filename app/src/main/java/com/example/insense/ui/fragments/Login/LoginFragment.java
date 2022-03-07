package com.example.insense.ui.fragments.Login;

import static android.util.Log.i;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.insense.R;
import com.example.insense.databinding.FragmentLoginBinding;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.material.snackbar.Snackbar;

import static androidx.navigation.Navigation.findNavController;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static final String TAG = "LoginFragment";
    public static final int SIGN_IN_RESULT_CODE = 1001;

    // TODO: Rename and change types of parameters
    private LoginViewModel viewModel = new LoginViewModel();

    private FragmentLoginBinding binding;

    private NavController navController;


    public LoginFragment() {
        // Required empty public constructorww
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false);
        binding.loginButton.setOnClickListener(oclBtnOk);
        return binding.getRoot();
    }

    View.OnClickListener oclBtnOk = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            launchSignInFlow();

        }
    };
    private void launchSignInFlow() {

        List<AuthUI.IdpConfig> providers;
        providers = new ArrayList<AuthUI.IdpConfig>(
                Arrays.asList((new AuthUI.IdpConfig.EmailBuilder()).build(),
                        (new AuthUI.IdpConfig.GoogleBuilder()).build())
        );

        this.startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(
                        providers
                ).build(), SIGN_IN_RESULT_CODE
        );
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==SIGN_IN_RESULT_CODE){
            IdpResponse response =IdpResponse.fromResultIntent(data);
            if(resultCode == Activity.RESULT_OK){
                i(
                        TAG,
                        "Successfully signed in user " +
                                "${FirebaseAuth.getInstance().currentUser?.displayName}!"
                );
            }else{
                Log.i(TAG, "Sign in unsuccessful ${response?.error?.errorCode}");
            }
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        navController = Navigation.findNavController(view);
        OnBackPressedCallback callback = new OnBackPressedCallback(
                true // default to enabled
        ) {
            @Override
            public void handleOnBackPressed() {

            }

            public Object invoke(Object var1) {
                this.invoke((OnBackPressedCallback)var1);
                return Unit.INSTANCE;
            }

            @SuppressLint("ResourceType")
            public final void invoke(@NotNull OnBackPressedCallback $this$addCallback) {
                Intrinsics.checkNotNullParameter($this$addCallback, "$receiver");
                navController.popBackStack(1000165, false);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

        viewModel.authenticationState.observe(getViewLifecycleOwner(), authenticationState -> {
            if( authenticationState == LoginViewModel.AuthenticationState.AUTHENTICATED){
                navController.popBackStack();
                navController.navigate(R.id.profileFragment);
            }else{
                Snackbar.make(view,"LOL",Snackbar.LENGTH_LONG).show();
            }
        });


    }


}