package com.bonifaciotech.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
private fun MyApp() {

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = "ConsultaPersonas"){

        composable(Routu){

        }
    }
    //Llamar las funciones
    //ConsultaPersona()
    //ConsultaOcupacion()
    //RegistroPersonas()
}
//Creacion Funciones
@Composable
fun ConsultaPersona(RegistroP : () -> Unit){

     val scaffoldState = rememberScaffoldState()

    Scaffold(
        
        topBar = {
            TopAppBar(title = { Text(text = "Consulta de personas")})
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    RegistroP()
                }) {
                Icon(imageVector = Icons.Default.Add, contentDescription =null )

            }
        },
        scaffoldState = scaffoldState
        
    ) {
        Column(modifier = Modifier.padding(8.dp)) {

            val list = listOf("Gabriel","Enel","Maria")

            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(list) {Nombres->
                    Text("El nombre es: $Nombres")
                    //AuxPersona(Nombres)
                }
            }
        }
    }
    
   
}

@Composable
fun RegistroPersonas(){
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Personas")})
        }
    ) {
        Column(modifier = Modifier.padding(8.dp)) {

            OutlinedTextField(
                label = {
                    Text(text = "Id")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                },

                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                label = {
                    Text(text = "Nombre")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                },

                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth()

            )

            OutlinedTextField(
                label = {
                    Text(text = "Salario")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                },

                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth()
            )

            Row() {
                OutlinedButton(
                    onClick = {

                    }) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                    Text(text = "Nuevo")

                }

                OutlinedButton(
                    onClick = {

                    }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    Text(text = "Guardar")

                }
                OutlinedButton(
                    onClick = {

                    }) {

                    Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                    Text(text = "Eliminar")

                }

            }
        }
        
    }

    




    
}


@Composable
fun RowOcup(ocup : String) {
    Row() {
        Text("Ocupacion : $ocup ")
    }
}

@Composable
fun ConsultaOcupacion(){

    Column(modifier = Modifier.padding(8.dp)) {

        //val listOcupacioId = listOf("1","2","3")
        val listDescripcion = listOf("Gerente","Supervisor","Contable")
        //val listIngresos = listOf("80,000","72,000","55,000")

        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(listDescripcion){ocup->

                RowOcup(ocup)
            }

        }
    }
}

@Composable
fun ComponentePrueba() {
    Column(modifier = Modifier.fillMaxWidth()) {

        /*
        Text(
            text = stringResource("julio"),
            style = MaterialTheme.typography.h3
        )

        OutlinedTextField(
            label = {
                Text("Ocupacion")
            },
        )

         */

    }


    OutlinedTextField(

        value = "",
        onValueChange = {}
    )
}




















//-------------------------------------------------------
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeBasicTheme {
        MyApp()
    }
}









