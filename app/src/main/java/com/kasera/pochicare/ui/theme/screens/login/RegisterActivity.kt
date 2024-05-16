package com.kasera.pochicare.ui.theme.screens.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.DrawerValue
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kasera.pochicare.ui.theme.PochicareTheme
import com.kasera.pochicare.ui.theme.LoginActivity

//import com.kasera.pochicare.ui.theme.screens.login_register.ui.theme.PochicareTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PochicareTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // Greeting3("Android")
                    Register()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Register() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val selectedIndex = remember { mutableStateOf(0) }
   // var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
   // var phonenumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
  //  var confirmpass by remember { mutableStateOf("")}
    val context = LocalContext.current


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(
            title = {
                Row() {
                Text(
                    text = "SHAMBACARE",
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color.Red
                )
                Text(
                    text = "FARM SUPPLIES",
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Cursive,
                    color = Color.White
                )

            }

            },
            backgroundColor = Color.Green)  },
        //floatingActionButtonPosition = FabPosition.End,
      //  floatingActionButton = { FloatingActionButton(onClick = {}){
      //      Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
       // }
                    //           },
        drawerContent = { Text(text = "Drawer Menu 1") },
        content = {
            // Text("We")
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ){
                Text(text = "WELCOME BACK!",
                    color = Color.Green,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 25.sp,
                )
                Text(text = "Login",
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 25.sp,
                )

                OutlinedTextField(
                    value = email,
                    onValueChange ={email=it},
                    leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "email")},
                    label = { Text(text = "Enter Email",
                        color = Color.Green,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 15.sp
                    )},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                )
                OutlinedTextField(
                    value = password ,
                    onValueChange ={password=it},
                    leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "password")},
                    label = { Text(text = "Enter Password",
                        color = Color.Green,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 15.sp
                    )},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                )

                Spacer(modifier = Modifier)
                Text(text = "Don't have an account? Register.",
                    color = Color.Gray,
                    fontFamily = FontFamily.Serif,
                    fontSize = 15.sp,
                )
                Button(onClick = {
                    val intent= Intent(context, LoginActivity::class.java)
                    context.startActivity(intent)
                },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),

                    )
                {
                    Text(text = "Register",
                        fontSize = 25.sp)
                }
                Spacer(modifier = Modifier)
                Button(onClick = {
                },
                    modifier = Modifier
                        .fillMaxWidth()) {
                    Text(text = "Click to Login",
                        fontSize = 25.sp)


                }
            }

        },
        bottomBar = { BottomAppBar(backgroundColor = Color.Green) {
            // Text("_")
        } }
    )
    // Box(modifier = Modifier
    //   .background(Color(0xff546e7a)),

    //  .fillMaxSize()
    // )
}

@Preview
@Composable
fun Registerprev(){
    Register()
}
