package com.example.randomuser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.randomuser.ui.mvi.AppNavKey
import com.example.randomuser.ui.navigation.CreateUserKey
import com.example.randomuser.ui.navigation.SplashScreen
import com.example.randomuser.ui.navigation.UserDetailsKey
import com.example.randomuser.ui.navigation.UserListKey
import com.example.randomuser.ui.theme.RandomUserTheme

val RootNavigation = compositionLocalOf<NavBackStack<AppNavKey>?> { null }

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            RandomUserTheme {
                val backStack = rememberNavBackStack(SplashScreen()) as NavBackStack<AppNavKey>

                NavDisplay(
                    backStack = backStack,
                    onBack = { backStack.removeLastOrNull() },
                    entryDecorators = listOf(
                        rememberSaveableStateHolderNavEntryDecorator(),
                        rememberViewModelStoreNavEntryDecorator()
                    ),
                    entryProvider = entryProvider {
                        entry<SplashScreen> {
                            CompositionLocalProvider(RootNavigation provides backStack) {
//                                SplashScreenContent()
                            }
                        }

                        entry<CreateUserKey> {
                            CompositionLocalProvider(RootNavigation provides backStack) {
//                                CreateUserScreen()
                            }
                        }

                        entry<UserListKey> {
                            CompositionLocalProvider(RootNavigation provides backStack) {
//                                UserListScreen()
                            }
                        }

                        entry<UserDetailsKey> {
                            CompositionLocalProvider(RootNavigation provides backStack) {
//                                UserDetailsScreen()
                            }
                        }
                    }
                )
            }
        }
    }
}
