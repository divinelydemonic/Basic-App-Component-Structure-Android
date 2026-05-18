package kr.android.appstructuretemplate.navigation

import androidx.annotation.DrawableRes
import kr.android.appstructuretemplate.R

sealed class Screens(
    val title : String,
    val route : String
) {

    sealed class AppDrawer(
        val dTitle : String,
        val dRoute : String,
        @DrawableRes val icon : Int
    ) : Screens(dTitle, dRoute) {

        object DrawerItem1 : AppDrawer(
            dTitle = "DrawerItem1",
            dRoute = "drawerItem1",
            icon = R.drawable.item_1
        )

        object DrawerItem2 : AppDrawer(
            dTitle = "DrawerItem2",
            dRoute = "drawerItem2",
            icon = R.drawable.item_2
        )

        object DrawerItem3 : AppDrawer(
            dTitle = "DrawerItem3",
            dRoute = "drawerItem3",
            icon = R.drawable.item_3
        )

    }

    sealed class BottomBar(
        val bTitle : String,
        val bRoute : String,
        @DrawableRes val icon : Int
    ) : Screens(bTitle, bRoute) {

        object BBItem1 : BottomBar(
            bTitle = "BBItem1",
            bRoute = "bBItem1",
            icon = R.drawable.bb_item1
        )

        object BBItem2 : BottomBar(
            bTitle = "BBItem2",
            bRoute = "bBItem2",
            icon = R.drawable.bb_item2
        )

        object BBItem3 : BottomBar(
            bTitle = "BBItem3",
            bRoute = "bBItem3",
            icon = R.drawable.bb_item3
        )

    }

}