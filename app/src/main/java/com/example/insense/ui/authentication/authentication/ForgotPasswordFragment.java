package com.example.insense.ui.authentication.authentication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.insense.R;
import com.example.insense.databinding.FragmentForgotPasswordBinding;
import com.google.firebase.auth.FirebaseAuth;


public class ForgotPasswordFragment extends Fragment {

    FragmentForgotPasswordBinding fragmentForgotPasswordBinding;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    public static ForgotPasswordFragment newInstance(String param1, String param2) {
        ForgotPasswordFragment fragment = new ForgotPasswordFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentForgotPasswordBinding = FragmentForgotPasswordBinding.inflate(inflater, container, false);
        auth = FirebaseAuth.getInstance();
        Log.d("RRRRR", "щщщ");
        fragmentForgotPasswordBinding.change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("RRRRR", "LOL00");
                String email = fragmentForgotPasswordBinding.textEditGetMail.getText().toString().trim();
                Log.d("RRRRR", email);
                if (!email.equals("")) {
                    auth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getContext(), "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                                    NavController navController = NavHostFragment.findNavController(ForgotPasswordFragment.this);
                                    navController.popBackStack();
                                } else {
                                    Toast.makeText(getContext(), "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });
        return fragmentForgotPasswordBinding.getRoot();
    }

}