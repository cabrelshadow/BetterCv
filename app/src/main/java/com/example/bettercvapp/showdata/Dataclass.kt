package com.example.bettercvapp.showdata

data class Profil(
    val firstname : String = "",
    val lastname : String = "",
    val borndate : String = "",
    val maritalstatus : String = "",
    val bornat : String = "" ,
    val drivinglicence : String = "",
)

data class ExperiencePro(
    val organisation : String = "",
    val status : String = "",
    val function : String = "",
    val startDate : String = "",
    val endDate : String = "",
)

data class Formation(
    val school : String = "",
    val domainOfStudy : String = "",
    val diploma : String = "",
    val obtainresult : String = "",
    val startdate : String = "",
    val enddate : String = "",
)

data class Project(
    val NameProject : String = "",
    val Status : String = "",
    val Partner : String = "",
    val UrlProject : String = "",
    val DescriptionOfProject : String = "",
    val StartDate : String = "",
    val EndDate : String = "",
)

data class Recommendation(
    val PersonName : String = "",
    val Relationship : String = "",
    val ResearchPost : String = "",
    val Message : String = "",
    val Number : String = "",
)

data class Contact(
    val Phone : String = "",
    val Email : String = "",
    val urlTelegram : String = "",
    val urlLinkedin : String = "",
)

data class Competence(
    val competence : String = "",
    val level : String = "",
)

data class Address(
    val country : String = "",
    val city : String = "",
    val language : String = "",
    val level : String = "",
)

data class Hobbies(
    val type_hobbies : String = "",
    val title_hobbies : String = "",
)



