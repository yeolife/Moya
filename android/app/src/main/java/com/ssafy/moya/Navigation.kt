package com.ssafy.moya

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ssafy.ar.ui.ARSceneComposable
import com.ssafy.main.encycdetail.EncycDetailScreen
import com.ssafy.main.encyclopedia.EncycScreen
import com.ssafy.main.exploredetail.ExploreDetailScreen
import com.ssafy.main.explorelist.ExploreListScreen
import com.ssafy.main.explorestart.ExploreStartScreen
import com.ssafy.main.login.LoginScreen
import com.ssafy.main.parkdetail.ParkDetailScreen
import com.ssafy.main.parklist.ParkListScreen
import com.ssafy.main.util.MultiplePermissionHandler
import com.ssafy.moya.navigation.MainBottomNavigation
import com.ssafy.ui.screen.UserProfileEditScreen

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
    ttsHelper: TTSHelper,
    sttHelper: STTHelper,
) {

    val context = LocalContext.current

    MultiplePermissionHandler(
        permissions =
        listOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
        ),
    ){

    }

    // TODO startDestination 추후에 loin화면으로 수정
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            MainBottomNavigation(
                onNavigateToParkList = {
                    navController.navigate(ParkList)
                },
                onNavigateToParkDetail = { id ->
                    navController.navigate(ParkDetail(itemId = id))
                },
                onNavigateToEncyc = { id ->
                    navController.navigate(EncycDetail(itemId = id))
                },
            )
//            HomeScreen(
//                onNavigateToParkList = {
//                    navController.navigate(ParkList)
//                },
//                onNavigateToParkDetail = { id ->
//                    navController.navigate(ParkDetail(itemId = id))
//                },
//                onNavigateToEncyc = { id ->
//                    navController.navigate(EncycDetail(itemId = id))
//                }
//            )
        }
        composable<ExploreList> {
            ExploreListScreen(
                page = 1,
                size = 3,
                onExploreItemClick = { itemId ->
                    navController.navigate(ExploreDetail(itemId))
                },
                onPop = {
                    navController.popBackStack()
                },
            )
        }
        composable<ParkList> {
            ParkListScreen(onParkItemClick = { itemId ->
                navController.navigate(ParkDetail(itemId))
            }, onPop = {
                navController.popBackStack()
            })
        }
        composable<ExploreDetail> {
            ExploreDetailScreen(onEncycItemClicked = { itemId ->
                navController.navigate(EncycDetail(itemId))
            }, onPop = {
                navController.popBackStack()
            })
        }
        composable<ParkDetail> {
            val parkDetail = it.toRoute<ParkDetail>()
            ParkDetailScreen(
                parkId = parkDetail.itemId,
                onNavigateToEncycDetail = { itemId ->
                    navController.navigate(EncycDetail(itemId))
                },
                onPop = {
                    navController.popBackStack()
                },
                onEnterExplore = {
                    navController.navigate(ExploreStart(parkId = parkDetail.itemId))
                },
            )
        }
        composable<Encyc> {
            EncycScreen(
                parkId = 1,
                page = 1,
                size = 10,
                onNavigateToEncycDetail = { itemId ->
                    navController.navigate(EncycDetail(itemId))
                },
                onPop = {
                    navController.popBackStack()
                },
            )
        }
        // TODO 추후에 찾으러가기 버튼을 눌렀을 때 해당하는 동식물을 찾으러 가는 네비게이션 추가
        composable<EncycDetail> {
            val item = it.toRoute<EncycDetail>()
            EncycDetailScreen(
                itemId = item.itemId + 1,
                onPop = {
                    navController.popBackStack()
                },
                onTTSClicked = { fullText ->
                    ttsHelper.speak(fullText)
                },
                onTTSShutDown = {
                    ttsHelper.shutdown()
                },
            )
        }
        composable<ExploreStart> {
            val exploreStart = it.toRoute<ExploreStart>()
            // TODO 추후에 카메라 화면으로 이동하는 네비게이션 추가
            ExploreStartScreen(
                parkId = exploreStart.parkId,
                onExitExplore = {
                    navController.navigate(Home) {
                        // TODO 추후에 탐험기록 화면으로 이동하도록 수정
                        popUpTo(Home) { inclusive = true }
                    }
                },
                onEnterEncyc = {
                    navController.navigate(Encyc)
                },
                onEnterAR = {
                    navController.navigate(ARCamera)
                },
            )
        }
        composable<ARCamera> {
            ARSceneComposable(onPermissionDenied = {})
        }
        composable<Login> {
            LoginScreen(
                onNavigateToHome = {
                    navController.navigate(Home)
                },
            )
        }
        composable<UserProfileEdit> {
            UserProfileEditScreen()
        }
    }
}
