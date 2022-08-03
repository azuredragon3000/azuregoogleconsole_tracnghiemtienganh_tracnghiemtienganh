package com.myapp.tracnghiemtienganh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myapp.mylibrary.ads.AdsInterstitial;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Thirst_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class Thirst_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ShareViewModelFirstFragment modelFirstFragment;
    ShareViewModelSecondFragment modelSecondFragment;
    ShareViewModelSecondFragmentFailed modelSecondFragmentFailed;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<String> ques;
    RecyclerView rc;
    AdsInterstitial adsInterstitial;
    boolean already = false;
    QuestionAdapter adapterTruyen;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Thirst_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Thirst_Fragment newInstance(String param1, String param2) {
        Thirst_Fragment fragment = new Thirst_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Thirst_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        adsInterstitial = new AdsInterstitial(
                "07CC7E40850ABA2DF210A2D2564CAD76",
                "ca-app-pub-8404443559572571/2632853186",
                requireContext());
        modelFirstFragment = new ViewModelProvider(requireActivity()).get(ShareViewModelFirstFragment.class);
        modelSecondFragment = new ViewModelProvider(requireActivity()).get(ShareViewModelSecondFragment.class);
        modelSecondFragmentFailed =
                new ViewModelProvider(requireActivity()).get(ShareViewModelSecondFragmentFailed.class);
        //ques = new ArrayList<>();
       // ques =  ((SubApp) getActivity().getApplication()).getQuestion();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        modelSecondFragment.getSelected().observe(getViewLifecycleOwner(), item -> {
            //ques =  ((SubApp) getActivity().getApplication()).getQuestion();
            if(item.pass) {
                ((SubApp) getActivity().getApplication()).updateQuestion(item.index);
                rc.setAdapter(adapterTruyen);
            }
        });



        ListenerItem listener = new ListenerItem() {

            @Override
            public void click(int index, Activity activity) {
                //startActivity(new Intent(getActivity(),));
                NavHostFragment.findNavController(Thirst_Fragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
                modelFirstFragment.select(index);

                adsInterstitial.showAds(requireActivity());
            }
        };

        ques =  ((SubApp) getActivity().getApplication()).getQuestion();
         rc = view.findViewById(R.id.rc);
         adapterTruyen = new QuestionAdapter(requireActivity(),ques,listener,requireActivity());
        rc.setAdapter(adapterTruyen);
        rc.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thirst_, container, false);
    }
}