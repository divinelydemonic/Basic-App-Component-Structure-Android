@file:OptIn(ExperimentalMaterial3Api::class)

package kr.android.appstructuretemplate.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.android.appstructuretemplate.navigation.bottomSheetItems

@Composable
fun BottomSheet(
    currentRoute : String,
    onDismiss : () -> Unit,
    onItemSelected : (String) -> Unit
){

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        scrimColor = Color.Black.copy(alpha = 0.6f),
        dragHandle = {
            Spacer(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .width(50.dp)
                    .height(5.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(100)
                    )
            )
        }
    ) {

        Column(
            modifier = Modifier.fillMaxHeight(0.35f)
        ){
            Text(
                text = "More Options",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Spacer(Modifier.height(8.dp))

            bottomSheetItems.forEachIndexed { index, item ->

                ListItem(
                    leadingContent = {
                        Icon(
                            painter = painterResource(item.bBIcon),
                            contentDescription = item.title,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    },
                    headlineContent = { Text(item.title, fontSize = 25.sp, fontWeight = FontWeight.SemiBold) },
                    colors = ListItemDefaults.colors(
                        containerColor = if (
                            currentRoute == item.route
                        ) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            Color.Transparent
                        },
                        headlineColor = if (
                            currentRoute == item.route
                        ) {
                            MaterialTheme.colorScheme.onPrimary
                        } else {
                            MaterialTheme.colorScheme.onSurfaceVariant
                        },
                        leadingIconColor = if (
                            currentRoute == item.route
                        ) {
                            MaterialTheme.colorScheme.onPrimary
                        } else {
                            MaterialTheme.colorScheme.onSurfaceVariant
                        },
                    ),
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .clickable { onItemSelected(item.route) }
                )

                if (index != bottomSheetItems.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant
                    )
                }

            }

            Spacer(Modifier.height(24.dp))
        }

    }

}