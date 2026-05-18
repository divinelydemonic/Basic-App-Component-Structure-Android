@file:OptIn(ExperimentalMaterial3Api::class)

package kr.android.appstructuretemplate.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(
    title : String,
    icon : Int?,
    onMenuClicked : () -> Unit,
    onMoreClicked : () -> Unit
){

    TopAppBar(
        title = {
            Text(
                title,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onMenuClicked
            ){
                if (icon != null) {
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = title,
                        modifier = Modifier.size(35.dp)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "menu",
                        modifier = Modifier.size(35.dp)
                    )
                }
            }
        },
        actions = {
            IconButton(
                onClick = onMoreClicked
            ){
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "more menu",
                    modifier = Modifier.size(30.dp)
                )
            }
        },
        windowInsets = TopAppBarDefaults.windowInsets,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onSurface
        )
    )

}