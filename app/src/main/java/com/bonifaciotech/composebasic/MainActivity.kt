package com.bonifaciotech.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bonifaciotech.composebasic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    //Llamar las funciones
    RegistroPersona()
}
//Creacion Funciones
@Composable
fun RegistroPersona(){
    Column(modifier = Modifier.padding(8.dp)) {
        val list = listOf("Gabriel","Enel","Maria")
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(list) {obj->
                AuxPersona(obj)
            }
        }
    }
}

@Composable
fun AuxPersona(Inicio: String){
    Row() {
        Text("$Inicio")
    }
}
//--------------------------
//@Composable
//fun





















//-------------------------------------------------------
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeBasicTheme {
        MyApp()
    }
}









