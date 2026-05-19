package kr.android.appstructuretemplate

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddAlert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.launch
import kr.android.appstructuretemplate.components.AppDrawer
import kr.android.appstructuretemplate.components.BottomBar
import kr.android.appstructuretemplate.components.BottomSheet
import kr.android.appstructuretemplate.components.TopBar
import kr.android.appstructuretemplate.navigation.AppNavigation
import kr.android.appstructuretemplate.navigation.allScreens

@Composable
fun MainView(
    modifier: Modifier,
    navController: NavHostController
) {

    val navBackStackEntry =
        navController.currentBackStackEntryAsState()

    val currentRoute =
        navBackStackEntry.value
            ?.destination
            ?.route

    val title = allScreens
        .find { it.route == currentRoute }
        ?.title ?: "App"

    val icon = allScreens
        .find { it.route == currentRoute }
        ?.icon


    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val showBottomSheet = remember { mutableStateOf(false) }
    val showDialog = remember { mutableStateOf(false) }


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(
                currentRoute = currentRoute ?: "",
                onItemClicked = {route ->
                    navController.navigate(route)
                    scope.launch { drawerState.close() }
                }
            )
        }
    ){

        Scaffold(
            topBar = {
                TopBar(
                    title = title,
                    icon = icon,
                    onMenuClicked = { scope.launch { drawerState.open() } },
                    onMoreClicked = { showBottomSheet.value = true }
                )
            },
            bottomBar = {
                BottomBar(
                    currentRoute = currentRoute ?: "",
                    onItemClicked = {route ->
                        navController.navigate(route)
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { showDialog.value = true },
                    modifier = Modifier
                        .padding(24.dp)
                        .size(64.dp)
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "add",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        ) {

            AppNavigation(
                navController = navController,
                padding = it
            )
        }

        if(showBottomSheet.value){
            BottomSheet(
                currentRoute = currentRoute ?: "",
                onDismiss = { showBottomSheet.value = false },
                onItemSelected = {route ->
                    navController.navigate(route)
                    showBottomSheet.value = false
                }
            )
        }

        if (showDialog.value){
            AlertDialog(
                onDismissRequest = {
                    showDialog.value = false
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.AddAlert,
                        contentDescription = "alert",
                        modifier = Modifier.size(40.dp)
                    )
                },
                title = {
                    Text(
                        text = "Alert Dialog",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                },
                text = {
                    Text(
                        text = "This is an alert dialog box!",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showDialog.value = false
                        }
                    ) {
                        Text(
                            text = "Okay",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            showDialog.value = false
                        }
                    ) {
                        Text(
                            text = "Cancel",
                            fontSize = 20.sp,
                        )
                    }
                },
                shape = RoundedCornerShape(20.dp),
                containerColor =
                    MaterialTheme.colorScheme.surfaceVariant,
                iconContentColor =
                    MaterialTheme.colorScheme.primary,
                titleContentColor =
                    MaterialTheme.colorScheme.onSurface,
                textContentColor =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

    }

}