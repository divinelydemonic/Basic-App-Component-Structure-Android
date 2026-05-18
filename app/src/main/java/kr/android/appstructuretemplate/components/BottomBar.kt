package kr.android.appstructuretemplate.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.android.appstructuretemplate.navigation.bottomBarItems

@Composable
fun BottomBar(
    currentRoute : String,
    onItemClicked : (String) -> Unit
){
    NavigationBar(

    ) {
        bottomBarItems.forEach {item ->

            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { onItemClicked(item.route) },
                alwaysShowLabel = false,
                label = { Text(item.title, fontSize = 20.sp, fontWeight = FontWeight.SemiBold) },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(35.dp)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            )

        }
    }
}