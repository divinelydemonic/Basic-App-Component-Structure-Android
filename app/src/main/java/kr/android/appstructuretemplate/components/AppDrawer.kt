package kr.android.appstructuretemplate.components

import android.util.Log.d
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.android.appstructuretemplate.navigation.drawerItems

@Composable
fun AppDrawer(
    currentRoute : String,
    onItemClicked : (String) -> Unit
){

    ModalDrawerSheet(
        modifier = Modifier.fillMaxWidth(0.7f),
        drawerShape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp),
        drawerContainerColor = MaterialTheme.colorScheme.primaryContainer,
        drawerContentColor = MaterialTheme.colorScheme.onSurface
    ) {

        Text(
            text = "Menu",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 16.dp)
                .padding(16.dp)
        )

        Spacer(Modifier.height(8.dp))

        drawerItems.forEach {item ->

            NavigationDrawerItem(
                label = { Text(item.title, fontWeight = FontWeight.SemiBold, fontSize = 20.sp) },
                icon = {
                    Icon(
                        painter = painterResource(item.dIcon),
                        contentDescription = item.title,
                        modifier = Modifier.size(30.dp)
                    )
                },
                selected = currentRoute == item.route,
                onClick = { onItemClicked(item.route) },
                shape = RoundedCornerShape(16.dp),
                colors = NavigationDrawerItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                    selectedContainerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 4.dp)

            )

        }
    }
}