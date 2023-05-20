package com.example.bettercvapp.showdata

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await



class DataViewModel : ViewModel(){
    val state = mutableStateOf(Profil())
    val state1 = mutableStateOf(ExperiencePro())
    val state2 = mutableStateOf(Formation())
    val state3 = mutableStateOf(Project())
    val state4 = mutableStateOf(Recommendation())
    val state5 = mutableStateOf(Contact())
    val state6 = mutableStateOf(Competence())
    val state7 = mutableStateOf(Address())


    init {
        getData()
    }
    private fun getData(){
        viewModelScope.launch{
            state.value = getDataFromFirestore()
            state1.value = getData1FromFirestore()
            state2.value = getData2FromFirestore()
            state3.value = getData3FromFirestore()
            state4.value = getData4FromFirestore()
            state5.value = getData5FromFirestore()
            state6.value = getData6FromFirestore()
            state7.value = getData7FromFirestore()
        }
    }
}




//recuperer les données du profil
suspend fun getDataFromFirestore():Profil{
    val db = FirebaseFirestore.getInstance()
    var profil = Profil()
    try{
        db.collection("Profile").get().await().map{
           val result = it.toObject(Profil::class.java)
                profil = result
        }
    }catch (e: FirebaseFirestoreException ){
        Log.d("error","getDataFromFirestore: $e")
    }
    return profil
}

//recuperer les données du experiencePro
suspend fun getData1FromFirestore():ExperiencePro{
    val db = FirebaseFirestore.getInstance()
    var experiencePro = ExperiencePro()
    try{
        db.collection("ExperiencePro").get().await().map{
            val result = it.toObject(ExperiencePro::class.java)
            experiencePro = result
        }
    }catch (e: FirebaseFirestoreException ){
        Log.d("error","getDataFromFirestore: $e")
    }
    return experiencePro
}

//recuperer les données du Formation
suspend fun getData2FromFirestore():Formation{
    val db = FirebaseFirestore.getInstance()
    var formation = Formation()
    try{
        db.collection("formation").get().await().map{
            val result = it.toObject(Formation::class.java)
            formation = result
        }
    }catch (e: FirebaseFirestoreException ){
        Log.d("error","getDataFromFirestore: $e")
    }
    return formation
}

//recuperer les données du Projet
suspend fun getData3FromFirestore():Project{
    val db = FirebaseFirestore.getInstance()
    var project = Project()
    try{
        db.collection("project").get().await().map{
            val result = it.toObject(Project::class.java)
            project = result
        }
    }catch (e: FirebaseFirestoreException ){
        Log.d("error","getDataFromFirestore: $e")
    }
    return project
}

//recuperer les données du Recommendation
suspend fun getData4FromFirestore():Recommendation{
    val db = FirebaseFirestore.getInstance()
    var recommendation = Recommendation()
    try{
        db.collection("recommandation").get().await().map{
            val result = it.toObject(Recommendation::class.java)
            recommendation = result
        }
    }catch (e: FirebaseFirestoreException ){
        Log.d("error","getDataFromFirestore: $e")
    }
    return recommendation
}

//recuperer les données du Contact
suspend fun getData5FromFirestore():Contact{
    val db = FirebaseFirestore.getInstance()
    var contact = Contact()
    try{
        db.collection("ElectronicAddress").get().await().map{
            val result = it.toObject(Contact::class.java)
            contact = result
        }
    }catch (e: FirebaseFirestoreException ){
        Log.d("error","getDataFromFirestore: $e")
    }
    return contact
}

//recuperer les données du Competence
suspend fun getData6FromFirestore():Competence{
    val db = FirebaseFirestore.getInstance()
    var competence = Competence()
    try{
        db.collection("Competence").get().await().map{
            val result = it.toObject(Competence::class.java)
            competence = result
        }
    }catch (e: FirebaseFirestoreException ){
        Log.d("error","getDataFromFirestore: $e")
    }
    return competence
}

//recuperer les données du address
suspend fun getData7FromFirestore():Address{
    val db = FirebaseFirestore.getInstance()
    var address = Address()
    try{
        db.collection("Country").get().await().map{
            val result = it.toObject(Address::class.java)
            address = result
        }
    }catch (e: FirebaseFirestoreException ){
        Log.d("error","getDataFromFirestore: $e")
    }
    return address
}