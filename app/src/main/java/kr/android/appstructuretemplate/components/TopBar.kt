@file:OptIn(ExperimentalMaterial3Api::class)

package kr.android.appstructuretemplate.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(
    title : String,
    onMenuClicked : () -> Unit,
    onMoreClicked : () -> Unit
){

    TopAppBar(
        title = {
            Text(
                title,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "menu"
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "more menu"
            )
        },
        windowInsets = TopAppBarDefaults.windowInsets,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onSurface
        )
    )

}