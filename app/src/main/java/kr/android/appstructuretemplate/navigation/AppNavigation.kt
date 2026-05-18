package kr.android.appstructuretemplate.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kr.android.appstructuretemplate.bottombar_screens.BBItem1
import kr.android.appstructuretemplate.bottombar_screens.BBItem2
import kr.android.appstructuretemplate.bottombar_screens.BBItem3
import kr.android.appstructuretemplate.bottomsheet_screens.BSItem1
import kr.android.appstructuretemplate.bottomsheet_screens.BSItem2
import kr.android.appstructuretemplate.bottomsheet_screens.BSItem3
import kr.android.appstructuretemplate.drawer_screens.DrawerItem1
import kr.android.appstructuretemplate.drawer_screens.DrawerItem2
import kr.android.appstructuretemplate.drawer_screens.DrawerItem3

@Composable
fun AppNavigation(
    navController: NavHostController,
    padding: PaddingValues
){

    NavHost(
        navController = navController,
        startDestination = Screens.BottomBar.BBItem1.route
    ){

        composable(Screens.BottomBar.BBItem1.route){
            BBItem1()
        }

        composable(Screens.BottomBar.BBItem2.route){
            BBItem2()
        }

        composable(Screens.BottomBar.BBItem3.route){
            BBItem3()
        }

        composable(Screens.AppDrawer.DrawerItem1.route){
            DrawerItem1()
        }

        composable(Screens.AppDrawer.DrawerItem2.route){
            DrawerItem2()
        }

        composable(Screens.AppDrawer.DrawerItem3.route){
            DrawerItem3()
        }

        composable(Screens.BottomSheet.BSItem1.route){
            BSItem1()
        }

        composable(Screens.BottomSheet.BSItem2.route){
            BSItem2()
        }

        composable(Screens.BottomSheet.BSItem3.route){
            BSItem3()
        }

    }

}