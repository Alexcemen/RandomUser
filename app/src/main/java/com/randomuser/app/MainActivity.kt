package com.randomuser.app

import android.os.Bundle
import android.util.Log
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
import com.randomuser.app.ui.navigation.UserInfo
import com.randomuser.app.ui.navigation.UserList
import com.randomuser.app.ui.screen.create_user.CreateUserScreen
import com.randomuser.app.ui.screen.user_info.UserInfoScreen
import com.randomuser.app.ui.screen.user_list.UserListScreen
import com.randomuser.app.utils.StateKeeper
import dagger.hilt.android.AndroidEntryPoint
import ru.project.tutor.common_ui.composable.theme.AppTheme
import javax.inject.Inject

val RootNavigation = compositionLocalOf<NavBackStack<AppNavKey>?> { null }

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var stateKeeper: StateKeeper

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.e("TAG2", "update = ${savedInstanceState}")
        stateKeeper.update(savedInstanceState)
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.e("TAG2", "onSaveInstanceState-2")
        outState.putAll(stateKeeper.getAll())
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AppTheme {
                val backStack = rememberNavBackStack(UserList()) as NavBackStack<AppNavKey>

                NavDisplay(
                    backStack = backStack,
                    onBack = { backStack.removeLastOrNull() },
                    entryDecorators = listOf(
                        rememberSaveableStateHolderNavEntryDecorator(),
                        rememberViewModelStoreNavEntryDecorator()
                    ),
                    entryProvider = entryProvider {
                        entry<CreateUser> {
                            CompositionLocalProvider(RootNavigation provides backStack) {
                                CreateUserScreen()
                            }
                        }

                        entry<UserList> {
                            CompositionLocalProvider(RootNavigation provides backStack) {
                                UserListScreen()
                            }
                        }

                        entry<UserInfo> {
                            CompositionLocalProvider(RootNavigation provides backStack) {
                                UserInfoScreen()
                            }
                        }
                    }
                )
            }
        }
    }
}
