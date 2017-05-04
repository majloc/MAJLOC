package fr.eni.maj_loc_android.fr.eni.models;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fr.eni.maj_loc_android.R;

/**
 * Created by Administrateur on 03/05/2017.
 */

public class ClientAdapter extends ArrayAdapter<Client> {

    public ClientAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Client> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.client_item, parent, false);
        }
        else {
            view = convertView;
        }

        TextView nom = (TextView) view .findViewById(R.id.nom);
        TextView prenom = (TextView) view .findViewById(R.id.prenom);
        TextView mail = (TextView) view .findViewById(R.id.mail);
        TextView adresse = (TextView) view .findViewById(R.id.adresse);

        Client item = getItem(position);
        nom.setText( item.getNom());
        prenom.setText( item.getPrennom());
        mail.setText( item.getMail());
        adresse.setText( item.getAdresse());

        return view;
    }

}
