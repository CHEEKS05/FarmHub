package com.kasera.pochicare.ui.theme.screens.rent

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.DrawerValue
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kasera.pochicare.R
import com.kasera.pochicare.ui.theme.PochicareTheme
import com.kasera.pochicare.ui.theme.screens.products.ProductsActivity
import com.kasera.pochicare.ui.theme.screens.sell.SellActivity

//import com.kasera.pochicare.ui.theme.screens.rent.ui.theme.PochicareTheme

class RentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PochicareTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ///Greeting("Android")
                    ScaffoldSample()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldSample() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val selectedIndex = remember { mutableStateOf(0) }
    val items = listOf("")
    val context = LocalContext.current

    BottomNavigation(elevation = 10.dp
    )
    {
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.ShoppingCart,"")
        },
            label = { Text(text = "Products") },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
                val intent= Intent(context, ProductsActivity::class.java)
                context.startActivity(intent)
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Star,"")
        },
            label = { Text(text = "Rent") },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            })
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.KeyboardArrowUp,"")
        },
            //  { val intent= Intent(context, ProductsActivity::class.java)
            // context.startActivity(intent) },
            label = { Text(text = "Sell") },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
                val intent= Intent(context, SellActivity::class.java)
                context.startActivity(intent)
            })


    }
    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = Color.DarkGray,
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
     //   floatingActionButtonPosition = FabPosition.End,
     //   floatingActionButton = {
         //   FloatingActionButton(onClick = {}){
                // Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
           // } }

        drawerContent = { Text(text = "Drawer Menu 1") },
        content = { Text(""
        )
        },
        bottomBar = { BottomAppBar(backgroundColor = Color.Green) {
            // Text("_")
            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.ShoppingCart,"")
            },
                label = { Text(text = "Products") },
                selected = (selectedIndex.value == 0),
                onClick = {
                    selectedIndex.value = 0
                    val intent= Intent(context, ProductsActivity::class.java)
                    context.startActivity(intent)
                })
            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.Star,"")
            },
                label = { Text(text = "Rent") },
                selected = (selectedIndex.value == 1),
                onClick = {
                    selectedIndex.value = 1
                })
            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.KeyboardArrowUp,"")
            },
                //  { val intent= Intent(context, ProductsActivity::class.java)
                // context.startActivity(intent) },
                label = { Text(text = "Sell") },
                selected = (selectedIndex.value == 1),
                onClick = {
                    selectedIndex.value = 1

                })

        } }
    )
    LazyColumn {
        items(items){item ->
            Text(text = item)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(25.dp)

            )
            {
                Text(
                    text = "",
                    color = Color.Gray,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 30.sp,
                )
                Image(
                    painter = painterResource(id = R.drawable.tractor),
                    contentDescription = "Ferguson Tractor",
                            modifier = Modifier
                            .fillMaxWidth()
                        .height(200.dp)
                )
                Text(
                    text = "Ferguson Tractor",
                    color = Color.Red,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                )
                OutlinedButton(
                    onClick = {
                        var uri = Uri.parse("smsto:0797630636")

                        val intent = Intent(Intent.ACTION_SENDTO, uri)

                        intent.putExtra("Hello", "Can I rent a Ferguson Tractor?")

                        //  context.startActivity(intent)
                    },
                    colors = ButtonDefaults.buttonColors(Color.Green),
                    shape = RoundedCornerShape(10.dp)
                    // modifier = Modifier.fillMaxWidth()
                )
                {
                    Text(
                        text = "RENT",
                        color = Color.Black,

                        fontSize = 15.sp
                    )


                }
                Image(
                    painter = painterResource(id = R.drawable.irrigationmachine),
                    contentDescription = "Irrigation Machine",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Text(
                    text = "Irrigation Machine",
                    color = Color.Red,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                )
                OutlinedButton(
                    onClick = {
                        var uri = Uri.parse("smsto:0797630636")

                        val intent = Intent(Intent.ACTION_SENDTO, uri)

                        intent.putExtra("Hello", "Can I rent an Irrigation Machine?")

                        //  context.startActivity(intent)
                    },
                    colors = ButtonDefaults.buttonColors(Color.Green),
                    shape = RoundedCornerShape(10.dp)
                    // modifier = Modifier.fillMaxWidth()
                )
                {
                    Text(
                        text = "RENT",
                        color = Color.Black,

                        fontSize = 15.sp
                    )


                }

                Image(
                    painter = painterResource(id = R.drawable.lawnmower),
                    contentDescription = "Lawn Mower",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Text(
                    text = "Lawn Mower",
                    color = Color.Red,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                )
                OutlinedButton(
                    onClick = {
                        var uri = Uri.parse("smsto:0797630636")

                        val intent = Intent(Intent.ACTION_SENDTO, uri)

                        intent.putExtra("Hello", "Can I rent a Lawn Mower?")

                        //  context.startActivity(intent)
                    },
                    colors = ButtonDefaults.buttonColors(Color.Green),
                    shape = RoundedCornerShape(10.dp)
                    // modifier = Modifier.fillMaxWidth()
                )
                {
                    Text(
                        text = "RENT",
                        color = Color.Black,

                        fontSize = 15.sp
                    )


                }


                Image(
                    painter = painterResource(id = R.drawable.lawnmower),
                    contentDescription = "Weeding Cart",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                OutlinedButton(
                    onClick = {
                        var uri = Uri.parse("smsto:0797630636")

                        val intent = Intent(Intent.ACTION_SENDTO, uri)

                        intent.putExtra("Hello", "Can I rent a Weeding Cart?")

                        //  context.startActivity(intent)
                    },
                    colors = ButtonDefaults.buttonColors(Color.Green),
                    shape = RoundedCornerShape(10.dp)
                    // modifier = Modifier.fillMaxWidth()
                )
                {
                    Text(
                        text = "RENT",
                        color = Color.Black,

                        fontSize = 15.sp
                    )


                }
            }
        }
    }
    // Box(modifier = Modifier
    //   .background(Color(0xff546e7a)),

    //  .fillMaxSize()
    // )
}

@Preview
    ( uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Light Mode")
@Composable
fun ScaffoldSampleprev(){
    ScaffoldSample()
}