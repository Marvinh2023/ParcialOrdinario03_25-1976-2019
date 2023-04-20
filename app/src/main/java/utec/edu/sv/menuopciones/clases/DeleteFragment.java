package utec.edu.sv.menuopciones.clases;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import utec.edu.sv.menuopciones.Helper.AdminSQLiteOpenHelper;
import utec.edu.sv.menuopciones.R;


public class DeleteFragment extends Fragment {
    EditText txtEmail;
    Button btnEliminar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_delete,container,false);

        txtEmail = view.findViewById(R.id.edtEmail);
        btnEliminar = view.findViewById(R.id.btnEliminar);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getActivity().getApplicationContext(), "parcial", null,1);
                SQLiteDatabase bd =  admin.getWritableDatabase();

                String email = txtEmail.getText().toString();

                int cat = bd.delete("contactos","email = '" + email + "'", null);
                bd.close();

                txtEmail.setText("");

                if(cat == 1){
                    Toast.makeText(getActivity().getApplicationContext(), "Se elimino el registro", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getActivity().getApplicationContext(), "No se elimino el registro", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}
