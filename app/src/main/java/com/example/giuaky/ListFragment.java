package com.example.giuaky;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {
    ListView lvBook;
    ArrayList<Singer> arraySinger;
    Singer_adapter adapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        lvBook = (ListView) view.findViewById(R.id.listViewBook);
        arraySinger = new ArrayList<>();
        arraySinger.add(new Singer("Nguyễn Thanh Tùng","Sơn Tùng MTP","Việt Nam","5",R.drawable.sontung));
        arraySinger.add(new Singer("Phan Thị Mỹ Tâm","Mỹ Tâm","Việt Nam","5",R.drawable.mytam));
        arraySinger.add(new Singer("Nguyễn Đức Phúc","Đức Phúc","Việt Nam","4",R.drawable.ducphuc));
        arraySinger.add(new Singer("Hoàng Thùy Linh","Thùy Linh","Việt Nam","5",R.drawable.thuylinh));
        arraySinger.add(new Singer("Mai Hồng Ngọc","Đông Nhi","Việt Nam","5",R.drawable.dongnhi));
        arraySinger.add(new Singer("Lê Trung Thành","Erik","Việt Nam","4",R.drawable.erikk));
        arraySinger.add(new Singer("Nguyễn Thị Hòa","Hòa Minzy","Việt Nam","5",R.drawable.minzy));
        arraySinger.add(new Singer("Nguyễn Minh Hằng","MIN","Việt Nam","4",R.drawable.min));
        arraySinger.add(new Singer("Bùi Thị Bích Phương","Bích Phương","Việt Nam","4",R.drawable.bichphuong));
        arraySinger.add(new Singer("Nguyễn Phước Thịnh","Noo Phước Thịnh","Việt Nam","5",R.drawable.noo));
        arraySinger.add(new Singer("Nguyễn Thanh Tùng","Sơn Tùng MTP","Việt Nam","5",R.drawable.sontung));
        arraySinger.add(new Singer("Phan Thị Mỹ Tâm","Mỹ Tâm","Việt Nam","5",R.drawable.mytam));
        arraySinger.add(new Singer("Nguyễn Đức Phúc","Đức Phúc","Việt Nam","4",R.drawable.ducphuc));
        arraySinger.add(new Singer("Hoàng Thùy Linh","Thùy Linh","Việt Nam","5",R.drawable.thuylinh));
        arraySinger.add(new Singer("Mai Hồng Ngọc","Đông Nhi","Việt Nam","5",R.drawable.dongnhi));
        arraySinger.add(new Singer("Lê Trung Thành","Erik","Việt Nam","4",R.drawable.erikk));
        arraySinger.add(new Singer("Nguyễn Thị Hòa","Hòa Minzy","Việt Nam","5",R.drawable.minzy));
        arraySinger.add(new Singer("Nguyễn Minh Hằng","MIN","Việt Nam","4",R.drawable.min));
        arraySinger.add(new Singer("Bùi Thị Bích Phương","Bích Phương","Việt Nam","4",R.drawable.bichphuong));
        arraySinger.add(new Singer("Nguyễn Phước Thịnh","Noo Phước Thịnh","Việt Nam","5",R.drawable.noo));
        adapter = new Singer_adapter( getActivity(),R.layout.singer, arraySinger);
        lvBook.setAdapter(adapter);
        lvBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), OpenList.class);
                intent.putExtra("Tên", arraySinger.get(i).getTen());
                intent.putExtra("Nghệ danh", arraySinger.get(i).getMoTa());
                intent.putExtra("Quốc gia", arraySinger.get(i).getQuocGia());
                intent.putExtra("Số sao", arraySinger.get(i).getSoSao());
                intent.putExtra("Hinh", arraySinger.get(i).getHinh());
                startActivity(intent);


            }
        });
        lvBook.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                openDialog(i);
                return false;
            }
        });

        return view;
    }
    private void openDialog(int position) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Thông báo");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("Bạn có muốn xoá?");
        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arraySinger.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }

}