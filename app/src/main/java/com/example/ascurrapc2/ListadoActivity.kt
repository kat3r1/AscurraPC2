package com.example.ascurrapc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ascurrapc2.adapter.EquipoAdapter
import com.example.ascurrapc2.model.EquipoModel
import com.google.firebase.firestore.FirebaseFirestore

class ListadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            val view: View = inflater.inflate(R.layout.activity_listado, container, false)

            val db = FirebaseFirestore.getInstance()
            var lstProducts: List<EquipoAdapter>
            val rvProduct: RecyclerView = view.findViewById(R.id.lvEquipos)

            db.collection("products")
                .addSnapshotListener{ snap, error ->
                    if(error!=null){

                        return@addSnapshotListener
                    }
                    lvEquipos = snap!!.documents.map {document ->
                        EquipoModel(document["logo"].toString(),
                            document["nombre"].toString(),
                            document["posicion"].toString())
                    }
                    rvProduct.adapter = EquipoModel(lstProducts)
                    rvProduct.layoutManager = LinearLayoutManager(requireContext())
                }
            return view
        }
    }
}