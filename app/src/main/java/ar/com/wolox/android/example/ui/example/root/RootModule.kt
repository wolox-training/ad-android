package ar.com.wolox.android.example.ui.example.root

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class RootModule {

    @ContributesAndroidInjector
    internal abstract fun rootActivity(): RootActivity
}
