package com.bonifaciotech.composebasic.util

sealed class Screen(val route: String) {
    object ConsultaPersona : Screen("ConsultaPersona")
    object RegistroPersonas : Screen("RegistroPersona")
    object RegistroOcupaciones : Screen("RegistroOcupacion")
    object ConsultaOcupacion : Screen("ConsultaOcupacion")
}