package com.example.insense.ui.authentication.authentication;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.insense.R;
import com.example.insense.databinding.FragmentLoginEmailBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginEmailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginEmailFragment extends Fragment {

    FragmentLoginEmailBinding fragmentLoginEmailBinding;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "AUTH";
    private FirebaseAuth mAuth;
    private int count = 0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginEmailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginEmailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginEmailFragment newInstance(String param1, String param2) {
        LoginEmailFragment fragment = new LoginEmailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentLoginEmailBinding = FragmentLoginEmailBinding.inflate(inflater);
        fragmentLoginEmailBinding.emailSignInButton.setOnClickListener(view -> {
            String email = fragmentLoginEmailBinding.textEditGetMail.getText().toString();
            String password = fragmentLoginEmailBinding.textEditGetPassword.getText().toString();
            signIn(email, password);
        });
        fragmentLoginEmailBinding.emailCreateAccountButton.setOnClickListener(view -> {
            String email = fragmentLoginEmailBinding.textEditGetMail.getText().toString();
            String password = fragmentLoginEmailBinding.textEditGetPassword.getText().toString();
            createAccount(email, password);
        });

        // Inflate the layout for this fragment
        return fragmentLoginEmailBinding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
    }

    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity(), task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(getContext(), "Succeeded",
                                Toast.LENGTH_SHORT).show();
                        updateUI(user);
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(getContext(), "Failed.",
                                Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }

                });
    }

    private void signIn(String email, String password) {
        Log.d(TAG, "signIn:" + email);
        if (email != null && password != null) {
            email = "lol";
            password = "lol";
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getContext(), "Authentication succeeded.", Toast.LENGTH_SHORT).show();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            count++;
                            Toast.makeText(getContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            if (count == 3) {
                                fragmentLoginEmailBinding.emailSignInButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        NavController navController = NavHostFragment.findNavController(LoginEmailFragment.this);
                                        navController.navigate(R.id.action_loginEmailFragment_to_forgotPasswordFragment);
                                    }
                                });
                            }
                            updateUI(null);
                        }

                    }
                });

    }

    private void signOut() {
        mAuth.signOut();
        updateUI(null);
    }


    private void reload() {
        mAuth.getCurrentUser().reload().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                updateUI(mAuth.getCurrentUser());
                Toast.makeText(getContext(),
                        "Reload successful!",
                        Toast.LENGTH_SHORT).show();
            } else {
                Log.e(TAG, "reload", task.getException());
                Toast.makeText(getContext(),
                        "Failed to reload user.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = fragmentLoginEmailBinding.textEditGetMail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            fragmentLoginEmailBinding.textEditGetMail.setError("Required.");
            valid = false;
        } else {
            fragmentLoginEmailBinding.textEditGetMail.setError(null);
        }

        String password = fragmentLoginEmailBinding.textEditGetPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            fragmentLoginEmailBinding.textEditGetPassword.setError("Required.");
            valid = false;
        } else {
            fragmentLoginEmailBinding.textEditGetPassword.setError(null);
        }

        return valid;
    }

    private void updateUI(FirebaseUser user) {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentLoginEmailBinding = null;
    }
}