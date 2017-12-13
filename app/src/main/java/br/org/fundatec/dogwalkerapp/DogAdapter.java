package br.org.fundatec.dogwalkerapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tecnico on 05/10/2017.
 */

public class DogAdapter extends ArrayAdapter<Dog>{

    public DogAdapter(@NonNull Context context, @LayoutRes int resource, DatabaseReference dogs) {
        super(context, resource);
    }

    public DogAdapter(DogWalkerMenu context, int simple_list_item_1, ArrayList<Dog> dogs) {
        super(context, simple_list_item_1, dogs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.item_dog, null);
        }

        Dog dog = getItem(position);

        if (dog != null) {
            ImageView img1 = (ImageView) v.findViewById(R.id.imgPerfil) ;
            TextView tt1 = (TextView) v.findViewById(R.id.txtName);
            TextView tt2 = (TextView) v.findViewById(R.id.txtPorte);
            TextView tt3 = (TextView) v.findViewById(R.id.txtDescrip);
            Button btn1 = (Button) v.findViewById(R.id.btnSelect);


            if (img1 != null) {
                Picasso.with(getContext()).load(dog.imgDog).into(img1);
            }

            if (tt1 != null) {
                tt1.setText(dog.name);
            }

            if (tt2 != null) {
                tt2.setText(dog.carrier);
            }

            if (tt3 != null) {
                tt3.setText(dog.descriptionDog);
            }

            if (btn1 != null) {
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getContext().startActivity(new Intent(getContext(), DogSelect.class));
                    }
                });
            }

        }

        return v;
    }
}
