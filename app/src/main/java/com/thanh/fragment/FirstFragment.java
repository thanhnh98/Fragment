package com.thanh.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FirstFragment extends Fragment {
    private static final String TAG ="FirstFragment" ;
    Button btn_dangNhap;
    EditText edt_taiKhoan;
    EditText edt_matKhau;
    ImageView img;
    private static FirstFragment fragment=null;
    public static Fragment getInstances(){
        if(fragment==null){
            fragment=new FirstFragment();
            Bundle bundle=new Bundle();
            fragment.setArguments(bundle);
        }
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"onCreate");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_dangNhap=view.findViewById(R.id.btn_dangNhap);
        edt_matKhau=view.findViewById(R.id.edt_matKhau);
        edt_taiKhoan=view.findViewById(R.id.edt_taiKhoan);
        img=view.findViewById(R.id.img);
        btn_dangNhap.setOnClickListener(v->{
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left,R.anim.slide_in_left,R.anim.slide_out_right)
                    .addSharedElement(img,"pikachu")
                    .replace(R.id.host_fragment,new SecondFragment())
                    .addToBackStack("Thanh")
                    .commit();
        });
        FragmentManager fragmentManager=getFragmentManager();
        fragmentManager.addOnBackStackChangedListener(()->{
           //Do something

            Log.e(TAG,fragmentManager.getBackStackEntryCount()+"");
        });
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        //fragmentTransaction.commitNow();

    }


    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG,"Pause");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG,"DestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
       //setInitialSavedState(new SavedState(new Bundle()));

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG,"Resume");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG,"SAve");

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.e(TAG,"Restore");
    }
}
