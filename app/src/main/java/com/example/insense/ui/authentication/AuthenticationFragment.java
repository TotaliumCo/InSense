package com.example.insense.ui.authentication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.insense.R;
import com.example.insense.databinding.FragmentAuthenticationBinding;
import com.example.insense.databinding.FragmentTabsBinding;

public class AuthenticationFragment extends Fragment {
    FragmentAuthenticationBinding fragmentAuthenticationBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentAuthenticationBinding = FragmentAuthenticationBinding.inflate(inflater,container,false);
        NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.authenticationContainer);
        return fragmentAuthenticationBinding.getRoot();
    }
}
