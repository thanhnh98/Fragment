package com.thanh.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    private static final String TAG ="SecondFragment" ;
    private static SecondFragment fragment=null;
    public static Fragment getInstances(){
        if(fragment==null){
            fragment=new SecondFragment();
            Bundle bundle=new Bundle();
            fragment.setArguments(bundle);
        }
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv_clickable=view.findViewById(R.id.tv_clickable);
        tv_clickable.setOnClickListener(v->{
           /* getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.host_fragment,FirstFragment.getInstances())
                    .setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left,R.anim.slide_in_left,R.anim.slide_out_right)
                    .addToBackStack("Hoai")
                    .commit();*/
           getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();

        });
        Log.e("SecondFragment name",SecondFragment.this.getTag()+this.getId()+"");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG,"Pause");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("DESTROY","Destroy-"+"Thanh");

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"onCreate");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG,"DestroyView");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG,"Resume");
    }
}
