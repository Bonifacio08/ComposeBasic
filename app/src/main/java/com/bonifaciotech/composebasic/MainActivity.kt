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
import com.bonifaciotech.composebasic.util.Screen

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

    NavHost(navController = navHostController, startDestination = Screen.ConsultaPersona.route){

        composable(route = Screen.ConsultaPersona.route){
            ConsultaPersona(RegistroP = {navHostController.navigate(Screen.RegistroPersonas.route)}, Ocupaciones = {navHostController.navigate(Screen.ConsultaOcupacion.route)})
        }
        composable(route = Screen.RegistroPersonas.route){
            RegistroPersonas (GoConsultaP = {navHostController.navigate(Screen.ConsultaPersona.route)})
        }

        composable(route = Screen.ConsultaOcupacion.route) {
            ConsultaOcupacion(GoRegistroOcupac = {navHostController.navigate(Screen.RegistroOcupaciones.route)}, GoConsultaP = {navHostController.navigate(Screen.ConsultaPersona.route)})
        }

        composable(route = Screen.RegistroOcupaciones.route){
            RegistroOcupaciones (GoConsultaOcup = {navHostController.navigate(Screen.ConsultaOcupacion.route)} )
        }
    }
}

//Creacion Funciones
@Composable
fun ConsultaPersona(RegistroP : () -> Unit, Ocupaciones: ()-> Unit){

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
            OutlinedButton(
                onClick = {
                    Ocupaciones()
                }) {
                Text(text = "Ocupaciones")
            }

            val list = listOf("Gabriel","Enel","Maria")

            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(list) {Nombres->
                    Text("El nombre es: $Nombres")
                }
            }
        }
    }
    
   
}

@Composable
fun RegistroPersonas(GoConsultaP:()->Unit){
    //Conexion inicio
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Personas")})
        },
       floatingActionButton = {
           FloatingActionButton(
               onClick = {
                    GoConsultaP()
               }) {
               Icon(imageVector = Icons.Default.Person, contentDescription = null)

           }
       },
        scaffoldState = scaffoldState
    ) {
        //Fin conexion
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
//Hacer un boton para para consulta personas
@Composable
fun ConsultaOcupacion(GoRegistroOcupac: ()-> Unit, GoConsultaP: () -> Unit){
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Consulta de Ocupaciones")})
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    GoRegistroOcupac()
                }) {
                Icon(imageVector = Icons.Default.Person, contentDescription =null )

            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier.padding(8.dp)) {

            OutlinedButton(onClick = {
                GoConsultaP()
            }) {
                Text(text = "Persona")
            }

            val listDescripcion = listOf("Gerente","Supervisor","Contable")

            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(listDescripcion){ocup->

                    RowOcup(ocup)
                }

            }
        }
    }


}

@Composable
fun RegistroOcupaciones(GoConsultaOcup: ()-> Unit){
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Ocupaciones")})
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    GoConsultaOcup()
                }) {
                Icon(imageVector = Icons.Default.Person, contentDescription = null)

            }
        },
        scaffoldState = scaffoldState
    ) {

    }

    Column(modifier = Modifier.padding(8.dp)) {

        OutlinedTextField(
            label = {
                    Text(text = "Id:")
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
                    Text(text = "Descripcion")
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
                Icon(Icons.Default.Person, contentDescription = null)
            },

            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth()
        )

    }

}
//-------------------------------------------------------
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeBasicTheme {
        MyApp()
    }
}









