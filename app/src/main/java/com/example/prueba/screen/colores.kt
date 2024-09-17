package com.example.prueba.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Definir colores globalmente
val Brown = Color(0xFFA52A2A)  // Marrón
val Red = Color(0xFFFF0000)    // Rojo
val Orange = Color(0xFFFFA500) // Naranja
val Black = Color(0xFF000000)  // Negro
val Gold = Color(0xFFFFD700)   // Oro
val Silver = Color(0xFFC0C0C0) // Plata

// Definir tolerancias
val tolerancias = mapOf(
    "Marrón" to "±1%",
    "Rojo" to "±2%",
    "Oro" to "±5%",
    "Plata" to "±10%",
    "Ninguna" to "±20%"
)

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun textos() {
    val context = LocalContext.current

    // Variables para cada banda
    var banda1 by remember { mutableStateOf("") }
    var banda2 by remember { mutableStateOf("") }
    var banda3 by remember { mutableStateOf("") }
    var banda4 by remember { mutableStateOf("") }  // Banda para tolerancia

    // Variable para el cálculo
    var resistencia by remember { mutableStateOf("") }
    var tolerancia by remember { mutableStateOf("Ninguna") }

    // Estado expandido para cada menú desplegable
    var expandedBanda1 by remember { mutableStateOf(false) }
    var expandedBanda2 by remember { mutableStateOf(false) }
    var expandedBanda3 by remember { mutableStateOf(false) }
    var expandedBanda4 by remember { mutableStateOf(false) }

    fun calcularResistencia(banda1: String, banda2: String, banda3: String, banda4: String) {
        val valorBanda1 = banda1.toIntOrNull() ?: 0
        val valorBanda2 = banda2.toIntOrNull() ?: 0
        val multiplicador = banda3.toIntOrNull() ?: 1

        resistencia = "${(valorBanda1 * 10 + valorBanda2) * multiplicador}Ω"
        tolerancia = tolerancias[banda4] ?: "±20%"
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Título
            Text(
                text = "Resistencias HELEN",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Menú desplegable para Banda 1
            ExposedDropdownMenuBox(
                expanded = expandedBanda1,
                onExpandedChange = { expandedBanda1 = !expandedBanda1 }
            ) {
                TextField(
                    value = if (banda1.isEmpty()) "Banda 1" else banda1,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expandedBanda1) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier.menuAnchor()
                )

                ExposedDropdownMenu(
                    expanded = expandedBanda1,
                    onDismissRequest = { expandedBanda1 = false }
                ) {
                    DropdownMenuItem(
                        text = {
                            Row {
                                Box(modifier = Modifier.size(24.dp).background(Black))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Negro - 0")
                            }
                        },
                        onClick = {
                            banda1 = "0"
                            expandedBanda1 = false
                            calcularResistencia(banda1, banda2, banda3, banda4)
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Row {
                                Box(modifier = Modifier.size(24.dp).background(Brown))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Marrón - 1")
                            }
                        },
                        onClick = {
                            banda1 = "1"
                            expandedBanda1 = false
                            calcularResistencia(banda1, banda2, banda3, banda4)
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Row {
                                Box(modifier = Modifier.size(24.dp).background(Red))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Rojo - 2")
                            }
                        },
                        onClick = {
                            banda1 = "2"
                            expandedBanda1 = false
                            calcularResistencia(banda1, banda2, banda3, banda4)
                        }
                    )
                }
            }

            // Menú desplegable para Banda 2
            ExposedDropdownMenuBox(
                expanded = expandedBanda2,
                onExpandedChange = { expandedBanda2 = !expandedBanda2 }
            ) {
                TextField(
                    value = if (banda2.isEmpty()) "Banda 2" else banda2,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expandedBanda2) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier.menuAnchor()
                )

                ExposedDropdownMenu(
                    expanded = expandedBanda2,
                    onDismissRequest = { expandedBanda2 = false }
                ) {
                    DropdownMenuItem(
                        text = {
                            Row {
                                Box(modifier = Modifier.size(24.dp).background(Black))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Negro - 0")
                            }
                        },
                        onClick = {
                            banda2 = "0"
                            expandedBanda2 = false
                            calcularResistencia(banda1, banda2, banda3, banda4)
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Row {
                                Box(modifier = Modifier.size(24.dp).background(Brown))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Marrón - 1")
                            }
                        },
                        onClick = {
                            banda2 = "1"
                            expandedBanda2 = false
                            calcularResistencia(banda1, banda2, banda3, banda4)
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Row {
                                Box(modifier = Modifier.size(24.dp).background(Red))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Rojo - 2")
                            }
                        },
                        onClick = {
                            banda2 = "2"
                            expandedBanda2 = false
                            calcularResistencia(banda1, banda2, banda3, banda4)
                        }
                    )
                }
            }

            // Menú desplegable para Banda 3 (multiplicador)
            ExposedDropdownMenuBox(
                expanded = expandedBanda3,
                onExpandedChange = { expandedBanda3 = !expandedBanda3 }
            ) {
                TextField(
                    value = if (banda3.isEmpty()) "Banda 3" else banda3,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expandedBanda3) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier.menuAnchor()
                )

                ExposedDropdownMenu(
                    expanded = expandedBanda3,
                    onDismissRequest = { expandedBanda3 = false }
                ) {
                    DropdownMenuItem(
                        text = {
                            Row {
                                Box(modifier = Modifier.size(24.dp).background(Black))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Negro - x1")
                            }
                        },
                        onClick = {
                            banda3 = "1"
                            expandedBanda3 = false
                            calcularResistencia(banda1, banda2, banda3, banda4)
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Row {
                                Box(modifier = Modifier.size(24.dp).background(Brown))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Marrón - x10")
                            }
                        },
                        onClick = {
                            banda3 = "10"
                            expandedBanda3 = false
                            calcularResistencia(banda1, banda2, banda3, banda4)
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Row {
                                Box(modifier = Modifier.size(24.dp).background(Red))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Rojo - x100")
                            }
                        },
                        onClick = {
                            banda3 = "100"
                            expandedBanda3 = false
                            calcularResistencia(banda1, banda2, banda3, banda4)
                        }
                    )
                }
            }

            // Menú desplegable para Banda 4 (tolerancia)
            ExposedDropdownMenuBox(
                expanded = expandedBanda4,
                onExpandedChange = { expandedBanda4 = !expandedBanda4 }
            ) {
                TextField(
                    value = if (banda4.isEmpty()) "Banda 4" else banda4,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expandedBanda4) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier.menuAnchor()
                )

                ExposedDropdownMenu(
                    expanded = expandedBanda4,
                    onDismissRequest = { expandedBanda4 = false }
                ) {
                    DropdownMenuItem(
                        text = {
                            Row {
                                Box(modifier = Modifier.size(24.dp).background(Brown))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Marrón - ±1%")
                            }
                        },
                        onClick = {
                            banda4 = "Marrón"
                            expandedBanda4 = false
                            calcularResistencia(banda1, banda2, banda3, banda4)
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Row {
                                Box(modifier = Modifier.size(24.dp).background(Red))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Rojo - ±2%")
                            }
                        },
                        onClick = {
                            banda4 = "Rojo"
                            expandedBanda4 = false
                            calcularResistencia(banda1, banda2, banda3, banda4)
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Row {
                                Box(modifier = Modifier.size(24.dp).background(Gold))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Oro - ±5%")
                            }
                        },
                        onClick = {
                            banda4 = "Oro"
                            expandedBanda4 = false
                            calcularResistencia(banda1, banda2, banda3, banda4)
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Row {
                                Box(modifier = Modifier.size(24.dp).background(Silver))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Plata - ±10%")
                            }
                        },
                        onClick = {
                            banda4 = "Plata"
                            expandedBanda4 = false
                            calcularResistencia(banda1, banda2, banda3, banda4)
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Row {
                                Box(modifier = Modifier.size(24.dp).background(Color.Gray))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Ninguna - ±20%")
                            }
                        },
                        onClick = {
                            banda4 = "Ninguna"
                            expandedBanda4 = false
                            calcularResistencia(banda1, banda2, banda3, banda4)
                        }
                    )
                }
            }

            // Resultado
            Text(text = "Resistencia: $resistencia", style = MaterialTheme.typography.titleMedium)
            Text(text = "Tolerancia: $tolerancia", style = MaterialTheme.typography.titleMedium)
        }
        }
        }



