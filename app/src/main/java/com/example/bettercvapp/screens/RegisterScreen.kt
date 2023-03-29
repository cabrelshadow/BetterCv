package com.example.bettercvapp.screens


import android.text.Layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bettercvapp.R
import com.example.bettercvapp.ui.theme.Poppins
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun RegisterScreen(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top=20.dp)
    )
    {
       Image(
           painter= painterResource(id = R.drawable.register),
           contentDescription="",
           modifier=Modifier.size(160.dp)
       )
    }
    Text(text = "CREER VOTRE COMPTE",
           textAlign = TextAlign.Center,
        fontFamily =Poppins,    )
}