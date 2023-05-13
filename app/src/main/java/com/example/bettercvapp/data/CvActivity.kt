package com.example.bettercvapp.data

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@Composable
fun MyCV(){
    var nom by remember{ mutableStateOf("") }
    var prenom by remember{ mutableStateOf("") }
    val db = Firebase.firestore
    val prof = db.collection("profile")

    prof.document().get()
        .addOnSuccessListener { document ->
            nom = document.getString("firstname").toString()
             prenom = document.getString("lastname").toString()
        }
    Column() {
        Text(text = "$nom")
        Text(text = "$prenom")
    }
}