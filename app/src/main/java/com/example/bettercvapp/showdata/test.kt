package com.example.bettercvapp.showdata

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


    @Composable
    fun Com() {
        var documentCount by remember { mutableStateOf(0) }

        Column {
            FirebaseFirestore.getInstance().collection("Profile")
                .get()
                .addOnSuccessListener { documents ->
                    documentCount = documents.size()
                }
            Text(
                text = "Nombre de documents dans la collection 'doc': $documentCount",
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }


