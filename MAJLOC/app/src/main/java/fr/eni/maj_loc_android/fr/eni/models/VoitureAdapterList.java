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

public class VoitureAdapterList extends ArrayAdapter<Voiture> {

    public VoitureAdapterList(@NonNull Context context, @LayoutRes int resource, @NonNull List<Voiture> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.voiture_list_item, parent, false);
        }
        else {
            view = convertView;
        }

        TextView marque = (TextView) view .findViewById(R.id.marque);
        TextView modele = (TextView) view .findViewById(R.id.modele);
        TextView energie = (TextView) view .findViewById(R.id.energie);
        TextView type = (TextView) view .findViewById(R.id.type);

        Voiture item = getItem(position);
        marque.setText( item.getMarque());
        modele.setText( item.getModele());
        energie.setText((CharSequence) item.getEnergie());
        type.setText((CharSequence) item.getType());

        return view;
    }

}
