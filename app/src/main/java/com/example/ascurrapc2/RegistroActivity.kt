package com.example.ascurrapc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val db = FirebaseFirestore.getInstance()

        db.collection("equipos")
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    Snackbar
                        .make(
                            findViewById(android.R.id.content),
                            "Error al conectarse a firestore",
                            Snackbar.LENGTH_LONG
                        ).show()
                    return@addSnapshotListener
                }

                for (dc in snapshots!!.documentChanges) {
                    when (dc.type) {
                        DocumentChange.Type.ADDED, DocumentChange.Type.MODIFIED -> {
                            Snackbar
                                .make(
                                    findViewById(android.R.id.content),
                                    "Consultando...",
                                    Snackbar.LENGTH_LONG
                                ).show()

                        }

                        DocumentChange.Type.REMOVED -> {
                            Snackbar
                                .make(
                                    findViewById(android.R.id.content),
                                    "El documento fue eliminado",
                                    Snackbar.LENGTH_LONG
                                ).show()
                        }

                        else -> {
                            Snackbar
                                .make(
                                    findViewById(android.R.id.content),
                                    "Error al consultar la colección",
                                    Snackbar.LENGTH_LONG
                                ).show()
                        }
                    }

                }

            }


        val etNombre: EditText = findViewById(R.id.etNombre)
        val etAnio: EditText = findViewById(R.id.etAnio)
        val etNumeroTitulo: EditText = findViewById(R.id.etNumeroTitulo)
        val eturlLogo: EditText = findViewById(R.id.eturlLogo)
        val btnGuardar: Button = findViewById(R.id.btnGuardar)




        btnGuardar.setOnClickListener {
            val fullName = etNombre.text.toString()
            val country = etAnio.text.toString()
            val email = etNumeroTitulo.text.toString()
            val password = eturlLogo.text.toString()
        }
    }
}