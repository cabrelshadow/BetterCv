 package com.example.bettercvapp.screens

 import android.content.ContentValues.TAG
 import android.util.Log
 import androidx.compose.foundation.Image
 import androidx.compose.foundation.background
 import androidx.compose.foundation.layout.*
 import androidx.compose.foundation.text.KeyboardOptions
 import androidx.compose.material.*
 import androidx.compose.runtime.*
 import androidx.compose.ui.Alignment
 import androidx.compose.ui.Modifier
 import androidx.compose.ui.draw.clip
 import androidx.compose.ui.graphics.Color
 import androidx.compose.ui.res.painterResource
 import androidx.compose.ui.text.TextStyle
 import androidx.compose.ui.text.font.FontWeight
 import androidx.compose.ui.text.input.KeyboardType
 import androidx.compose.ui.text.input.PasswordVisualTransformation
 import androidx.compose.ui.text.input.VisualTransformation
 import androidx.compose.ui.text.style.TextAlign
 import androidx.compose.ui.unit.dp
 import androidx.compose.ui.unit.sp
 import androidx.navigation.NavController
 import com.example.bettercvapp.R
 import com.example.bettercvapp.ui.theme.*
 import com.google.firebase.auth.ktx.auth
 import com.google.firebase.ktx.Firebase

 @Composable
 fun RegisterScreen(navController: NavController) {
     var isPasswordOpen by remember { mutableStateOf(false) }
     var username by remember { mutableStateOf("") }
     var email by remember { mutableStateOf("") }
     var password by remember { mutableStateOf("") }
     var checkBoxOne by remember { mutableStateOf(true) }
     var checkBoxTwo by remember { mutableStateOf(true) }
     Column(
         horizontalAlignment = Alignment.CenterHorizontally,
         modifier = Modifier.padding(top = 20.dp)
     ) {
         Image(
             painter = painterResource(id = R.drawable.ic_register_img),
             contentDescription = "",
             modifier = Modifier.size(160.dp)
         )

         Text(
             text = "CREATE YOUR ACCOUNT",
             textAlign = TextAlign.Center,
             fontFamily = Poppins,
             color = SecondaryColor,
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(top = 14.dp),
             fontWeight = FontWeight.ExtraBold,
             fontSize = 16.sp,

             )

         TextField(
             value = username, onValueChange = { username = it },
             Modifier
                 .fillMaxWidth()
                 .padding(horizontal = 20.dp)
                 .padding(top = 20.dp),
             colors = TextFieldDefaults.textFieldColors(
                 textColor = PrimaryColor,
                 backgroundColor = Color.White,
                 cursorColor = PrimaryColor,
                 focusedIndicatorColor = Color.Transparent,
                 unfocusedIndicatorColor = Color.Transparent
             ),
             shape = InputBoxShape.medium,
             singleLine = true,
             leadingIcon = {
                 Row(
                     modifier = Modifier.padding(start = 8.dp),
                     verticalAlignment = Alignment.CenterVertically
                 ) {
                     Icon(
                         painter = painterResource(id = R.drawable.ic_user), contentDescription = "",
                         tint = PrimaryColor,
                         modifier = Modifier.size(20.dp)
                     )
                     Spacer(
                         modifier = Modifier
                             .width(6.dp)
                     )
                     Spacer(
                         modifier = Modifier
                             .width(1.dp)
                             .height(24.dp)
                             .background(BackgroundColor)
                     )
                 }
             },
             placeholder = {
                 Text(text = "Username", color = PlaceholderColor)
             },
             textStyle = TextStyle(
                 fontSize = 14.sp,
                 fontWeight = FontWeight.SemiBold,
                 fontFamily = Poppins
             )
         )

         TextField(
             value = email, onValueChange = { email = it },
             Modifier
                 .fillMaxWidth()
                 .padding(horizontal = 20.dp)
                 .padding(top = 20.dp),
             colors = TextFieldDefaults.textFieldColors(
                 textColor = Textcolor,
                 backgroundColor = Color.White,
                 cursorColor = PrimaryColor,
                 focusedIndicatorColor = Color.Transparent,
                 unfocusedIndicatorColor = Color.Transparent
             ),
             shape = InputBoxShape.medium,
             singleLine = true,
             leadingIcon = {
                 Row(
                     modifier = Modifier.padding(start = 8.dp),
                     verticalAlignment = Alignment.CenterVertically
                 ) {
                     Icon(
                         painter = painterResource(id = R.drawable.ic_email_outline),
                         contentDescription = "",
                         tint = PrimaryColor,
                         modifier = Modifier.size(20.dp)
                     )
                     Spacer(
                         modifier = Modifier
                             .width(6.dp)
                     )
                     Spacer(
                         modifier = Modifier
                             .width(1.dp)
                             .height(24.dp)
                             .background(BackgroundColor)
                     )
                 }
             },
             placeholder = {
                 Text(text = "Email Address", color = PlaceholderColor)
             },
             textStyle = TextStyle(
                 fontSize = 14.sp,
                 fontWeight = FontWeight.SemiBold,
                 fontFamily = Poppins
             )
         )

         TextField(
             value = password, onValueChange = { password = it },
             Modifier
                 .fillMaxWidth()
                 .padding(horizontal = 20.dp)
                 .padding(top = 20.dp),
             colors = TextFieldDefaults.textFieldColors(
                 textColor = Textcolor,
                 backgroundColor = Color.White,
                 cursorColor = PrimaryColor,
                 focusedIndicatorColor = Color.Transparent,
                 unfocusedIndicatorColor = Color.Transparent
             ),
             keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
             visualTransformation = if (!isPasswordOpen) PasswordVisualTransformation() else VisualTransformation.None,
             shape = InputBoxShape.medium,
             singleLine = true,
             leadingIcon = {
                 Row(
                     modifier = Modifier.padding(start = 8.dp),
                     verticalAlignment = Alignment.CenterVertically
                 ) {
                     Icon(
                         painter = painterResource(id = R.drawable.ic_lock), contentDescription = "",
                         tint = PrimaryColor,
                         modifier = Modifier.size(20.dp)
                     )
                     Spacer(
                         modifier = Modifier
                             .width(6.dp)
                     )
                     Spacer(
                         modifier = Modifier
                             .width(1.dp)
                             .height(24.dp)
                             .background(BackgroundColor)
                     )
                 }
             },
             placeholder = {
                 Text(text = "Password", color = PlaceholderColor)
             },
             textStyle = TextStyle(
                 fontSize = 14.sp,
                 fontWeight = FontWeight.SemiBold,
                 fontFamily = Poppins
             ),
                     trailingIcon = {
                 IconButton(onClick = { isPasswordOpen = !isPasswordOpen }) {
                     if (!isPasswordOpen) {
                         Icon(
                             painter = painterResource(id = R.drawable.ic_eye_open),
                             contentDescription = "",
                             tint = PrimaryColor,
                             modifier = Modifier.size(24.dp)
                         )
                     } else {
                         Icon(
                             painter = painterResource(id = R.drawable.ic_eye_close),
                             contentDescription = "",
                             tint = PrimaryColor,
                             modifier = Modifier.size(24.dp)
                         )
                     }
                 }
             }


         )

         Row(
             modifier = Modifier
                 .padding(top = 20.dp)
                 .padding(horizontal = 40.dp)
                 .fillMaxWidth(),
             verticalAlignment = Alignment.CenterVertically
         ) {
             Checkbox(
                 checked = checkBoxOne, onCheckedChange = { checkBoxOne = it },
                 colors = CheckboxDefaults.colors(
                     checkedColor = PrimaryColor,
                     uncheckedColor = SecondaryColor,
                     checkmarkColor = SecondaryColor
                 ),
                 modifier = Modifier.clip(shape = Shapes.medium)
             )
             Spacer(modifier = Modifier.width(6.dp))
             Text(
                 text = "Log In with Email",
                 fontFamily = Poppins,
                 color = SecondaryColor,
                 fontSize = 12.sp
             )
         }

         Row(
             modifier = Modifier
                 .padding(top = 10.dp)
                 .padding(horizontal = 40.dp)
                 .fillMaxWidth(),
             verticalAlignment = Alignment.CenterVertically
         ) {
             Checkbox(
                 checked = checkBoxTwo, onCheckedChange = { checkBoxTwo = it },
                 colors = CheckboxDefaults.colors(
                     checkedColor = PrimaryColor,
                     uncheckedColor = SecondaryColor,
                     checkmarkColor = SecondaryColor
                 ),
                 modifier = Modifier.clip(shape = Shapes.medium)
             )
             Spacer(modifier = Modifier.width(6.dp))
             Text(
                 text = "Email me about special pricing",
                 fontFamily = Poppins,
                 color = SecondaryColor,
                 fontSize = 12.sp
             )
         }
         var load by remember { mutableStateOf(false) }
         val showDialog = remember { mutableStateOf(false) }
         Button(
             onClick = {
                 if(email.isEmpty() || password.isEmpty()){
                     showDialog.value = true
                     load = false
                 }else{
                     load = true
                     createUser(email, password , navController)
                 }
                       },
             colors = ButtonDefaults.buttonColors(
                 backgroundColor = PrimaryColor
             ),
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(horizontal = 20.dp)
                 .padding(top = 20.dp),
             contentPadding = PaddingValues(vertical = 14.dp),
             elevation = ButtonDefaults.elevation(
                 defaultElevation = 0.dp,
                 pressedElevation = 2.dp
             ),
             shape = Shapes.medium
         ) {
             Text(
                 text = "Sign Up with Email",
                 fontFamily = Poppins,
                 color = SecondaryColor,
                 fontSize = 12.sp,
                 fontWeight = FontWeight.Bold
             )
             if(load){
                 CircularProgressIndicator()
             }
         }
         if (showDialog.value) {
             AlertDialog(
                 onDismissRequest = { showDialog.value = false },
                 title = { Text(text = "Information") },
                 text = { Text(text = "veuillez remplir tout les champs") },
                 confirmButton = {
                     Button(
                         onClick = { showDialog.value = false },
                         colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
                     ) {
                         Text(text = "OK")
                     }
                 }
             )
         }

         SocialMediaSignInButtons()

         TextButton(onClick = {
             navController.navigate("LoginScreen"){
             popUpTo(navController.graph.startDestinationId)
             launchSingleTop = true
         } },
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(top = 20.dp)
         ) {
             Text(text = "Already have an account ? Sign In",
                 fontFamily = Poppins,
                 color= SecondaryColor,
                 fontSize = 12.sp,
                 fontWeight = FontWeight.SemiBold,
             )
         }
     }
 }

 @Composable
 fun SocialMediaSignInButtons() {
     Row(
         modifier = Modifier
             .fillMaxWidth()
             .padding(top = 20.dp)
             .padding(horizontal = 20.dp),
         horizontalArrangement = Arrangement.SpaceBetween
     ) {
         Button(
             onClick = {},
             colors = ButtonDefaults.buttonColors(
                 backgroundColor = Color.White,
             ),
             elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
             modifier = Modifier.clip(shape = Shapes.large),
             contentPadding = PaddingValues(horizontal = 26.dp, vertical = 10.dp)
         ) {
             Row(verticalAlignment = Alignment.CenterVertically) {
                 Icon(
                     painter = painterResource(id = R.drawable.ic_google),
                     contentDescription = "",
                     modifier = Modifier.size(20.dp),
                     tint = Color.Unspecified
                 )
                 Spacer(modifier = Modifier.width(10.dp))
                 Text(text = "Google",
                     fontFamily = Poppins,
                     color = SecondaryColor
                 )
             }
         }

         Button(
             onClick = {},
             colors = ButtonDefaults.buttonColors(
                 backgroundColor = Color.White,
             ),
             elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
             modifier = Modifier.clip(shape = Shapes.large),
             contentPadding = PaddingValues(horizontal = 26.dp, vertical = 10.dp)
         ) {
             Row(verticalAlignment = Alignment.CenterVertically) {
                 Icon(
                     painter = painterResource(id = R.drawable.ic_facebook),
                     contentDescription = "",
                     modifier = Modifier.size(20.dp),
                     tint = Color.Unspecified
                 )
                 Spacer(modifier = Modifier.width(10.dp))
                 Text(text = "Facebook",
                     fontFamily = Poppins,
                     color = SecondaryColor
                 )
             }
         }
     }
 }

 fun createUser(
     email: String,
     password: String,
     navController: NavController

 ){
     println("L'email est $email, et le mot de passe est $password")

     val auth = Firebase.auth
     try {
         auth.createUserWithEmailAndPassword(email, password)
             .addOnCompleteListener { task ->
                 if (task.isSuccessful) {
                     Log.d(TAG, "createUserWithEmail:success")
                     navController.navigate("LoginScreen") // naviguer vers la page de connexion


                 } else {
                     Log.w(TAG, "createUserWithEmail:failure", task.exception)
                 }
             }
     } catch (e: Exception) {
         println("Erreur : $e.message")
     }
 }