package susparaconcursos.mxtechnologies.com.susparaconcursos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Moisés on 10/02/2016.
 */
public class PrincOrgActivity extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_princ_org, container, false);
        return view;
    }
}