package com.example.insense.ui.fragments.Profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.insense.R;
import com.example.insense.databinding.FragmentProfileBinding;
import com.example.insense.databinding.FragmentProfileBindingImpl;
import com.example.insense.ui.fragments.Login.LoginViewModel;
import com.firebase.ui.auth.AuthUI;


public class ProfileFragment extends Fragment {

    LoginViewModel viewModel = new LoginViewModel();
    FragmentProfileBinding binding;

    private NavController navController;

    void observeAuthenticationState(){
        viewModel.authenticationState.observe(getViewLifecycleOwner(), authenticationState -> {
            if(authenticationState == LoginViewModel.AuthenticationState.AUTHENTICATED){
                binding.logoutButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AuthUI.getInstance().signOut(requireContext());
                        navController.popBackStack();
                    }
                });
            }
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile,container,false );
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        observeAuthenticationState();
    }

}