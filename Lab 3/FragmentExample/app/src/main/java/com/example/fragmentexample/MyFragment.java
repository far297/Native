package com.example.fragmentexample;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    private  static final String TAG = "MyFragment";

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        Button sendButton = view.findViewById(R.id.send_button);
        sendButton.setOnClickListener(v -> {

            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).sendDataToFragment2("Hello from Fragment1");
            }
        });
        return view;
    }

    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }
}


