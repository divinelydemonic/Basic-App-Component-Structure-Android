package kr.android.appstructuretemplate.navigation

import androidx.annotation.DrawableRes
import kr.android.appstructuretemplate.R

sealed class Screens(
    val title : String,
    val route : String,
    @DrawableRes val icon : Int
) {

    sealed class AppDrawer(
        val dTitle : String,
        val dRoute : String,
        @DrawableRes val dIcon : Int
    ) : Screens(dTitle, dRoute, dIcon) {

        object DrawerItem1 : AppDrawer(
            dTitle = "Drawer Item 1",
            dRoute = "drawerItem1",
            dIcon = R.drawable.item_1
        )

        object DrawerItem2 : AppDrawer(
            dTitle = "Drawer Item 2",
            dRoute = "drawerItem2",
            dIcon = R.drawable.item_2
        )

        object DrawerItem3 : AppDrawer(
            dTitle = "Drawer Item 3",
            dRoute = "drawerItem3",
            dIcon = R.drawable.item_3
        )

    }

    sealed class BottomBar(
        val bTitle : String,
        val bRoute : String,
        @DrawableRes val bIcon : Int
    ) : Screens(bTitle, bRoute, bIcon) {

        object BBItem1 : BottomBar(
            bTitle = "BB Item 1",
            bRoute = "bBItem1",
            bIcon = R.drawable.bb_item1
        )

        object BBItem2 : BottomBar(
            bTitle = "BB Item 2",
            bRoute = "bBItem2",
            bIcon = R.drawable.bb_item2
        )

        object BBItem3 : BottomBar(
            bTitle = "BB Item 3",
            bRoute = "bBItem3",
            bIcon = R.drawable.bb_item3
        )

    }

    sealed class BottomSheet(
        val bsTitle : String,
        val bsRoute : String,
        @DrawableRes val bsIcon : Int
    ) : Screens(bsTitle, bsRoute, bsIcon) {

        object BSItem1 : BottomSheet(
            bsTitle = "BS Item 1",
            bsRoute = "bSItem1",
            bsIcon = R.drawable.item_1
        )

        object BSItem2 : BottomSheet(
            bsTitle = "BS Item 2",
            bsRoute = "bSItem2",
            bsIcon = R.drawable.item_2
        )

        object BSItem3 : BottomSheet(
            bsTitle = "BS Item 3",
            bsRoute = "bSItem3",
            bsIcon = R.drawable.item_3
        )

    }

}


val drawerItems = listOf(
    Screens.AppDrawer.DrawerItem1,
    Screens.AppDrawer.DrawerItem2,
    Screens.AppDrawer.DrawerItem3
)

val bottomBarItems = listOf(
    Screens.BottomBar.BBItem1,
    Screens.BottomBar.BBItem2,
    Screens.BottomBar.BBItem3
)

val bottomSheetItems = listOf(
    Screens.BottomSheet.BSItem1,
    Screens.BottomSheet.BSItem2,
    Screens.BottomSheet.BSItem3
)

val allScreens = listOf(

    Screens.BottomBar.BBItem1,
    Screens.BottomBar.BBItem2,
    Screens.BottomBar.BBItem3,

    Screens.AppDrawer.DrawerItem1,
    Screens.AppDrawer.DrawerItem2,
    Screens.AppDrawer.DrawerItem3,

    Screens.BottomSheet.BSItem1,
    Screens.BottomSheet.BSItem2,
    Screens.BottomSheet.BSItem3
)