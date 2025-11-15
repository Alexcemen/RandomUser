package com.randomuser.app

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
import com.randomuser.app.ui.mvi.AppNavKey
import com.randomuser.app.ui.navigation.CreateUser
import com.randomuser.app.ui.navigation.SplashScreen
import com.randomuser.app.ui.navigation.UserDetails
import com.randomuser.app.ui.navigation.UserList
import com.randomuser.app.ui.screen.create_user.CreateUserScreenContent
import dagger.hilt.android.AndroidEntryPoint
import ru.project.tutor.common_ui.composable.theme.AppTheme

val RootNavigation = compositionLocalOf<NavBackStack<AppNavKey>?> { null }

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AppTheme {
                val backStack = rememberNavBackStack(CreateUser()) as NavBackStack<AppNavKey>

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

                        entry<CreateUser> {
                            CompositionLocalProvider(RootNavigation provides backStack) {
                                CreateUserScreenContent()
                            }
                        }

                        entry<UserList> {
                            CompositionLocalProvider(RootNavigation provides backStack) {
//                                UserListScreen()
                            }
                        }

                        entry<UserDetails> {
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
